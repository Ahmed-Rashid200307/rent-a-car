import java.time.LocalDateTime;
import java.util.Map;
import java.lang.reflect.Field;
import java.time.Duration;

public class Car {
  protected String brand;
  protected String model;
  protected int topSpeed;
  protected int year;
  protected double price;
  protected String color;
  protected String registrationNumber;
  
  // protected String insuranceDetails;
  // protected String lastServiceDate;
  // protected String carCategory;

  protected String renterName;
  protected String renterContact;
  protected String renterEmail;
  protected String renterAddress;
  protected String renterCity;
  protected String renterId;

  protected boolean isAvailable = true;
  protected LocalDateTime rentalDate;
  protected LocalDateTime returnDate;
  protected int rentalDuration;
  protected double rentalCost;
  protected double rentPerHour;

  public Car(Map<String, Object> map) {
      this.brand = (String) map.get("brand");
      this.model = (String) map.get("model");
      this.topSpeed = Integer.parseInt((String) map.get("topSpeed"));
      this.year = Integer.parseInt((String) map.get("year"));
      this.price = Double.parseDouble((String) map.get("price"));
      this.color = (String) map.get("color");
      this.registrationNumber = (String) map.get("registrationNumber");
      this.rentPerHour = Double.parseDouble((String) map.get("rentPerHour"));
  }


  public void SetRenterDetails(Map<String, Object> map) {
    if(this.isAvailable) {

      this.renterName = (String) map.get("name");
      this.renterContact = (String) map.get("contact");
      this.renterEmail = (String) map.get("email");;
      this.renterAddress = (String) map.get("address");
      this.renterCity = (String) map.get("city");
      this.renterId = (String) map.get("ID");
      setRentedCarDetails(Integer.parseInt((String) map.get("durationInHours")));
    }
    else {
      System.out.println("Car is already rented");
    }
  }

  public void setRentedCarDetails (int durationInHours) {
    LocalDateTime today = LocalDateTime.now();
    this.rentalDate = today;
    this.returnDate = today.plusHours(durationInHours);
    Duration duration = Duration.between(today, returnDate);
    this.rentalDuration = (int)duration.toHours();
    this.rentalCost = calculateCost(rentalDuration, rentPerHour);
    this.isAvailable = false;
  }

  public void carReturned() {
    if(isAvailable == false) {
      isAvailable = true;
      System.out.println("Car successfully returned!");
    }
    else {
      System.out.println("Car is already available");
    }
    }

  public double calculateCost (int durationHours,double rentRate) {
    return durationHours * rentRate;
  }

  public void setter(String fieldName, Object value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = null;
    Class<?> currentClass = this.getClass();

    while (currentClass != null) {
        try {
            field = currentClass.getDeclaredField(fieldName);
            break;
        } catch (NoSuchFieldException e) {
            currentClass = currentClass.getSuperclass();
        }
    }

    if(field == null){
      throw new NoSuchFieldException("Field not found");
    }
    else { 
      field.setAccessible(true);
      Class<?> dataType = field.getType();
      if(dataType == String.class) {
        field.set(this, value.toString());
      }
      else if(dataType == int.class) {
        field.set(this, Integer.parseInt(value.toString()));
      }
      else if(dataType == double.class) {
        field.set(this, Double.parseDouble(value.toString()));
      }
      else if(dataType == boolean.class) {
        field.set(this, Boolean.parseBoolean(value.toString()));
      }else {
        throw new IllegalArgumentException("Unsupported type: " + dataType.getName());
      }
    }
  }

  public Object getter(String fieldName) throws NoSuchFieldException, SecurityException, IllegalAccessException {
    Field field = null;
    Class<?> currentClass = this.getClass();

    while (currentClass != null) {
        try {
            field = currentClass.getDeclaredField(fieldName);
            break;
        } catch (NoSuchFieldException e) {
            currentClass = currentClass.getSuperclass();
        }
    }

    if (field == null) {
        throw new NoSuchFieldException("Field not found");
    } else {
        field.setAccessible(true);
        return field.get(this);
    }
  }

  
  public void displayDetails () {
    System.out.println("---------------------------------------");
    System.out.println("     |Brand: " + brand + "| Model: " + model +"|");
    System.out.println("---------------------------------------");
    System.out.println("Year: " + year);
    System.out.println("Price: " + price);
    System.out.println("Color: " + color);
    System.out.println("Registration Number: " + registrationNumber);
    System.out.println("Is Available: " + isAvailable);
    System.out.println("Rental Price Per Hour: " + rentPerHour + "$");
  }

  public void displayRentalDetails () {
    System.out.println("---------------------------------------");
    System.out.println("\t   Rental Details");
    System.out.println("---------------------------------------");
    System.out.println("Renter Name: " + renterName);
    System.out.println("Renter Contact: " + renterContact);
    System.out.println("Renter Email: " + renterEmail);
    System.out.println("Renter Address: " + renterAddress);
    System.out.println("Renter City: " + renterCity);
    System.out.println("Renter ID: " + renterId);
    System.out.println("Rental Date: " + rentalDate);
    System.out.println("Return Date: " + returnDate);
    System.out.println("Rental Duration: " + rentalDuration);
    System.out.println("Rental Cost: " + rentalCost + "$");
    System.out.println("---------------------------------------");
  }
}


