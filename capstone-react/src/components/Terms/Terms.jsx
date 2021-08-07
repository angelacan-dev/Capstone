import React, { Fragment } from 'react';
import './Terms.css'; //imports the styling for terms page


function Terms () {
    return (
            <section className="terms">
                <section className="terms-description">
                    <h1>Terms of Use</h1><br />
                    The information on this Website is for information purposes only.
                    The information on the Website is not intended as an offer or 
                    solicitation for the purchase any security or any financial instrument.
                    Securities including mutual funds and CD's, are not bank deposits and 
                    are not insured by the FDIC or any other agency of the United States, 
                    nor are they obligations of, nor insured or guaranteed by, MeritBank 
                    or their affiliates. Securities (including mutual funds and variable 
                    life insurance) and annuities involve investment risks, including the 
                    possible loss of value. The information and materials contained in this 
                    Website are subject to change without notice. Products and services described,
                    as well as, associated fees, charges, interest rates, and balance requirements 
                    may differ among geographic locations.
                </section>
            </section>
    )
}

export default Terms;
