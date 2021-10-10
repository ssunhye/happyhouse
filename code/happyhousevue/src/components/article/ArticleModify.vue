<template>
    <b-container style="min-height:600px">
        <div class="p-5">
            <b-form>
                <b-form-group label="이름:" label-for="name">
                    <b-form-input id="name" type="text" placeholder="name" required v-model="item.name"></b-form-input>
                </b-form-group>

                <b-form-group label="제목:" label-for="title">
                    <b-form-input id="title" type="text" placeholder="title" required v-model="item.title"></b-form-input>
                </b-form-group>

                <b-form-group label="내용" label-for="content">
                    <b-form-textarea id="content" rows="10" placeholder="content" required v-model="item.content"></b-form-textarea>
                </b-form-group>

                <b-button @click="onModify" variant="outline-primary">수정</b-button>
                <b-button type="reset" variant="outline-danger">Reset</b-button>
                <b-button @click="moveList" variant="outline-success">목록</b-button>
            </b-form>
        </div>
    </b-container>
</template>
<style scoped>

</style>
<script>
import rest from "@/js/httpCommon.js";
import { mapGetters } from 'vuex';
export default {
    data() {
        return {
            num : -1,
        };
    },
    created() {
        this.num = this.$route.params.num;
        this.$store.dispatch("setItem", this.num);
    },
    computed: {
        ...mapGetters(["item"]),
    },
    methods: {
        moveList() {
            this.$router.push({
                path: "/article/list",
            })
        },
        onModify() {
            rest.axios({
                url: "/article/" + this.num ,
                method: "put",
                data: this.item,
            }).then((res) => {
                console.log(res);
                alert("게시글 수정 성공");
                this.moveList();
            }).catch((err) => {
                alert("수정 실패");
                console.log(err);
            });
        }
    },

}
</script>