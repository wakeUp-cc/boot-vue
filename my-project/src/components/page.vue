<template>
  <el-pagination
    background
    layout="prev, pager, next"
    :page-size="size === undefined ? 10 : size"
    :total="total === undefined ? 0 : total"
    :current="current === undefined ? 1 : current">
  </el-pagination>
</template>

<script>
export default {
  props: ['total', 'size', 'current'],
  methods: {
    turnPage () {
      this.$http.post('/user/pageUser', this.page).then((result) => {
        this.$emit('turnPage', result.data.message)
      })
    }
  }
}
</script>

<style>
  .el-pagination {
    float: right;
  }
</style>
