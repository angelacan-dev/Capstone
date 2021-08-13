import React, { Fragment } from 'react';
import React, { Component } from 'react';
import './Close.css'; //imports the styling for about page


class Close extends Component() {
render() {
const submit = () => {
    alert("Your account has been closed")
}

    return (

            <section className="close">
            
    const restrictions1 = [Checking accounts can be closed without restrictions
    but balance must be transferred to savings, When closing an IRA, 80% of balance is transferred
    to savings or checking, but 20% is taken away to IRS, When CD's are closed, balances must
    be transferred to either checking or savings, Savings accounts can only be closed when user
    doesn't want to have an account. Account records are deleted at this point]; 
            <form className="contact-form" onSubmit={submit}>
                <h1>Get In Touch</h1>

                <label>Name</label>
                <input placeholder="name" />

                <label>Email</label>
                <input placeholder="email" />
                {/* //message requires textarea its not an input */}
                <label>Message</label>
                <textarea placeholder="Message"></textarea>

                <button type="submit">Close Account</button>
            </form>
            </section>
    )
}

export default Close;