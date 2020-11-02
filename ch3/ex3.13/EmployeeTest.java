public class EmployeeTest {
  public static void main(String[] args) {
    Employee bob = new Employee("Robert", "Tate", 10000.00);
    
    System.out.printf("New Employee: %s %s - starting pay is $%.2f.\n",
      bob.getFirstName(), bob.getLastName(), bob.getSalary());
  }
}
