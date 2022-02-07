import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/watermark'
  },
  {
    path: '/watermark',
    name: 'Watermark',
    component: () => import("@/views/Watermark")
  },
  {
    path: '/sticker',
    name: 'sticker',
    component: () => import("@/views/Sticker")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
