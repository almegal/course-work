import java.util.ArrayList;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    EmployeeBook employeeBook = new EmployeeBook(10);

    employeeBook.add("Денисов Андрей Витальевич", 3, 65_000);
    employeeBook.add("Компотов Василий Иванович", 1, 55_000);
    employeeBook.add("Котов Иннокентий Иванович", 2, 75_000);
    employeeBook.add("Федоров Иван Иванович", 4, 59_000);
    employeeBook.add("Сидиров Никита Васильевич", 1, 75_000);
    employeeBook.add("Фомин Арсений Васильевич", 2, 85_000);
    employeeBook.add("Комов Сергей Федорович", 3, 95_000);
    employeeBook.add("Плюшкин Андрей Геннадьевич", 4, 55_000);
    employeeBook.add("Антонов Кирилл Семенович", 5, 65_000);
    employeeBook.add("Жуков Георг Андреевич", 5, 75_000);
    employeeBook.printDataFromEmployees();
    employeeBook.remove("Жуков Георг Андреевич");
    employeeBook.remove(1);
    employeeBook.changeSalaryByFullName("Плюшкин Андрей Геннадьевич", 100_000);
    employeeBook.changeSalaryByFullName("Котов Иннокентий Иванович", 100_000);
    employeeBook.changeDepartmentByFullName("Котов Иннокентий Иванович", 1);
    System.out.println("Весь список работников:");
    employeeBook.printDataFromEmployees();

    employeeBook.printSortEmployeeByDepartment();
    }
}