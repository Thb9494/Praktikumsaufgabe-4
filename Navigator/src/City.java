package Navigator.src;

public class City {

  private String name;
  private double longitude;
  private double latitude;

  public City(String name, double longitude, double latitude) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
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
}