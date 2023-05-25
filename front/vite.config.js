import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  server: {
    hmr: { overlay: false },
    port: 80,
  },
  preview: {
    https: false,
    host: true,
    port: 3030,
  },
});