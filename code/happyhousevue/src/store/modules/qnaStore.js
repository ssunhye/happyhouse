import Vue from "vue";
import Vuex from "vuex";
import rest from "@/js/httpCommon.js";

Vue.use(Vuex);

const qnaStore = {
  state: {
    qnaitems: [],
    qnai: {},
  },
  getters: {
    qnaitems(state) {
      return state.qnaitems;
    },
    qnai(state) {
      return state.qnai;
    },
  },
  mutations: {
    set_qna_Items(state, payload) {
      state.qnaitems = payload;
    },

    set_qna_Item(state, payload) {
      state.qnai = payload;
    },
  },
  actions: {
    setqnaItems(store) {
      rest
        .axios({
          method: "get",
          url: "/qna",
        })
        .then((res) => {
          store.commit("set_qna_Items", res.data);
        })
        .catch((err) => {
          alert("게시판 로딩 실패");
          console.log(err);
        });
    },

    getqnaList({ commit }, keyword) {
      rest
        .axios({
          method: "get",
          url: "/qna/search/" + keyword,
        })
        .then((res) => {
          commit("set_qna_Items", res.data);
        })
        .catch((err) => {
          alert("게시판 로딩 실패");
          console.log(err);
        });
    },

    setqnaItem({ commit }, num) {
      rest
        .axios({
          method: "get",
          url: "/qna/select/" + num,
        })
        .then((res) => {
          commit("set_qna_Item", res.data);
        })
        .catch((err) => {
          alert("게시판 로딩 실패");
          console.log(err);
        });
    },
  },
  modules: {},
};

export default qnaStore;
