/*
This file has test data until I build the server-side 
    for the private pilot path
*/
class Plane{
    name;
    speedInKnots;
    rangeInMiles;
    type;

    constructor(name, speedInKnots, rangeInMiles, type){
        this.name = name;
        this.speedInKnots = speedInKnots;
        this.rangeInMiles = rangeInMiles;
        this.type = type;
    }
}

class Airport{
    name;
    icaoCode;
    latitude;
    longitude;
    size;
    country;
    continent;

    constructor(name, icaoCode, latitude, longitude, size, country, continent){
        this.name = name;
        this.icaoCode = icaoCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.size = size;
        this.country = country;
        this.continent = continent;
    }
}

class Hangar{
    planes;

    constructor(planes){
        this.planes = planes;
    }
}

class Stats{
    airportsVisited;
    countriesVisisted;
    planesFlown;

    constructor(airportsVisited, countriesVisisted, planesFlown){
        this.airportsVisited = airportsVisited;
        this.countriesVisisted = countriesVisisted;
        this.planesFlown = planesFlown;
    }
}

class Flight{
    departureAirport;
    destinationAirport;
    timeToComplete;
    distance;
    story;
    constructor(departureAirport, destinationAirport, timeToComplete, distance, story){
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.timeToComplete = timeToComplete;
        this.distance = distance;
        this.story = story;
    }
}

class Pilot{
    name;
    isActiveFlight;
    activeFlight;
    inactiveFlights;
    balance;
    level;
    repToNextLevel;
    hangar;
    stats;

    constructor(name, isActiveFlight, activeFlight, inactiveFlights, balance, level, repToNextLevel, hangar, stats){
        this.name = name;
        this.isActiveFlight = isActiveFlight;
        this.activeFlight = activeFlight;
        this.inactiveFlights = inactiveFlights;
        this.balance = balance;
        this.level = level;
        this.repToNextLevel = repToNextLevel;
        this.hangar = hangar;
        this.stats = stats;
    }
}

let airports = [];
let planes = [];

airports.push(new Airport("Logan Internation Airport", "KBOS", 100, 100, "Large", "US", "NA"));
airports.push(new Airport("Logan Airport", "KBOS", 100, 100, "Large", "US", "NA"));
planes.push(new Plane("C152", 140, 1000, "propeller"));
planes.push(new Plane("C152", 140, 1000, "propeller"));

const hangar = new Hangar(planes);
const stats = new Stats(10, 3, 5);
const activeFlight = new Flight(airports[0], airports[1], 1, 100, "Hello");

let inactiveFlights = [];
inactiveFlights.push(new Flight(airports[0], airports[1], 3, 1500, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 2, 1000, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 3, 1500, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 2, 1000, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 3, 1500, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 2, 1000, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 3, 1500, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 2, 1000, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 3, 1500, "WORKING" ));
inactiveFlights.push(new Flight(airports[0], airports[1], 2, 1000, "WORKING" ));

const pilot = new Pilot("Test Pilot", false, activeFlight, inactiveFlights, 10000.00, 5, 100, hangar, stats);

export function getTestPilotData(){
    return pilot;
}

//this function will be used when server-side is built to update the chosen flights for pilots
export function updatePilotData(pilot){

}

//this function will be used to buy planes when server-side is built
export function buyPlane(jwtToken, plane){
    
}