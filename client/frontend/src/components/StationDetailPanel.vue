<template>
  <div class="station-panel">
    <h3>{{ station.name }} - Details</h3>
    <ul>
      <li><strong>pH:</strong> {{ station.ph }}</li>
      <li><strong>Salinity:</strong> {{ station.salinity }}</li>
      <li><strong>Sediment Grain Size:</strong> {{ station.sediment.grainSize }}</li>
      <li><strong>Organic Matter:</strong> {{ station.sediment.organicMatter }}</li>
    </ul>
  </div>
</template>

<script setup>
defineProps({
  station: Object
})
</script>

<style scoped>
.station-panel {
  border: 1px solid #aaa;
  padding: 15px;
  margin-top: 20px;
  background-color: #f8f8f8;
  border-radius: 8px;
}
</style>
