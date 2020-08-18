<template>
  <el-row class="tac" style="height: 100%" type="flex" justify="start">
    <el-col :span="3" id="navigation">
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo">
        <!--循环树菜单-->
        <div v-for="(menu,index) in treeMenu" :key="index">
          <!--如果树菜单有子节点,就显示可以展开的样式,index必须是字符串,所以后面+''变成字符串-->
          <el-submenu :index="index + 1 + ''" v-if="menu.children">
            <template slot="title">
              <i class="el-icon-platform-eleme"></i>
              <span>{{menu.name}}</span>
            </template>
            <!--此处自己引用自己,相当于递归调用,将父组件的数据通过组件数据传,传递下去,以此为递归-->
            <navigation-bar :data="menu.children"></navigation-bar>
          </el-submenu>
          <!--没有子节点,显示为没有子节点的样式,index必须是字符串,所以后面+''变成字符串-->
          <el-menu-item :index="index + 1 + ''" v-else>
            <i class="el-icon-menu"></i>
            <span slot="title">{{menu.name}}</span>
          </el-menu-item>
        </div>
      </el-menu>
    </el-col>
    <el-divider direction="vertical"></el-divider>
  </el-row>
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
  /*设定占满屏幕的分割线*/
  .el-divider--vertical {
    display: inline-block;
    width: 1px;
    height: 100%;
    margin: 0 8px;
    vertical-align: middle;
    position: relative;
  }
  /*去掉原本的导航栏分割线*/
  .el-menu {
    border-right: 0 !important;
  }
</style>
