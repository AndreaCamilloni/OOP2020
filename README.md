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
##Configurazione
Inputfile...
##Esempi di rotte e output

### UseCaseDiagram
<p align="center">
  <img src="https://github.com/AndreaCamilloni/OOP2020/blob/master/varie/UseCase.png" width="400" title="UseCase">
</p>
