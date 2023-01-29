import '../../styles/private_pilot/PrivatePilotFlights.css'

function PrivatePilotFlights(props) {
    const numberFormatter = new Intl.NumberFormat();

    return (  
        <div className="private-pilot-flights-container">
            <h1 id="flight-container-title">Available Flights</h1>
            <hr id="flight-container-seperator"/>

            {props.pilotFlightOffers.map((flight, index) => {
                return  <div key={index} className="private-pilot-flight-column">
                            <div className="private-pilot-flight">
                                <div className="private-pilot-flight-airport-info">
                                    <p>{flight.departureAirport.name} ({flight.departureAirport.icaoCode})</p>
                                    <p>{flight.departureAirport.country}, {flight.departureAirport.continent}</p>
                                </div>
                                <div className="private-pilot-flight-info">
                                    <hr />
                                    <div>
                                        <h4>{flight.timeToComplete} hours</h4>
                                        <button onClick={() => props.activateStory(true, flight.story)}>See Story</button>
                                        <h4>{numberFormatter.format(flight.distance)} mi</h4>
                                    </div>
                                    <hr />
                                </div>
                                <div className="private-pilot-flight-airport-info">
                                    <p>{flight.destinationAirport.name} ({flight.destinationAirport.icaoCode})</p>
                                    <p>{flight.destinationAirport.country}, {flight.destinationAirport.continent}</p>
                                </div>
                            </div>
                            {/* 
                            TODO:
                                after pressing assign flight button, set the pilot's isActiveFlight to true,
                                call api with flight chosen, and update pilot object to reflect current flight
                            */}
                            <button className="assign-private-flight">Accept Offer</button>
                            <hr className="flight-seperator"/>
                        </div>
            })}
        </div>
    );
}

export default PrivatePilotFlights;