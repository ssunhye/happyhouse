import Vue from "vue";
import Vuex from "vuex";
import rest from "@/js/httpCommon.js";

Vue.use(Vuex);

const articleStore = {
  state: {
    items: [],
    item: {},
  },
  getters: {
    items(state) {
      return state.items;
    },
    item(state) {
      return state.item;
    },
  },
  mutations: {
    setItems(state, payload) {
      state.items = payload;
    },
    setItem(state, payload) {
      state.item = payload;
    },
  },
  actions: {
    setItems(store) {
      rest
        .axios({
          method: "get",
          url: "/article",
        })
        .then((res) => {
          store.commit("setItems", res.data);
        })
        .catch((err) => {
          alert("게시판 로딩 실패");
          console.log(err);
        });
    },
    setItem(store, num) {
      rest
        .axios({
          method: "get",
          url: "/article/" + num,
        })
        .then((res) => {
          store.commit("setItem", res.data);
        })
        .catch((err) => {
          alert("상세화면 로딩 실패");
          console.log(err);
        });
    },
  },
  modules: {},
};

export default articleStore;
