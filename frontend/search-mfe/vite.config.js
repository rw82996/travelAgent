import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import federation from '@originjs/vite-plugin-federation'

export default defineConfig({
  plugins: [
    react(),
    federation({
      name: 'searchMfe',
      filename: 'remoteEntry.js',
      exposes: {
        './SearchApp': './src/SearchApp.jsx'
      },
      shared: ['react', 'react-dom']
    })
  ],
  build: { target: 'esnext' }
})
