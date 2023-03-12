import axios from "axios";

const api = axios.create({
  baseURL: "http://ec2-44-212-184-96.compute-1.amazonaws.com:8000",
});

export { api };
