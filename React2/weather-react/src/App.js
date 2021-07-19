import { date } from 'language-tags';
import React from 'react';

const api = {
  key: "f3d46159a2b700c4c784048fd6bd2a2d",
  base: "https://api.openweathermap.org/data/2.5/"
}

function App() {

  const dateBuilder = (d) => {
    let months = ["January", "February", "March", "April", "May", "June", "July", "August",
  "September", "October", "November", "December"];
    let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
  "Saturday"];

  let day = days[d.getDay()];
  let date = d.getDate();
  let month = months[d.getMonth()];  //will return number between 0-11 which will give us our month
  let year = d.getFullYear(); //will give us 2021 for example
  
  return '${day} ${date} ${month} ${year}' //todo: fix this
  }

  return (
    <div className="app">
      <main>
        <div className = "search-box">
          <input 
          type = "text"
          className= "search-bar"
          placeholder = "Search..."
          />
        </div>
        <div className = "location-box">
          <div className = "location" > New York City,US</div>
          <div className = "date">{dateBuilder(new Date())}</div>
        </div>
        <div className = "weather-box">
          <div className = "temp">
            15°C
          </div>
          <div className="weather">Sunny</div>
          </div>
      </main>
    </div>
  );
}

export default App;
