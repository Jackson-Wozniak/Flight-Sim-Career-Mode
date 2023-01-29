import '../../styles/private_pilot/PrivatePilotFlights.css'

function PrivatePilotFlights(props) {
    return (  
        <div className="private-pilot-flights-container">
            {props.pilotFlightOffers.map((flight, index) => {
                return  <div key={index}>
                            <div>
                                {flight.departureAirport.name}
                                {flight.departureAirport.icaoCode + "->"}
                                {flight.destinationAirport.name}
                                {flight.destinationAirport.icaoCode}
                            </div>
                            <button>Assign Flight</button>
                            <button>Show Story</button>
                        </div>
            })}
        </div>
    );
}

export default PrivatePilotFlights;