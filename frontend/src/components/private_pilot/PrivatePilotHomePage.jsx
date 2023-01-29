import { useState } from "react";
import PrivatePilotFlights from "./PrivatePilotFlights";
import PrivatePilotHangar from './PrivatePilotHangar';
import PrivatePilotAccount from './PrivatePilotAccount';
import PrivatePilotStats from './PrivatePilotStats';
import '../../styles/private_pilot/PrivatePilotHomePage.css';
import NavBar from '../NavBar';
import { useEffect } from "react";
import { getTestPilotData } from "../../utils/PrivatePilotApi";
import LoadingScreen from '../LoadingScreen';

function PrivatePilotHomePage() {

    useEffect(() => {
        let pilot = getTestPilotData();
        setPilot(pilot);
    }, []);
    
    // const [jwtToken, setJwtToken] = useState("");
    const [pilot, setPilot] = useState(null);

    if(pilot !== null){
        return (  
            <div className="private-pilot-homepage-container">
                <NavBar fixed={false}/>
                <div className="private-pilot-homepage-content-container">
                    <PrivatePilotFlights pilotFlightOffers={pilot.inactiveFlights}/>
                    <PrivatePilotHangar pilotHangar={pilot.hangar.planes}/>
                    <PrivatePilotAccount />
                    <PrivatePilotStats />
                </div>
            </div>
        );
    }

    return(
        <LoadingScreen />
    );
}

export default PrivatePilotHomePage;