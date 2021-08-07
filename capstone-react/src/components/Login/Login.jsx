import { useState } from "react";
import { Redirect } from "react-router-dom";// const Login = (props: {setFirstName: (firstName: string) => void }) => {

const Login = (props) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [redirect, setRedirect] = useState(false);
    const [token, setToken] = useState(null);    // const submit = async (e: SyntheticEvent) => {
    const submit = async (e) => {
        e.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            // credentials: 'include',
            body: JSON.stringify({
                username: username,
                password: password
            })
        };
        const response = await fetch('http://localhost:8080/authenticate', requestOptions);
        // const response = await fetch('authenticate', requestOptions);
        const content = await response.json();
        const token = content.jwt;
        console.log(token);
        sessionStorage.setItem('jwt', JSON.stringify(token));
        //props.setToken(content.jwt);            // var url = 'http://localhost:8080/accountHolders';
        // var r = new XMLHttpRequest();
        // r.open('GET', url);
        // r.setRequestHeader('Authorization', 'Bearer ' + content.jwt);
        // r.send();            // r.addEventListener('load', () => {
        //     console.log(r);
        // })            // const url = 'Me';
        var url = 'http://localhost:8080/accountHolders';
        // var url = 'accountHolders';
        // token = JSON.parse(sessionStorage.getItem('jwt'));
        // console.log("token is = " + token);
        const h = new Headers();
        // h.append('Authentication', 'Bearer ${token}');
        h.append('Authorization', 'Bearer ' + content.jwt );
         const requestOptions1 = {
            method: 'GET',
            mode: 'cors',
            headers: h,
        };
        const a = await fetch(new Request(url, requestOptions1))
            .then(response => response.json())
            .then(content => {
                console.log(content[0]);
            })
            .catch(err => {
                console.error(err.message);
            })            // setFirstName(content.firstName);        // setRedirect(true);    }    // if (redirect) {
        //     return <Redirect to='/' />
    }
    return (
        < form onSubmit={submit} >
            <h1 className="h3 mb-3 fw-normal">Please sign in</h1>
            <input type="text" className="form-control" placeholder="Username" required
                onChange={e => setUsername(e.target.value)}
            />            <input type="password" className="form-control" placeholder="Password" required
                onChange={e => setPassword(e.target.value)}
            />
            <button className="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        </form >
    )
}
export default Login;


//sessionStorage.get("jwt") this is the value
//can assign to any variable we want

//const jwt = sessionStorage.get("jwt") 