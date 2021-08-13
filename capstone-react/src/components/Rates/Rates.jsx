import React, { Fragment } from 'react';
import './Rates.css'; //imports the styling for rates page
import { CompoundInterest } from '../Content/Content'


function Rates () {
    return (
        <>
            <section className="rates">
                <section className="rates-description">
                    <h1>Types of Accounts</h1><br />
                    We offer Certificates of Deposits 
                    Merit America Bank will offer various CDs:
                    1 year term at 1.8%
                    2 year term at 1.9%
                    3 year term at 2.0%
                    5 year term at 2.5%
                    10 year term at 2.2%

                    We also offer personal checking accounts, savings accounts,
                    DBA checking accounts, and 3 types of IRA accounts: Regular,
                    Roth and Rollover.

                </section>
            </section>
            <CompoundInterest/>
        </>    
    )
}

export default Rates;