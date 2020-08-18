<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
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
