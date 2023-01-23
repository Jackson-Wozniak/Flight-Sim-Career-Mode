export default async function loginAndObtainJwtKey(username, password){
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