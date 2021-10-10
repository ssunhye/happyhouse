<template>
  <div>
    <b-row
      class="pl-4 pr-4 pt-2 pb-1"
      @click="chooseApt"
      @mouseover="colorChange(true)"
      @mouseout="colorChange(false)"
      :class="{ 'mouse-over-bgcolor': isColor }">
      <b-media>
        <b-media-body>
          <h4 style="color:#0D5917;"><b-icon-building></b-icon-building>{{this.apt.aptName}}</h4>
          <h6>- 거래금액 :{{this.apt.dealAmount}}</h6>
          <h6>- 면적: {{this.apt.area}}</h6>
          <p><b-icon-calendar2-date></b-icon-calendar2-date> {{this.apt.dealDate}}</p>
        </b-media-body>
      </b-media>
    </b-row>
    <hr>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  name: 'AptListItem',
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    apt: Object,
  },
  methods: {
    // chooseApt() {
    //   // this.$emit('select-apt', this.apt);
    //   this.$store.dispatch('selectApt', this.apt);
    // },
    ...mapActions(['selectApt']),
    chooseApt() {
      this.selectApt(this.apt);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.img-list {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: rgb(212, 207, 207);
}
hr {
  border: solid 1px;
  background-color: rgb(67, 74, 167);
}
</style>
