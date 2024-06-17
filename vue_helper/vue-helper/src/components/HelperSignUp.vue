<template>
  <div class="body-container">
    <div class="signup-container">
      <div class="signup">
        <h1 class="singup-title"><span class="logo">HELPER</span> 회원가입</h1>
        <label>아이디</label>
        <input
          name="user-name"
          type="text"
          placeholder="아이디를 입력하세요"
          v-model.trim="id"
        />
        <button type="button" class="id-verify-btn" @click="checkIdIsDuplicated">아이디 중복 체크</button>
        
        <label>비밀번호</label>
        <input
          name="password"
          type="password"
          placeholder="비밀번호"
          v-model.trim="password"
        />
        <label>이메일</label>
        <div class="email-container">
          <input 
          name="email" 
          type="email" 
          placeholder="이메일을 입력하세요" 
          class="email-input"
          v-model.trim="email" />
          <button type="button" class="email-send-btn" @click="sendEmailVerificationCode">이메일 인증코드 발송</button>
        </div>
        <div class="email-verify-container">
          <input 
          name="email-code" 
          type="text" 
          placeholder="인증코드 입력" 
          class="email-code-input"
          v-model.trim="verificationCodeNumber" />
          <button type="button" class="email-verify-btn" @click="verifyNumberCode">인증코드 확인</button>
        </div>
        <label>생년월일</label>
        <input
          name="user-birth"
          type="text"
          placeholder="생년-월-일 형식으로 입력하세요"
          v-model.trim="birthdate"
        />
        <label>닉네임</label>
        <input
          name="user-nickname"
          type="text"
          placeholder="닉네임"
          v-model.trim="nickName"
        />
        <label for="dropdown">성별</label>
        <select 
          id="dropdown"
          name="user-sex"
          class="dropdown-sex"
          v-model.trim="sex">
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
        <!-- <label>별명</label>
        <input
          name="user-nickname"
          type="text"
          placeholder="별명"
        /> -->
        <label for="dropdown">헬스장</label>
        <select 
        id="dropdown" 
        name="user-gym" 
        class="dropdown-gym"
        v-model.trim="gymName"
        >
          <option value="바이젝월드스튜디오">바이젝월드스튜디오</option> <!-- -> 헬스장으로 될 수 있도록 v-for 사용 필요!!! -->
          <option value="동국스포츠">동국스포츠</option>
        </select>
        <div class="button-container">
          <RouterLink :to="{name: 'main'}" class="button-cancel" >취소</RouterLink>
          <button class="button-register" @click="signUpHelper">등록</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
  import { useCounterStore } from '@/stores/user';
  import KaKaoLogin from './KaKaoLogin.vue';
  import{ref} from 'vue';
  import { RouterLink } from 'vue-router';

  const store = useCounterStore();


  const id = ref('');
  const password = ref('');
  const email = ref('');
  const verificationCodeNumber = ref('');
  const birthdate = ref('');
  const sex = ref('');
  const gymName = ref('');
  const nickName = ref('');

  const signUpHelper = () => {
    store.signUpHelper(id.value,password.value,email.value,birthdate.value,nickName.value,sex.value,gymName.value,verificationCodeNumber.value)
  }

  const checkIdIsDuplicated = () => {
    store.checkIdIsDuplicated(id.value)
  }

  const sendEmailVerificationCode = () => {
    store.sendEmailVerificationCode(id.value,email.value)
  }

  const verifyNumberCode = () => {
    store.verfiyNumberCode(id.value,email.value,verificationCodeNumber.value);
  }
</script>

<style scope>
  .body-container {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    height: 100vh;
    overflow-y: auto; /* 화면이 짤리지 않도록 스크롤바 추가 */
  }

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

  .email-verify-btn{
    width: 80%;
    display: flex;
    text-align: center;
    justify-content: center;
  }

  .email-send-btn{
    width: 80%;
    display: flex;
    text-align: center;
    justify-content: center;
  }

  .id-verify-btn{
    display: flex;
    text-align: center;
    justify-content: center;
    width: 80%;
  }

/* 버튼 공통 스타일 */
button, .button-cancel, .button-register {
  font-size: 18px;
  font-weight: 700;
  margin: 24px auto;
  padding: 16px;
  width: calc(50% - 5px); /* 버튼을 반반 나누고, 사이 간격을 고려해 조정 */
  display: inline-block; /* 인라인 블록 요소로 설정하여 옆으로 배치 */
  text-align: center; /* 텍스트 가운데 정렬 */
  border-radius: 10px; /* 모서리 둥글게 */
}

/* 등록 버튼 특화 스타일 */
.button-register {
  background-color: #2c2c2c;
  border: none;
  color: #ffffff;
}

/* 취소 버튼 특화 스타일 */
.button-cancel {
  background-color: white;
  border: 1px solid #d1d1d1;
  color: black;
  text-decoration: none; /* 링크의 밑줄 등 제거 */
  display: inline-flex; /* 인라인 플렉스로 설정하여 내부 텍스트를 가운데 정렬 */
  justify-content: center; /* 가로 내용 가운데 정렬 */
  align-items: center; /* 세로 내용 가운데 정렬 */
}

/* 선택적: 버튼 사이 간격을 추가할 필요가 없어짐 */


  *{
    box-sizing: border-box;
    border-radius: 10px;
  }

  .signup {
    margin: 0 auto;
    width: 360px;
  }

  .signup-container {
    background-color: #f1f3f5; /* 원하는 백그라운드 컬러 지정 */
    width: 420px; /* 컨테이너 너비 */
    border-radius: 20px; /* 모서리 둥글기 */
    padding: 10px;
  }

  .logo {
    color: #4e4e4e;
    font-size: 36px;
    font-weight: 700;
    background: linear-gradient(to top, aquamarine 10%, transparent 30%);
  }

  .singup {
    margin: 0px auto;
    width: 360px;
  }

  .singup-title {
    color: #4e4e4e;
    font-size: 36px;
    font-weight: 700;
    text-align: center;
  }

  select {
    padding: 16px 10px; /* 내부 여백 조정 */
    font-size: 16px; /* 글자 크기 조정 */
    border: 1px solid #d1d1d1;
    color: #ababab;
  }

  .dropdown-sex {
    width: 100px; /* 너비 조정 */
  }

  .dropdown-gym {
    width: 250px; /* 너비 조정 */
  }

</style>