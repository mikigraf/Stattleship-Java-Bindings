# Stattleship-Java-Bindings
Work in progress... 
TODO:
[ ] implement parsers for the json objects
[ ] use json objects instead of strings
[ ] implement missing, endpoint specific functions

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
