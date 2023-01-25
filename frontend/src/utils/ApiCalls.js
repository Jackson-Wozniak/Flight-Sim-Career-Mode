async function loginAndObtainJwtKey(username, password){
    let usernameQuery = "username=" + username + "&";
    let passwordQuery= "password=" + password;
    const response = await fetch('http://localhost:8080/api/v1/pilot/login?' + usernameQuery + passwordQuery);

    if(response.status !== 200){
        let res = await response.text();
        throw new Error(res);
    }else{
        let token = await response.text();
        return token;
    }
}

async function findTotalPilotCount(){
    const response = await fetch('http://localhost:8080/api/v1/pilot/count');

    if(response.status !== 200){
        let res = await response.text();
        throw new Error(res);
    }else{
        let pilotCount = await response.text();
        return pilotCount;
    }
}

class CreatePilotRequest{
    username;
    password;
    pilotName;
    homeCountry;
    
    constructor(username, password, pilotName, homeCountry){
        this.username = username;
        this.password= password;
        this.pilotName = pilotName;
        this.homeCountry = homeCountry;
    }
}

async function registerNewPilot(username, password, pilotName, homeCountry){
    let createPilotRequest = new CreatePilotRequest(username, password, pilotName, homeCountry);
    const response = await fetch('http://localhost:8080/api/v1/pilot/register', {
        method : 'POST',
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(createPilotRequest)
    });

    if(response.status !== 200){
        let res = await response.text();
        throw new Error(res);
    }else{
        let pilotCount = await response.text();
        return pilotCount;
    }
}

export {loginAndObtainJwtKey, findTotalPilotCount, registerNewPilot};