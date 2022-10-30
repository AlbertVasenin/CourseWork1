package sky.pro.java;

import java.util.Objects;

public class Employee {

  private String fullName;
  private int department;
  private double salary;
  private int id;
  private static int counter = 0;

  public Employee(String fullName, int department, double salary) {
    id = ++counter;
    this.fullName = fullName;
    this.department = department;
    this.salary = salary;
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

  @Override
  public String toString() {
    return String.format("Работник №%d: %s, отдел: %d, зарплата: %.2f рублей", id, fullName,
        department, salary);
  }
}

