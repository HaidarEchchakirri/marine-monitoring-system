<template>
  <div>
    <h3>Water Quality Parameters Over Time</h3>
    <p v-if="loading">Loading chart...</p>
    <Line v-else-if="chartData.labels.length" :data="chartData" :options="chartOptions" />
    <p v-else>Select a station to load time series data.</p>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { Line } from 'vue-chartjs'
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale
} from 'chart.js'
import { getWaterQualityTimeSeries } from '../api'

ChartJS.register(
  Title,
  Tooltip,
  Legend,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale
)

const props = defineProps({
  station: Object
})

const chartData = ref({
  labels: [],
  datasets: []
})

const chartOptions = {
  responsive: true,
  plugins: {
    legend: { position: 'top' },
    title: { display: true, text: 'Water Quality Over Time' }
  },
  scales: {
    y: { beginAtZero: false }
  }
}

const loading = ref(false)

watch(() => props.station, async (newStation) => {
  if (!newStation) return

  loading.value = true
  try {
    const records = await getWaterQualityTimeSeries(newStation.id)

    chartData.value = {
      labels: records.map(r => new Date(r.time).toLocaleDateString()),
      datasets: [
        {
          label: 'DO (mg/L)',
          data: records.map(r => r.dissolvedOxygen), // ✅ CORRECTED
          borderColor: 'blue',
          fill: false
        },
        {
          label: 'pH',
          data: records.map(r => r.ph), // ✅ ALREADY CORRECT
          borderColor: 'green',
          fill: false
        },
        {
          label: 'Salinity (PSU)',
          data: records.map(r => r.psu), // ✅ CORRECTED
          borderColor: 'purple',
          fill: false
        }
      ]
    }
  } catch (error) {
    console.error('Error loading time series:', error)
    chartData.value = { labels: [], datasets: [] }
  } finally {
    loading.value = false
  }
})
</script>

