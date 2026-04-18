<template>
  <div v-if="station" class="station-detail">
    <h3>{{ station.name }} Details</h3>
    <p><strong>ID:</strong> {{ station.id }}</p>
    <p><strong>Water Quality:</strong> {{ waterQuality }}</p>
    <p><strong>Sediment Quality:</strong> {{ sedimentQuality }}</p>
  </div>
  <div v-else>
    <p>Select a station on the map to see details.</p>
  </div>
</template>

<script setup>
import { computed } from 'vue'

const props = defineProps({
  station: Object,
  stationData: Object
})

const waterQuality = computed(() => {
  return props.stationData?.waterQuality || 'N/A'
})

const sedimentQuality = computed(() => {
  return props.stationData?.sedimentQuality || 'N/A'
})
</script>

<style scoped>
.station-detail {
  margin-top: 1rem;
  padding: 1rem;
  background-color: #eef7ff;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}
</style>
