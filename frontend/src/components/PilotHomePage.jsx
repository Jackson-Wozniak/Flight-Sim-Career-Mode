import { useState } from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import NavBar from './NavBar';
import '../styles/PilotHomePage.css';
//credit: https://unsplash.com/photos/4UgUpo3YdKk
import propPlaneImg from '../images/prop_plane_cockpit.jpg';
//credit: https://unsplash.com/photos/twIzCL3YSRI
import airlinerImg from '../images/airliner.jpg';

function PilotHomepage() {

    const navigate = useNavigate();
    const [jwtToken, setJwtToken] = useState("");
    
    useEffect(() => {
        let storedJwtToken = localStorage.getItem("jwtToken");
        if(storedJwtToken === null){
            navigate("/login");
        }else{
            setJwtToken(storedJwtToken);
        }
    }, [jwtToken, navigate]);

    return (  
        <div className="pilot-home-page-container">
            <NavBar fixed={true}/>
            <div className="pilot-homepage-card-container">
                <div className="pilot-homepage-info-card">
                    <img src={propPlaneImg} alt="" className="pilot-home-page-images"/>
                    <h1>Become a private pilot</h1>
                    <hr />
                    <p className="pilot-path-prompts">
                        Climb the ranks as a private pilot, completing
                        contracted flights carrying cargo, passengers, and more. Earn 
                        more money as your reputation grows. Don't forget to set aside some money
                        to upgrade your hangar!
                    </p>
                </div>
                <div className="pilot-homepage-info-card">
                    <img src={airlinerImg} alt="" className="pilot-home-page-images"/>
                    <h1>Manage your own airline</h1>
                    <hr />
                    <p className="pilot-path-prompts">
                        Take control of a full-scale airline, and act as its primary pilot.
                        Set aside money to upgrade your fleet, so that you can grow your buisness,
                        and fly more routes concurrently!
                    </p>
                </div>
            </div>
        </div>
    );
}

export default PilotHomepage;