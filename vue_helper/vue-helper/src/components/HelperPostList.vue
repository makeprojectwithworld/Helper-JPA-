<template>
  <div class="post-list">
    <div class="post-item" v-for="post in store.postList" :key="post.seq">
      <div class="post-header">
        <RouterLink :to="`/home/${post.seq}`" class="post-title">{{ post.title }}</RouterLink>
      </div>
      <div class="post-content">
        <p>{{ post.content }}</p>
        <span class="post-footer">{{ post.registDate }}</span>
        <div class="post-icons">
          <span class="icon"><font-awesome-icon :icon="['fas', 'eye']" /> <span class="icon-text">{{ post.viewCnt }}</span></span>
          <span class="icon"><font-awesome-icon :icon="['fas', 'thumbs-up']" /> <span class="icon-text">{{ post.likes }}</span></span>
          <!-- <span class="icon"><font-awesome-icon :icon="['fas', 'comment']" /> <span class="icon-text">{{ post.comments }}</span></span> -->
        </div>
      </div>
    </div>
  </div>

</template>

<script setup>

import { useBoardStore } from '@/stores/board';
import { onMounted } from 'vue';
import { RouterLink, RouterView } from 'vue-router';


const store = useBoardStore()

onMounted(() =>{
  store.selectAllBoard()
})

</script>

<style scoped>
.post-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  width: 100%;
}

.post-item {
  width: 48%;
  background: white;
  border: 1px solid #ddd;
  margin-bottom: 20px;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.post-header {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-bottom: 10px;
}

.post-title {
  font-size: 18px;
  font-weight: bold;
}

.post-content {
  font-size: 14px;
}

.post-footer {
  margin-top: 10px;
  font-size: 12px;
  color: gray;
}

.post-icons {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

.icon {
  display: flex;
  align-items: center;
  font-size: 12px;
  color: gray;
  margin-right: 15px;
}

.icon .fa-icon {
  margin-right: 5px;
}

.icon-text {
  margin-left: 5px;
}
</style>