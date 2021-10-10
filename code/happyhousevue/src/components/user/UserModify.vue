<template>
    <div class="container h-100">
    	<div class="row h-100">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
                    <b-form>
                        <h1 class="mt-3 text-center">회원가입</h1>
                        <b-form-group id="id" label="아이디" label-for="id">
                            <b-form-input id="id" v-model="user.id" type="text" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="pass" label="비밀번호" label-for="pass">
                            <b-form-input id="pass" v-model="user.pass" type="password" placeholder="Enter your Password" required></b-form-input>
                        </b-form-group>
                        <b-form-group id="name" label="이름" label-for="name">
                            <b-form-input id="name" v-model="user.name" type="text" placeholder="Enter your Name" required></b-form-input>
                        </b-form-group>
                        <b-form-group id="email" label="이메일" label-for="email">
                            <b-form-input id="email" v-model="user.email" type="email" placeholder="Enter your Email" required></b-form-input>
                        </b-form-group>
                        <b-form-group id="address" label="주소" label-for="address">
                            <b-form-input id="address" v-model="user.address" type="text" placeholder="Enter your Address" required></b-form-input>
                        </b-form-group>
                        <b-form-group id="phone" label="전화번호" label-for="phone">
                            <b-form-input id="phone" v-model="user.phone" type="text" placeholder="010-xxxx-xxxx" required></b-form-input>
                        </b-form-group>

                        <div class="text-center m-3">
                            <b-button @click="modify" variant="outline-primary">수정</b-button>
                            <b-button @click="cancel" variant="outline-danger">취소</b-button>
                        </div>
                    </b-form>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>

</style>
<script>
import rest from "@/js/httpCommon.js";
const storage = window.sessionStorage;

export default {
    created() {
        this.user = JSON.parse(storage.getItem("loginUser"));
    },
    data() {
        return {
            user: {},
        };
    },
    methods: {
        modify() {
            rest.axios({
                url: "/user/" + this.user.id,
                method: "put",
                data: this.user,
            }).then((res) => {
                console.log(this.user);
                if (res.data === "success") {
                    storage.setItem("loginUser", JSON.stringify(this.user));
                    alert("정보 수정 성공");
                    this.$router.push({
                        path: "/user/mypage",
                    });
                } else {
                    alert("정보 수정 실패");
                }
            });
        },
        cancel() {
            this.$router.push({
                path: "/user/mypage",
            });
        },
    },
}
</script>