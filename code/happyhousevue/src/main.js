import Vue from "vue";

import App from "./App.vue";
import router from "./router";
import store from "./store/index.js";
import { BootstrapVue, IconsPlugin, BootstrapVueIcons } from "bootstrap-vue";

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.use(IconsPlugin);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

import dayjs from "dayjs";
Vue.filter("formatDate", (value) => {
  if (value) {
    return dayjs(String(value)).format("YYYY-MM-DD");
  }
});

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
