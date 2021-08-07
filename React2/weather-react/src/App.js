import { date } from 'language-tags';
import React, {useState} from 'react';

const api = {
  key: "f3d46159a2b700c4c784048fd6bd2a2d",
  base: "https://api.openweathermap.org/data/2.5/"
}

function App() {
  const [query, setQuery] = useState('');
  const [weather, setWeather] = useState({});

  //if event is equal to 'enter' fetch api to setweather. response in json and setweather equal to result
  const search = evt => {
    if (evt.key === "Enter") { //fetch api is implemented
      fetch(`${api.base}weather?q=${query}&units=metric&APPID=${api.key}`) //must use back ticks instead of quote string
      .then(res => res.json())
      .then(result => {
        setWeather(result);
        setQuery('');
        console.log(result);
    });
  }
  }


  const dateBuilder = (d) => {
    let months = ["January", "February", "March", "April", "May", "June", "July", "August",
  "September", "October", "November", "December"];
    let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
  "Saturday"];

  let day = days[d.getDay()];
  let date = d.getDate();
  let month = months[d.getMonth()];  //will return number between 0-11 which will give us our month
  let year = d.getFullYear(); //will give us 2021 for example
  
  return `${day} ${date} ${month} ${year}` 
  }

  return (
    //here we are checking for the type of weather and app will display warm or cold pic depending
    <div className={(typeof weather.main != "undefined") ? ((weather.main.temp > 16)
        ? 'app warm' : 'app'): 'app'}>
      <main>
        <div className = "search-box">
          <input 
          type = "text"
          className= "search-bar"
          placeholder= "Search..."
          onChange={e => setQuery(e.target.value)}
          value={query} //need to bind value equal to the query
          onKeyPress={search}
          />
        </div>
        {/* //if type of weather is not equal to undefined */}
        {(typeof weather.main !== "undefined") ? (
        <div>
        <div className = "location-box">
          <div className = "location" > {weather.name}, {weather.sys.country}</div>
          <div className = "date">{dateBuilder(new Date())}</div>
        </div>
        <div className = "weather-box">
          <div className = "temp">
            {Math.round(weather.main.temp)}°C
          </div>
          {/* //tells us if sunny, clouds, etc */}
          <div className="weather">{weather.weather[0].main}</div>
          </div>
        </div>
        ) : ('')}
      </main>
    </div>
  );
}

export default App;
