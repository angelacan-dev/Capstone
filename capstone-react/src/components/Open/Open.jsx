import React, { Fragment } from 'react';
import { ButtonDropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import './Open.css'; //imports the styling for openaccount page


function Open() {
const submit = () => {
    alert("Account has been created")
}
    return (

            <section className="open">
            <form className="open-form" onSubmit={submit}>

                <label>What type of account would you like to open?</label>
                <input placeholder="name" />

                <label>If opening IRA choose from</label>
                <input placeholder="email" />

                
                <label>If opening CD choose from</label>
                <textarea placeholder="Message"></textarea>

                <label>Deposit amount to open account</label>
                <input placeholder=" " />

                <button type="submit">Submit</button>
                <button type= "cancel">Cancel</button>
            </form>
            </section>
    )
}

export default Open;