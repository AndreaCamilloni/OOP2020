# Object-oriented programming project
Step by step, starting with Twitter [API](https://developer.twitter.com/en/docs/trends/locations-with-trending-topics/api-reference/get-trends-closest), I developed according to the project specifications a service based on REST API to show the locations that Twitter has trending topic information for.

## User Interface

User can make GET requests to show data and statistics. Below there are the possible routes:
| Method | Root | Description | 
|---------|---------|---------|
| GET | /Metadata | List of attribute,alias and source field of data | 
| GET | /Data | Trending topic closest to locations entered from input file |
| GET | /DataWithDistanceFrom?name="place" | Trending topic closest to locations with distance from "place" |
| GET | /TrendsAvailable | Locations that Twitter has trending topic information for |
| GET | /Stats | Sorted list by CountryCode of TOP rankings countries with multiple locations with trends |

_(For /Data and /DataWithDistanceFrom roots the user must configure the file "location.txt" with some location' name)_

### Use Case Diagram

<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/UseCase.png" width="400" title="UseCase">
</p>

## Configuration

 - Configure the file "location.txt (e.g. : Bologna,Milan,Rome,Naples,London,NewYork,Amsterdam)
	
 - After importing the project into eclipse, launch it as a spring boot application
 
 - Through an application(e.g. Postman), make GET requests to the server(http://localhost:8080)
	
### Requests

**GET /Metadata** (http://localhost:8080/Metadata)
```json
[
    {
        "alias": "name",
        "sourceField": "name",
        "type": "String"
    },
    {
        "alias": "PlaceType",
        "sourceField": "placeType",
        "type": "Object"
    },
    
    ...
    
    {
        "alias": "countryCode",
        "sourceField": "countryCode",
        "type": "String"
    }
]
```

<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/get%20METADATA.png"  title="Metadata">
</p>

**GET /Data** (http://localhost:8080/Data) It shows the locations that Twitter has trending topic information for, closest to the locations entered by input file
```json
[
    {
        "name": "Bologna",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/711080",
        "parentid": 23424853,
        "country": "Italy",
        "woeid": 711080,
        "countryCode": "IT"
    },
    ...
 ]
```    
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/GET%20Data.png"  title="Data">
</p>

**GET /DataWithDistanceFrom?name="place"**  (http://localhost:8080/DataWithDistanceFrom?name=Ancona) It shows the locations that Twitter has trending topic information for, closest to the locations entered by input file and it displays the distance of each location from "place"

```json
[
    {
        "name": "Bologna",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/711080",
        "parentid": 23424853,
        "country": "Italy",
        "woeid": 711080,
        "countryCode": "IT",
        "Coordinates": {
            "latitude": 11.34278,
            "longitude": 44.49389
        },
        "Distance[Km]": 259.8147529182084
    },
    {
        "name": "Milan",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/718345",
        "parentid": 23424853,
        "country": "Italy",
        "woeid": 718345,
        "countryCode": "IT",
        "Coordinates": {
            "latitude": 9.19034,
            "longitude": 45.46416
        },
        "Distance[Km]": 521.5067507327918
    }
]

```   
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/GET%20DatawithDistance.png"  title="DatawithDistance">
</p>

**GET /TrendsAvailable** (http://localhost:8080/TrendsAvailable) 
It show a list of the locations that Twitter has trending topic information for, formatted as in /Data
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/Get%20TrendsAvailable.png"  title="TrendsAvailable">
</p>

**GET /Stats** (http://localhost:8080/Stats) It displays the Country that Twitter has trending topic information for, sorted by how many town, for each Country, have trends. The statistic was made by comparing countrycodes.

The count parameter identifies how many town are available for each Country.

``` json
[
 {
        "name": "United States",
        "placeType": {
            "code": 12,
            "name": "Country"
        },
        "url": "http://where.yahooapis.com/v1/place/23424977",
        "parentid": 1,
        "country": "United States",
        "woeid": 23424977,
        "countryCode": "US",
        "count": 63,
        "town": [
            "Albuquerque",
            "Atlanta",
            "Austin",
            "Baltimore",
            "Baton Rouge",
            "Birmingham",
            "Boston",
            "Charlotte",
            "Chicago",
            "Cincinnati",
            "Cleveland",
            "Colorado Springs",
            "Columbus",
            "Dallas-Ft. Worth",
            "Denver",
            "Detroit",
            "El Paso",
            "Fresno",
            "Greensboro",
            "Harrisburg",
            "Honolulu",
            "Houston",
            "Indianapolis",
            "Jackson",
            "Jacksonville",
            "Kansas City",
            "Las Vegas",
            "Long Beach",
            "Los Angeles",
            "Louisville",
            "Memphis",
            "Mesa",
            "Miami",
            "Milwaukee",
            "Minneapolis",
            "Nashville",
            "New Haven",
            "New Orleans",
            "New York",
            "Norfolk",
            "Oklahoma City",
            "Omaha",
            "Orlando",
            "Philadelphia",
            "Phoenix",
            "Pittsburgh",
            "Portland",
            "Providence",
            "Raleigh",
            "Richmond",
            "Sacramento",
            "St. Louis",
            "Salt Lake City",
            "San Antonio",
            "San Diego",
            "San Francisco",
            "San Jose",
            "Seattle",
            "Tallahassee",
            "Tampa",
            "Tucson",
            "Virginia Beach",
            "Washington"
        ]
    },
{
        "name": "United Kingdom",
        "placeType": {
            "code": 12,
            "name": "Country"
        },
        "url": "http://where.yahooapis.com/v1/place/23424975",
        "parentid": 1,
        "country": "United Kingdom",
        "woeid": 23424975,
        "countryCode": "GB",
        "count": 26,
        "town": [
            "Birmingham",
            "Blackpool",
            "Bournemouth",
            "Brighton",
            "Bristol",
            "Cardiff",
            "Coventry",
            "Derby",
            "Edinburgh",
            "Glasgow",
            "Hull",
            "Leeds",
            "Leicester",
            "Liverpool",
            "Manchester",
            "Middlesbrough",
            "Newcastle",
            "Nottingham",
            "Plymouth",
            "Portsmouth",
            "Preston",
            "Sheffield",
            "Stoke-on-Trent",
            "Swansea",
            "London",
            "Belfast"
        ]
    }
]
``` 
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/GET%20Stats.png"  title="Stats">
</p>
	
## Package
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/Package.png"  title="Package">
</p>

### Model
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/model.png" title="Model">
</p>

### dbConnection
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/dbConnection.png" title="dbConnection">
</p>

### Controller
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/Controller.png" title="Controller">
</p>

### Util
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/Util.png" title="Util">
</p>

### Service
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/service.png" title="Service">
</p>

### Exception
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/exception.png" title="Exception">
</p>
## Software
 
 - Eclipse
 - Postman
 - VisualParadigm