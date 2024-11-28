public class Admin {
  private String adminName = "Admin";
  private String adminPassword = "Admin";
  private String adminEmail = "ahmedrashid2003.07@gmail.com";
  private long adminPhone = 3158216962L;
  
  public boolean login(String name, String password) {
    return name.equals(adminName) && password.equals(adminPassword);
  }

  public void setEmail(String email) {
    this.adminEmail = email;
  }

  public void getEmail () {
    System.out.println("Admin Email: " + adminEmail);
  }

  public void setPhoneNumber(long phone) {
    this.adminPhone = phone;
  }

  public void getPhoneNumber () {
    System.out.println("Admin Phone Number: " + adminPhone);
  }
}
