<template>
  <div>
    <b-row style="display: grid;"
      class="pl-4 pr-4 pt-2 pb-1"
      @click="chooseRegion"
      @mouseover="colorChange(true)"
      @mouseout="colorChange(false)"
      :class="{ 'mouse-over-bgcolor': isColor }">
      <b-media class="text-center">
        <b-media-body>
          <h4 style="color:#0D5917;">{{this.region.gu}}</h4> 
        </b-media-body>
      </b-media>
    </b-row>
    <hr>
  </div>
</template>
<style scoped>

</style>
<script>
import { mapActions } from 'vuex';

export default {
  name: 'RegionItem',
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    region: Object,
  },
  methods: {
    ...mapActions(['selectRegion']),
    chooseRegion() {
      this.selectRegion(this.region.gu);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>

.mouse-over-bgcolor {
  background-color: rgb(212, 207, 207);
}
hr {
  border: solid 1px;
  background-color: rgb(67, 74, 167);
}
</style>