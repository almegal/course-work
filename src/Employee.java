import java.util.Objects;

public class Employee {

    final private String fullName;
    private int department;
    private int salary;
    final private int id;
    private static int counterInstances = 0;

    public Employee(String fullName, int department, int salary) {
        // set id by postincrement
        this.id = ++counterInstances;

        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // GETTERS
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
    public static int getCounterInstances() {
        return counterInstances;
    }

    //SETTERS
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return "{ id: " + this.getId() +
                "\nФИО: " + this.getFullName() +
                "\nОтдел: " + this.getDepartment() +
                "\nЗапрлата: " + this.getSalary() +
                "\n" +
                " }";
    }

    @Override
    public boolean equals(Object other){
      if (this.getClass() != other.getClass()) return false;
      Employee employee = (Employee) other;
      return employee.getId() == this.getId() &&  this.getFullName().equals(employee.fullName);
    };

    @Override
    public int hashCode(){
        return Objects.hash(id, fullName);
    }
}
