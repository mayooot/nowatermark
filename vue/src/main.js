import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import App from './App.vue'
import store from './store'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

import '@/assets/css/global.css'

createApp(App).use(store).use(router).use(ElementPlus, {locale: zhCn,}).mount('#app')
