import java.util.Map;

public class Economy extends Car{
  
  protected double engineCapacity;
  protected int seatingCapacity;
  protected String fuelEfficiency;
  protected boolean isHybrid;
  protected String transmission;
  protected String fuelType;
  
  protected String location;
  protected int mileage;
  protected String insuranceDetails;
  protected String lastServiceDate;
  protected String carCategory;
  protected boolean entertainment;
  protected boolean sunroof;
  protected int safetyRating;
  protected String luggageCapacity;

 public Economy(Map<String, Object> map)
   {
    super(map);
    this.engineCapacity = Double.parseDouble((String) map.get("engineCapacity"));
    this.seatingCapacity = Integer.parseInt((String) map.get("seatingCapacity"));; 
    this.fuelEfficiency = (String) map.get("fuelEfficiency");
    this.isHybrid = Boolean.parseBoolean((String) map.get("isHybrid"));
    this.transmission = (String) map.get("transmission");
    this.fuelType = (String) map.get("fuelType");
    this.location = (String) map.get("location");
    this.mileage = Integer.parseInt((String) map.get("mileage"));;
    this.insuranceDetails = (String) map.get("insuranceDetails");
    this.lastServiceDate = (String) map.get("lastServiceDate");
    this.carCategory = (String) map.get("carCategory");
    this.entertainment = Boolean.parseBoolean((String) map.get("entertainment"));
    this.sunroof = Boolean.parseBoolean((String) map.get("sunroof"));
    this.safetyRating = Integer.parseInt((String) map.get("safetyRating"));;
    this.luggageCapacity = (String) map.get("luggageCapacity");
    
  }

  @Override
  public void displayDetails () {
    super.displayDetails();
    System.out.println("Engine Capacity: " + engineCapacity);
    System.out.println("Seating Capacity: " + seatingCapacity);
    System.out.println("Fuel Efficiency: " + fuelEfficiency);
    System.out.println("Hybrid: " + isHybrid);
    System.out.println("Transmission: " + transmission);
    System.out.println("Fuel Type: " + fuelType);
    System.out.println("Location: " + location);
    System.out.println("Mileage: " + mileage);
    System.out.println("Insurance Details: " + insuranceDetails);
    System.out.println("Last Service Date: " + lastServiceDate);
    System.out.println("Car Category: " + carCategory);
  }

}
