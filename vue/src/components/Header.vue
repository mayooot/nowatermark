<template>
    <el-menu
        :default-active="path"
        class="el-menu-demo"
        mode="horizontal"
        router
    >
      <el-menu-item index="/watermark" >短视频去水印工具</el-menu-item>
      <el-menu-item index="/sticker">微信表情包工具</el-menu-item>
    </el-menu>
</template>

<script>

export default {
  name: "Header",
  data() {
    return {
      path: '/watermark'
    }
  },
  methods: {

  }
}

</script>

<style scoped>

</style>