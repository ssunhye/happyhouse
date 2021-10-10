<template>
    <b-container style="min-height:600px">
        <b-table id="my-table" @row-clicked="detail" 
            striped hover :items="qnaitems"
            :per-page="perPage"
            :current-page="currentPage"
            :fields="fields"
            >
        </b-table>
        
        <div>
            <b-pagination
                v-model="currentPage"
                :total-rows="rows"
                :per-page="perPage"
                aria-controls="my-table">
            </b-pagination>
        </div>
    </b-container>
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
            perPage: 3,
            currentPage: 1,
            fields: ["num", "name", "title", "date", "commentcount"],
        };
    },
    computed: {
        ...mapGetters(["qnaitems"]),
        rows() {
            return this.qnaitems.length
        }
    },
    created() {
        this.$store.dispatch("setqnaItems");
    },
    methods: {
        detail(item) {
            this.$router.push({
                path: "/qna/detail/" + item.num,
            });
        },
    },
}
</script>
