import React, { useState, useEffect } from 'react';
import Login from '../Login/Login.jsx';
import { render } from "react-dom";
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

import './Content.css';
import { classes } from 'istanbul-lib-coverage';


export const CompoundInterest = () => {
    const [principal, setPrincipal] = useState();
    const [years, setYears] = useState();
    const [interest, setInterest] = useState();
    const [result, setResult] = useState();

    const calculate = () => {
        // A=p(1+(r/n))^(nt)
        const result = principal * Math.pow(1 + interest, years);
        setResult(result.toFixed(2));
    };

    return (
        <>
        <form>
            <TextField 
            label = "What is the principal?" 
            /* value = {principal} */
            variant = "outlined"
            onChange={(e) => setPrincipal(e.target.value)}
            />

            <TextField 
            label = "How Many Years?" 
            variant = "outlined"
            onChange={(e) => setYears(e.target.value)}
            />

            <TextField 
            label = "Annual Interest rate?" 
            variant = "outlined"
            onChange={(e) => setInterest(e.target.value/ 100)}
            />
            <br/>
            <br/>

            <Button variant ="contained" 
            color="primary" 
            onClick={() => {
                calculate();
            }}
            >
                Calculate
            </Button>
            <br/><br/>
            {result}
        </form>
        </>
    );
};

// render (<CompoundInterest />, document.querySelector("#root"));

function Content() {

    return (
        <>
        <section className="content">
            <Login />
        </section>
        {/* <CompoundInterest /> */}
        </>
    )
}

export default Content;