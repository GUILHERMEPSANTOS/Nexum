import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  server: {
    port: 8080,
  },
  preview: {
    https: false,
    host: true,
    port: 3030,
  },
});
