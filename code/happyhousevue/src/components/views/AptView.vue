<template>
  <b-container class="bv-example-row">
    <h3 id="h3" class="ml-5 mt-5">아파트 거래 내역</h3>
    <b-row>
      <b-col cols="3" align="left">
        <apt-list />
      </b-col>
      <b-col cols="9">
        <apt-search-bar />
        <maps></maps>
      </b-col>
    </b-row>
  </b-container>
</template>
<script src="@/js/vue-google-maps.js"></script>

<script>
import AptSearchBar from '@/components/apart/AptSearchBar.vue';
import AptList from '@/components/apart/AptList.vue';
import Maps from '@/components/apart/Maps.vue';

export default {
  name: 'Apt',
  components: {
    AptSearchBar,
    AptList,
    Maps,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
#h3 {
  text-shadow: 1px 1px 1px rgb(4, 61, 7);
  color: rgb(59, 109, 57)
}</style>
