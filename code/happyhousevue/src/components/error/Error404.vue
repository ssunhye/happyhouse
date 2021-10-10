<template>
  <b-container>
  <b-jumbotron header="Not Found">
       
    <p>요청하신 페이지를 찾을 수 없습니다.</p>
  </b-jumbotron>  
  <p><a href="move">메인으로 가기</a></p>
</b-container>
</template>

<script>
export default {
   methods: {
        moveList() {
            this.$router.push({
                path: "/",
            })
        },
   }
}
</script>

<style>

</style>