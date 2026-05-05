import React, { useEffect, useState } from 'react'
import { createRoot } from 'react-dom/client'
import './style.css'

const API = import.meta.env.VITE_API_URL || 'http://localhost:8080/api/v1'

export default function SearchApp() {
  const [form, setForm] = useState({
    name: 'NYC to London', fromAirport: 'JFK', toAirport: 'LHR', tripType: 'ROUND_TRIP',
    departureDate: '2026-11-24', returnDate: '2026-11-30', flexDays: 3, passengers: 1,
    carryOnRequired: true, maxPrice: 1200, currency: 'USD'
  })
  const [criteria, setCriteria] = useState([])
  const [offers, setOffers] = useState([])
  const [message, setMessage] = useState('')

  async function loadCriteria() {
    const res = await fetch(`${API}/search-criteria`)
    setCriteria(await res.json())
  }

  useEffect(() => { loadCriteria().catch(console.error) }, [])

  function update(e) {
    const { name, value, type, checked } = e.target
    setForm(prev => ({ ...prev, [name]: type === 'checkbox' ? checked : value }))
  }

  async function saveCriteria(e) {
    e.preventDefault()
    setMessage('Saving...')
    const payload = { ...form, flexDays: Number(form.flexDays), passengers: Number(form.passengers), maxPrice: Number(form.maxPrice) }
    const res = await fetch(`${API}/search-criteria`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload) })
    if (!res.ok) { setMessage('Failed to save criteria'); return }
    setMessage('Saved criteria')
    await loadCriteria()
  }

  async function runSearch(id) {
    setMessage('Running search...')
    const res = await fetch(`${API}/search-criteria/${id}/run`, { method: 'POST' })
    setOffers(await res.json())
    setMessage('Search complete')
  }

  return (
    <div>
      <h2>Create saved itinerary criteria</h2>
      <form className="grid" onSubmit={saveCriteria}>
        <label>Name<input name="name" value={form.name} onChange={update} /></label>
        <label>From airport<input name="fromAirport" value={form.fromAirport} onChange={update} maxLength="3" /></label>
        <label>To airport<input name="toAirport" value={form.toAirport} onChange={update} maxLength="3" /></label>
        <label>Trip type<select name="tripType" value={form.tripType} onChange={update}><option>ONE_WAY</option><option>ROUND_TRIP</option><option>MULTI_CITY</option></select></label>
        <label>Departure date<input type="date" name="departureDate" value={form.departureDate} onChange={update} /></label>
        <label>Return date<input type="date" name="returnDate" value={form.returnDate} onChange={update} /></label>
        <label>Flex days<input type="number" name="flexDays" value={form.flexDays} onChange={update} min="0" max="7" /></label>
        <label>Passengers<input type="number" name="passengers" value={form.passengers} onChange={update} min="1" max="9" /></label>
        <label>Max price<input type="number" name="maxPrice" value={form.maxPrice} onChange={update} /></label>
        <label>Currency<input name="currency" value={form.currency} onChange={update} maxLength="3" /></label>
        <label className="check"><input type="checkbox" name="carryOnRequired" checked={form.carryOnRequired} onChange={update} /> Carry-on required</label>
        <button type="submit">Save itinerary search</button>
      </form>
      <p className="message">{message}</p>
      <h2>Saved searches</h2>
      <div className="cards">
        {criteria.map(c => <div className="card" key={c.id}>
          <strong>{c.name}</strong>
          <p>{c.fromAirport} → {c.toAirport} · {c.tripType} · +/- {c.flexDays} days · Carry-on: {String(c.carryOnRequired)}</p>
          <button onClick={() => runSearch(c.id)}>Run now</button>
        </div>)}
      </div>
      <h2>Latest offers</h2>
      <table>
        <thead><tr><th>Airline</th><th>Flight</th><th>Date</th><th>Price</th><th>Carry-on</th></tr></thead>
        <tbody>{offers.map(o => <tr key={o.id}><td>{o.airline}</td><td>{o.flightNumber}</td><td>{o.departureDate}</td><td>{o.currency} {o.price}</td><td>{String(o.carryOnIncluded)}</td></tr>)}</tbody>
      </table>
    </div>
  )
}

if (document.getElementById('root')) {
  createRoot(document.getElementById('root')).render(<SearchApp />)
}
