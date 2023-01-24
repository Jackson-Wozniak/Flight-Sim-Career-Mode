import '../styles/LoadingScreen.css';
import clouds from '../images/cloud_clipart.png'
import plane from '../images/plane_clipart.png';

function LoadingScreen() {
    return (  
        <div className="loading-screen-container">
            <img className="airplane" src={plane} alt="airplane" />
            <h3>Landing Shortly...</h3>
            <img src={clouds} alt="cloud1" className="cloud1" />
            <img src={clouds} alt="cloud2" className="cloud2" />
            <img src={clouds} alt="cloud3" className="cloud3" />
        </div>
    );
}

export default LoadingScreen;