<template>
    <div class="container h-100">
    	<div class="row h-100">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
                    <b-form>
                        <h1 class="mt-3 text-center">회원가입</h1>
                        <b-form-group id="id" label="아이디" label-for="id">
                            <b-form-input id="id" v-model="user.id" type="text" placeholder="Enter your Id" required></b-form-input>
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
                        <b-form-group label="성별" v-slot="{ gender }">
                            <b-form-radio-group
                                v-model="user.gender"
                                :options="options"
                                :aria-describedby="gender"
                                name="gender">
                            </b-form-radio-group>
                        </b-form-group>
                        <b-form-group id="phone" label="전화번호" label-for="phone">
                            <b-form-input id="phone" v-model="user.phone" type="text" placeholder="010-xxxx-xxxx" required></b-form-input>
                        </b-form-group>

                        <div class="text-center m-3">
                            <b-button @click="signup" variant="outline-primary">회원 가입</b-button>
                            <b-button @click="moveMain" variant="outline-danger">가입 취소</b-button>
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
export default {
    data() {
        return {
            user: {},
            options: [
                { text: '남성', value: '남' },
                { text: '여성', value: '여' },
            ]};
    },
    methods: {
        moveMain() {
            this.$router.push({
                path: "/",
            })
        },
        signup() {
            rest.axios({
                url: "/user",
                method: "post",
                data: this.user,
            }).then((res) => {
                if(res.data === "success") {
                    alert("유저 등록 성공");
                    this.moveMain();
                }
            }).catch((err) => {
                alert("유저 등록 실패");
                console.log(err);
            });
        },
    }

}
</script>