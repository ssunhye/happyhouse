<template>
    <b-container style="min-height:600px">
        <div class="p-5">
            <b-form>
                <b-form-group label="제목:" label-for="title">
                    <b-form-input id="qtitle" type="text" placeholder="title" readonly v-model="qnai.title"></b-form-input>
                </b-form-group>

                <b-form-group label="내용" label-for="content">
                    <b-form-textarea id="qcontent" rows="5" placeholder="content" readonly v-model="qnai.content"></b-form-textarea>
                </b-form-group>
                

                <b-form inline>
                    <b-col v-if="user.id==qnai.id" class="ml-auto">
                        <b-button @click="qnamodOpen()" variant="outline-primary">수정</b-button>
                        <b-button v-b-modal.qna-del-modal variant="outline-danger">삭제</b-button>
                    </b-col>
                    <b-col>
                    <b-button class="float-right" @click="moveList" variant="outline-success">목록</b-button>
                    </b-col>
                </b-form>

                <b-card no-body class="mt-5">
                    <b-list-group flush>
                        <b-list-group-item v-for="(cmt, idx) in comitems" :key="idx">
                            <b-row>
                                <b-col cols="2">
                                    <b-badge>{{ cmt.name }}</b-badge>
                                </b-col>
                                <b-col cols="6">
                                    <span>  {{ cmt.comment}}</span>
                                </b-col>
                                <b-col cols="2">
                                    <span>  {{ ago(cmt.date)}}</span>
                                </b-col>
                                <!-- <b-col v-if="user && user.id == comi.id" cols="2"> -->
                                <b-button-group v-if="user.id==cmt.id" class="float-right" size="sm">
                                    <b-btn variant="warning" @click="commodOpen(cmt)"><b-icon icon="pencil"></b-icon></b-btn>
                                    <b-btn variant="danger" @click="comdel(cmt)"><b-icon icon="trash"></b-icon></b-btn>
                                </b-button-group>
                                <!-- </b-col> -->
                            </b-row>
                        </b-list-group-item>
                    </b-list-group>
                    <b-card-footer inline>
                        <b-textarea v-model="comform.comment"></b-textarea>
                        <b-btn variant="outline-success" class="float-right" @click="comregist">댓글 등록</b-btn>
                    </b-card-footer>
                </b-card>
            </b-form>


            <b-modal ref="qnamod" hide-footer title="글 수정하기">
                <b-form >
                    <b-form-group label="제목:" label-for="ftitle">
                        <b-form-input id="ftitle"
                            type="text"
                            v-model="qnaform.title"
                            required
                            placeholder="제목">
                        </b-form-input>
                    </b-form-group>

                    <b-form-group label="글" label-for="fcontent">
                        <b-form-textarea id="fcontent"
                            v-model="qnaform.content"
                            placeholder="글쓰기..."
                            :rows="10"
                            :max-rows="20">
                        </b-form-textarea>
                    </b-form-group>
                    <b-button @click="qnamodify()" variant="warning" class="float-right">글 수정</b-button>
                </b-form>
            </b-modal>


            <b-modal ref="commod" hide-footer title="댓글 수정하기">
                <b-form>
                    <b-form-group label="글" label-for="comment">
                        <b-form-textarea id="comment"
                            v-model="modcomment"
                            placeholder="글쓰기..."
                            :rows="10"
                            :max-rows="20">
                        </b-form-textarea>
                    </b-form-group>
                    <b-btn @click="commodify()" variant="warning" class="float-right">글 수정</b-btn>
                </b-form>
            </b-modal>

            <b-modal id="qna-del-modal" hide-footer title="글 삭제">
                <div class="d-block text-center">
                    <h3>삭제하시겠습니까?</h3>
                </div>
                <b-button class="mt-2" variant="outline-warning" block @click="qnadel()">예</b-button>
                <b-button class="mt-3" variant="outline-secondary" block @click="qnahideModal">아니요</b-button>
            </b-modal>
        </div>
    </b-container>
</template>
<style scoped>

</style>
<script>
import rest from "@/js/httpCommon.js";
import { mapActions, mapGetters } from 'vuex';
import dayjs from "dayjs"
var relativeTime = require('dayjs/plugin/relativeTime')
dayjs.extend(relativeTime)
const storage = window.sessionStorage;

export default {
    data() {
        return {
            qnaform : {
                title : '',
                content : '',
            },
            comform : {
                comment : '',
            },
            comi : Object,
            modcomment : '',
        };
    },
    created() {
        this.user = JSON.parse(storage.getItem("loginUser"));
        this.update();
        this.setcomItems(this.$route.params.num);
    },
    computed: {
        ...mapGetters(["qnai","comitems"]),
        currentUser() {
            if (!storage.getItem('loginUser')){
                return false;
            } else {
                return true;
            }
        },
    },
    methods: {
        ...mapActions(["setqnaItem","setcomItems"]),
        refresh() {
            this.$router.go();
        },
        moveList() {
            this.$router.push({
                path: "/qna/list",
            })
        },

        update(){
            let num = this.$route.params.num;
            this.setqnaItem(num);
        },

        qnamodify() {
            this.qnai.title = this.qnaform.title;
            this.qnai.content = this.qnaform.content;
            
            rest.axios({
                url: "/qna/" + this.qnai.num,
                method: "put",
                data: this.qnai,
            }).then((res) => {
                console.log(res);
                alert("게시글 수정 성공");
                this.moveList();
            }).catch((err) => {
                alert("수정 실패");
                console.log(err);
            });
        },
        commodify() {
            this.comi.comment = this.modcomment
            rest.axios({
                url: "/comments/" + this.comi.num,
                method: "put",
                data: this.comi,
            }).then((res) => {
                console.log(res);
                alert("댓글 수정 성공");
                this.refresh();
            }).catch((err) => {
                alert("수정 실패");
                console.log(err);
            });
        },
        qnadel() {
            rest.axios({
                url: "/qna/" + this.qnai.num,
                method: "delete",
            }).then((res) => {
                if (res.data === "success") {
                    alert("글 삭제 성공");
                    this.moveList();
                }
            }).catch((err)=>{
                alert("글 삭제 실패")
                console.log(err);
            });
        },

        comdel(cmt) {
            
            rest.axios({
                
                url: "/comments/" + cmt.num,
                method: "delete",
            }).then((res) => {
                if (res.data === "success") {
                    alert("댓글 삭제 성공");
                    this.refresh()
                }
            }).catch((err)=>{
                alert("글 삭제 실패")
                console.log(err);
            });
        },

        qnamodOpen() {
            this.qnaform.title = this.qnai.title;
            this.qnaform.content = this.qnai.content;
            this.$refs.qnamod.show();
        },

        commodOpen(cmt) {
            this.modcomment= cmt.comment;
            this.comi = cmt;
            this.$refs.commod.show();
        },

        comregist() {
            if(!this.currentUser) return;
            let user = JSON.parse(storage.getItem('loginUser'))
            this.comform.name = user.name
            this.comform.id = user.id
            this.comform.qna_id = this.$route.params.num
            
            rest.axios({
                url: "/comments",
                method: "post",
                data: this.comform,
            }).then((res) => {
                if(res.data === "success") {
                    alert("댓글이 등록되었습니다");
                    this.comform.comment = '';
                    this.refresh()
                }
            }).catch((err) => {
                alert("등록 실패");
                console.log(err);
            });
        },


        qnahideModal() {
            this.$refs['qna-del-modal'].hide()
        },

        ago(t){
            return dayjs(t).fromNow()
        }
    },

}
</script>