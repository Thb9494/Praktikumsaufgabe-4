package Navigator.src;

import java.util.ArrayList;
import java.util.List;

public class Route {
  private ArrayList<City> routeCities;
  private int totalDistance;

  // default constructor
  private Route() {
    this.routeCities = new ArrayList<>();
    this.totalDistance = 0;
  }

  // Copy Constructor
  private Route(Route route) {
    this.routeCities = new ArrayList<>(route.routeCities); // copy the routeCities
    this.totalDistance = route.totalDistance;
  }

  public void appendCity(City city, Connection connection) {
    routeCities.add(city);
    if (connection != null) {
      City previousCity = routeCities.get(routeCities.size() - 2); // Die vorherige Stadt in der Route, da letzte Stadt
                                                                   // die aktuelle Stadt ist
      totalDistance += connection.getDistanceInKm(previousCity, city); // Distanz zwischen der vorherigen und der
                                                                       // aktuellen Stadt
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
    // Leere Route erstellen
    Route currentRoute = new Route();
    ArrayList<Route> allPossibleRoutes = new ArrayList<>();
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
    // alle Routen ausgeben
    for (Route route : routesOrderedByDistance) {
      System.out.println(route.toString());
    }
    return routesOrderedByDistance.get(0);
  }

  private static void addAllRoutes(ArrayList<Route> allPossibleRoutes, Route currentRoute, City currentCity,
      City destination, Connection connection) {
    currentRoute.appendCity(currentCity, connection);

    if (currentCity.equals(destination)) { // Wenn die aktuelle Stadt das Ziel ist, füge die Route zu den möglichen
                                           // Routen hinzu
      allPossibleRoutes.add(currentRoute);
      return;
    } else {

      List<Connection> possibleNextCities = currentCity.getConnections(); // Erhalte alle möglichen Verbindungen von der
                                                                          // aktuellen Stadt

      for (int i = 0; i < possibleNextCities.size(); i++) { // Iteriere durch alle möglichen nächsten Städte
        City otherCity = possibleNextCities.get(i).getOtherCity(currentCity);

        if (!currentRoute.containsCity(otherCity)) { // Vermeide Zyklen durch Überprüfung, ob die Stadt bereits in der
                                                     // aktuellen Route enthalten ist
          Route continuedRoute = new Route(currentRoute);
          addAllRoutes(allPossibleRoutes, continuedRoute, otherCity, destination, possibleNextCities.get(i));
        }
      }
    }

  }
}
