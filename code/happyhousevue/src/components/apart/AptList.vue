<template>
  <b-container style="min-height:400px" v-if="apts && apts.length != 0" class="bv-example-row pt-4 pb-4">
    <b-card no-body>
      <b-card-body class="mb-2"
        style="position:relative; min-height:500px; max-height:650px; overflow-y:scroll;">
        <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" />
      </b-card-body>
    </b-card>
  </b-container>
  <b-container v-else class="bv-example-row pt-4 pb-4">
    <b-row>
      <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from 'vuex';
import AptListItem from '@/components/apart/AptListItem.vue';

export default {
  name: 'AptList',
  components: {
    AptListItem,
  },
  computed: {
    ...mapGetters(['apts']),
  },
};
</script>

<style></style>
