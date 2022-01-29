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

  export default {
    name: "Layout",
    components: {
      Header
    }
  }
</script>