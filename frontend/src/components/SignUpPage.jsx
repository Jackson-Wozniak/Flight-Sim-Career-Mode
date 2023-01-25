import '../styles/SignUpPage.css';
import NavBar from '../components/NavBar';
import pilotIconImg from '../images/pilot_icon.png';
import { useState } from 'react';
import { registerNewPilot } from '../utils/ApiCalls';
import { useNavigate } from 'react-router-dom';
import LoadingScreen from './LoadingScreen';

function SignUpPage() {

    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [pilotName, setPilotName] = useState("");
    const [homeCountry, setHomeCountry] = useState("");
    const [loading, setLoading] = useState(false);
    const [errorWithRegistration, setErrorWithRegistration] = useState(false);

    async function callToRegisterNewPilot(e){
        e.preventDefault();
        setLoading(true);
        try{
            let tokenRes = await registerNewPilot(username, password, pilotName, homeCountry);
            localStorage.setItem("jwtToken", tokenRes);
            navigate('/pilot-home');
        }catch (ex){
            setErrorWithRegistration(true);
        }
        setLoading(false);
    }

    if(loading){
        return (
            <LoadingScreen />
        );
    }

    let errorPopup;
    if(errorWithRegistration){
        errorPopup = <button className="error-popup" onClick={() => setErrorWithRegistration(false)}>
		                <p>There was an error in your registration attempt</p>
                        <p className="close-error-popup">x</p>
	                </button>
    }

    return ( 
        <div className="sign-up-page-container">
            <NavBar fixed={false}/>
            <div className="sign-up-page-content">
                {errorPopup}
                <form className="pilot-sign-up-form" onSubmit={(e) => callToRegisterNewPilot(e)}>
                    <img src={pilotIconImg} alt="" className="pilot-sign-up-icon"></img>
                    <h2>Begin Your Aviation Career</h2>
                    <hr />
                    <div className="pilot-sign-up-prompt-container">
                        <input type="email" placeholder="Email" onChange={(e) => setUsername(e.target.value)}
                            className="pilot-sign-up-form-prompts"/>
                        <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}
                            className="pilot-sign-up-form-prompts"/>
                    </div>
                    <div className="pilot-sign-up-prompt-container">
                        <input type="text" placeholder="Pilot First Name" onChange={(e) => setPilotName(e.target.value)} 
                            className="pilot-sign-up-form-prompts"/>
                        <input type="text" placeholder="Pilot Home Country" onChange={(e) => setHomeCountry(e.target.value)}
                            className="pilot-sign-up-form-prompts"/>
                    </div>

                    <input type="submit" value="Register Pilot" className="pilot-sign-up-form-submit"/>
                </form>
            </div>
        </div>
     );
}

export default SignUpPage;