import java.util.Map;

public class Luxury extends Economy {

  protected boolean heatedSeats;
  protected boolean ventilatedSeats;
  protected boolean massageSeats;
  protected boolean rearSeatEntertainment;
  protected String interiorMaterial;
  protected String ambientLighting;
  protected boolean adaptiveCruiseControl;
  protected boolean airSuspension;
  protected boolean allWheelSteering;
  protected String driveModes;
  protected String chauffeurPackage;
  protected boolean voiceControl;

  public Luxury(Map<String, Object> map) {

    super(map);
    boolean heatedSeats = Boolean.parseBoolean((String) map.get("heatedSeats"));
    boolean ventilatedSeats = Boolean.parseBoolean((String) map.get("ventilatedSeatse"));
    boolean massageSeats = Boolean.parseBoolean((String) map.get("massageSeats"));
    boolean rearSeatEntertainment = Boolean.parseBoolean((String) map.get("rearSeatEntertainment"));
    String interiorMaterial = (String) map.get("interiorMaterial");
    String ambientLighting = (String) map.get("ambientLighting");
    boolean adaptiveCruiseControl = Boolean.parseBoolean((String) map.get("adaptiveCruiseControl"));
    boolean airSuspension = Boolean.parseBoolean((String) map.get("airSuspension"));
    boolean allWheelSteering = Boolean.parseBoolean((String) map.get("allWheelSteering"));
    String driveModes = (String) map.get("driveModes");
    String chauffeurPackage = (String) map.get("chauffeurPackage");
    boolean voiceControl = Boolean.parseBoolean((String) map.get("voiceControl"));

  }

  public void displayDetails() {
    super.displayDetails();
    System.out.println("Heated Seats: " + heatedSeats);
    System.out.println("Ventilated Seats: " + ventilatedSeats);
    System.out.println("Massage Seats: " + massageSeats);
    System.out.println("Rear Seat Entertainment: " + rearSeatEntertainment);
    System.out.println("Interior Material: " + interiorMaterial);
    System.out.println("Ambient Lighting: " + ambientLighting);
    System.out.println("Adaptive Cruise Control: " + adaptiveCruiseControl);
    System.out.println("Air Suspension: " + airSuspension);
    System.out.println("All Wheel Steering: " + allWheelSteering);
    System.out.println("Drive Modes: " + driveModes);
    System.out.println("Chauffeur Package: " + chauffeurPackage);
    System.out.println("Voice Control: " + voiceControl);
  }
}