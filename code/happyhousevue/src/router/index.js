import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/components/views/Main.vue";
import AptView from "@/components/views/AptView.vue";

import ArticleList from "@/components/views/ArticleList.vue";
import ArticleRegist from "@/components/article/ArticleRegist.vue";
import ArticleDetail from "@/components/article/ArticleDetail.vue";
import ArticleModify from "@/components/article/ArticleModify.vue";

import UserRegist from "@/components/user/UserRegist.vue";
import UserPage from "@/components/user/UserPage.vue";
import UserModify from "@/components/user/UserModify.vue";

import QnaView from "@/components/views/QnaView.vue";
import QnaDetail from "@/components/views/QnaDetail.vue";
import QnaRegist from "@/components/QnA/QnaRegist.vue";

import InterestList from "@/components/views/InterestList.vue";
import InterestRegister from "@/components/interest/InterestRegister.vue";

import AdminPage from "@/components/admin/AdminPage.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Main",
    component: Main,
  },
  {
    path: "/article/list",
    name: "ArticleList",
    component: ArticleList,
  },
  {
    path: "/article/regist",
    name: "ArticleRegist",
    component: ArticleRegist,
  },
  {
    path: "/article/list/:num",
    name: "ArticleDetail",
    component: ArticleDetail,
  },
  {
    path: "/article/modify/:num",
    name: "ArticleModify",
    component: ArticleModify,
  },
  {
    path: "/user/regist",
    name: "UserRegist",
    component: UserRegist,
  },
  {
    path: "/user/mypage",
    name: "UserPage",
    component: UserPage,
  },
  {
    path: "/user/modify/:id",
    name: "UserModify",
    component: UserModify,
  },
  {
    path: "/apart/search",
    name: "AptView",
    component: AptView,
  },
  {
    path: "/interest/add",
    name: "InterestRegister",
    component: InterestRegister,
  },
  {
    path: "/interest/parkinglist",
    name: "InterestList",
    component: InterestList,
  },
  {
    path: "/admin/adminpage",
    name: "AdminPage",
    component: AdminPage,
  },
  {
    path: "/qna/regist",
    name: "QnaRegist",
    component: QnaRegist,
  },
  {
    path: "/qna/list",
    name: "QnaView",
    component: QnaView,
  },
  {
    path: "/qna/detail/:num",
    name: "QnaDetail",
    component: QnaDetail,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
