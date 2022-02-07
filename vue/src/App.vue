<template>
  <div>
    <!-- 头部 -->
    <Header />
  </div>
  <router-view/>
</template>

<style>
</style>

<script>
  import Header from "@/components/Header";
  import Watermark from "@/views/Watermark";
  import Sticker from "@/views/Sticker";

  export default {
    name: "Layout",
    components: {
      Header,
      Watermark,
      Sticker
    }
  }
</script>