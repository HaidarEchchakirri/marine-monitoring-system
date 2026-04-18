<template>
  <div>
    <h3>Species Distribution</h3>
    <Pie v-if="chartData.labels.length" :data="chartData" :options="chartOptions" />
    <p v-else>Loading species distribution...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { Pie } from 'vue-chartjs'
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  ArcElement
} from 'chart.js'
import axios from 'axios'

ChartJS.register(Title, Tooltip, Legend, ArcElement)

const chartData = ref({
  labels: [],
  datasets: []
})

const chartOptions = ref({
  responsive: true,
  plugins: {
    legend: {
      position: 'right'
    },
    title: {
      display: true,
      text: 'Species Biomass Distribution'
    }
  }
})

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/species-distribution')

    const labels = response.data.map(item => item.species)
    const biomassData = response.data.map(item => item.biomass)

    chartData.value = {
      labels,
      datasets: [
        {
          data: biomassData,
          backgroundColor: [
            '#36A2EB',
            '#FF6384',
            '#FFCE56',
            '#4BC0C0',
            '#9966FF'
          ]
        }
      ]
    }
  } catch (error) {
    console.error('Failed to fetch species distribution:', error)
  }
})
</script>


