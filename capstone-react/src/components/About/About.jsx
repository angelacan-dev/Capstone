import React, { Fragment } from 'react';
import './About.css'; //imports the styling for about page


function About() {
const submit = () => {
    alert("Message submitted")
}
    return (
            <section className="about">
                <section className="about-description">
                    <h1>We're Merit Bank</h1><br />
                    We help customers prosper. Our mission is to treat you and your money with respect and care.
                    How will we do this? With simple ways to help you save, make transactions, and manage your money
                    better. At Merit Bank, we are excited to watch you and your money grow.
                </section>
            <form className="contact-form" onSubmit={submit}>
                <h1>Get In Touch</h1>

                <label>Name</label>
                <input placeholder="name" />

                <label>Email</label>
                <input placeholder="email" />
                {/* //message requires textarea its not an input */}
                <label>Message</label>
                <textarea placeholder="Message"></textarea>

                <button type="submit">HighFive</button>
            </form>
            </section>
    )
}

export default About;