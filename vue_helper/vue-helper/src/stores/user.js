import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API = 'http://localhost:8080/userapi'

export const useCounterStore = defineStore('counter', () => {
  const loginUserId = ref(null)
  const accessToken = ref('')
 
  const userLogin = function (id,password) {
      axios.post(`${REST_API}/login`,{
        id: id,
        password: password
      },
    )
    .then((res) => {
      console.log("로그인 성공")
      alert("로그인 성공")
      console.log(res.data)

       // 응답 데이터 구조 확인
       if (res.data && res.data.user && res.data.user.accessToken) {
        const token = res.data.user.accessToken
        sessionStorage.setItem('access-token', token)
        accessToken.value = token
        const tokenParts = token.split('.')
        console.log(tokenParts)
        if (tokenParts.length === 3) {
          try {
            const base64Url = tokenParts[1];
            console.log(base64Url);

            // Base64url을 Base64로 변환
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            const paddedBase64 = base64.padEnd(base64.length + (4 - base64.length % 4) % 4, '=');

            const payload = JSON.parse(atob(paddedBase64));
            loginUserId.value = payload.id;

            router.push({ name: 'home' });
          } catch (e) {
            console.error("토큰 페이로드를 디코딩하고 파싱하는데 실패했습니다:", e);
            }
      } else {
        console.error("JWT 형식이 올바르지 않습니다.");
        }
  } else {
    console.error("응답 데이터에 accessToken이 없습니다.");
    }
  })
    .catch((e) => {
      console.log("로그인 실패")
      console.log(e)
    })
  }


    const sendEmailVerificationCode = function (id,email) {
      axios.post(`${REST_API}/send-email-cerification`,{
        id: id,
        email: email
      }
    )
    .then((res) =>{
      console.log(res.data)
      console.log("이메일 발송 성공")
      alert("이메일 발송에 성공하였습니다.")
    })
    .catch((e) =>{
      console.log("이메일 발송에 실패하였습니다")
      console.log(e)
      alert("이메일 발송에 실패하였습니다.")
    })
    }

    const verfiyNumberCode = function (id,email,verficationCodeNumber) {
      axios.post(`${REST_API}/verify-email-certification`,{
        id: id,
        email: email,
        verficationCodeNumber: verficationCodeNumber
      })
      .then((res) =>{
        
      console.log(res.data)
      console.log("이메일 인증에 성공하셨습니다.")
      alert("이메일 인증에 성공하셨습니다")
      })
      .catch((e)=>{
        console.log(e)
        alert(e)
      })
    }
    const checkIdIsDuplicated = function (id) {
      axios.post(`${REST_API}/id-check`,{
        id: id,
      })
      .then((res) =>{
        
      console.log(res.data)
      console.log("사용 가능한 아이디입니다.")
      alert("사용가능한 아이디입니다")
      })
      .catch((e)=>{
        console.log(e)
        alert(e)
      })
    }

    const signUpHelper = function(id,password,email,birthdate,nickname,sex,gymName,verificationCodeNumber) {
      axios.post(`${REST_API}/signup`,{
        user: {
          id: id,
          password: password,
          nickname: nickname,
          email: email,
          birthDate: birthdate,
          sex: sex,
          gymName: gymName
        },
        certificationInfo: {
          id: id,
          email: email,
          certificationNumber: verificationCodeNumber
        }
      })
      .then((res) =>{
        console.log(res.data)
        alert("회원가입이 완료되었습니다")
        router.push({ name: 'home' })
      })
      .catch((e)=>{
        console.log(e)
        alert("올바른 형식을 입력해주세요")
      })
      
    }
   

  
  return{
    accessToken,userLogin, loginUserId, sendEmailVerificationCode, verfiyNumberCode, checkIdIsDuplicated, signUpHelper
  }

})

