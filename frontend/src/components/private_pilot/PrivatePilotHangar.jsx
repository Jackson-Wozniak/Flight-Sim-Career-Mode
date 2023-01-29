import '../../styles/private_pilot/PrivatePilotHangar.css';

function PrivatePilotHangar(props) {
    const numberFormatter = new Intl.NumberFormat();

    function displayPilotStore(){

    }

    return (  
        <div className="private-pilot-hangar-container">
            
            <h1 id="hangar-container-title">Owned Planes</h1>
            <hr id="hangar-container-seperator"/>

            {props.pilotHangar.map((plane, index) => {
                return  <div key={index} className="private-hangar-plane-container">
                            <div className="private-hangar-plane-info">
                                <div className="plane-info">
                                    <p className="plane-stats">{numberFormatter.format(plane.rangeInMiles)}mi</p>
                                    <p className="plane-labels">range</p>
                                </div>
                                <p>|</p>
                                <h1>{plane.name}</h1>
                                <p>|</p>
                                <div className="plane-info">
                                    <p className="plane-stats">{plane.speedInKnots} knots</p>
                                    <p className="plane-labels">cruising speed</p>
                                </div>
                            </div>
                            <hr className="plane-seperator"/>
                        </div>
            })}
            <button onClick={() => displayPilotStore()} className="plane-buy-button">Buy Planes</button>
        </div>
    );
}

export default PrivatePilotHangar;