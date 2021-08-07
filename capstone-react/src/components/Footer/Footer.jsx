import React from 'react';

import './Footer.css';

function Footer() {

    return (
        <section className="footer">
            <section className="footer-items">
                <a href="/privacy" className="footer-item">Privacy Policy</a>
                <a href="/terms" className="footer-item">Terms of Use</a>
                <a href="/rates" className="footer-item">Rates</a>
            </section>
            <section className= "footer-fdic">
                <a href= "/footer-fdic" className="footer-fdic">Member of FDIC</a>
            </section>
         </section>
    )
}

export default Footer;