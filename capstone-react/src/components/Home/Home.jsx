import React from 'react';
import './Home.css'; //imports the styling for homepage
import { Link } from 'react-router-dom';


function Home () {


    //our section with different navigating items
    return (
        <section className = "navbar"> 
            <Link to = "/home">Home</Link>
            <Link to = "/transactions">Transactions</Link>
            <Link to = "/history">History</Link>
            <Link to = "/closeaccount">Close Account</Link>
            <Link to = "/updateprofile">Update Profile</Link>
            <Link to = "/logout">Logout</Link>
        </section>
    )

}


export default Home;
