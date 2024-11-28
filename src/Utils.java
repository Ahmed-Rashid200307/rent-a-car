import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utils {
  Scanner input = new Scanner(System.in);
  ArrayList<String> carData = new ArrayList<>(Arrays.asList("brand","model","year","price","color","registrationNumber","isAvailable","rentPerHour","engineCapacity","seatingCapacity","fuelEfficiency","isHybrid","transmission","fuelType","location","mileage","insuranceDetails","lastServiceDate","carCategory","topSpeed","entertainment","sunroof","safetyRating","luggageCapacity","heatedSeats","ventilatedSeats","massageSeats","rearSeatEntertainment","interiorMaterial","ambientLighting","adaptiveCruiseControl","airSuspension","allWheelSteering","driveModes","chauffeurPackage","voiceControl"));

  ArrayList<String> rentData = new ArrayList<>(Arrays.asList("name", "contact", "email", "address", "city", "ID", "durationInHours"));
  public boolean running = true;
  
  
  public void start(Map<String, Object> allCars) throws NoSuchFieldException, SecurityException, IllegalAccessException {
    while (running) {
      switch (chooseOption()) {
        case 1:
        addCar(allCars);
        break;

        case 2:
        rentCar(allCars);
        break;

        case 3:
        removeCar(allCars);
        break;

        case 4:
        editCar(allCars);
        break;

        case 5:
        displayCar(allCars);;
        break;

        case 6:
        displayCarsAll(allCars, null);
        break;

        case 7:
        displayAvailableCars(allCars);;
        break;

        case 8:
        returnCar(allCars);
        break;

        case 9:
        running = false;
        break;
        
        default:
        System.out.println("Invalid Option");
        break;
      }
    }
  }
  

  public int chooseOption () {
    int option;
    System.out.println("\nChoose Option");
    System.out.println("1. Add Car");
    System.out.println("2. Rent a Car");
    System.out.println("3. Remove Car");
    System.out.println("4. Edit Car");
    System.out.println("5. Display Car");
    System.out.println("6. Display All Cars");
    System.out.println("7. Display Available Cars");
    System.out.println("8. Return Car");
    System.out.println("9. EXIT");
    
    option = input.nextInt();
    return option;
  }
  

  public int chooseCarType () {
    int option;
    System.out.println("\nChoose Car Type");
    System.out.println("1. Economy");
    System.out.println("2. Luxury");
    System.out.println("3. Exit");
    
    option = input.nextInt();
    input.nextLine();
    return option;
  }
  

  public Map<String, Object> insertData(int typeOption) {
    Map<String, Object> carDataMap = new HashMap<>();
    System.out.println("---------------------------------------");
    System.out.println("       Enter Car Details");
    System.out.println("---------------------------------------");
    if(typeOption == 1) {
      for(int i = 0; i< 24; i++){
        System.out.print("Enter " + carData.get(i) + ": ");
        carDataMap.put(carData.get(i), input.nextLine());
      }
    }
    else if(typeOption == 2) {
      for(int i = 0; i< 36; i++){
        System.out.print("Enter " + carData.get(i) + ": ");
        carDataMap.put(carData.get(i), input.nextLine());
      }
    }

    return carDataMap;
  }
  

  public Map<String, Object> addCar(Map<String, Object> allCars) {
    int carType = chooseCarType();
    Map<String, Object> carDataMap = insertData(carType);
    String carIdentifier = carDataMap.get("brand").toString() + "-" + carDataMap.get("model").toString() + "-" + carDataMap.get("year").toString();

    if(carType == 1){
      allCars.put(carIdentifier, new Economy(carDataMap));
    }else if(carType == 2){
      allCars.put(carIdentifier, new Luxury(carDataMap));
    }else{
      System.out.println("Unknown error: Car not added");
      return allCars;
    }

    return allCars;

  }


  public void removeCar(Map<String, Object> allCars) {
    System.out.print("Enter the car you want to remove: ");
    String carToRemove = displayAllCars(allCars);
    // input.nextLine();
    Iterator<Map.Entry<String, Object>> iterator = allCars.entrySet().iterator();

    boolean removed = false;
    while (iterator.hasNext()) {
        Map.Entry<String, Object> entry = iterator.next();
        if (carToRemove.equalsIgnoreCase(entry.getKey())) {
            iterator.remove();
            removed = true;
            System.out.println("Removed entry: " + entry.getKey());
            break;
        }
    }

    if (!removed) {
        System.out.println("No matching entry found.");
    }

  }

  public void editCar(Map<String, Object> allCars) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    String carToEdit = displayAllCars(allCars , "----Choose the car for editing----");
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      if(carToEdit.equalsIgnoreCase(entry.getKey())) {
        System.out.println("Enter the field you want to edit: ");
        String fieldToEdit = input.next();
        input.nextLine();
        System.out.println("Enter the new value: ");
        String newValue = input.next();
        input.nextLine();
        Car car= (Car)castObject(entry.getValue());
        car.setter(fieldToEdit, newValue);
        car.displayDetails();
      }
    }
  }

  public void displayCar(Map<String,Object> allCars) {
    String carToDisplay = displayAllCars(allCars, "----Choose the car for displaying----");
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      if(carToDisplay.equalsIgnoreCase(entry.getKey())) {
        Car car = (Car)castObject(entry.getValue());
        car.displayDetails();
      }
  }
  }


  public String displayAllCars (Map<String, Object> allCars) {
    int count = 1;
    System.out.println("----Choose the car for renting----");
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      System.out.println(count + entry.getKey());
      count ++;
    }
  
    System.out.print("Enter (brand-model-year) : ");
    String option = input.next();
    input.nextLine();
    return option;
  }


  public String displayAllCars (Map<String, Object> allCars, String display) {
    int count = 1;
    System.out.println(display);
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      System.out.println(count+ ". " + entry.getKey());
      count ++;
    }
  
    System.out.print("Enter (brand-model-year) : ");
    String option = input.next();
    input.nextLine();
    return option;
  }

  public void displayCarsAll (Map<String, Object> allCars, String display) {
    System.out.println(display);
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      Car car = (Car)castObject(entry.getValue());
      car.displayDetails();
      car.displayRentalDetails();
    }
  }

  public void displayAvailableCars (Map<String, Object> allCars) throws NoSuchFieldException, SecurityException, IllegalAccessException {
    System.out.println("----Cars available for renting----");
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      Car car = (Car)castObject(entry.getValue());
      if(car.getter("isAvailable").equals(true)) {
        car.displayDetails();
        car.displayRentalDetails();
      }
    }
  }

  // CONTINUE FROM HERE
  public void setRentDetails(Car rentcar) throws NoSuchFieldException, SecurityException, IllegalAccessException{
    Map<String, Object> rentDataMap = new HashMap<>();
    rentcar.displayDetails();

    System.out.println("---------------------------------------");
    System.out.println("       Enter Customer Details");
    System.out.println("---------------------------------------");
    for(String rentDataItem: rentData){
      System.out.print("Enter " + rentDataItem + ": ");
      rentDataMap.put(rentDataItem, input.next());
    }

    System.out.println(rentDataMap);
    rentcar.SetRenterDetails(rentDataMap);
    rentcar.getter("brand");
    rentcar.displayRentalDetails();
  }


  public void rentCar(Map<String, Object> allCars) throws NoSuchFieldException, SecurityException, IllegalAccessException {
    String option = displayAllCars(allCars);
    Car car = null;
    boolean carFound = false;
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      car = (Car)castObject(entry.getValue());
      System.out.println(car.getter("model"));

      String carDetails = (String)car.getter("brand") + "-" + (String)car.getter("model") + "-" + car.getter("year").toString();
      if(option.equalsIgnoreCase(carDetails)) {
        carFound = true;
        setRentDetails(car);
        break;
      }

      }

      if(!carFound) {
        System.out.println("Car not found! Try again");
      }

  }

  public void returnCar(Map<String, Object> allCars) throws NoSuchFieldException, SecurityException, IllegalAccessException {
    String option = displayAllCars(allCars);
    Car car = null;
    boolean carFound = false;
    for (Map.Entry<String, Object> entry : allCars.entrySet()) {
      car = (Car)castObject(entry.getValue());
      System.out.println(car.getter("model"));

      String carDetails = (String)car.getter("brand") + "-" + (String)car.getter("model") + "-" + car.getter("year").toString();
      if(option.equalsIgnoreCase(carDetails)) {
        carFound = true;
        car.carReturned();;
        break;
      }

      }

      if(!carFound) {
        System.out.println("Car not found! Try again");
      }

  }


  public Object castObject(Object object) {
    Object car = null;
    if(object instanceof Economy){
      car = (Economy) object;
    }
    else if(object instanceof Luxury){
      car = (Luxury) object;
    }

    return car;
  }

}