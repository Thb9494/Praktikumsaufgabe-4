package Navigator.src;

public class Main {
  public static void main(String[] args) {
    
  City Ingolstadt = new City ("Ingolstadt", 48.764001378240835, 11.42625484665524);
  City Muenchen = new City ("Muenchen", 48.13891855227781, 11.577266137987793);
  City Nuernberg = new City ("Nuernberg", 49.45061728516064, 11.076253152617218);
  City Ulm = new City ("Ulm", 48.40203485876449, 9.976324958249457); 
  City Stuttgart = new City ("Stuttgart", 48.77593813959718, 9.17688481609677);
  City Augsburg = new City ("Augsburg", 48.3684765834842, 10.89671693335146);
  City Regensburg = new City ("Regensburg", 49.01662121288669, 12.092787603517024);
  City Wuerzburg = new City ("Wuerzburg", 49.01662121288669, 12.092787603517024);

    //Stadt ausgeben
    Ingolstadt.toString(Ingolstadt);
    Muenchen.toString(Muenchen);
    Nuernberg.toString(Nuernberg);
    Ulm.toString(Ulm);
    Stuttgart.toString(Stuttgart);
    Augsburg.toString(Augsburg);
    Regensburg.toString(Regensburg);
    Wuerzburg.toString(Wuerzburg);

    //direkte Verbindung zwischen Städten hinzufügen
    Ingolstadt.addConnection(Muenchen);
    Ingolstadt.addConnection(Nuernberg);
    Ingolstadt.addConnection(Regensburg);
    Ingolstadt.addConnection(Augsburg);
    Muenchen.addConnection(Augsburg);
    Ulm.addConnection(Augsburg);
    Stuttgart.addConnection(Ulm);
    Stuttgart.addConnection(Nuernberg);
    Stuttgart.addConnection(Wuerzburg);
    Regensburg.addConnection(Muenchen);
    Regensburg.addConnection(Nuernberg);
    Nuernberg.addConnection(Ulm);
  }

}
