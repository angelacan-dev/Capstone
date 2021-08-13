import React, { Fragment, useState } from 'react';
import './Contact.css'; //imports the styling for contact page


function Contact() {

const [example, setExample] = useState()

const submit = (event) => {
    alert("Message submitted")
    event.preventDefault()
    localStorage.setItem("example", JSON.stringify({name: example}))

    const readString = JSON.parse(localStorage.getItem("example"))
    console.log(readString);
}
    return (
            <section className="contact">
                <section className="contact-description">
                    <h1>We're Merit Bank</h1><br />
                    We help customers prosper. Our mission is to treat you and your money with respect and care.
                    How will we do this? With simple ways to help you save, make transactions, and manage your money
                    better. At Merit Bank, we are excited to watch you and your money grow.
                </section>
            <form className="contact-form" onSubmit={submit}>
                <h1>Get In Touch</h1>

                <label>Name</label>
                <input placeholder="name"
                value = {example}
                onChange = {(e) => setExample(e.target.value)} />

                <label>Email</label>
                <input placeholder="email" />
                {/* //message requires textarea not an input */}
                <label>Message</label>
                <textarea placeholder="Message"></textarea>

                <button type="submit">HighFive</button>
            </form>
            </section>
    )
}

export default Contact;