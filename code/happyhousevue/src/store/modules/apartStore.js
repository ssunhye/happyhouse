import Vue from "vue";
import Vuex from "vuex";
import rest from "@/js/httpCommon.js";
import bcode from "@/assets/법정동코드.json";

Vue.use(Vuex);

const apartStore = {
  state: {
    apts: [],
    apt: Object,
    silist: ["구"],
    donglist: ["동"],
  },
  getters: {
    apt(state) {
      return state.apt;
    },
    apts(state) {
      return state.apts;
    },
    silist(state) {
      return state.silist;
    },
    donglist(state) {
      return state.donglist;
    },
  },
  mutations: {
    GET_SI_LIST(state, datas) {
      state.silist = ["구"];
      let set = new Set(datas);
      set = [...set];

      set.forEach((item) => {
        state.silist.push(item);
      });
    },

    GET_DONG_LIST(state, datas) {
      state.donglist = ["동"];
      let set = new Set(datas);
      set = [...set];

      set.forEach((item) => {
        state.donglist.push(item);
      });
    },
    GET_DONG_APT_LIST(state, apts) {
      state.apts = apts;
    },
    GET_NAME_APT_LIST(state, apts) {
      state.apts = apts;
    },
    SELECT_APT(state, apt) {
      state.apt = apt;
    },
  },
  actions: {
    getDongAptList({ commit }, dong) {
      rest
        .axios({
          method: "get",
          url: "/house/dong/" + dong,
        })
        .then((res) => {
          commit("GET_DONG_APT_LIST", res.data);
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    getNameAptList({ commit }, aptName) {
      rest
        .axios({
          method: "get",
          url: "/house/aptname/" + aptName,
        })
        .then((res) => {
          commit("GET_NAME_APT_LIST", res.data);
        })
        .catch((error) => {
          console.dir(error);
        });
    },

    getSiList({ commit }, selArea) {
      const res = bcode;

      let datas = [];
      res.forEach((item) => {
        let str = new String(item["법정동코드"]);
        let chars = str.split("");

        if (!(chars[2] == "0" && chars[3] == "0" && chars[4] == "0")) {
          let areaname = new String(item["법정동명"]).split(" ");

          if (areaname[0] == selArea) {
            datas.push(areaname[1]);
          }
        }
      });
      commit("GET_SI_LIST", datas);
    },

    getDongList({ commit }, si) {
      const res = bcode;

      let datas = [];
      res.forEach((item) => {
        let str = new String(item["법정동코드"]);
        let chars = str.split("");

        if (!(chars[5] == "0" && chars[6] == "0" && chars[7] == "0" && chars[8] == "0" && chars[9] == "0")) {
          let areaname = new String(item["법정동명"]).split(" ");
          if (areaname[1] == si) {
            datas.push(areaname[2]);
          }
        }
      });

      commit("GET_DONG_LIST", datas);
    },

    selectApt({ commit }, apt) {
      commit("SELECT_APT", apt);
    },
  },
  modules: {},
};

export default apartStore;
