<template>
  <HelperHeader />
  <div class="post-form">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="board.title" placeholder="제목을 입력해주세요." />
    </div>
    <div class="form-group">
      <label for="type">기능</label>
      <select id="type" v-model="board.type">
        <option value="자유">자유</option>
        <option valye="보조">보조</option>
        <option value="도움">도움</option>
      </select>
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" v-model="board.content" placeholder="내용을 입력해주세요."></textarea>
    </div>
    <button @click="writeBoard">제출</button>
  </div>
</template>

<script setup>
import HelperHeader from '@/components/HelperHeader.vue';
import { useBoardStore } from '@/stores/board';
import { onMounted } from 'vue';
import { ref } from 'vue';

const store = useBoardStore()
const board =ref({
  title: '',
  type: '',
  content: ''
})

const writeBoard = () =>{
  store.writeBoard(board.value.title,board.value.content,board.value.type)
}

</script>

<style scoped>
.post-form {
  max-width: 1200px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
  background-color: #f9f9f9;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"],
textarea,
select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
}

textarea {
  height: 150px;
  resize: vertical;
}

button {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #007BFF;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>