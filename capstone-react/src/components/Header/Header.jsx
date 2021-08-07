import React from 'react';
import Navbar from '../Navbar';

import './Header.css';

function Header() {

    return (
        <section className="header">
            <section className="header-top__logo">
                <a href="/" className="header-logo"><img src="/Merit_Bank_Logo_White_BG.png" /></a>
            </section>

            <Navbar />
        </section>
    )
}

export default Header;