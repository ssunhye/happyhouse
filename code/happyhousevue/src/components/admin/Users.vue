<template>
  <div class="m-5 text-left">
    <h3 class="pb-2">User Information</h3>
    <b-table hover :items="totalUsers" :fields="fields"
      :per-page="perPage"
      :current-page="currentPage">
    </b-table>
    <div>
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="my-table">
      </b-pagination>
    </div>
  </div>
</template>

<style scoped>
  .b-pagination {
    display: flex;
    justify-content: center;
  }
</style>

<script>
import { mapGetters } from 'vuex';

export default {
    data() {
        return {
          fields: [
            {
              key: "id",
              sortable: true
            },
            {
              key: "name", 
              sortable: true
            },
            {
              key: "email",
              sortable: true
            },
            {
              key: "address",
              sortable: true
            },
            {
              key:"gender",
              sortable: true
            },
            {
              key: "phone",
              sortable: false
            }
          ],
          perPage: 5,
          currentPage: 1,
        };
    },
    computed: {
      ...mapGetters(["totalUsers"]),
      rows() {
        return this.totalUsers.length
      }
    },
    created() {
        this.$store.dispatch("setTotalUsers");
    },
    methods: {
    },
    components: {
    },
}
</script>