<template>
  <b-container class="bv-example-row">
    <h3 id="h3" class="ml-5 mt-5">관심 지역 주차 정보</h3>
    <b-row>
      <b-col cols="3" align="left">
        <interest-region-list />
      </b-col>
      <b-col cols="9" class="pt-4 pb-4">
        <maps></maps>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import InterestRegionList from '@/components/interest/InterestRegionList.vue';
import Maps from '@/components/apart/Maps.vue';
export default {
  components: {
    InterestRegionList,
    Maps,
  },
}
</script>

<style>

</style>