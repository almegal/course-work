import java.util.ArrayList;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private final static Employee[] employee = randomizerEmployeeArray(15);
    public static void main(String[] args) {

        printDataFromEmployees(employee);
        //printFullNameFromEmployees(employee);
        //increaseSalaryies(employee, 20, 4);
        //printDataFromEmployees(employee);
        //System.out.println("calcAverageSalaries(employee) = " + calcAverageSalaries(employee));
        //System.out.println("calcTotalExpensesForSalaries(employee) = " + calcTotalExpensesForSalaries(employee));
        //System.out.println("findBiggestSalariesEmployee(employee) = " + findBiggestSalariesEmployee(employee));
        //System.out.println("findSmallestSalariesEmployee(employee) = " + findSmallestSalariesEmployee(employee));

        //increaseSalaryies(employee, 10);
        //printDataFromEmployees(employee);

        //System.out.println("findSmallestSalariesEmployee(employee, 3) = " + findSmallestSalariesEmployee(employee, 3));
        //System.out.println("findBiggestSalariesEmployee(employee, 3) = " + findBiggestSalariesEmployee(employee, 3));
        //System.out.println("calcTotalExpensesForSalaries(employee, 2) = " + calcTotalExpensesForSalaries(employee, 2));
        //System.out.println("calcAverageSalaries(employee, 2) = " + calcAverageSalaries(employee, 2));

        //printDataFromEmployeesWithoutDepartment(employee, 2);
        // printEmployeeSalariyesMoreThan(employee, 60_000);
        // printEmployeeSalariyesLessThan(employee, 60_000);
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public static void printDataFromEmployees(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static void printDataFromEmployeesWithoutDepartment(Employee[] array, int department){
        for (Employee employee1 : array) {
            if(employee1.getDepartment() == department) {
                System.out.println("id: " + employee1.getId() +
                        "\nФИО: " + employee1.getFullName() +
                        "\nЗарплата: " + employee1.getSalary()
                        );

            }
        }
    }
    //Посчитать сумму затрат на зарплаты в месяц.
    public static int calcTotalExpensesForSalaries(Employee[] array) {
        int result = 0;
        for (Employee employee1 : array) {
            result += employee1.getSalary();
        }
        return result;
    }
    //Посчитать сумму затрат на зарплаты в месяц по отделу
    public static int calcTotalExpensesForSalaries(Employee[] array, int department) {
        Employee[] newArr = getEmployeeByDepartment(array, department);
        return calcTotalExpensesForSalaries(newArr);
    }

    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public static int calcAverageSalaries(Employee[] array){
        return calcTotalExpensesForSalaries(array) / array.length;
    };
    //Подсчитать среднее значение зарплат по отделу.
    public static int calcAverageSalaries(Employee[] array, int department){
      Employee [] newArr = getEmployeeByDepartment(array, department);
      return calcTotalExpensesForSalaries(newArr) / newArr.length;
    };
    //Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public static void printFullNameFromEmployees(Employee[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getFullName());
        }
    }

    //Найти сотрудника с минимальной / максимальной зарплатой зарплатой.
    public static Employee findSmallestSalariesEmployee(Employee[] array){
        int index = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            final int salary = array[i].getSalary();
            if(i == 0 || salary < result) {
                result = salary;
                index = i;
            }
        }
        return array[index];
    }
    public static Employee findSmallestSalariesEmployee(Employee[] array, int department) {
        Employee[] newArr = getEmployeeByDepartment(array, department);
        return findSmallestSalariesEmployee(newArr);
    }

    public static Employee findBiggestSalariesEmployee(Employee[] array) {
        int index = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            final int salary = array[i].getSalary();
            if(i == 0 || salary > result) {
                result = salary;
                index = i;
            }
        }
        return array[index];
    };
    public static Employee findBiggestSalariesEmployee(Employee[] array, int department){
        Employee[] newArr = getEmployeeByDepartment(array, department);
        return findBiggestSalariesEmployee(newArr);
    }
    //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static void printEmployeeSalariyesLessThan(Employee[] array, int value){
        for (Employee employee1 : array) {
            final int salary = employee1.getSalary();
            if(salary < value) {
                System.out.println("id: " + employee1.getId() +
                        "\nФИО: " + employee1.getFullName() +
                        "\nЗарплата: " + employee1.getSalary()
                );
            }
        }
    }
    //Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static void printEmployeeSalariyesMoreThan(Employee[] array, int value){
        for (Employee employee1 : array) {
            final int salary = employee1.getSalary();
            if(salary > value) {
                System.out.println("id: " + employee1.getId() +
                        "\nФИО: " + employee1.getFullName() +
                        "\nЗарплата: " + employee1.getSalary()
                );
            }
        }
    }

    //функция для генерации рандомный объектов типа Employee для списка employee
    private static Employee[] randomizerEmployeeArray(int size){

        Employee[] result = new Employee[size];

        for (int i = 0; i < result.length; i++) {

            final String fullName = randomFullName();
            final int salary = randomSalary();
            final int  department = randomDepartment();
            result[i] = new Employee(fullName, department, salary);
        }

        return result;
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public static void increaseSalaryies(Employee[] array, int value){
        final float procent = value/100f;
        for (int i = 0; i < array.length; i++) {
            final int salary = array[i].getSalary();
            final double increased = (salary * (value/100d)) + salary;
            array[i].setSalary((int)increased);
        }
    }
    //Проиндексировать зарплату в отделе
    public static void increaseSalaryies(Employee[] array, int value, int department) {
        Employee[] newArr = getEmployeeByDepartment(array, department);
        increaseSalaryies(newArr, value);
    }
    // вспомогательная функция которая вовзращает список Employy определенного отдела
    public static Employee[] getEmployeeByDepartment(Employee[] array, int department){
        Employee[] result;
        int count = 0;
        //считаем количество сотрудников соответсвующие департмену
        for (Employee employee1 : array) {
            if(employee1.getDepartment() == department){
                count++;
            }
        }
        // инициализируем пустой список сотрудников
        result = new Employee[count];
        //
        count = 0;
        for (int i = 0; i < array.length; i++) {
            final int dept = array[i].getDepartment();
            if(dept == department){
                result[count] = array[i];
                count++;
            }
        }

        return result;
    }    //****************
    //ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ для randomizerEmployeeArray
    //
    private static String randomFullName(){
        // чтобы сгенерировать рандомные фио - определим списки фамалий, имен и отчеств
        final String[] fName = {"Алексей", "Иван", "Олег", "Сергей", "Максим", "Александр", "Федор", "Кирилл", "Антон", "Илья"};
        final String[] mName = {"Алексеевич", "Иванавич", "Олегович", "Сергеевич", "Максимович", "Александрович", "Федорович", "Кириллович", "Антонович", "Ильич"};
        final String[] lName = {"Елисеев", "Иванов", "Беглов", "Сергеев", "Асимов", "Хандров", "Поров", "Иларинов", "Фатонов", "Ивлеев"};
        // получаем рандомные числа от 0 до велечины списка
        final int i1 = (int) (Math.random() * fName.length-1);
        final int i2 = (int) (Math.random() * mName.length-1);
        final int i3 = (int) (Math.random() * lName.length-1);
        //возвращаем рандомную строку
        // в качестве индекса используются рандомные числа полученные ранее
        return fName[i1] + " " + mName[i2] + " " + lName[i3];
    }

    private static int randomSalary(){
        // возвращаем рандомное число от 50_000 до 100_000
        return (int) (Math.random() * 50_000) + 50_000;
    };
    private static int randomDepartment(){
        // возвращаем рандомное число от 1 до 5
        return 1 + (int) (Math.random() * 5);
    }
}