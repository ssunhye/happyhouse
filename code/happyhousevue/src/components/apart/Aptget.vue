<template>
  <b-container>
    <b-table id="my-table" @row-clicked="detail" 
            :items="housedeal">
        </b-table>
        <b-button @click="start"></b-button>
  </b-container>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  methods : {
    ...mapActions(['updateHouseDeal']),
    start(){
      this.updateHouseDeal()
    }
  },
  
};
</script>

<style></style>
