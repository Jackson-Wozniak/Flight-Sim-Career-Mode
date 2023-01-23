import { useState } from 'react';
import '../styles/LoginPage.css';
import 'font-awesome/css/font-awesome.min.css';
import email from "../images/email.jpg";
import pass from "../images/password.png";

function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function attemptLogin(e){
        e.preventDefault();
        alert("working");
    }

    return (  
        <div className="login-page-container">
            <form className="login-form" onSubmit={(e) => attemptLogin(e)}>
                <div className="user-icon-image-container">
                    <i class="fa fa-regular"></i>
                    <i className="fa fa-light fa-user fa-5x user-icon-image"></i>
                </div>
                <input type="email" placeholder="Email" className="login-prompts" required/>
                <input type="password" className="login-prompts" placeholder="Password" required/>

                <input type="submit" value="Login" id="login-button"/>
            </form>
        </div>
    );
}

export default LoginPage;