import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'leaflet/dist/leaflet.css'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8080/api' // Change if your backend runs elsewher
createApp(App).use(router).mount('#app')
