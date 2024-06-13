package Navigator.src;

public class Connection {
    private City city1;
    private City city2;
    private final double DISTANCE;

    public Connection(City city1, City city2) {
        this.city1 = city1;
        this.city2 = city2;
        this.DISTANCE = getDistanceInKm(city1, city2); //hier wird die Distanz zwischen den beiden Städten berechnet
    }
 public double getDistanceInKm(City city1, City city2) { //Methode, um die Distanz zwischen den beiden Städten zu berechnen
        double earthRadiusKm = 6371.0; //erdradius in km

        double lat1 = city1.getLatitude();
        double lon1 = city1.getLongitude();
        double lat2 = city2.getLatitude();
        double lon2 = city2.getLongitude();

        double dLat = degreesToRadians(lat2 - lat1); //Differenz der Breitengrade
        double dLon = degreesToRadians(lon2 - lon1); //Differenz der Längengrade

        lat1 = degreesToRadians(lat1);
        lat2 = degreesToRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + 
                   Math.sin(dLon / 2) * Math.sin(dLon / 2) *
                   Math.cos(lat1) * Math.cos(lat2); //Formel zur Berechnung der Distanz zwischen zwei Punkten auf der Erdoberfläche

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); //c entspricht dem Winkel zwischen den beiden Punkten
        return earthRadiusKm * c; //Distanz zwischen den beiden Städten
    }

    private double degreesToRadians(double degrees) { //Methode, um Grad in Bogenmaß umzurechnen
        return degrees * Math.PI / 180;
    }

    public City getOtherCity(City city) {
        if (city.equals(city1)) {
            return city2;
        } else if (city.equals(city2)) {
            return city1;
        } else {
            return null;
        }
      
    }
   

   
    }

