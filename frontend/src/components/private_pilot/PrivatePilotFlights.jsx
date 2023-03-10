import '../../styles/private_pilot/PrivatePilotFlights.css'
import { assignActiveFlight } from '../../utils/PrivatePilotApi';

function PrivatePilotFlights(props) {
    const numberFormatter = new Intl.NumberFormat();

    function assignFlightAsActive(index){
        const jwtToken = localStorage.getItem("jwtToken");
        assignActiveFlight(jwtToken, index);
    }

    return (  
        <div className="private-pilot-flights-container">
            <h1 id="flight-container-title">Available Flights</h1>
            <hr id="flight-container-seperator"/>

            {props.pilotFlightOffers.map((flight, index) => {
                return  <div key={index} className="private-pilot-flight-column">
                            <div className="private-pilot-flight">
                                <div className="private-pilot-flight-airport-info">
                                    <p>{flight.route.departure.name} ({flight.route.departure.icaoCode})</p>
                                    <p>{flight.route.departure.country}, {flight.route.departure.continent}</p>
                                </div>
                                <div className="private-pilot-flight-info">
                                    <div className="airport-seperator">
                                        <p className="airport-direction-identifier">Departure</p>
                                        <hr />
                                    </div>
                                    <div>
                                        <h4>{flight.route.durationInHours} hours</h4>
                                        <button onClick={() => props.activateStory(true, flight.flightStory.narrative)}>See Story</button>
                                        <h4>{numberFormatter.format(flight.route.distanceInMiles)} mi</h4>
                                    </div>
                                    <div className="airport-seperator">
                                        <p className="airport-direction-identifier">Destination</p>
                                        <hr />
                                    </div>
                                </div>
                                <div className="private-pilot-flight-airport-info">
                                    <p>{flight.route.destination.name} ({flight.route.destination.icaoCode})</p>
                                    <p>{flight.route.destination.country}, {flight.route.destination.continent}</p>
                                </div>
                            </div>
                            {/* 
                            TODO:
                                after pressing assign flight button, set the pilot's isActiveFlight to true,
                                call api with flight chosen, and update pilot object to reflect current flight
                            */}
                            <button className="assign-private-flight" onClick={() => assignFlightAsActive(flight.flightIndex)}>Accept Offer</button>
                            <hr className="flight-seperator"/>
                        </div>
            })}
        </div>
    );
}

export default PrivatePilotFlights;