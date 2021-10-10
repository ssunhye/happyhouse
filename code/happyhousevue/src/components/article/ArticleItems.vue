<template>
    <div id="notice" class="pt-4 p-1">
        <h4>공지사항</h4>
        <b-table @row-clicked="detail" striped hover :items="items" :fields="fields" class="mt-4">
        <template #cell(fdate)="data">
            {{ data.item.date| formatDate }}
        </template>
        
        </b-table>
    </div>
</template>
<style scoped>
* {
    color:white;
}
b-table {
    border: 1px solid white;
}
#notice {
    font-size: 17px;
    font: #fff;
    border: 5px solid rgba(231, 221, 221, 0.719);
}
</style>
<script>
import { mapGetters } from 'vuex';

export default {
    data() {
        return {fields: ["num", "name", "title", { key: 'fdate', label: 'date' }],};
    },
    
    computed: {
        ...mapGetters(["items"]),
    },
    created() {
        this.$store.dispatch("setItems");
    },
    methods: {
        detail(item) {
            this.$router.push({
                path: "/article/list/" + item.num,
            });
        },
    },
}
</script>