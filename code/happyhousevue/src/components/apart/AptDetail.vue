<template>
  <b-container v-if="apt.일련번호" class="bv-example-row">
    
  </b-container>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'AptDetail',
  computed: {
    ...mapState(['apt']),
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
};
</script>

<style></style>
