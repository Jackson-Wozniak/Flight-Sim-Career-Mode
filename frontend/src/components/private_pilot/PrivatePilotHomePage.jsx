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
import StoryPopup from "./StoryPopup";
import AssignedFlightDisplay from './AssignedFlightDisplay';
import { useNavigate } from "react-router-dom";

function PrivatePilotHomePage() {

    const navigate = useNavigate();
    const [jwtToken, setJwtToken] = useState("");
    const [pilot, setPilot] = useState(null);
    const [showStory, setShowStory] = useState(false);
    const [story, setStory] = useState("");

    useEffect(() => {
        let storedJwtToken = localStorage.getItem("jwtToken");
        if(storedJwtToken === null){
            navigate("/login");
        }else{
            setJwtToken(storedJwtToken);
        }
        let pilot = getTestPilotData();
        setPilot(pilot);
    }, [jwtToken, navigate]);

    //called from PrivatePilotFlightsComponent & StoryPopup. ShowStory actives/deactives the story popup display
    function activateStory(activated, storyChosen){
        if(activated){
            setStory(storyChosen);
        }
        setShowStory(activated);
    }

    //if user presses button in PrivatePilotFlights component to show story, display the given story in a centered div
    let storyPopup;
    if(showStory){
        storyPopup = <StoryPopup story={story} activateStory={activateStory}/>
    }else{
        storyPopup = <div></div>
    }

    if(pilot !== null && pilot.isActiveFlight){
        return (
            <AssignedFlightDisplay pilot={pilot}/>
        );
    }

    if(pilot !== null){
        return (  
            <div className={"private-pilot-homepage-container " + (showStory ? "private-pilot-homepage-container-dimmed" : "")}>
                <NavBar fixed={false}/>
                {storyPopup}
                <div className="private-pilot-homepage-content-container">
                    <PrivatePilotFlights pilotFlightOffers={pilot.inactiveFlights} activateStory={activateStory}/>
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