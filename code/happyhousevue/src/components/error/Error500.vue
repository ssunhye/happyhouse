<template>
  <b-container>
  <b-jumbotron header="Sorry">
    <p>ㅠㅠ</p>
  </b-jumbotron>  
  <p><a href="move">메인으로 가기</a></p>
</b-container>
</template>

<script>
export default {
  methods: {
        move() {
            this.$router.push({
                path: "/",
            })
        },
   }
}
</script>

<style>

</style>