<template>
    <b-container style="min-height:600px">
        <div class="p-5">
            <b-form>
                <b-form-group label="제목:" label-for="title">
                    <b-form-input id="title" type="text" placeholder="title" required v-model="item.title"></b-form-input>
                </b-form-group>

                <b-form-group label="내용" label-for="content">
                    <b-form-textarea id="content" rows="10" placeholder="content" required v-model="item.content"></b-form-textarea>
                </b-form-group>

                <b-button @click="onSubmit" variant="outline-primary">등록</b-button>
                <b-button type="reset" variant="outline-danger">초기화</b-button>
                <b-button @click="moveList" variant="outline-success">목록</b-button>
            </b-form>
        </div>
    </b-container>
</template>
<style scoped>

</style>
<script>
import rest from "@/js/httpCommon.js";
const storage = window.sessionStorage;
export default {
    data() {
        return {item: {}};
    },
    computed: {
        currentUser() {
            if (!storage.getItem('loginUser')){
                return false;
            } else {
                return true;
            }
        }
    },
    methods: {
        moveList() {
            this.$router.push({
                path: "/article/list",
            })
        },
        onSubmit() {
            if(!this.currentUser) return;
            let user = JSON.parse(storage.getItem('loginUser'))
            this.item.name = user.name
            
            rest.axios({
                url: "/article",
                method: "post",
                data: this.item,
            }).then((res) => {
                if(res.data === "success") {
                    alert("게시글 등록 성공");
                    this.moveList();
                }
            }).catch((err) => {
                alert("게시글 등록 실패");
                console.log(err);
            });
        }
    },
}
</script>