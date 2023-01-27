function PrivatePilotFlights(props) {
    return (  
        <div>
            {props.pilotFlightOffers.map((flight, index) => {
                <div key={index}>
                    {flight.route.departure.icaoCode}
                </div>
            })}
        </div>
    );
}

export default PrivatePilotFlights;