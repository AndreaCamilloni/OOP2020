# Object-oriented programming project
Step by step, starting with Twitter [API](https://developer.twitter.com/en/docs/trends/locations-with-trending-topics/api-reference/get-trends-closest), I developed according to the project specifications a service based on REST API to show the locations that Twitter has trending topic information for.

##User Interface

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

##Configuration

	1- configure the file "location.txt"
		e.g. : Bologna,Milan,Rome,Naples,London,NewYork,Amsterdam
	2- After importing the project into eclipse, launch it as a spring boot application
	3- Through an application(e.g. Postman), make GET requests to the server(http://localhost:8080)
	
##Example requests

	
Inputfile...

##Esempi di rotte e output

