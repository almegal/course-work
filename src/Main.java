// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private final static Employee[] employee = randomizerEmployeeArray(10);
    public static void main(String[] args) {

        printDataFromEmployees(employee);
        printFullNameFromEmployees(employee);

        System.out.println("calcAverageSalaries(employee) = " + calcAverageSalaries(employee));
        System.out.println("calcTotalExpensesForSalaries(employee) = " + calcTotalExpensesForSalaries(employee));
        System.out.println("findBiggestSalariesEmployee(employee) = " + findBiggestSalariesEmployee(employee));
        System.out.println("findSmallestSalariesEmployee(employee) = " + findSmallestSalariesEmployee(employee));
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public static void printDataFromEmployees(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
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

    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public static int calcAverageSalaries(Employee[] array){
        int result = calcTotalExpensesForSalaries(array) / array.length;
        return result;
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

    //****************
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