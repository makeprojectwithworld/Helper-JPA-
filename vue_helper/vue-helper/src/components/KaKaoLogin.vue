<template>
  <div>
    <div style="display: flex; align-items: center;">
      <a id="custom-login-btn" @click="kakaoLogin()">
        <img
          src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
          width="170" 
          alt="카카오 로그인 버튼"
        />
      </a>
      <a id="custom-login-btn" class="naver-button" @click="naverLogin">
        <img
          src="@/assets/btnW_완성형.png"
          width="170"
          alt="네이버 로그인 버튼"
        />
      </a>
    </div>
  </div>
</template>

<script>
import router from '@/router';

export default {
  methods: {
    kakaoLogin() {
      window.Kakao.Auth.login({
        scope: "account_email",
        success: (authObj) => {
          this.getKakaoAccount();
        },
        fail: (err) => {
          console.error(err);
        },
      });
    },
    getKakaoAccount() {
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          const ninkname = kakao_account.profile.ninkname;
          const email = kakao_account.email;
          console.log("ninkname", ninkname);
          console.log("email", email);

          //로그인처리구현
         
          alert("로그인 성공!");
          router.push({ name: 'home' })
        },
        fail: (error) => {
          console.log(error);
        },
      });
    },
    kakaoLogout() {
      window.Kakao.Auth.logout((res) => {
        console.log(res);
      });
    },
  },
};
</script>
<style>
  .naver-button {
    margin-left: 3%;
  }
</style>