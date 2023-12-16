import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employee;
    EmployeeBook(int size) {
        this.employee = new Employee[size];
    }
    public void printDataFromEmployees() {
        for (Employee value : this.employee) {
            System.out.println(value);
        }
    }
    //метод который добавляет Employee в список
    public void add(String fullName, int department, int salary) {
        for (int i = 0; i < employee.length; i++) {
            if(employee[i] == null) {
                employee[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }
    public void remove(int id) {
        for (int i = 0; i < this.employee.length; i++) {
            final Employee empl = this.employee[i];
            if (empl == null) continue;
            if(empl.getId() == id) {
                this.employee[i] = null;
                break;
            }
        }
    }
    public void remove(String fullName) {
        for (int i = 0; i < this.employee.length; i++) {
            final Employee empl = this.employee[i];
            if (empl == null) continue;

            final String a = empl.getFullName().toLowerCase();
            final String b = fullName.toLowerCase();
            if(a.equals(b)) {
                this.employee[i] = null;
                break;
            }
        }
    }
    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printDataFromEmployeesByDepartment( int department){
        for (Employee empl : this.employee) {
            if(empl == null) continue;
            if(empl.getDepartment() == department) {
                System.out.println("id: " + empl.getId() +
                        "\nФИО: " + empl.getFullName() +
                        "\nЗарплата: " + empl.getSalary()
                );
            }
        }
    }
    //Посчитать сумму затрат на зарплаты в месяц.
    public int calcTotalExpensesForSalaries() {
        int result = 0;

        for (Employee empl : this.employee) {
            if(empl == null) continue;
            result += empl.getSalary();
        }
        return result;
    }
    //Посчитать сумму затрат на зарплаты в месяц по отделу
    public int calcTotalExpensesForSalaries(int department) {
        EmployeeBook employeeBook = getEmployeeByDepartment(this.employee, department);
        return employeeBook.calcTotalExpensesForSalaries();
    }
    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public int calcAverageSalaries(){
        return calcTotalExpensesForSalaries() / this.employee.length;
    };
    //Подсчитать среднее значение зарплат по отделу.
    public int calcAverageSalaries(int department){
        EmployeeBook employeeBook = getEmployeeByDepartment(this.employee, department);
        return employeeBook.calcAverageSalaries();
    };
    //Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public void printFullNameFromEmployees(){
        for (int i = 0; i < this.employee.length; i++) {
            if (this.employee[i] == null) continue;
            System.out.println(this.employee[i].getFullName());
        }
    }
    //Найти сотрудника с минимальной / максимальной зарплатой зарплатой.
    public Employee getSmallestOrBiggestSalaries(String str){
        int index = 0;
        int result = 0;
        boolean needSmallest = str.equalsIgnoreCase("smallest");

        for (int i = 0; i < this.employee.length; i++) {
            if(this.employee[i] == null) continue;
            final int salary = this.employee[i].getSalary();
            if (result == 0) {
                result = salary;
                continue;
            }
            if(needSmallest && salary < result) {
                result = salary;
                index = i;
            } else if(!needSmallest && salary > result){
                result = salary;
                index = i;
            }
        }
        return this.employee[index];
    }
    public Employee getSmallestOrBiggestSalaries(String str, int department) {
        EmployeeBook employeeBook = getEmployeeByDepartment(this.employee, department);
        return employeeBook.getSmallestOrBiggestSalaries(str);

    }
    //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeeSalariyesLessThan( int value){
        for (Employee empl : this.employee) {
            if(empl == null) continue;
            final int salary = empl.getSalary();
            if(salary < value) {
                System.out.println("id: " + empl.getId() + "\nФИО: " + empl.getFullName() + "\nЗарплата: " + empl.getSalary());
            }
        }
    }
    //Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeeSalariyesMoreThan( int value){
        for (Employee empl : this.employee) {
            if (empl == null) continue;
            final int salary = empl.getSalary();
            if(salary > value) {
                System.out.println("id: " + empl.getId() + "\nФИО: " + empl.getFullName() + "\nЗарплата: " + empl.getSalary());
            }
        }
    }
    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void increaseSalaryies(int value){
        final double procent = value/100f;

        for (int i = 0; i < this.employee.length; i++) {
            if (this.employee[i] == null) continue;

            final int salary = this.employee[i].getSalary();
            final double increased = (salary * procent) + salary;

            this.employee[i].setSalary((int)increased);
        }
    }
    //Проиндексировать зарплату в отделе
    public void increaseSalaryies(int value, int department) {
        final double procent = value/100f;
        for (Employee empl : this.employee) {
            if (empl == null) continue;

            final int depart = empl.getDepartment();
            if (depart == department) {
                final int salary = empl.getSalary();
                final double increased = (salary * procent) + salary;
                empl.setSalary((int)increased);
            }
        }
    }
    //5.
    //    1. Изменить зарплату по фио
    public void changeSalaryByFullName(String fullName, int salary){
        for (Employee empl : this.employee) {
            if(empl == null) continue;

            final String a = empl.getFullName().toLowerCase();
            final String b = fullName.toLowerCase();
            if(a.equals(b)) empl.setSalary(salary);
        }
    }
    //Изменить отдел.
    public void changeDepartmentByFullName(String fullName, int department) {
        for (Employee empl : this.employee) {
            if(empl == null) continue;

            final String a = empl.getFullName().toLowerCase();
            final String b = fullName.toLowerCase();
            if (a.equals(b)) empl.setDepartment(department);
        }
    }
    // Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void printSortEmployeeByDepartment(){
        ArrayList<Integer> departments = new ArrayList<Integer>();
        for (Employee empl : this.employee) {
            if(empl == null) continue;
            final int dept = empl.getDepartment();
            if(!departments.contains(dept)) departments.add(dept);
        }

        for (int i = 0; i < departments.size(); i++) {
            final int department = departments.get(i);
            EmployeeBook employeeByDepartment = getEmployeeByDepartment(this.employee, department);

            System.out.println("department = " + department);
            for (Employee empl : employeeByDepartment.employee) {
                System.out.println(empl.getFullName());
            }
            System.out.println("______________________");
        }
    }
    // вспомогательная функция которая вовзращает  EmployeeBook определенного отдела
    public EmployeeBook getEmployeeByDepartment(Employee[] array, int department){
        EmployeeBook result;
        int count = 0;
        //считаем количество сотрудников соответсвующие департмену
        for (Employee empl : array) {
            if(empl != null && empl.getDepartment() == department){
                count++;
            }
        }
        // инициализируем пустой  сотрудников
        result = new EmployeeBook(count);
        //
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null) continue;

            final String fullName = array[i].getFullName();
            final int dept = array[i].getDepartment();
            final int salary = array[i].getSalary();

            if(dept == department){
                result.add(fullName, dept, salary);
            }
        }
        return result;
    }
}
