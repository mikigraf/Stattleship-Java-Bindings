# Stattleship-Java-Bindings

Work in progress... 
Java bindings for the https://www.stattleship.com/ API. This is my personal project. I have nothing to do with Stattleship. I am not employed by Stattleship.
TODO: 

1. [ ] implement parsers for the json objects
2. [ ] use json objects instead of strings
3. [ ] implement missing, endpoint specific functions

## How to use it?
```javascript
// create Stattleship object with your API KEY as parameter
Stattleship stl = new Stattleship("<_YOUR_API_KEY_HERE>");
// create object for the league, that you want to fetch data from: NBA,NFL,MLB,NHL
NBA nba = new NBA();
// build your parameters by calling get[XY] and appending parameters trough functions. 
// getCurrentRequest() returns a string value of the url
String url = nba.getBasketballFeats().season_id("nba-2015-2016").player_id("nba-lebron-james").getCurrentRequest();
// connect returns a string containing the JSON response from the server
System.out.println(stl.connect(url));
```


## Other examples

```javascript
Stattleship stl = new Stattleship("<_YOUR_API_KEY_HERE>");
MLB mlb = new MLB();
NFL nfl = new NFL();
NHL nhl = new NHL();
NBA nba = new NBA();
System.out.println(stl.connect(mlb.getBaseballFeats().team_id("mlb-kc").player_id("mlb-eric-hosmer").getCurrentRequest()));
System.out.println(stl.connect(mlb.getBaseballFeats().team_id("mlb-bos").getCurrentRequest()));
System.out.println(stl.connect(nfl.getFootballFeats().season_id("nfl-2015-2016").week(6).getCurrentRequest()));
System.out.println(stl.connect(nhl.getHockeyFeasts().season_id("nhl-2015-2016").getCurrentRequest()));
System.out.println(stl.connect(nba.getBasketballFeats().season_id("nba-2015-2016").player_id("nba-lebron-james").getCurrentRequest()));
GameLogs mlbLogs = new GameLogs(SportLeague.MLB);
System.out.println(mlbLogs.getCurrentRequest());
```
