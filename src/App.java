import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // boolean statusRunning = true;
        boolean adminAcces = false;
        Admin admin = new Admin();
        Utils utils = new Utils();
        Scanner input = new Scanner(System.in);
        Map<String, Object> allCars = new HashMap<>();

        Map<String, Object> economyData = new HashMap<>();
        economyData.put("brand", "Toyota");
        economyData.put("model", "Corolla");
        economyData.put("topSpeed", "300");
        economyData.put("price", "50000");
        economyData.put("rentPerHour", "30");
        economyData.put("year", "2020");
        economyData.put("color", "Blue");
        economyData.put("registrationNumber", "WNC478");
        economyData.put("engineCapacity", "1.8");
        economyData.put("seatingCapacity", "5");
        economyData.put("fuelEfficiency", "15km/L");
        economyData.put("isHybrid", "false");
        economyData.put("transmission", "Automatic");
        economyData.put("fuelType", "Petrol");
        economyData.put("location", "Karachi");
        economyData.put("mileage", "20000");
        economyData.put("insuranceDetails", "Full Coverage");
        economyData.put("lastServiceDate", "2024-11-10");
        economyData.put("carCategory", "Economy");
        economyData.put("entertainment", "false");
        economyData.put("sunroof", "false");
        economyData.put("safetyRating", "4");
        economyData.put("luggageCapacity", "450L");
        Car car1 = new Economy(economyData);
        allCars.put("Toyota-Corolla-2020", car1);

        Map<String, Object> luxuryData = new HashMap<>();
        luxuryData.put("brand", "Tesla");
        luxuryData.put("model", "X");
        luxuryData.put("topSpeed", "300");
        luxuryData.put("price", "50000");
        luxuryData.put("rentPerHour", "30");
        luxuryData.put("year", "2020");
        luxuryData.put("color", "Blue");
        luxuryData.put("registrationNumber", "WNC478");
        luxuryData.put("engineCapacity", "1.8");
        luxuryData.put("seatingCapacity", "5");
        luxuryData.put("fuelEfficiency", "15km/L");
        luxuryData.put("isHybrid", "false");
        luxuryData.put("transmission", "Automatic");
        luxuryData.put("fuelType", "Petrol");
        luxuryData.put("location", "Karachi");
        luxuryData.put("mileage", "20000");
        luxuryData.put("insuranceDetails", "Full Coverage");
        luxuryData.put("lastServiceDate", "2024-11-10");
        luxuryData.put("carCategory", "Economy");
        luxuryData.put("entertainment", "false");
        luxuryData.put("sunroof", "false");
        luxuryData.put("safetyRating", "4");
        luxuryData.put("luggageCapacity", "450L");
        luxuryData.put("engineCapacity", "1.8");
        luxuryData.put("seatingCapacity", "5");
        luxuryData.put("fuelEfficiency", "15km/L");
        luxuryData.put("isHybrid", "false");
        luxuryData.put("transmission", "Automatic");
        luxuryData.put("fuelType", "Petrol");
        luxuryData.put("location", "Karachi");
        luxuryData.put("mileage", "20000");
        luxuryData.put("insuranceDetails", "Full Coverage");
        luxuryData.put("lastServiceDate", "2024-11-10");
        luxuryData.put("carCategory", "Economy");
        luxuryData.put("heatedSeats", "true");
        luxuryData.put("ventilatedSeats", "true");
        luxuryData.put("massageSeats", "false");
        luxuryData.put("rearSeatEntertainment", "true");
        luxuryData.put("interiorMaterial", "Leather");
        luxuryData.put("ambientLighting", "Soft White");
        luxuryData.put("adaptiveCruiseControl", "true");
        luxuryData.put("airSuspension", "false");
        luxuryData.put("allWheelSteering", "false");
        luxuryData.put("driveModes", "Sport");
        luxuryData.put("chauffeurPackage", "Basic");
        luxuryData.put("voiceControl", "true");

        Car car2 = new Luxury(luxuryData);
        allCars.put("Tesla-X-2020", car2);
        // car2.displayDetails();
        // Car car1 = new Economy("Toyota", "Corolla",300, 2020, "ABC123", 50.0, "Available", "Economy");        
        // car1.displayDetails();


        System.out.println("--------------------------------");
        System.out.println("Welcome to ABC Car Rental System");
        System.out.println("\t | ADMIN LOGIN |");

        while(!adminAcces){
            System.out.println("Enter Username: ");
            String username = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            adminAcces = admin.login(username, password);
            if (!adminAcces) {
                System.out.println("Invalid Username or Password. Try again");
            }else {
                System.out.println("Login Successful");
            }
        }
        
        utils.start(allCars);
    }        
}
