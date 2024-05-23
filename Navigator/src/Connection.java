package Navigator.src;

public class Connection {
  private City city1;
  private City city2;
  

  public Connection(City city1, City city2) {
    

    double getDistanceInKm(City city1, City city2) {
      double lat1 = city1.getLatitude();
      double lon1 = city1.getLongitude();
      double lat2 = city2.getLatitude();
      double lon2 = city2.getLongitude();
      double earthRadiusKm = 6371;
      double dLat = Math.toRadians(lat2-lat1);
      double dLon = Math.toRadians(lon2-lon1);
      lat1 = degreesToRadians(lat1);
      lat2 = degreesToRadians(lat2);
      double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
              Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
              double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      return earthRadiusKm * c;
     
  }
}
}
