<template>
    <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
    >
      <el-menu-item index="1">短视频去水印工具</el-menu-item>
      <el-menu-item index="2">微信表情包工具</el-menu-item>
    </el-menu>
</template>

<script>

export default {
  name: "Header",
  data() {
    return {
      activeIndex: '1'
    }
  },
  methods: {
    handleSelect() {
      alert("123")
    }
  }
}

</script>

<style scoped>

</style>