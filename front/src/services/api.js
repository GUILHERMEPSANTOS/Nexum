import axios from "axios";

const api = axios.create({
  baseURL: "https://44.212.184.96:8000",
});

export { api };
