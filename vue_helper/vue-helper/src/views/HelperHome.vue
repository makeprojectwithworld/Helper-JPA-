<template>
  <HelperHeader />
  <!-- <HelperPostList /> -->
  <RouterView/>
</template>

<script setup>
import { RouterLink, RouterView, useRoute } from 'vue-router';

import HelperHeader from '@/components/HelperHeader.vue';
import HelperPostList from '@/components/HelperPostList.vue';
import HelperPostDetail from '@/components/HelperPostDetail.vue';


</script>


<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  max-width: 1200px;
  margin: 20px auto;
}

.logo {
  display: flex;
  align-items: center;
  margin-right: 20px;
}

.logo span {
  color: #4e4e4e;
  font-size: 36px;
  font-weight: 700;
  background: linear-gradient(to top, aquamarine 10%, transparent 30%);
}

.gym {
  background-color: lightgrey;
  padding: 5px;
  margin-right: 10px;
  color: white;
  border: none;
}

.nav-links {
  display: flex;
  align-items: center;
  margin-right: 20px;
  margin-left: 1%;
}

.nav-link {
  margin: 0 10px;
  text-decoration: none;
  color: #4e4e4e;
  font-size: 18px;
}

.nav-link:hover {
  text-decoration: underline;
}

.search-bar {
  flex: 1;
  display: flex;
  justify-content: flex-end;
  margin-right: 20px;
}

.search-bar input {
  width: 100%;
  max-width: 300px;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.write-button {
  background-color: #ff4d4f;
  color: white;
  border: none;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
  width: 10%;
  text-decoration: none;
  text-align: center;
}

.main-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  max-width: 1200px;
  margin: 20px auto;
}
</style>