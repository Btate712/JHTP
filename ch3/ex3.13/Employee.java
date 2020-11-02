public class Employee {
  private String firstName;
  private String lastName;
  private double salary;

  public Employee(String firstName, String lastName, double salary) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
  }

  public void setFirstName(String name) {
    this.firstName = name;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setLastName(String name) {
      this.lastName = name;
    }

  public String getLastName() {
    return this.lastName;
  }

  public void setSalary(double salary) {
    if(salary > 0) {
      this.salary = salary;
    }
  }

  public double getSalary() {
    return this.salary;
  }
}
