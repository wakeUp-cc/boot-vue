import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    // 登录页
    {path: '/', redirect: '/login'},
    {path: '/login', component: () => import('@/views/login')},
    {path: '/index', component: () => import('@/views/index')}
  ]
})
