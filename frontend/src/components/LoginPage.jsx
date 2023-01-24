import { useState } from 'react';
import '../styles/LoginPage.css';
import 'font-awesome/css/font-awesome.min.css';
import { loginAndObtainJwtKey } from '../utils/ApiCalls';
import LoadingScreen from './LoadingScreen';
import { useNavigate } from 'react-router-dom';

function LoginPage(props) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    async function attemptLogin(e){
        e.preventDefault();
        setLoading(true);
        try{
            let tokenRes = await loginAndObtainJwtKey(username, password);
            navigate('/pilot-home', {state : {jwtToken : tokenRes}});
        }catch (ex){
            alert(ex.message);
        }
        setLoading(false);
    }

    if(loading){
        return (
            <LoadingScreen />
        );
    }

    return (  
        <div className="login-page-container">
            <form className="login-form" onSubmit={(e) => attemptLogin(e)}>
                <div className="user-icon-image-container">
                    <i className="fa fa-solid fa-user fa-5x user-icon-image"></i>
                    
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