import { useState } from 'react';
import '../styles/LoginPage.css';
import 'font-awesome/css/font-awesome.min.css';
import loginAndObtainJwtKey from '../utils/ApiCalls';
import { useEffect } from 'react';

function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [token, setToken] = useState(null);

    useEffect(() => {
        console.log(token);
    }, [token]);

    async function attemptLogin(e){
        e.preventDefault();
        let tokenRes = await loginAndObtainJwtKey(username, password).catch((ex) => {
            alert(ex.message);
        });
        if(tokenRes != null){
            setToken(tokenRes);
        }
    }

    return (  
        <div className="login-page-container">
            <form className="login-form" onSubmit={(e) => attemptLogin(e)}>
                <div className="user-icon-image-container">
                    <i className="fa fa-regular"></i>
                    <i className="fa fa-light fa-user fa-5x user-icon-image"></i>
                </div>
                <input type="email" onChange={(e) => setUsername(e.target.value)}
                    className="login-prompts" placeholder="Email" required 
                />
                <input type="password" onChange={(e) => setPassword(e.target.value)}
                    className="login-prompts" placeholder="Password" required
                />
                <input type="submit" value="Login" id="login-button"/>
            </form>
        </div>
    );
}

export default LoginPage;