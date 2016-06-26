# Stattleship-Java-Bindings
Work in progress... 
This is my personal project. I am not employed by Stattleship. I am not in any way connected with Stattleship.

Example:
```javascript
        MLB mlb = new MLB();
        NFL nfl = new NFL();
        NHL nhl = new NHL();
        NBA nba = new NBA();
        System.out.println(stl.connect(mlb.getBaseballFeats().team_id("mlb-kc").player_id("mlb-eric-hosmer").getCurrentRequest()));
        System.out.println(stl.connect(nfl.getFootballFeats().season_id("nfl-2015-2016").week(6).getCurrentRequest()));
        System.out.println(stl.connect(nhl.getHockeyFeasts().season_id("nhl-2015-2016").getCurrentRequest()));
        System.out.println(stl.connect(nba.getBasketballFeats().season_id("nba-2015-2016").player_id("nba-lebron-james").getCurrentRequest()));
```
