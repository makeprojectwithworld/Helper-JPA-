<template>
  <div class="post-detail">
    <div class="post-header">
      <h1>{{ store.post.title }}</h1>
      <div class="post-meta">
        <span class="author">{{ store.post.userNickname }}</span>
        <span class="date">{{ store.post.registDate }}</span>
      </div>
    </div>
    <div class="post-content">
      <p>{{ store.post.content }}</p>
    </div>
    <div class="post-reactions">
      <!-- <span class="reaction" @click="toggleLikePost"> -->
        <font-awesome-icon icon="thumbs-up" />
        <span class="icon-text"> {{ store.post.likes }} </span>
      
      <!-- <span v-if="likedPostByUser" class="reaction cancel-like"> -->
        <!-- <span @click="toggleLikePost" class="cancel-text">좋아요 취소</span> -->
      
      <span class="reaction">
        <font-awesome-icon icon="comment" />
        <!-- <span class="icon-text"> {{ store.post.comments.length }} </span> -->
      </span>
    </div>
    <div class="post-comments">
      <!-- <h2>댓글 {{ post.comments.length }}</h2> -->
      <div class="comment-input">
        <font-awesome-icon icon="camera" />
        <input type="text" placeholder="댓글을 남겨주세요." v-model="content" @keyup.enter ="addComment" />
      </div>
      <div class="comments-list">
        <div class="comment" v-for="comment in store.commentList" :key="comment.id">
          <div class="comment-meta">
            <span class="comment-author">{{ comment.userNickname }}</span>
            <span class="comment-date">{{ comment.registDate }}</span>
          </div>
          <div class="comment-content">
            <p>{{ comment.content }}</p>
          </div>
        
          <div class="comment-actions">
              <font-awesome-icon icon="thumbs-up" />
              <span class="icon-text"> {{ comment.likes }} </span>
          
            <!-- <span v-if="likedCommentByUser(comment)" class="reaction cancel-like"> -->
              <!-- <span @click="cancelLikeComment(comment)" class="cancel-text">좋아요 취소</span> -->
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { ref } from 'vue';

const store = useBoardStore()

const route = useRoute();
const router = useRouter();
const content = ref('')

onMounted(() =>{
  store.selectBoard(route.params.seq)
  store.loadAllcomment(route.params.seq)
})

const addComment = () => {
  store.addComment(route.params.seq,content.value)
}

</script>


<style scoped>
p {
  margin-top: 5px;
}

.post-detail {
  max-width: 800px;
  margin: 3% auto;
  padding: 20px;
  background: white;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.post-header {
  border-bottom: 1px solid #ddd;
  padding-bottom: 10px;
  border-radius: 0px;
}

.post-header h1 {
  font-size: 24px;
  margin-bottom: 10px;
}

.post-meta {
  display: flex;
  gap: 10px;
  font-size: 14px;
  color: gray;
}

.post-content {
  padding: 20px 0;
}

.post-reactions {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
  font-size: 12px;
}

.reaction {
  display: flex;
  align-items: center;
  cursor: pointer;
}

.reaction .fa-icon {
  margin-right: 5px;
}

.icon-text {
  margin-left: 5px;
}

.cancel-like {
  font-size: 12px;
  color: gray;
}

.cancel-text {
  cursor: pointer;
  color: gray;
  margin-left: 5px; /* 좋아요 숫자 오른쪽에 위치하도록 여백 추가 */
}

.post-comments {
  border-top: 1px solid #ddd;
  padding-top: 20px;
  border-radius: 0px;
}

.comment-input {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 20px;
}

.comment-input input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.comments-list {
  margin-top: 10px;
}

.comment {
  padding: 10px;
  border-bottom: 1px solid #ddd;
  border-radius: 0px;
}

.comment-meta {
  display: flex;
  gap: 10px;
  font-size: 14px;
  color: gray;
  margin-bottom: 5px;
}

.comment-content {
  font-size: 16px;
  margin-bottom: 5px;
}

.comment-actions {
  font-size: 12px; /* 포스트의 좋아요 폰트 크기와 동일하게 설정 */
  color: gray;
  display: flex;
  align-items: center;
}

.comment-like {
  display: flex;
  align-items: center;
  cursor: pointer;
}

.comment-like .fa-icon {
  margin-right: 5px;
}
</style>