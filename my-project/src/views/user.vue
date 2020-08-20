<template>
  <div id="user">
    <el-table
      :data="page.records"
      stripe
      style="width: 100%">
      <el-table-column
        prop="username"
        label="账号"
        min-width="400">
      </el-table-column>
      <el-table-column
        prop="name"
        label="用户名"
        min-width="400">
      </el-table-column>
    </el-table>
    <page :total="page.total" :size="page.size" :current="page.current"></page>
  </div>
</template>

<script>
import page from '@/components/page'
export default {
  data () {
    return {
      page: {
        size: 2,
        current: 1
      }
    }
  },
  methods: {
    initTableData () {
      this.$http.post('/user/pageUser', this.page).then((result) => {
        this.page = result.data.message
      })
    }
  },
  created () {
    this.initTableData()
  },
  components: {page: page}
}
</script>

<style>
  #user {
    float: left;
    width: 85%;
  }
</style>
