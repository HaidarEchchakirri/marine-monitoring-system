import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

// Get all stations
export const getStations = async () => {
  try {
    const response = await apiClient.get('/stations');
    return response.data;
  } catch (error) {
    console.error('Failed to fetch stations:', error);
    return [];
  }
};

// Get station water and sediment quality details
export const getStationDetails = async (stationId) => {
  try {
    const response = await apiClient.get(`/stations/${stationId}/data`);
    return response.data;
  } catch (error) {
    console.error(`Failed to fetch station ${stationId} details:`, error);
    return null;
  }
};

// Get time-series data for a station
export const getWaterQualityTimeSeries = async (stationId) => {
  try {
    const response = await apiClient.get(`/waterquality/station/${stationId}`);
    return response.data;
  } catch (error) {
    console.error(`Failed to fetch time-series for station ${stationId}:`, error);
    return [];
  }
};

