import '../styles/HomePage.css';

function HomePage() {
    return ( 
        <div className="home-page-container">
            <div className="homepage-info-card">
                <h2>Choose Your Path...</h2>
                <h4>and join {} virtual pilots worldwide</h4>

                <button>Login</button>
                <button>Or Sign Up</button>
            </div>
            <div className="homepage-info-card-container">
                <div className="homepage-info-card">
                    <h2>Local License</h2>
                    <hr />
                    <p>
                        Begin as an unknown, and complete contracted cargo and passenger
                        flights as you increase your reputation and make money. Buy new planes
                        and improve your operations as you climb the ranks of private piloting
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