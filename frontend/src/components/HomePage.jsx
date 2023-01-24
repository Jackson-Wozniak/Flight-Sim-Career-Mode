import { useEffect } from 'react';
import '../styles/HomePage.css';
import { findTotalPilotCount } from '../utils/ApiCalls';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import NavBar from './NavBar';
import pilotIcon from '../images/pilot_icon.png';

function HomePage() {
    
    const [totalPilotCount, setTotalPilotCount] = useState("");
    const navigate = useNavigate();

    useEffect(() => {
        async function updateTotalPilotCount(){
            try{
                let pilotCount = await findTotalPilotCount();
                setTotalPilotCount(pilotCount);
            }catch (ex) {
                setTotalPilotCount("");
            }
        }
        updateTotalPilotCount();
    }, []);

    function navigateToPath(path){
        navigate(path);
    }

    return ( 
        <div className="home-page-container">
            <NavBar fixed={false}/>
            <div className="homepage-info-card">
                
                <h2 id="homepage-header">Choose Your Path...</h2>
                <img src={pilotIcon} alt="" className="pilot-icon-homepage"/>
                <h4>and join {totalPilotCount} virtual pilots worldwide</h4>

                <button onClick={() => navigateToPath("/login")}>Login</button>
                <button onClick={() => navigateToPath("/sign-up")}>Or Sign Up</button>
            </div>
            <div className="homepage-info-card-container">
                <div className="homepage-info-card">
                    <h2>Local License</h2>
                    <hr />
                    <p>
                        Begin as an unknown pilot, and complete contracted cargo and passenger
                        flights as you increase your reputation and make money. Buy new planes
                        and improve your operations as you climb the ranks of private piloting!
                    </p>
                </div>
                <div className="homepage-info-card">
                    <h2>Airline Manager</h2>
                    <hr />
                    <p>
                        Become the owner of your own airline. Manage its operation, and act as its
                        primary pilot as you make money and increase your impact on the industry.
                        Buy more planes and hire new pilots to complete routes for you and earn you
                        passive money!
                    </p>
                </div>
            </div>
        </div>
     );
}

export default HomePage;