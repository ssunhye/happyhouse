<template>
    <div class="container h-100">
    	<div class="row h-100">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">
                    <b-form>
                        <h1 class="mt-3 text-center">회원 정보</h1>
                        <b-form-group id="id" label="아이디" label-for="id">
                            <b-form-input id="id" :value="user.id" type="text" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="name" label="이름" label-for="name">
                            <b-form-input id="name" :value="user.name" type="text" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="email" label="이메일" label-for="email">
                            <b-form-input id="email" :value="user.email" type="email" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="address" label="주소" label-for="address">
                            <b-form-input id="address" :value="user.address" type="text" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="gender" label="성별" label-for="gender">
                            <b-form-input id="gender" :value="user.gender" type="text" readonly></b-form-input>
                        </b-form-group>
                        <b-form-group id="phone" label="전화번호" label-for="phone">
                            <b-form-input id="phone" :value="user.phone" type="text" readonly></b-form-input>
                        </b-form-group>

                        <div class="text-center m-3">
                            <b-button @click="modify" variant="outline-primary">정보 수정</b-button>
                            <b-button @click="withdraw(user.id)" variant="outline-danger">회원 탈퇴</b-button>
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
const storage = window.sessionStorage;
import rest from "@/js/httpCommon.js";
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
            this.$router.push({
                path: "/user/modify/"+this.user.id,
            })
        },
        withdraw(id) {
            rest.axios({
                url: "/user/" + id,
                method: "delete",
            }).then((res) => {
                if (res.data === "success") {
                    storage.removeItem("jwt-auth-token");
                    storage.removeItem("loginUser");
                    alert("유저 삭제 성공");
                    this.$router.push({
                        path: "/",
                    });
                }
            }).catch((err)=>{
                alert("유저 삭제 실패")
                console.log(err);
            });
        }
    }
}
</script>