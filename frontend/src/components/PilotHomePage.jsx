import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import NavBar from './NavBar';

function PilotHomepage() {

    const location = useLocation();
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
        <div>
            <NavBar />
            {jwtToken};
        </div>
    );
}

export default PilotHomepage;