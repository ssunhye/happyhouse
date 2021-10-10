<template>
  <div class="overflow-auto">
    
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
export default {
  data() {
    return{
      
    }
  },
  computed : {
    ...mapGetters(["items"]),
    rows() {
      return this.items.length
    }
  }
}
</script>

<style>

</style>