package sky.pro.java;

public class Main {

  Employee[] storage = new Employee[10];

  public static void main(String[] args) {
    Employee[] storage = {
        new Employee("Иванов Иван Иванович", 1, 81_000.78),
        new Employee("Петров Сергей Леонидович", 2, 86_050.21),
        new Employee("Арзуманян Артур Равильевич", 4, 70_000),
        new Employee("Сидоров Петр Константинович", 3, 93_850.64),
        new Employee("Козочкина Юлия Сергеевна", 5, 90_250.13),
        new Employee("Симонов Александ Сергеевич", 3, 75_120.55),
        new Employee("Марамзина Елена Анатольевна", 2, 92_850.35)};
    getStorage(storage);
    separator();
    System.out.printf("Сумма затрат на зарплаты сотрудников в месяц: %.2f \n",
        checkSumSalary(storage));
    separator();
    findMinSalary(storage);
    System.out.print("Сотрудник с минимальной зарплатой:\n");
    findEmployeeWithMinSalary(storage);
    separator();
    findMaxSalary(storage);
    System.out.print("Сотрудник с максимальной зарплатой:\n");
    findEmployeeWithMaxSalary(storage);
    separator();
    System.out.printf("Среднее значение всех зарплат сотрудников: %.2f рублей\n",
        averageSalaryOfAllEmployees(storage));
    separator();
    checkFullNameEmployees(storage);
    separator();
  }

  public static void separator() {
    System.out.println(
        "==========================================================================");
  }

  public static void getStorage(Employee[] storage) {
    for (Employee employee : storage) {
      if (employee != null) {
        System.out.println((employee.toString()));
      }
    }
  }

  public static double checkSumSalary(Employee[] storage) {
    double sum = 0;
    for (Employee employee : storage) {
      sum += employee.getSalary();
    }
    return sum;
  }

  public static double findMinSalary(Employee[] storage) {
    double min = storage[0].getSalary();
    for (Employee employee : storage) {
      if (employee.getSalary() < min) {
        min = employee.getSalary();
      }
    }
    return min;
  }

  public static void findEmployeeWithMinSalary(Employee[] storage) {
    for (Employee employee : storage) {
      if (employee.getSalary() == findMinSalary(storage)) {
        System.out.println(employee);
      }
    }
  }

  public static double findMaxSalary(Employee[] storage) {
    double max = storage[0].getSalary();
    for (Employee employee : storage) {
      if (employee.getSalary() > max) {
        max = employee.getSalary();
      }
    }
    return max;
  }

  public static void findEmployeeWithMaxSalary(Employee[] storage) {
    for (Employee employee : storage) {
      if (employee.getSalary() == findMaxSalary(storage)) {
        System.out.println(employee);
      }
    }
  }

  public static double averageSalaryOfAllEmployees(Employee[] storage) {
    double average = 0;
    for (int i = 0; i < storage.length; i++) {
      average = checkSumSalary(storage) / storage.length;
    }
    return average;
  }

  public static void checkFullNameEmployees(Employee[] storage) {
    for (Employee employees : storage) {
      if (employees != null) {
        System.out.printf("%s \n", employees.getFIO());
      }
    }
  }

}
