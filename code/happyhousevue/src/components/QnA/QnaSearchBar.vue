<template>
  <div class="text-right pb-4">
    <b-form inline style="justify-content: flex-end;">
      <input type="text" :v-model="keyword" class="form-control" id="input-text" placeholder="검색어 입력">
      <b-button variant="outline-success" @click="sendkeyword">검색</b-button>
      <b-button v-if="currentUser" variant="outline-primary" @click="move" class="ml-4">글 작성</b-button>
    </b-form>
  </div>
</template>

<script>
import {mapActions } from 'vuex';

const storage = window.sessionStorage;

export default {
  name: 'SearchBar',
  data() {
    return {
      keyword : '',
    };
  },
  computed:{
    
    currentUser() {
      if (!storage.getItem('loginUser')){
        return false;
      } else {
        return true;
      }
    },
  },
  methods: {
    ...mapActions(['getqnaList']),
    sendkeyword() {
      this.getqnaList(this.keyword);
          
    },
    move() {
        this.$router.push({
            path: "/qna/regist",
        })
    },

  },
};
</script>

<style scoped>
</style>
