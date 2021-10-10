<template>
    <b-container style="min-height:600px">
        <div class="text-right pb-4">
            <b-button @click="moveList" v-if="currentAdmin" variant="outline-primary">공지글 작성</b-button>
        </div>

        <b-table id="my-table" @row-clicked="detail" 
            striped hover :items="items" :fields="fields"
            :per-page="perPage"
            :current-page="currentPage">
        </b-table>

        <div class="pt-4">
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
const storage = window.sessionStorage;
import { mapGetters } from 'vuex';

export default {
    data() {
        return {
            fields: ["num", "name", "title", "date"],
            perPage: 5,
            currentPage: 1,
        };
    },
    computed: {
        ...mapGetters(["items"]),
        rows() {
            return this.items.length
        },
        currentAdmin() {
            if (this.user.id=="admin") {
                return true;
            } else {
                return false;
            }
        }
    },
    created() {
        this.user = JSON.parse(storage.getItem("loginUser"));
        this.$store.dispatch("setItems");
    },
    methods: {
        detail(item) {
            this.$router.push({
                path: "/article/list/" + item.num,
            });
        },
        moveList() {
            this.$router.push({
                path: "/article/regist",
            })
        },
    },
}
</script>
