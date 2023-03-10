function AssignedFlightDisplay(props) {
    return (  
        <div>
            <h1>{props.flight.route.distanceInMiles}</h1>
        </div>
    );
}

export default AssignedFlightDisplay;