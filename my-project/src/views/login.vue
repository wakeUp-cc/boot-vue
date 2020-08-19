<template>
  <div id="login">
    <el-row style="height: 30%"/>
    <el-row>
      <el-col :offset="9" :span="1">
        <el-card style="width: 380px">
          <div style="text-align: center;">登录</div>
          <hr/>
          <el-form ref="form" :model="login">
            <el-form-item>
              <el-input v-model="login.username" size="small" placeholder="用户名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input v-model="login.password" size="small" placeholder="密码" show-password></el-input>
            </el-form-item>
            <el-form-item>
              <el-button size="small" round @click="loginSubmit">登录</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      login: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    loginSubmit () {
      let user = {username: this.login.username, password: this.login.password}
      this.$http.post('/user/login', user).then((result) => {
        if (result.data.status === 1) {
          this.$router.push('/index')
        }
      })
    }
  }
}
</script>

<style scoped>
  #login {
    background: url("../assets/登录背景.jpg");
    background-size:100% 100%;
    -moz-background-size:100% 100%;
    margin: 0;
    height: 100%;
  }
</style>
