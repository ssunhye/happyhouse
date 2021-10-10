<template>
  <b-container style="min-height:600px">
  <div id="admin" class="text-right pt-4 pb-4">
    <carousel :per-page="1" :autoplay="true" :loop="true" :navigationEnabled="true">
      <slide style="width:100px">
        <h4 class="text-center">가입자 추이</h4>
        <sign-up-chart :label="joindate" :chart-data="totalUser"></sign-up-chart>
      </slide>
      <slide style="width:100px">
        <h4 class="text-center">사용자 통계: 성별</h4>
        <gender-chart :label="gender" :chart-data="genderCnt"></gender-chart>
      </slide>
      <slide style="width:100px">
        <h4 class="text-center">사용자 통계: 사는 지역</h4>
        <region-chart :label="region" :chart-data="regionCnt"></region-chart>
      </slide>
      <slide style="width:100px">
        <h4 class="text-center">사용자 통계: 관심 지역</h4>
        <interest-chart :label="interest" :chart-data="interestCnt"></interest-chart>
      </slide>
    </carousel>
    <b-button v-b-modal.my-modal variant="warning">DB 업데이트</b-button>
    <Users />

    <b-modal id="my-modal" title="Update DB">
      <div class="d-block text-center">
        <h3>최신 거래정보 업데이트!</h3>
      </div>
      <b-button class="mt-2" variant="outline-warning" block @click="start">Update!</b-button>
      <b-button class="mt-3" variant="outline-secondary" block @click="hideModal">Close Me</b-button>
    </b-modal>
  </div>
  </b-container>
</template>

<script>
import { Carousel, Slide } from 'vue-carousel';
import SignUpChart from "./SignUpChart";
import GenderChart from "./GenderChart";
import RegionChart from "./RegionChart";
import InterestChart from "./InterestChart";
import Users from "./Users";

import { mapGetters, mapActions } from 'vuex';

export default {
  name: "Admin",
  components: {
    Carousel,
    Slide,
    SignUpChart,
    GenderChart,
    RegionChart,
    InterestChart,
    Users,
  },
  data() {
    return {
      joindate : 
      ["January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",],
      totalUser : [],
      gender: ['man', 'woman'],
      genderCnt: [],
      region: [],
      regionCnt: [],
      interest: [],
      interestCnt: [],
    };
  },
  computed: {
      ...mapGetters(["totalUsers", "totalInterest"]),
  },
  async created() {
    // const {data} = await rest.axios.get("/user/admin");
    this.$store.dispatch("setTotalUsers");
    this.$store.dispatch("setTotalInterest");
    let man = 0;
    let woman = 0;
    let month = [0,0,0,0,0,0,0,0,0,0,0,0,0];
    let userData = this.totalUsers;
    let regArr = new Array();
    let interestData = this.totalInterest;
    let interestArr = new Array();

    for (let i=0; i<userData.length; i++) {
      let date = userData[i].joindate.substr(3,2);
      switch(+date) {
        case 1: month[1]++; break;
        case 2: month[2]++; break;
        case 3: month[3]++; break;
        case 4: month[4]++; break;
        case 5: month[5]++; break;
        case 6: month[6]++; break;
        case 7: month[7]++; break;
        case 8: month[8]++; break;
        case 9: month[9]++; break;
        case 10: month[10]++; break;
        case 11: month[11]++; break;
        case 12: month[12]++; break;
      }
      
      if (userData[i].gender=='남') {
        man++;
      } else {
        woman++;
      }
      
      regArr.push(userData[i].address);
    }
    for (let i=1; i<=12; i++) {
      this.totalUser.push(month[i]);
    }

    let RegCnt = regArr.reduce((accu,curr)=> {
      accu.set(curr, (accu.get(curr)||0) + 1);
      return accu;
    }, new Map());

    for (let [key, value] of RegCnt.entries()) {
      this.region.push(key);
      this.regionCnt.push(value);
    }
    
    this.genderCnt.push(man);
    this.genderCnt.push(woman);

    for (let i=0; i<interestData.length; i++) {
      interestArr.push(interestData[i].gu);
    }

    let interestCnt = interestArr.reduce((accu,curr)=> {
      accu.set(curr, (accu.get(curr)||0) + 1);
      return accu;
    }, new Map());

    for (let [key, value] of interestCnt.entries()) {
      this.interest.push(key);
      this.interestCnt.push(value);
    }
  },
  methods: {
    ...mapActions(['updateHouseDeal']),
      showModal() {
        this.$refs['my-modal'].show()
      },
      hideModal() {
        this.$refs['my-modal'].hide()
      },
      start(){
        this.updateHouseDeal()
        this.$router.go();
      }
  }
};
</script>

<style>
</style>

