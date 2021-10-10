<template>
  <div id="main">
    <b-container class="pt-5">
      <b-carousel
        id="carousel"
        :interval="2500"
        controls
        indicators
        background="#343A40"
        img-width="1024"
        img-height="90"
        style="text-shadow: 1px 1px 2px #333;">

        <b-carousel-slide caption="최신 거래 정보를 검색해 보세요!" img-blank img-alt="house image">
          <template #img>
            <img
              class="d-block w-100"
              src='@/assets/house5.png'
              alt="image slot"
            >
          </template>
        </b-carousel-slide>

        <b-carousel-slide caption="관심있는 지역을 등록해 보세요!" img-blank img-alt="map image">
          <template #img>
            <img
              class="d-block w-100"
              src='@/assets/map4.png'
              alt="image slot"
            >
          </template>
        </b-carousel-slide>

        <b-carousel-slide caption="QnA 게시판을 통해 궁금한 것을 물어보세요!" img-blank img-alt="qna image">
          <template #img>
            <img
              class="d-block w-100"
              src='@/assets/qna.png'
              alt="image slot"
            >
          </template>
        </b-carousel-slide>
      </b-carousel>
     </b-container>
    <b-container class="p-4 bg-dark">
      <div id="mention" class="ml-5 pt-5">어떤 집을 찾으세요?</div><br>
      <b-row class="text-center">
        <b-col class="m-2">
          <b-img thumbnail fluid :src="require('@/assets/apart1.jpg')" alt="Image 1" class="mb-3"/>
          <h4 style="color:white">아파트</h4>
        </b-col>
        <b-col class="m-2">
          <b-img thumbnail fluid :src="require('@/assets/house3.jpg')" alt="Image 2" class="mb-3"/>
          <h4 style="color:white">하우스</h4>
        </b-col>
        <b-col class="m-2">
          <b-img thumbnail fluid :src="require('@/assets/house4.jpg')" alt="Image 3" class="mb-3"/>
          <h4 style="color:white">원룸</h4>
        </b-col>
      </b-row>
      <div id="gohouse" class="text-right pr-3 pt-5" style="color:#fff;">
        <b-icon-house @click="searchHouse"></b-icon-house>
        <span @click="searchHouse"> 집 보러 가기 </span>
        <b-icon-play @click="searchHouse"></b-icon-play><b-icon-play @click="searchHouse"></b-icon-play><b-icon-play @click="searchHouse"></b-icon-play>
      </div>
    </b-container>
    <b-container id="article" class="p-4 mb-4">
      <b-row class="text-center">
        <b-col>
          <article-items></article-items>
        </b-col>
        <b-col>
          <qna-items></qna-items>
        </b-col>
      </b-row>
    </b-container><br><br>
  </div>
</template>

<style scoped>
#main {
  background-color: #343A40;
}
#mention {
  background-color: #343A40;
  font-size: 30px;
  text-shadow: 1px 1px 2px #333;
  color: #fff
}
#gohouse {
  background-color: #343A40;
  font-size: 23px;
  text-shadow: 1px 1px 2px #333;
  color: #fff
}
#article {
  background-color:rgba(255, 255, 255, 0.404);
}
</style>

<script>
import ArticleItems from "../article/ArticleItems.vue";
import QnaItems from '../QnA/QnaItems.vue';
export default{
  name: "Main",
  components: {
    ArticleItems,
    QnaItems,
    // Slide1
  },
  methods: {
    searchHouse() {
      this.$router.push({
        path: "/apart/search",
      })
    }
  },
};
</script>

<style>
    
</style>
