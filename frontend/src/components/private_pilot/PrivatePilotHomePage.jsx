import { useState } from "react";
import PrivatePilotFlights from "./PrivatePilotFlights";
import PrivatePilotHangar from './PrivatePilotHangar';
import PrivatePilotAccount from './PrivatePilotAccount';
import PrivatePilotStats from './PrivatePilotStats';
import '../../styles/private_pilot/PrivatePilotHomePage.css';
import NavBar from '../NavBar';
import { useEffect } from "react";
import LoadingScreen from '../LoadingScreen';
import StoryPopup from "./StoryPopup";
import AssignedFlightDisplay from './AssignedFlightDisplay';
import { useNavigate } from "react-router-dom";
import { getPrivatePilotByToken } from "../../utils/PrivatePilotApi";

function PrivatePilotHomePage() {

    const navigate = useNavigate();
    const [pilot, setPilot] = useState(null);
    const [showStory, setShowStory] = useState(false);
    const [story, setStory] = useState("");

    useEffect(() => {
        async function getPilotData(token){
            try{
                let pilot = await getPrivatePilotByToken(token);
                console.log(pilot);
                setPilot(pilot);
            }catch (ex) {
                localStorage.removeItem("jwtToken");
                localStorage.setItem("webTokenError", ex.message);
                navigate("/web-token-error");
            }
        }

        let storedJwtToken = localStorage.getItem("jwtToken");
        console.log(storedJwtToken);
        if(storedJwtToken === null){
            navigate("/login");
            return;
        }
        getPilotData(storedJwtToken);
    }, [navigate]);

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
                    <PrivatePilotFlights pilotFlightOffers={pilot.flights} activateStory={activateStory}/>
                    <PrivatePilotHangar pilotHangar={pilot.planesOwned}/>
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