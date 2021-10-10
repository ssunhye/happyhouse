<template>
  <b-container>
    <h3 id="h3" class="ml-5 mt-5">관심지역 등록</h3>
    <b-row>
      <b-col cols="3">
        <interest-region-list></interest-region-list>
      </b-col>
      <b-col cols = "9" class="sm-10 md-6 lg-4 mx-auto">
            <b-card bg-variant="Light"  header="지역 선택" class="text-center">
              <b-card-body>
                <b-container class="sm-3">
                  <b-form>
                    <b-input-group prepend="시/도" class="mb-3 sm-3" >
                      <b-form-select cols="3" v-model="selectedarea" :options="arealist" @change="getGu()"></b-form-select>
                    </b-input-group>
                    <b-input-group prepend="구" class="mb-3 mt-5">
                      <b-form-select cols="3" v-model="item.gu" :options="silist"></b-form-select>
                      <b-button variant="info" @click="onSubmit">등록</b-button>
                    </b-input-group>
                    <b-input-group  class="mb-3 mt-5">
                      <b-button variant="primary" @click="moveMap()">지도로 보기</b-button>
                      <b-button variant="danger" @click="del">삭제</b-button>      
                    </b-input-group>
                  </b-form>
                </b-container>
                
              </b-card-body>
            </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import rest from "@/js/httpCommon.js";
import { mapGetters, mapActions } from 'vuex';
import InterestRegionList from './InterestRegionList.vue';
const storage = window.sessionStorage;
export default {
  data(){
    return {
      item : {},
      arealist : ["시","서울특별시","경기도","인천광역시","대구광역시","광주광역시","대전광역시","울산광역시","세종시","강원도","충청도","전라도","경상도","제주도"],
      selectedarea : '시',
    }
  },
  components : {
    InterestRegionList
  },
  computed:{
    ...mapGetters(["silist","region"]),
    currentUser() {
        return JSON.parse(storage.getItem("loginUser"));
    }
  },
  methods : {
    ...mapActions(['getSiList']),
    moveMap() {
        this.$router.push({
            path: "/interest/parkinglist",
        })
    },
    getGu(){
      this.getSiList(this.selectedarea);
    },

    onSubmit() {
        if(!this.currentUser) return;
        this.item.id = this.currentUser.id;
        
        rest.axios({
            url: "/interest",
            method: "post",
            data: this.item,
        }).then((res) => {
          if(res.data === "success") {
              alert("관심 지역 등록 성공");
          }
        }).catch((err) => {
            alert("등록 실패");
            console.log(err);
        });
    },
    del() {
        rest.axios({
            url: "/interest/" +this.currentUser.id+ "/" + this.region,
            method: "delete",
        }).then((res) => {
            if (res.data === "success") {
                alert("관심 지역 삭제 성공");
            }
        }).catch((err)=>{
            alert("삭제 실패")
            console.log(err);
        });
    }
  }
}
</script>

<style scoped>
#h3 {
  text-shadow: 1px 1px 1px rgb(4, 61, 7);
  color: rgb(59, 109, 57)
}
</style>