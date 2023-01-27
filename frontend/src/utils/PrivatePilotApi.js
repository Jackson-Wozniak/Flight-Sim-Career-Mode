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


let airports = [];
let planes = [];

airports.push(new Airport("Logan Airport", "KBOS", 100, 100, "Large", "US", "NA"));
airports.push(new Airport("Logan Airport", "KBOS", 100, 100, "Large", "US", "NA"));
planes.push(new Plane("C152", 140, 1000, "propeller"));
planes.push(new Plane("C152", 140, 1000, "propeller"));

function getPlanes(){
    return planes;
}

function getAirports(){
    return airports;
}

export {getPlanes, getAirports};