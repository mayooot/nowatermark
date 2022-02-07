<template>
  <!-- 懒洋洋logo图片 -->
  <el-row style="margin-top: 50px" justify="center" align="middle">
    <el-image
        style="width: 200px;height: 200px"
        src="https://s4.ax1x.com/2022/02/07/HMGy1e.jpg"
    ></el-image>
  </el-row>
  <!-- 主体部分 -->
  <el-row style="margin-top: 10px" justify="center" align="middle">
      <el-input v-model="inputUrl" placeholder="请输入分享链接" style="width: 40%; display: inline-table;"></el-input>
      <el-popover
        placement="top-start"
        :width="200"
        trigger="hover"
        content="直接下载视频或图片"
      >
      <template #reference>
        <el-button type="primary" style="margin: 0 5px" @click="download()">下载</el-button>
      </template>
    </el-popover>
      <el-popover
        placement="top-start"
        :width="200"
        trigger="hover"
        content="在线预览视频或图片"
      >
      <template #reference>
        <el-button type="success" style="margin: 0 5px" @click="preview()">预览</el-button>
      </template>
    </el-popover>

     <!-- 视频预览框 -->
      <el-dialog
          v-model="dialogVisible"
          width="80%"
          title="预览☁️"
      >
        <span class="demonstration">视频封面：</span>
          <el-image
              :style="{width: (this.video.width / 10) + 'px', height: (this.video.height / 10) + 'px'}"
              :src="this.previewCover"
          ></el-image>
        <el-divider border-style="dashed"></el-divider>

        <span style="color: #999">下载地址（链接仅存在1分钟，过期自动删除）：</span>
        <el-link :href="previewUrl" target="_blank" type="success">{{ previewUrl }}</el-link>
        <template #footer>
      <span class="dialog-footer">
        <el-button type="success" @click="dialogVisible = false"
        >确认</el-button
        >
      </span>
        </template>
      </el-dialog>

      <!-- 图集预览框 -->
      <el-dialog
          v-model="imagesDialogVisible"
          width="90%"
          title="预览🐾"
      >
          <el-carousel :interval="2000" type="card" height="200px">
            <el-carousel-item v-for="item in carouselList" :key="item">
              <el-image
                  style="width: 100%;height: 100%;object-fit: contain;"
                  :src="item.url"
                  @click="downloadFile(item.url, item.url.split('/')[1], true)"
              ></el-image>>
            </el-carousel-item>
          </el-carousel>
        <span style="color: #999999">直接点击图片即可下载，展示的图片为缩略图，下载之后的为高清原图。</span><br>
        <span style="color: #999999">图片过期自动删除，请尽快操作。</span><br>
        <template #footer>
      <span class="dialog-footer">
        <el-button type="success" @click="dialogVisible = false"
        >确认</el-button
        >
      </span>
        </template>
      </el-dialog>
    </el-row>

</template>
<script>
import request from "@/utils/request";


export default {
  name: "Watermark",
  data() {
    return {
      inputUrl: '',
      dialogVisible: false,
      imagesDialogVisible: false,
      previewUrl: '',
      previewCover: '',
      carouselList: [],
      imageUrl: '',
      video: {
        width: '108',
        height: '192'
      },
      image: {
        width: '108',
        height: '192'
      }
    }
  },
  methods: {
    download() {
      // 如果输入的url为空，则不进行解析
      let url = this.inputUrl.trim()
      if (url === '') {
        this.$message({
          message: '分享地址不能为空',
          type: 'warning'
        })
        return
      }
      this.$message({
        type: 'success',
        message: '正在解析中，请稍等片刻~🪄'
      })
      // 发送axios请求
      request.post("/bare", {
        url: url
      }).then(res => {
        if (res.code === 200) {
          // 清空输入框
          this.inputUrl = ''
          // 请求成功，下载
          if (res.data.type === 'VIDEO') {
              this.$message({
                type: 'success',
                message: '解析成功！作品类型为视频，正在下载！👻'
              })
            let downloadUrl = res.data.videos[0].url // 获取下载路径
            let fileName = downloadUrl.split("/")[1] // 获取文件名

            this.downloadFile(downloadUrl, fileName) // 调用下载方法
          } else if (res.data.type === 'IMAGE'){
            this.$message({
              type: 'success',
              message: '解析成功！作品类型为图集，正在下载！👻'
            })
            // 遍历图集，下载完一张删除一张
            for (let i = 0; i < res.data.images.length; i++) {
              let downloadUrl = res.data.images[i].url // 获取下载路径
              let fileName = downloadUrl.split("/")[1] // 获取文件名

              this.downloadFile(downloadUrl, fileName) // 调用下载方法
            }
          } else {
            this.$message({
              type: 'error',
              message: '服务器出小差了，要不等会再试试🥵'
            })
          }
        } else {
          // 请求失败，给出提醒，同时清空输入框
          this.inputUrl = ''
          this.$message({
            type: 'error',
            message: '解析失败！链接错误或暂不支持该平台 😥'
          })
        }

      })
    },
    preview() {
      // 如果输入的url为空，则不进行解析
      let url = this.inputUrl.trim()
      if (url === '') {
        this.$message({
          message: '分享地址不能为空',
          type: 'warning'
        })
        return
      }
      this.$message({
        type: 'success',
        message: '正在解析中，请稍等片刻~🪄'
      })
      // 发送axios请求
      request.post("/bare", {
        url: url
      }).then(res => {
        if (res.code === 200) {
          console.log(res.data)
          // 清空输入框
          this.inputUrl = ''
          // 请求成功，先弹出警告栏，再弹出信息窗口
          if (res.data.type === 'VIDEO') {
            this.$message({
              type: 'success',
              message: '解析成功！作品类型为视频!'
            })
            this.previewCover = res.data.cover.url
            this.previewUrl = res.data.videos[0].url
            this.video.width = res.data.videos[0].width
            this.video.height = res.data.videos[0].height
            this.dialogVisible = true
            this.deleteFile(this.previewUrl) // 调用删除方法
          } else if (res.data.type === 'IMAGE') {
            this.$message({
              type: 'success',
              message: '解析成功！作品类型为图集'
            })
           this.carouselList = res.data.images
           this.imagesDialogVisible = true
            for (let i = 0; i < this.carouselList.length; i++) {
              this.deleteFile(this.carouselList[i].url)
            }
          } else {
            this.$message({
              type: 'error',
              message: '服务器出小差了，要不等会再试试🥵'
            })
          }
        } else {
          // 请求失败，给出提醒，同时清空输入框
          this.inputUrl = ''
          this.$message({
            type: 'error',
            message: '解析失败！链接错误或暂不支持该平台 😥'
          })
        }
      })
    },
    deleteFile(downloadUrl) {
      // 一分钟后自动发送删除请求
      setTimeout(() => {
        request.post("/delete", {
          path: downloadUrl
        })
      }, 1000 * 60)
    },
    downloadFile(downloadUrl, fileName, isNeedAlert) {
      if (isNeedAlert) {
        this.$message({
          type: 'success',
          message: '下载成功 🐼'
        })
      }
      let link = document.createElement("a"); //创建a标签
      link.style.display = "none"; //使其隐藏
      link.href = downloadUrl //赋予文件下载地址
      link.setAttribute("download", fileName); //设置下载属性 以及文件名
      document.body.appendChild(link); //a标签插至页面中
      link.click(); //强制触发a标签事件
      this.deleteFile(downloadUrl) // 调用删除方法
    }
  }
}
</script>

<style scoped>
.el-dialog {
  margin-top: 9vh !important;
  margin-bottom: 8vh !important;
  overflow: auto;
}

.demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}




</style>