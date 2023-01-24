import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function PilotHomepage() {

    const location = useLocation();
    const navigate = useNavigate();
    const [jwtToken, setJwtToken] = useState("");

    useEffect(() => {
        if(location.state === null || location.state.jwtToken === null || jwtToken === null){
            navigate("/login");
        }else if(location.state.jwtToken !== null){
            setJwtToken(location.state.jwtToken);
        }
    }, [location.state, navigate, jwtToken]);    

    return (  
        <div>
            {jwtToken};
        </div>
    );
}

export default PilotHomepage;