package sky.pro.java;

import java.util.Arrays;

public class EmployeeBook {

  private final Employee[] book;

  public EmployeeBook(int size) {
    this.book = new Employee[size];
  }

  public void addEmployeeBook(String fullName, int department, double salary) {
    for (int i = 0; i < book.length; i++) {
      if (book[i] == null) {
        book[i] = new Employee(fullName, department, salary);
        return;
      }
    }
  }

  public void getAllEmployee() {
    for (Employee employees : book) {
      if (employees != null) {
        System.out.printf("Работник №%d: %s, отдел: %d, зарплата: %.2f рублей\n", employees.getId(),
            employees.getFIO(), employees.getDepartment(), employees.getSalary());
      }
    }
  }

  public double getSumSalary() {
    double sum = 0;
    for (Employee employee : book) {
      if (employee != null) {
        sum += employee.getSalary();
      }
    }
    return sum;
  }

  public double getMinSalary() {
    double min = Double.MAX_VALUE;
    for (Employee employee : book) {
      if (employee != null && employee.getSalary() < min) {
        min = employee.getSalary();
      }
    }
    return min;
  }

  public void getEmployeeWithMinSalary() {
    for (Employee employee : book) {
      if (employee != null && employee.getSalary() == getMinSalary()) {
        System.out.printf("Работник №%d: %s, отдел %d\n", employee.getId(), employee.getFIO(),
            employee.getDepartment());
      }
    }
  }

  public double getMaxSalary() {
    double max = Double.MIN_VALUE;
    for (Employee employee : book) {
      if (employee != null && employee.getSalary() > max) {
        max = employee.getSalary();
      }
    }
    return max;
  }

  public void getEmployeeWithMaxSalary() {
    for (Employee employee : book) {
      if (employee != null && employee.getSalary() == getMaxSalary()) {
        System.out.printf("Работник №%d: %s, отдел %d\n", employee.getId(), employee.getFIO(),
            employee.getDepartment());
      }
    }
  }

  public double getAverageSalaryOfEmployees() {
    double average = 0;
    int count = 0;
    for (int i = 0; i < book.length; i++) {
      if (book[i] != null)
        ;
      count++;
      average = getSumSalary() / count;
    }
    return average;
  }

  public void getFullNameEmployees() {
    for (Employee employees : book) {
      if (employees != null) {
        System.out.printf("%s \n", employees.getFIO());
      }
    }
  }

  public void indexSalary(double percent) {
    double kof = percent / 100;
    for (Employee employees : book) {
      if (employees != null) {
        double salary = employees.getSalary();
        employees.setSalary(salary + kof * salary);
      }
    }
  }

  public void showIndexSalary() {
    for (Employee employee : book) {
      if (employee != null) {
        System.out.printf("%s: %.2f рублей\n", employee.getFIO(), employee.getSalary());
      }
    }
  }

  public Employee[] filterByDepartment(int department) {
    return Arrays.stream(book).filter(x -> (x != null) && (x.getDepartment() == department))
        .toArray(Employee[]::new);
  }

  public Employee getMinSalaryDepartment(int department) {
    Employee result = book[0];
    double min = Double.MAX_VALUE;
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null && employee.getSalary() < min) {
        min = employee.getSalary();
        result = employee;
      }
    }
    return result;
  }

  public Employee getMaxSalaryDepartment(int department) {
    Employee result = book[0];
    double max = Double.MIN_VALUE;
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null && employee.getSalary() > max) {
        max = employee.getSalary();
        result = employee;
      }
    }
    return result;
  }

  public double getSumSalaryDepartment(int department) {
    double sumDepartment = 0;
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null) {
        sumDepartment += employee.getSalary();
      }
    }
    return sumDepartment;
  }

  public double getAverageSalaryDepartment(int department) {
    double average = 0;
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null) {
        average += employee.getSalary() / filterByDepartment(department).length;
      }
    }
    return average;
  }

  public void indexSalaryInDepartment(int department, double percent) {
    double kof = percent / 100;
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null) {
        employee.setSalary(employee.getSalary() + (employee.getSalary() * kof));
        System.out.println(employee.toStringWithoutDepartment());
      }
    }
  }

  public void showEmployeeDataInDepartment(int department) {
    for (Employee employee : filterByDepartment(department)) {
      if (employee != null) {
        System.out.println(employee.toStringWithoutDepartment());
      }
    }
  }

  public void findLowerSalary(double number) {
    for (Employee employees : book) {
      if (employees != null && employees.getSalary() < number) {
        System.out.println(employees.toStringWithoutDepartment());
      } else if (employees == null && number < getMinSalary()) {
        System.out.println("Сотрудников с такой зарплатой нет!");
      }
    }
  }

  public void findHigherSalary(double number) {
    for (Employee employees : book) {
      if (employees != null && employees.getSalary() >= number) {
        System.out.println(employees.toStringWithoutDepartment());
      } else if (employees == null && number > getMaxSalary()) {
        System.out.println("Сотрудников с такой зарплатой нет!");
      }
    }
  }

  public boolean deleteEmployee(int id) {
    for (int i = 0; i < book.length; i++) {
      if (book[id] != null && book[i].getId() == id) {
        book[i] = null;
        return true;
      }
    }
    return false;
  }

  public int getEmployeeIndex(String fullName) {
    for (int i = 0; i < book.length; i++) {
      if (book[i] != null && book[i].getFIO().equals(fullName)) {
        return i;
      }
    }
    return -1;
  }

  public void setSalaryEmployees(String fullName, double salary) {
    int index = getEmployeeIndex(fullName);
    for (int i = index; i < book.length; i++) {
      if (book[i] != null) {
        book[index].setSalary(salary);
      }
    }
  }

  public void setDepartmentEmployee(String fullName, int department) {
    int index = getEmployeeIndex(fullName);
    for (int i = index; i < book.length; i++) {
      if (book[i] != null) {
        book[index].setDepartment(department);
      }
    }
  }

  public String printArrayToStringWithoutDepartment(int department) {
    for (Employee employee : this.filterByDepartment(department)) {
      if (employee != null) {
        System.out.println(employee.toStringWithoutDepartment());
      }
    }
    return "==========================================================================";
  }


  public void printEmployeesDepartment() {
    for (int i = 1; i < 6; i++) {
      this.filterByDepartment(i);
      System.out.println("Список отдела номер: " + i);
      System.out.println(printArrayToStringWithoutDepartment(i));
    }
  }
}



