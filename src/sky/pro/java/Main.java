package sky.pro.java;

public class Main {

  public static void main(String[] args) {
    EmployeeBook employeeBook = new EmployeeBook(10);
    employeeBook.addEmployeeBook("Иванов Иван Иванович", 1, 81_000.78);
    employeeBook.addEmployeeBook("Петров Сергей Леонидович", 2, 86_050.21);
    employeeBook.addEmployeeBook("Арзуманян Артур Равильевич", 4, 70_000);
    employeeBook.addEmployeeBook("Сидоров Петр Константинович", 3, 93_850.64);
    employeeBook.addEmployeeBook("Козочкина Юлия Сергеевна", 5, 90_250.13);
    employeeBook.addEmployeeBook("Симонов Александр Сергеевич", 3, 75_120.55);
    employeeBook.addEmployeeBook("Марамзина Елена Анатольевна", 2, 92_850.35);
    employeeBook.addEmployeeBook("Петров Виктор Владимирович", 1, 65_050.78);
    employeeBook.addEmployeeBook("Валов Иван Леонидович", 5, 61_406.78);
    separator();
    System.out.println("Список данных о сотрудниках компании:");
    employeeBook.getAllEmployee();
    separator();
    System.out.printf("Сумма затрат на зарплаты сотрудников компании в месяц: %.2f рублей\n",
        employeeBook.getSumSalary());
    separator();
    System.out.println(
        "Минимальная зарплата сотрудника в компании: " + employeeBook.getMinSalary() + " рублей");
    employeeBook.getEmployeeWithMinSalary();
    separator();
    System.out.println(
        "Максимальная зарплата сотрудника в компании: " + employeeBook.getMaxSalary() + " рублей");
    employeeBook.getEmployeeWithMaxSalary();
    separator();
    System.out.printf("Среднее значение всех зарплат сотрудников в компании: %.2f рублей\n",
        employeeBook.getAverageSalaryOfEmployees());
    separator();
    System.out.println("ФИО сотрудников компании: ");
    employeeBook.getFullNameEmployees();
    separator();
    //Повышенный уровень
    System.out.println("Зарплата сотрудников компании после индексации: ");
    employeeBook.indexSalary(5);
    employeeBook.showIndexSalary();
    separator();
    System.out.println("Минимальная зарплата в выбранном отделе:\n" +
        employeeBook.getMinSalaryDepartment(1));
    separator();
    System.out.println("Максимальная зарплата в выбранном отделе:\n" +
        employeeBook.getMaxSalaryDepartment(1));
    separator();
    System.out.printf("Сумма затрат на зарплату по отделу: %.2f рублей\n",
        employeeBook.getSumSalaryDepartment(3));
    separator();
    System.out.printf("Среднее значение всех зарплат сотрудников в отделе: %.2f рублей\n",
        employeeBook.getAverageSalaryDepartment(5));
    separator();
    System.out.println("Зарплата сотрудников выбранного отдела после индексации: ");
    employeeBook.indexSalaryInDepartment(3, 5);
    separator();
    System.out.println("Данные о работниках отдела: ");
    employeeBook.showEmployeeDataInDepartment(4);
    separator();
    System.out.println("Все сотрудники компании с зарплатой меньше введенного числа:");
    employeeBook.findLowerSalary(90_000);
    separator();
    System.out.println("Все сотрудники с зарплатой больше введенного числа:");
    employeeBook.findHigherSalary(85_000);
    separator();
    //Создаем нового сотрудника, кладем в свободную ячейку массива
    employeeBook.addEmployeeBook("Галицына Анастасия Вадимовна", 1, 94_235);
    employeeBook.getAllEmployee();
    separator();
    //Удаляем сотрудника по id
    employeeBook.deleteEmployee(2);
    //Проверяем в списке удаленного сотрудника
    employeeBook.getAllEmployee();
    separator();
    //Изменяем зарплату сотруднику по ФИО
    employeeBook.setSalaryEmployees("Валов Иван Леонидович", 84_361);
    employeeBook.getAllEmployee();//Проверяем
    separator();
    //Изменяем отдел сотрудника по ФИО
    employeeBook.setDepartmentEmployee("Галицына Анастасия Вадимовна", 4);
    employeeBook.getAllEmployee();
    separator();
    employeeBook.printEmployeesDepartment();
  }

  public static void separator() {
    System.out.println(
        "==========================================================================");
  }
}
