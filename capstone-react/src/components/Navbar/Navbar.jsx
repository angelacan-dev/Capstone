import React from 'react';
import './Navbar.css'; //imports the styling for navbar
import { Link } from 'react-router-dom';


function Navbar () {

    //our section with different navigating items
    return (
        <section className = "navbar"> 
            <Link to = "/openaccount">Open Account</Link>
            <Link to = "/contact">Contact Us</Link>
            <Link to = "/about">About Us</Link>
        </section>
    )

}


export default Navbar;