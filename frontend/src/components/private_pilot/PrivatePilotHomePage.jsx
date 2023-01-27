import { useState } from "react";
import PrivatePilotFlights from "./PrivatePilotFlights";
import PrivatePilotHangar from './PrivatePilotHangar';
import PrivatePilotAccount from './PrivatePilotAccount';
import PrivatePilotStats from './PrivatePilotStats';
import '../../styles/private_pilot/PrivatePilotHomePage.css';
import NavBar from '../NavBar';

function PrivatePilotHomePage() {
    
    const [jwtToken, setJwtToken] = useState("");
    const [pilot, setPilot] = useState();

    return (  
        <div className="private-pilot-homepage-container">
            <NavBar fixed={false}/>
            <div className="private-pilot-homepage-content-container">
                <PrivatePilotFlights pilotFlightOffers={[]}/>
                <PrivatePilotHangar />
                <PrivatePilotAccount />
                <PrivatePilotStats />
            </div>
        </div>
    );
}

export default PrivatePilotHomePage;