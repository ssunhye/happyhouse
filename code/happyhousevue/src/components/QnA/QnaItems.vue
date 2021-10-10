<template>
    <div id="qna" class="pt-4 p-1">
        <h4>QnA</h4>
        <b-table @row-clicked="detail" striped hover :items="qnaitems" :fields="fields" class="mt-4">
            <template #cell(fdate)="data">
                {{ data.item.date| formatDate }}
            </template>
        </b-table>
    </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
    data() {
        return {
            fields: ["num", "name", "title", { key: 'fdate', label: 'date' }],
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

<style scoped>
* {
    color:white;
}
b-table {
    border: 1px solid white;
}
#qna {
    font-size: 17px;
    font: #fff;
    border: 5px solid rgba(231, 221, 221, 0.719);
}
</style>