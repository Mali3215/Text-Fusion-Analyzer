import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api'; // Spring Boot API URL

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const mergeTexts = (data) => api.post('/cumle', data); // Merge text endpoint

export const saveText = (data) => api.post('/add', data); // Save text endpoint

export const getTexts = () => api.get('/all'); // Get all texts endpoint

