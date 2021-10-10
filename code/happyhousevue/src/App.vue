<template>
  <div id="app">
    <Header />
    <router-view />
    <Footer />
  </div>
</template>

<script>
import Header from '@/layout/Header.vue';
import Footer from '@/layout/Footer.vue';
export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style>
  @import url("https://fonts.googleapis.com/css?family=Roboto+Condensed");

html,
body {
  font-family: "Nanum Gothic","Karla", sans-serif;
}

#app {
  font-family: "Nanum Gothic","Karla", sans-serif;
  color: #2c3e50;
}
</style>
