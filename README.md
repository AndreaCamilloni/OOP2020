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

**GET /Data** (http://localhost:8080/Data)
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

**GET /DataWithDistanceFrom?name=Ancona**  (http://localhost:8080/DataWithDistanceFrom?name=Ancona)

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
    ....
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

**GET /Stats** (http://localhost:8080/Stats) 
``` json
[
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
    },
    ....
    ]
``` 
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/GET%20Stats.png"  title="Stats">
</p>
	
Inputfile...

## Esempi di rotte e output

