package Navigator.src;

import java.util.ArrayList;

public class City {

  private String name;
  private double longitude;
  private double latitude;
  private ArrayList<Connection> connections;


  public City(String name, double longitude, double latitude) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.connections = new ArrayList<>();
  }

  //getter und setter
  public String getName() {
    return name;
  } 
  public void setName(String name) {
    this.name = name;
  }

  public double getLongitude() {
    return longitude;
  }
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void toString(City city) {
    System.out.println( ""+ getName() + " " + getLongitude() + " " + getLatitude() + "\n");
  }

  public void addConnection(City city) {
    //Verbindein einer stadt mit sich selbst ist nicht möglich
    if (this.equals(city)) {
      System.out.println("Eine Stadt kann nicht mit sich selbst verknüpft werden");;
    }
     Connection connection = new Connection(this, city);
        this.connections.add(connection);
        city.connections.add(connection);
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }
  }
