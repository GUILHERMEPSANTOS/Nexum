import axios from "axios";

const api = axios.create({
  baseURL: "http://44.212.184.96:8000",
  httpsAgent: new https.Agent({
    rejectUnauthorized: false
  })
});

export { api };
