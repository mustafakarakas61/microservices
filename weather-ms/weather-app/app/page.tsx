'use client';

import React, {useState} from "react";
import axios from "axios";
import {translateWeatherDescription} from "@/app/utils/weatherTranslations";

export default function Home() {
  const [city, setCity] = useState('');
  const [weather, setWeather] = useState<any>(null);
  const [error, setError] = useState<string | null>(null);

  const getWeather = async (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      setError(null);

      try {
        const response = await axios.get(`http://localhost:8080/weather?city=${city}`);
        setWeather(response.data);
      } catch (err: any) {
        setError('Hava durumu alınamadı. Şehir adını kontrol edin: ' + err.message);
      }
  };

  return (
      <div style={{padding: '20px'}}>
          <form onSubmit={getWeather}>
              <input
                  type="text"
                  value={city}
                  onChange={(e) => setCity(e.target.value)}
                  placeholder="Şehir ismi"
                  required
              />
              <button type="submit" style={{
                  marginLeft: '10px',
                  padding: '10px 15px',
                  backgroundColor: '#0070f3',
                  color: 'white',
                  border: 'none',
                  borderRadius: '5px',
                  cursor: 'pointer'
              }}>
                  Hava Durumu
              </button>
          </form>

          {error && <p style={{color: 'red'}}>{error}</p>}
          {weather && (
              <div>
                  <h2>{weather.name}</h2>
                  <p>Sıcaklık: {weather.main.temp} °C</p>
                  <p>Hava Durumu: {translateWeatherDescription(weather.weather[0].description)}</p>
                  {weather.weather[0].icon && (
                      <img
                          src={`http://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png`}
                          alt={weather.weather[0].description}
                      />
                  )}
              </div>
          )}
      </div>
  );
}
