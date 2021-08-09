import React, { useState, useEffect } from 'react';
import Login from '../Login/Login.jsx';
import Home from '../Home/Home.jsx';

import './Content.css';

function Content() {

    return (
        <section className="content">
            <Login />
            <Home />
        </section>
    )
}

export default Content;