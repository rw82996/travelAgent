import React, { Suspense } from 'react'
import { createRoot } from 'react-dom/client'
import './style.css'

const SearchApp = React.lazy(() => import('searchMfe/SearchApp'))

function App() {
  return (
    <div className="page">
      <header className="hero">
        <div>
          <p className="eyebrow">TravelAgent</p>
          <h1>Saved itinerary search, monitored daily</h1>
          <p>Track flight options across flexible dates, trip types, and carry-on baggage preferences.</p>
        </div>
      </header>
      <main className="panel">
        <Suspense fallback={<div>Loading search module...</div>}>
          <SearchApp />
        </Suspense>
      </main>
    </div>
  )
}

createRoot(document.getElementById('root')).render(<App />)
