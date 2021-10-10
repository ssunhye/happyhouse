<template>
  <b-container>
    <b-row class="mt-4 mb-4">
      <b-col id="check">
        <b-form-group>
          <b-form-radio-group
            id="radio-group-1"
            v-model="selected"
            name="radio-options">
            <b-form-radio  value="dong">지역으로 검색</b-form-radio>
            <b-form-radio  value="aptName">아파트 이름으로 검색</b-form-radio>
          </b-form-radio-group>
        </b-form-group>
      </b-col>
      <b-col class="sm-3">
        <b-form inline v-if="selected=='dong'">
          <b-form-select cols="3" v-model="selectedarea" :options="arealist" @change="getGu()"></b-form-select>
          <b-form-select cols="3" v-model="selectedGu" :options="silist" @change="getDong()"></b-form-select>
          <b-form-select cols="3" v-model="selectedDong" :options="donglist"  @change="sendkeyword()"></b-form-select>
        </b-form>
        <b-form inline v-if="selected=='aptName'">
          <b-form-input v-model.trim="aptName"
            placeholder="입력 후 enter..."
            @keypress.enter="sendkeyword">
          </b-form-input>
          <b-button variant="outline-primary" @click="sendkeyword">검색</b-button>
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'SearchBar',
  data() {
    return {
      dong: '',
      aptName:'',
      selected:'',
      arealist : ["시","서울특별시","경기도","인천광역시","대구광역시","광주광역시","대전광역시","울산광역시","세종시","강원도","충청도","전라도","경상도","제주도"],
      selectedarea : '시',
      selectedGu : '구',
      selectedDong : '동',
    };
  },
  computed:{
    ...mapGetters(["silist","donglist"]),

  },
  methods: {
    ...mapActions(['getSiList','getDongList','getNameAptList','getDongAptList']),
    sendkeyword() {
      
      if (this.selected=="dong") 
        {
          this.getDongAptList(this.selectedDong);
          return;
        }
      if (this.selected=="aptName") 
        {
          this.getNameAptList(this.aptName);
          return;
        }
    },
    getGu(){
      this.getSiList(this.selectedarea);
      
    },
    getDong(){
      this.getDongList(this.selectedGu);
    }

  },
};
</script>

<style scoped>
#check {
  text-align: center;
}
#radio-group-1 {
  text-align: center;
  display: inline-grid
}
</style>
