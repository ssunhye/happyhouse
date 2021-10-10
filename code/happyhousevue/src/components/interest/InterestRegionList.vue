<template>
  <b-container style="min-height:400px" v-if="regionlist && regionlist.length != 0" class="bv-example-row pt-4 pb-4">
    <b-card no-body>
      <b-card-body
        style="position:relative; min-height:500px; max-height:650px; overflow-y:scroll;">
        <region-item v-for="(region, index) in regionlist" :key="index" :region="region" />
      </b-card-body>
    </b-card>
  </b-container>
  
  <b-container v-else class="bv-example-row pt-4 pb-4">
    <b-row>
      <b-col><b-alert show>관심지역이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import RegionItem from '@/components/interest/RegionItem.vue';

export default {
  name: 'InterestRegionList',
  components: {
    RegionItem,
  },
  computed: {
    ...mapGetters(['regionlist']),
  },
  methods : {
    ...mapActions(['getRegionList']),
  },
  mounted() {
    this.getRegionList()
  },
};
</script>

<style>

</style>