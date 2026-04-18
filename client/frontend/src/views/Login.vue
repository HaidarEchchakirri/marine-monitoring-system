<template>
  <div class="login-page">
    <div class="overlay"></div>
    <div class="login-container">
      <h2>Xiaoyangkou Marine Monitoring System</h2>
      <input v-model="username" placeholder="Username" />
      <input v-model="password" type="password" placeholder="Password" />
      <button @click="login">Login</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const username = ref('')
const password = ref('')
const router = useRouter()

const login = () => {
  if (username.value === 'admin' && password.value === '1234') {
    router.push('/dashboard')
  } else {
    alert('Invalid login')
  }
}
</script>

<style scoped>
.login-page {
  position: relative;
  min-height: 100vh;
  background: url('/cpicwat.jpg') no-repeat center center fixed;
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  padding: 20px;
  color: white;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 47, 75, 0.6);
  z-index: 1;
}

.login-container {
  position: relative;
  z-index: 2;
  background: rgba(240, 248, 255, 0.85);
  padding: 40px 50px;
  border-radius: 12px;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.25);
  width: 320px;
  text-align: center;
  color: #003f5c;
}

input {
  width: 100%;
  padding: 12px 15px;
  margin-bottom: 20px;
  border: 2px solid #0077be;
  border-radius: 6px;
  font-size: 16px;
  transition: border-color 0.3s ease;
  outline: none;
  box-sizing: border-box;
}

input:focus {
  border-color: #003f5c;
  background: #e0f0ff;
}

button {
  width: 100%;
  padding: 14px 0;
  background-color: #0077be;
  border: none;
  border-radius: 6px;
  color: white;
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0 5px 15px rgba(0, 119, 190, 0.4);
}

button:hover {
  background-color: #005f8f;
  box-shadow: 0 8px 25px rgba(0, 95, 143, 0.6);
}
</style>
