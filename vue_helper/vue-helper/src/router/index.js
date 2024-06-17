import { createRouter, createWebHistory } from 'vue-router'
import HelperMain from '../views/HelperMain.vue'
import HelperHome from '../views/HelperHome.vue'
import HelperMyPage from '../views/HelperMyPage.vue'
import HelperLogin from '@/components/HelperLogin.vue'
import HelperSignUp from '@/components/HelperSignUp.vue'
import HelperPostDetail from '@/components/HelperPostDetail.vue'
import HelperPostWrite from '@/components/HelperPostWrite.vue'
import HelperPostList from '@/components/HelperPostList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'main',
      component: HelperMain
    },
    {
      path: '/home',
      name: 'home',
      component: HelperHome,
      children: [
        {
          path: '',
          name: 'boardList',
          component: HelperPostList

        },
        {
          path: ':seq',
          name: 'detail',
          component: HelperPostDetail
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: HelperLogin,
    },
    {
      path: '/signup',
      name: 'signup',
      component: HelperSignUp
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: HelperMyPage
    },
    ,
    {
      path: '/postwrite',
      name: 'postwrite',
      component: HelperPostWrite
    }
  ]
})

export default router
