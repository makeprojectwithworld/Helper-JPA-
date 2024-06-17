<template>
  <div class="body-container">
    <div class="login-container">
      <div class="login">
        <h1 class="login-title"><span class="logo">HELPER</span> 로그인</h1>
        <label>아이디</label>
        <input
          name="username"
          type="text"
          placeholder="Email 또는 전화번호"
          v-model.trim = "id"
        />
        <label>비밀번호</label>
        <input
          name="password"
          type="password"
          placeholder="비밀번호"
          v-model.trim = "password"
        />
        <div class="login-forgot">
          <a class="login-forgot-link" href="#">비밀번호를 잊으셨나요?</a>
        </div>
        <button class="button" @click = "login" >로그인</button>
        <div>
          <KaKaoLogin />
        </div>
        
        <div class="login-signup">
          회원이 아니신가요?
          <RouterLink :to="{name: 'signup'}" class="login-signup-link" >가입하기</RouterLink>
        </div>
      </div>
    </div>

  </div>
  
</template>

<script setup>
  import { useCounterStore } from '@/stores/user';
  import KaKaoLogin from './KaKaoLogin.vue';
  import { RouterLink, RouterView } from 'vue-router';
  import {ref} from 'vue';

  const id = ref('');
  const password = ref('');

  const store = useCounterStore();

  const login = () => {
    store.userLogin(id.value, password.value)
  }
</script>

<style scope>
  html {
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 16px;
    font-weight: 400;
  }

  label {
    color: #2c2c2c;
    display: block;
    margin: 16px 0 8px;
  }

  input {
    border: 1px solid #d1d1d1;
    color: #ababab;
    display: block;
    font-size: 16px;
    line-height: 24px;
    margin: 8px 0;
    padding: 16px 24px;
    width: 100%;
  }

  button {
    background-color: #2c2c2c;
    border: none;
    color: #ffffff;
    display: flex;
    font-size: 18px;
    font-weight: 700;
    margin: 24px 0;
    padding: 16px;
    width: 100%;
  }

  .button {
    font-size: 18px;
    font-weight: 700;
    margin: 24px auto;
    padding: 16px;
    width: calc(50% - 5px);
    display: flex;
    text-align: center;
    border-radius: 10px;
    justify-content: center;
  }

  * {
    box-sizing: border-box;
    border-radius: 10px;
  }

  .body-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }

  .login-container {
    background-color: #f1f3f5; /* 원하는 백그라운드 컬러 지정 */
    padding: 30px;
    width: 420px; /* 컨테이너 너비 */
    border-radius: 20px; /* 모서리 둥글기 */
  }

  .logo {
    color: #4e4e4e;
    font-size: 36px;
    font-weight: 700;
    background: linear-gradient(to top, aquamarine 10%, transparent 30%);
  }

  .login {
    margin: 0px auto;
    width: 360px;
  }

  .login-title {
    color: #4e4e4e;
    font-size: 36px;
    font-weight: 700;
    text-align: center;
  }

  .login-forgot {
    text-align: right;
  }

  .login-forgot-link {
    font-size: 14px;
    color: #ababab;
  }

  .login-signup {
    margin-top: 15px;
    font-size: 14px;
    text-align: center;
    color: #ababab;
  }

  .login-signup-link {
    color: #2c2c2c;
  }
</style>