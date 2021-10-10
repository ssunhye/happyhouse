<template>
  <b-container class="bv-example-row">
    <h3 id="h3" class="ml-5 mt-5">공지사항</h3>
    <b-row>
       <b-col cols="12" align="center">
        <article-list></article-list>
       </b-col>
    </b-row>
  </b-container>
</template>

<script>
import ArticleList from '../article/ArticleList.vue'
export default {
  components: { ArticleList },

}
</script>

<style scoped>
#h3 {
  text-shadow: 1px 1px 1px rgb(4, 61, 7);
  color: rgb(59, 109, 57)
}
</style>