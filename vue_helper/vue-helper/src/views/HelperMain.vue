<template>
  <div id="helper-main">
    <div class="aside">
      <div class="logo">
        <span>HELPER</span>
      </div>
      <div class="auth-buttons">
        <RouterLink :to="{name: 'login'}" class="login-link" >로그인</RouterLink>
        <RouterLink :to="{name: 'signup'}" class="login-signup-link" >회원가입</RouterLink>
      </div>
      <div class="gym-search">
        <h3>헬스장 둘러보기</h3>
        <input type="text" placeholder="헬스장 검색" @input="filterList" />
        <ul>
          <li v-for="gym in store.gymList" :key="gym.name">
            <RouterLink :to="`/home`">{{ gym.name }}</RouterLink>
          </li>
        </ul>
      </div>
    </div>

    <div class="content">
      <h2>
        운동은, HELPER와 함께
      </h2>
      <span>
        지금도 수많은 헬스인이 HELPER와 함께하고 있어요!
      </span>
      <div class="statistics">
        <div class="info__item">
          <div class="stat-icon">
            <img src="@/assets/HelperMain_Img/main_people.png" alt="HELPER 인원">
          </div>
          <div class="stat-info">
            <div class="stat-title">HELPER 인원</div>
            <div class="stat-value">50만</div>
          </div>
        </div>
        <div class="info__item">
          <div class="stat-icon">
            <img src="@/assets/HelperMain_Img/main_place.png" alt="제휴 헬스장">
          </div>
          <div class="stat-info">
            <div class="stat-title">제휴 헬스장</div>
            <div class="stat-value">5만</div>
          </div>
        </div>
        <div class="info__item">
          <div class="stat-icon">
            <img src="@/assets/HelperMain_Img/main_help.png" alt="성사된 도움">
          </div>
          <div class="stat-info">
            <div class="stat-title">성사된 도움</div>
            <div class="stat-value">30만</div>
          </div>
        </div>
        <div class="info__item">
          <div class="stat-icon">
            <img src="@/assets/HelperMain_Img/main_post.png" alt="작성된 게시물">
          </div>
          <div class="stat-info">
            <div class="stat-title">작성된 게시물</div>
            <div class="stat-value">100만</div>
          </div>
        </div>
      </div>
      <br>
      <br>
      <img src="@/assets/HelperMain_Img/main_back.png" alt="main_back">
    </div>
  </div>
</template>
  
<script setup>
  import { RouterLink, RouterView } from 'vue-router';
  import { onMounted } from 'vue';
  import { useGymStore } from '@/stores/gym';

  const store = useGymStore()

  onMounted(() =>{
    store.getGymList()
  })

</script>
  
<style scoped>

  #helper-main {
    display: flex;
  }

  .statistics {
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 25px;
  background-color: #ffffff;
  border-radius: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #f9f9f9;
  max-width: 75%;
  margin: 0 auto;
  margin-top: 30px;
  }

  .info__item {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 10px;
  }

  .stat-icon img {
    width: 30px;
    height: 30px;
  }

  .stat-info {
    text-align: center;
  }

  .stat-title {
    font-weight: bold;
  }
  
  .stat-value {
    font-size: 1.3em;
    font-weight: bold;
    margin-top: 2px;
  }

  .aside {
  top: 0;
  left: 0;
  display: flex;
  flex-direction: column;
  flex-shrink: 0;
  width: 300px;
  height: 100%;
  background-color: rgb(255, 255, 255);
  border-right: 1px solid rgb(240, 240, 240);
  overflow: auto;
  padding: 20px;
  }

  .content {
    flex-grow: 1; /* content가 남은 공간을 채울 수 있도록 설정 */
    margin-left: 20px; /* aside와 content 사이의 간격 설정 */
    text-align: center;
  }

  .content h2 {
    font-size: 40px;
    margin-top: 20px;
    margin-bottom: 5px;
  }

  .content span {
    font-size: 18px;
  }

  .logo {
    margin-bottom: 20px;
    text-align: center;
    background-clip: text;
  }

  .logo span {
    color: #4e4e4e;
    font-size: 36px;
    font-weight: 700;
    background: linear-gradient(to top, aquamarine 10%, transparent 30%);
  }

  .auth-buttons {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
  }

  .auth-buttons button {
    margin-bottom: 10px;
  }

  .gym-search {
    margin-top: 20px;
  }

  .gym-search h3 {
    margin-bottom: 10px;
  }

  .gym-search input {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 20px;
  }

  .gym-search ul {
    list-style: none;
    padding: 0;
  }

  .gym-search li {
    padding: 10px;
    border-bottom: 1px solid #ccc;
  }

  main {
    margin-left: 320px;
    padding: 20px;
    flex-grow: 1;
  }
  
  .app-buttons {
    display: flex;
  }

  .app-buttons img {
    width: 150px;
    margin-right: 10px;
  }

  .auth-buttons a {
    border: none;
    color: #ababab;
    border: 1px solid;
    display: block;
    font-size: 14px;
    font-weight: 700;
    margin: 4px 0;
    padding: 10px;
    width: 100%;
    text-align: center;
  }

  a:hover {
    background-color: #f9f9f9;
  }

</style>