<template>
  <div class="dashboard-wrapper">
    <aside class="sidebar">
      <h2 class="sidebar-title">Xiaoyangkou Marine Monitoring</h2>
      <nav class="sidebar-nav">
        <router-link to="/avg_station" active-class="active">Avg Station</router-link>
        <router-link to="/benthos_data" active-class="active">Benthos Data</router-link>
        <router-link to="/biology_data" active-class="active">Biology Data</router-link>
        <router-link to="/float_animal_data" active-class="active">Float Animal Data</router-link>
        <router-link to="/float_plant_data" active-class="active">Float Plant Data</router-link>
        <router-link to="/interdite_zone_data" active-class="active">Interdite Zone Data</router-link>
        <router-link to="/ocean_bouy_data" active-class="active">Ocean Bouy Data</router-link>
        <router-link to="/" class="logout">Logout</router-link>
      </nav>
    </aside>

    <main class="main-content">
      <h1 class="page-title">Dashboard</h1>

      <section class="card map-card">
        <div id="map" ref="map"></div>
      </section>

      <section class="card details-card">
        <StationDetail :station="selectedStation" :stationData="stationData" />
        <WaterQualityChart :station="selectedStation" />
      </section>

      <section class="card pie-chart-card">
        <h2>Marine Ecological Dashboard</h2>
        <SpeciesPieChart />
      </section>
    </main>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import L from 'leaflet'
import iconUrl from 'leaflet/dist/images/marker-icon.png'
import iconShadowUrl from 'leaflet/dist/images/marker-shadow.png'
import { getStations, getStationDetails } from '../api'
import SpeciesPieChart from '../components/SpeciesPieChart.vue'
import StationDetail from '../components/StationDetail.vue'
import WaterQualityChart from '../components/WaterQualityChart.vue'

delete L.Icon.Default.prototype._getIconUrl

L.Icon.Default.mergeOptions({
  iconUrl,
  shadowUrl: iconShadowUrl,
})

const map = ref(null)
const selectedStation = ref(null)
const stations = ref([])
const stationData = ref(null)

const fetchStationData = async (id) => {
  try {
    stationData.value = await getStationDetails(id)
  } catch (err) {
    console.error(`Error loading data for station ${id}:`, err)
    stationData.value = null
  }
}

onMounted(async () => {
  try {
    stations.value = await getStations()

    map.value = L.map('map').setView([32.7, 122.0], 10)

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map.value)

    stations.value.forEach(station => {
      const lat = Number(station.lat ?? station.latitude)
      const lng = Number(station.lng ?? station.longitude)

      if (!isNaN(lat) && !isNaN(lng)) {
        const marker = L.marker([lat, lng]).addTo(map.value)
        marker.bindPopup(`<b>${station.name}</b><br>ID: ${station.id}`)

        marker.on('click', async () => {
          selectedStation.value = station
          await fetchStationData(station.id)
          marker.openPopup()
        })
      } else {
        console.warn(`Station "${station.name}" has invalid coordinates: lat=${station.lat}, lng=${station.lng}`)
      }
    })
  } catch (error) {
    console.error('Failed to load stations:', error)
  }
})
</script>

<style scoped>
/* Layout */
.dashboard-wrapper {
  display: flex;
  height: 100vh;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #003f5c;
  background: #f0f8ff;
}

.sidebar {
  width: 250px;
  background: #004e89;
  color: white;
  display: flex;
  flex-direction: column;
  padding: 20px;
  box-shadow: 3px 0 8px rgba(0, 0, 0, 0.1);
}

.sidebar-title {
  font-size: 1.6rem;
  font-weight: 700;
  margin-bottom: 30px;
  text-align: center;
  letter-spacing: 1px;
}

.sidebar-nav {
  display: flex;
  flex-direction: column;
  gap: 12px;
  flex-grow: 1;
}

.sidebar-nav a {
  color: #bbe1fa;
  text-decoration: none;
  padding: 10px 15px;
  border-radius: 6px;
  font-weight: 600;
  transition: background-color 0.3s ease, color 0.3s ease;
}

.sidebar-nav a:hover,
.sidebar-nav a.active {
  background-color: #0284c7;
  color: white;
}

.logout {
  margin-top: auto;
  background-color: #e63946;
  color: white !important;
  font-weight: 700;
  text-align: center;
}

.logout:hover {
  background-color: #b71c1c;
  color: white !important;
  cursor: pointer;
}

.main-content {
  flex-grow: 1;
  padding: 30px 40px;
  overflow-y: auto;
}

.page-title {
  font-size: 2rem;
  font-weight: 700;
  margin-bottom: 25px;
  color: #023e8a;
  text-align: center;
}

/* Cards */
.card {
  background: white;
  padding: 20px 25px;
  border-radius: 12px;
  box-shadow: 0 8px 25px rgb(0 63 92 / 0.15);
  margin-bottom: 30px;
}

.map-card {
  height: 400px;
}

#map {
  height: 100%;
  width: 100%;
  border-radius: 12px;
}

/* Station Detail + WaterQualityChart side by side */
.details-card {
  display: flex;
  gap: 30px;
  flex-wrap: wrap;
}

/* Pie Chart section */
.pie-chart-card h2 {
  margin-bottom: 20px;
  font-weight: 700;
  color: #0077be;
  text-align: center;
}

/* Responsive */
@media (max-width: 900px) {
  .dashboard-wrapper {
    flex-direction: column;
  }

  .sidebar {
    width: 100%;
    flex-direction: row;
    overflow-x: auto;
    padding: 10px 15px;
  }

  .sidebar-title {
    display: none;
  }

  .sidebar-nav {
    flex-direction: row;
    gap: 10px;
    flex-grow: 1;
  }

  .sidebar-nav a {
    white-space: nowrap;
    padding: 8px 12px;
  }

  .logout {
    margin-left: 10px;
    margin-top: 0;
  }

  .details-card {
    flex-direction: column;
  }
}
</style>





