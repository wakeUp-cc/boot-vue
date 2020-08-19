<!--导航栏组件-->
<template>
  <div id="navigation">
    <el-row class="tac" type="flex" justify="start">
      <el-col :span="24">
        <el-menu router default-active="1" class="el-menu-vertical-demo" background-color="#0471c1">
          <!--循环树菜单-->
          <div v-for="(menu,index) in treeMenu" :key="index">
            <!--如果树菜单有子节点,就显示可以展开的样式,index就是路由地址,通过router属性,开启点击后跳转路由-->
            <template v-if="menu.children">
              <el-submenu :index="menu.path">
                <template slot="title">
                  <i :class="menu.icon"></i>
                  <span>{{menu.name}}</span>
                </template>
                <!--此处自己引用自己,相当于递归调用,将父组件的数据通过组件数据传,传递下去,以此为递归-->
                <navigation-bar :data="menu.children"></navigation-bar>
              </el-submenu>
            </template>
            <template v-else>
              <!--没有子节点,显示为没有子节点的样式,index就是路由地址,通过router属性,开启点击后跳转路由-->
              <el-menu-item :index="menu.path">
                <i :class="menu.icon"></i>
                <span slot="title">{{menu.name}}</span>
              </el-menu-item>
            </template>
          </div>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  // 父组件向子组件传递数据,通过props传递
  props: ['data'],
  data () {
    return {
      treeMenu: []
    }
  },
  methods: {
    getTreeMenu () {
      // 如果父组件传递的data值不是未定义的,那么就直接给树菜单赋值
      if (this.data !== undefined) {
        this.treeMenu = this.data
      } else {
        // 如果父组件传递的值为空,那么就证明,没有子节点了
        this.$http.get('/menu/getTreeMenu').then((result) => {
          // props中是父组件向子组件传递的值,不能直接修改,需要通过一个媒介,因此,组件本身也需要一个值来作为顶层节点
          this.treeMenu = result.data.message
        })
      }
    }
  },
  created () {
    this.getTreeMenu()
  }
}
</script>

<style>
  /*设定导航栏的最外侧的框*/
  .tac {
    height: 100%;
    width: 100%;
    float: left
  }

  /*设定导航栏右侧的线占满整个屏幕*/
  .el-menu {
    border-right: solid 1px;
    border-color: #e6e6e6;
    height: 100%;
  }

  #navigation, #navigation span {
    height: 100%;
    color: #ffffff;
  }

</style>
