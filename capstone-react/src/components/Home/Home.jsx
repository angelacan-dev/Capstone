import React from 'react';
import './Home.css'; //imports the styling for homepage
import { Link } from 'react-router-dom';


function Home () {

    //our section with different navigating items
    return (
        <section className = "navbar"> 
            <Link to = "/logout">Logout</Link>
            <Link to = "/closeaccount">Close Account</Link>
            <Link to = "/transactions">Transactions</Link>
        </section>
    )

}


export default Home;