package Navigator.src;

import java.util.ArrayList;
import java.util.List;
public class Route {
  private ArrayList<City> routeCities;
  private double totalDistance;

  //default constructor
  private Route() {
    this.routeCities = new ArrayList<>();
    this.totalDistance = 0;
  }

  //Copy Constructor
  private Route(Route route) {
    this.routeCities = new ArrayList<>(route.routeCities); //copy the routeCities
    this.totalDistance = route.totalDistance;
  }
    

    public void appendCity(City city, Connection connection) {
        //city zu routeCities hinzufügen
        routeCities.add(city);
        // falls die Connection nicht null ist die Distanz in Kilometern der übergebenen Connection zu der totalDistance der Route hinzugefügt werden.
        if (connection != null) {
            totalDistance += connection.getDistanceInKm(city, city);
        }
    }
    public boolean containsCity(City city) {
      return routeCities.contains(city);
  }

  public String toString() {
    StringBuilder routeString = new StringBuilder();
    for (int i = 0; i < routeCities.size(); i++) {
        routeString.append(routeCities.get(i).getName());
        if (i < routeCities.size() - 1) {
            routeString.append(" - ");
        }
    }
    routeString.append("; Distanz: ").append(totalDistance).append(" km");
    return routeString.toString();
}

public static Route getShortestRoute(City origin, City destination) {
  //Leere Route erstellen
  Route currentRoute = new Route();
  ArrayList <Route> allPossibleRoutes = new ArrayList<>();
  addAllRoutes(allPossibleRoutes, currentRoute, origin, destination, null);
  ArrayList<Route> routesOrderedByDistance = new ArrayList<>();
  for (Route route : allPossibleRoutes) {
      if (routesOrderedByDistance.isEmpty()) {
          routesOrderedByDistance.add(route);
      } else {
          for (int i = 0; i < routesOrderedByDistance.size(); i++) {
              if (route.totalDistance < routesOrderedByDistance.get(i).totalDistance) {
                  routesOrderedByDistance.add(i, route);
                  break;
              }
          }
      }
  }
  //alle Routen ausgeben
  for (Route route : routesOrderedByDistance) {
      System.out.println(route.toString());
  }
  return routesOrderedByDistance.get(0);
}


private static void addAllRoutes(ArrayList <Route> allPossibleRoutes, Route currentRoute, City currentCity, City destination, Connection connection) {
  currentRoute.appendCity(currentCity, connection);

  if (currentCity.equals(destination)) {
      allPossibleRoutes.add(new Route(currentRoute));
      return;
  } 
  // Erhalte alle möglichen Verbindungen von der aktuellen Stadt
        List<Connection> possibleNextCities = currentCity.getConnections();

        // Iteriere durch alle möglichen nächsten Städte
        for (int i = 0; i < possibleNextCities.size(); i++) {
          Connection nextConnection = possibleNextCities.get(i);
          City nextCity = nextConnection.getOtherCity(currentCity);
          // Vermeide Zyklen durch Überprüfung, ob die Stadt bereits in der aktuellen Route enthalten ist
          if (!currentRoute.containsCity(nextCity)) {
              Route continuedRoute = new Route(currentRoute);
                addAllRoutes(allPossibleRoutes, continuedRoute, nextCity, destination, possibleNextCities.get(i));
            }
        }
  

 
  }
}



