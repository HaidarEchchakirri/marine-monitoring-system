import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',  // Your Spring Boot backend address
        changeOrigin: true,
        secure: false,
      },
    },
  },
})