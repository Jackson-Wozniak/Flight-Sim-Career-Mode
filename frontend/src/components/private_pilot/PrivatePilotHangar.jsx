function PrivatePilotHangar(props) {
    return (  
        <div>
            {props.pilotHangar.map((plane, index) => {
                return  <div key={index}>
                            {plane.name}
                        </div>
            })}
        </div>
    );
}

export default PrivatePilotHangar;