<template>
  <div id="header">
    <b-container>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        
        <b-navbar-brand href="/">
          <img src="@/assets/logo.png" alt="logo image" width="70px"/>
          <span class="ml-2">Happy House</span>
        </b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav v-if="currentUser">
            <b-nav-item href="/article/list">공지사항</b-nav-item>
            <b-nav-item href="/qna/list">Q & A</b-nav-item>
            <b-nav-item href="/apart/search">매매 검색</b-nav-item>
            <b-nav-item href="/interest/add">관심 지역</b-nav-item>
            <b-nav-item href="/interest/parkinglist">주차 정보</b-nav-item>
          </b-navbar-nav>

      <b-navbar-nav class="ml-auto mr-auto">
        <today-view></today-view>
      </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav v-if="!currentUser" class="ml-auto">
            <b-nav-item href="/user/regist"><b-icon icon="person-plus"></b-icon>회원 가입</b-nav-item>
            <b-nav-item href="#" v-b-modal.loginModal><b-icon icon="person-check"></b-icon>로그인</b-nav-item>
          </b-navbar-nav>      
            <!-- <b-nav-item @click="myPage">My page</b-nav-item> -->
          <b-navbar-nav v-if="currentUser" class="ml-auto">
            <b-nav-item @click="logout"><b-icon icon="power" aria-hidden="true"></b-icon>로그아웃</b-nav-item>
            <b-nav-item @click="myPage" v-if="!currentAdmin"><b-icon icon="person" aria-hidden="true"></b-icon>마이페이지</b-nav-item>
            <b-nav-item @click="adminPage" v-if="currentAdmin"><b-icon icon="clipboard-data"></b-icon>관리자페이지</b-nav-item>
          </b-navbar-nav>

          <b-modal id="loginModal" title="Login" hide-footer>
            <form>
              <div class="modal-body">
                <label for="id">ID:</label>
                <input type="text" name="id" class="form-control" id="id" v-model="user.id" required placeholder="ID" />
                <label for="pass">Password:</label>
                <input type="password" name="pass" class="form-control" id="pass" v-model="user.pass" required placeholder="Enter Password" />
                <div class="text-right">
                  <b-button type="submit" @click="login" class="btn btn-primary mt-3">Login</b-button>
                </div>
              </div>
            </form>
          </b-modal>
        </b-collapse>
      </b-navbar>
    </b-container>
  </div>
</template>

<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
  span {
    font-size: 25px;
    font-family: 'Montserrat', sans-serif;
  }
  #header {
    background-color: #343A40;
  }
</style>

<script>
import rest from "@/js/httpCommon.js";
import TodayView from './TodayView.vue';

const storage = window.sessionStorage;

export default {
  components: { TodayView },
  data() {
    return {
      user: {},
    };
  },
  computed: {
    currentUser() {
      if (!storage.getItem('loginUser')){
        return false;
      } else {
        return true;
      }
    },
    currentAdmin() {
      if (JSON.parse(storage.getItem("loginUser")).id=="admin") {
        return true;
      } else {
        return false;
      }
    }
  },

  methods: {
    moveMain() {
      this.$router.push({
        path: "/",
      })
    },
    redirect() {
      this.$router.go();
    },
    login() {
      rest.axios({
        url: "/user/login",
        method: "post",
        data: this.user,
      }).then((res) => {
        console.log(JSON.stringify(res.data.data));
        console.dir(res.headers["jwt-auth-token"]);
        storage.setItem("jwt-auth-token", res.headers["jwt-auth-token"]);
        storage.setItem("loginUser", JSON.stringify(res.data.data));
        this.user = JSON.parse(storage.getItem("loginUser"));
        alert("로그인 성공");
      }).catch((err) => {
        alert("로그인 실패");
        console.log(err);
      });
      if (this.$route.name=='Main') {
        this.redirect();
      } else {
        this.moveMain();
      }
    },
    logout() {
      storage.removeItem("jwt-auth-token");
      storage.removeItem("loginUser");
      if (this.$route.name=='Main') {
        this.redirect();
      } else {
        this.moveMain();
      }
      alert("로그아웃 성공");
    },
    myPage() {
      this.$router.push({
        path: "/user/mypage",
      })
    },
    adminPage() {
      this.$router.push({
        path: "/admin/adminpage",
      })
    }
  },
}
</script>
