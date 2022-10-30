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
    //повышенный уровень
    System.out.print("Зарплата сотрудников после индексации:\n");
    indexSalary(storage);
    separator();
    System.out.print("Информация обо всех работниках из одного отдела:\n");
    filterDepartment(storage, 3);
    separator();
    System.out.print("Минимальная зарплата в выбранном отделе:\n");
    System.out.printf("%.2f рублей\n", findMinSalaryInDepartment(storage, 3));
    separator();
    System.out.print("Максимальная зарплата в выбранном отделе:\n");
    System.out.printf("%.2f рублей\n", findMaxSalaryInDepartment(storage, 3));
    separator();
    System.out.print("Сумма затрат на зарплаты сотрудников в отделе:\n");
    System.out.printf("%.2f рублей\n", checkSumSalaryDepartment(storage, 3));
    separator();
    System.out.println("Среднее значение всех зарплат сотрудников в отделе:");
    System.out.printf("%.2f рублей\n", averageSalaryInDepartment(storage, 2));
    separator();
    System.out.println("Зарплата сотрудников выбранного отдела после индексации:");
    indexSalaryInDepartment(storage, 3, 5);
    separator();
    System.out.println("Информация о сотрудниках отдела без вывода номера отдела:");
    printEmployeesDepartment(storage, 2);
    separator();
    System.out.println("Все сотрудники с зарплатой меньше введенного числа:");
    findLowerSalary(storage, 87_000);
    separator();
    System.out.println("Все сотрудники с зарплатой больше введенного числа:");
    findHigherSalary(storage, 70_000);
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

  //метод filterDepartment создан для проверки min/max зарплат сотрудников в отделе
  public static void filterDepartment(Employee[] storage, int department) {
    int i = 0;
    while (i < storage.length) {
      if (storage[i].getDepartment() == department && storage[i] != null) {
        System.out.println(storage[i].toString());
      }
      i++;
    }
  }

  public static void indexSalary(Employee[] storage) {
    int percent = 5;
    for (Employee employees : storage) {
      System.out.printf("%s: %.2f рублей\n", employees.getFIO(),
          (employees.getSalary() + (employees.getSalary() * percent) / 100));
    }
  }

  public static double findMinSalaryInDepartment(Employee[] storage, int department) {
    double min = Double.MAX_VALUE;
    for (Employee employee : storage) {
      if (employee != null && employee.getDepartment() == department
          && employee.getSalary() < min) {
        min = employee.getSalary();
      }
    }
    return min;
  }


  public static double findMaxSalaryInDepartment(Employee[] storage, int department) {
    double max = Double.MIN_VALUE;
    int i = 0;
    while (i < storage.length) {
      if (storage[i] != null && storage[i].getDepartment() == department
          && storage[i].getSalary() > max) {
        max = storage[i].getSalary();
      }
      i++;
    }
    return max;
  }

  public static double checkSumSalaryDepartment(Employee[] storage, int department) {
    double sum = 0;
    int i = 0;
    while (i < storage.length) {
      if (storage[i] != null && storage[i].getDepartment() == department) {
        sum += storage[i].getSalary();
      }
      i++;
    }
    return sum;
  }

  public static double averageSalaryInDepartment(Employee[] storage, int department) {
    double average = 0;
    int count = 0;
    for (Employee employee : storage) {
      if (employee != null && employee.getDepartment() == department) {
        count++;
        average += employee.getSalary();
      }
    }
    return average / count;
  }

  public static void indexSalaryInDepartment(Employee[] storage, int department, int percent) {
    double salary = 0;
    for (Employee employee : storage) {
      if (employee != null && employee.getDepartment() == department) {
        salary = employee.getSalary() + (employee.getSalary() * percent) / 100;
        System.out.printf("%s: %.2f рублей\n", employee.getFIO(), salary);
      }
    }
  }

  public static void printEmployeesDepartment(Employee[] storage, int department) {
    for (Employee employees : storage) {
      if (employees != null && employees.getDepartment() == department) {
        System.out.printf("Работник №%d: %s, зарплата: %.2f\n", employees.getId(),
            employees.getFIO(),
            employees.getSalary());
      }
    }
  }

  public static void findLowerSalary(Employee[] storage, double number) {
    for (Employee employees : storage) {
      if (employees != null && employees.getSalary() < number) {
        System.out.printf("Работник №%d: %s, зарплата: %.2f рублей\n", employees.getId(),
            employees.getFIO(),
            employees.getSalary());
      }
    }
  }

  public static void findHigherSalary(Employee[] storage, double number) {
    for (Employee employees : storage) {
      if (employees != null && employees.getSalary() >= number) {
        System.out.printf("Работник №%d: %s, зарплата: %.2f рублей\n", employees.getId(),
            employees.getFIO(),
            employees.getSalary());
      }
    }
  }
}
