package sky.pro.java;

import java.util.Objects;

public class Employee {

  private final String fullName;
  private int department;
  private double salary;
  private final int id;
  private static int counter;

  public Employee(String fullName, int department, double salary) {
    this.fullName = fullName;
    this.department = department;
    this.salary = salary;
    counter++;
    id = counter;
  }

  public String getFIO() {
    return fullName;
  }

  public int getDepartment() {
    return department;
  }

  public double getSalary() {
    return salary;
  }

  public int getId() {
    return id;
  }

  public void setDepartment(int department) {
    this.department = department;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String toStringWithoutDepartment() {
    return String.format("Работник №%d: %s, зарплата: %.2f рублей", id, fullName, salary);
  }

  @Override
  public String toString() {
    return String.format("Работник №%d: %s, отдел: %d, зарплата: %.2f рублей\n", id, fullName,
        department, salary);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return department == employee.department && Double.compare(employee.salary, salary) == 0
        && id == employee.id && Objects.equals(fullName, employee.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, department, salary, id);
  }
}

