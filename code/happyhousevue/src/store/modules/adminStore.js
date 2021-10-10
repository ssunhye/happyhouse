import Vue from "vue";
import Vuex from "vuex";
import rest from "@/js/httpCommon.js";
import bcode from "@/assets/법정동코드.json";
import dayjs from "dayjs";

Vue.use(Vuex);

const adminStore = {
  state: {
    totalUsers: [],
  },
  getters: {
    totalUsers(state) {
      return state.totalUsers;
    },
  },
  mutations: {
    setTotalUsers(state, payload) {
      state.totalUsers = payload;
    },
  },
  actions: {
    setTotalUsers(store) {
      rest
        .axios({
          method: "get",
          url: "/user/admin",
        })
        .then((res) => {
          store.commit("setTotalUsers", res.data);
        })
        .catch((err) => {
          alert("전체 유저 로딩 실패");
          console.log(err);
        });
    },

    updateHouseDeal() {
      rest
        .axios({
          url: "/house",
          method: "delete",
        })
        .then((res) => {
          res;
          alert("거래 정보 업데이트 시작");
        })
        .catch((err) => {
          alert("오류");
          console.log(err);
        });

      const res = bcode;

      let dcode = [];
      res.forEach((item) => {
        let str = new String(item["법정동코드"]);

        dcode.push(str.substr(0, 5));
      });

      dcode = new Set(dcode);
      dcode = [...dcode];
      console.log(dcode.length);

      var today = new Date();

      let dateParams = [];
      for (var i = 0; i < 6; i++) {
        today.setMonth(today.getMonth() - 1);
        dateParams.push(dayjs(today).format("YYYYMM"));
      }
      let flag = false;
      dcode.forEach((code) => {
        dateParams.forEach((dat) => {
          rest
            .axios({
              url: "/house/aptdeal/" + code + "/" + dat,
              method: "get",
            })
            .then((res) => {
              res;
              return;
            })
            .catch((err) => {
              flag = true;
              console.log(err);
              return false;
            });
        });
        if (flag) return false;
      });
    },
  },
  modules: {},
};

export default adminStore;
