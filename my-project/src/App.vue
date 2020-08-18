<template>
  <div id="app">
    <!--导航栏,并且在登录页面不显示导航栏-->
    <navigation-bar v-show="this.$route.path !== '/login'"></navigation-bar>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
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
