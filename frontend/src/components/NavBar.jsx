import '../styles/NavBar.css';
import { useNavigate } from 'react-router-dom';

function NavBar(props) {
    const navigate = useNavigate();

    function navigateToPath(path){
        navigate(path);
    }

    return ( 
        <div className={props.fixed ? "nav-bar-container-fixed" : "nav-bar-container-free"}>
            <div className="left-nav-bar">
                <button onClick={() => navigateToPath("/")} className="nav-bar-links">Home</button>
                <button onClick={() => navigateToPath("/pilot-home")} className="nav-bar-links">Your Pilot Homepage</button>
            </div>
            <div className="right-nav-bar">
                <button onClick={() => navigateToPath("/login")} className="nav-bar-links">Login</button>
                <button onClick={() => navigateToPath("/sign-up")} className="nav-bar-links">Sign Up</button>
            </div>
        </div>
     );
}

export default NavBar;