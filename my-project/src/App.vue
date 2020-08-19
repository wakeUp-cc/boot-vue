<template>
  <div id="app">
    <icon/>
    <!--导航栏,并且在登录页面不显示导航栏-->
    <navigation-bar v-show="this.$route.path !== '/login'"></navigation-bar>
    <router-view/>
  </div>
</template>

<script>
import icon from '@/components/icon'
export default {
  name: 'App',
  components: {'icon': icon}
}
</script>

<style>
  /*全局设定*/
  #app, html, body {
    height: 100%;
    padding: 0;
    margin: 0;
  }

  * {
    font-size: 15px;
    color: #333;
    font-family: "微软雅黑";
    box-sizing: border-box;
  }
</style>
