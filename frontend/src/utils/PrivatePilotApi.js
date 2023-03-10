//this function will be used when server-side is built to update the chosen flights for pilots
export function updatePilotData(pilot){

}

//this function will be used to buy planes when server-side is built
export function buyPlane(jwtToken, plane){
    
}

export async function getPrivatePilotByToken(token){
    const response = await fetch("http://localhost:8080/api/v1/pilot/private?token=" + token);

    if(response.status !== 200){
        let res = await response.text();
        throw new Error(res);
    }else{
        let pilot = await response.json();
        return pilot;
    }
}

export async function assignActiveFlight(token, flightIndex){
    const response = await fetch("http://localhost:8080/api/v1/pilot/private/flights/active?token=" 
        + token + "&flightIndex=" + flightIndex, {
            method : "PUT",
            headers: {
                "Content-Type": "application/json"
            }
        });

    if(response.status !== 200){
        let err = response.text();
        console.log(err);
        throw new Error(err);
    }
    let text = await response.text();
    console.log(text);
}