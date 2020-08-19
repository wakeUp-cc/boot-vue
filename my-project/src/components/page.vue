<template>
  <el-pagination
    background
    layout="prev, pager, next"
    :page-size="size === undefined ? 10 : size"
    :total="total === undefined ? 0 : total">
  </el-pagination>
</template>

<script>
export default {
  props: ['total', 'size']
}
</script>

<style>
  .el-pagination {
    float: right;
  }
</style>
