
import router from "@/router"
import { defineStore } from "pinia"
import { ref } from "vue"
import axios from "axios"
import { useCounterStore } from "./user"

const REST_API = 'http://localhost:8080/boardapi'
const REST_API_COMMENT = 'http://localhost:8080/commentapi'


export const useBoardStore = defineStore('board',() => {
  const loginStore = useCounterStore();
  const accessToken = ref('')
  const writeBoard = function(title,content,type) {
    axios.post(`${REST_API}/board`,
    { 
      title: title,
      content: content,
      type: type
    },
    { 
      headers: {
        'accessToken': sessionStorage.accessToken,
        'Authorization': `Bearer ${sessionStorage.accessToken}` // 올바른 위치에 토큰을 헤더에 포함
      }
    })
    .then((res) =>{
      console.log(sessionStorage.accessToken)
      console.log(res.data)
      alert("게시글 작성이 완료되었습니다")
      router.push({ name: 'home' })
    })
    .catch((e)=>{
      console.log(e)
      console.log(accessToken.value)
      alert("게시글 작성 실패")
    })
  }
  
  const post = ref('')
  const selectBoard = function(seq) {
    axios.get(`${REST_API}/board/${seq}`,{
      headers: {
        'access-token': accessToken.value
      }
    })
      .then((response) => {
        post.value = response.data
        console.log(post.value)
    })
  
  }
  const postList = ref({})
  const selectAllBoard = function(){
    axios.get(`${REST_API}/allBoard`,{
      headers: {
        'Authorization': `Bearer ${accessToken.value}`
      }
    })
    .then((res) =>{
      postList.value = res.data
       console.log(postList)
    })
  }

  const commentList = ref({})
  const loadAllcomment = function(seq){
    axios.get(`${REST_API_COMMENT}/comment/${seq}`,{
      headers: {
        'Authorization': `Bearer ${accessToken.value}`
      }
    })
    .then((res) => {
      commentList.value =res.data
    })
  }

  const comment = ref('')
  const addComment = function (boardSeq,content){
    axios.post(`${REST_API_COMMENT}/comment/add`,
      { 
        boardSeq: boardSeq,
        content: content
      },
      { 
        headers: {
          'accessToken': sessionStorage.accessToken,
          'Authorization': `Bearer ${sessionStorage.accessToken}` // 올바른 위치에 토큰을 헤더에 포함
        }
      }
    )
    .then((res) =>{
      comment.value = res.data
      alert("댓글을 작성하셨습니다")
      router.push({ name: 'detail' })
    })
    .catch((e)=>{
      console.log(e)
    })
  }

  return{ comment,addComment,commentList,loadAllcomment,selectBoard, writeBoard, selectAllBoard, postList, accessToken, post}

})