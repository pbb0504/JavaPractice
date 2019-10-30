package jdbc_01;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Employee[] employees;
        employees = new Employee[5];
        employees[0] = new Employee("zhangsan", 23562);
        employees[1] = new Employee("lisi", 27544);
        employees[2] = new Employee("wangwu", 22533);
        employees[3] = new Employee("zhaoliu", 29235);
        employees[4] = new Employee("qianqi", 29223);

        Arrays.sort(employees);
        Manager manager = new Manager("test",2343);
        Employee employee = new Employee("lskd",2314);
        manager.compareTo(employee);
        employee.compareTo(manager);
        for (Employee e : employees) {
            System.out.println("name: " + e.getName() + "\t salary: " + e.getSalary() + "\t");
        }

        employee.printNum(2,2,2,2,3,4,4,4,4,4,4,4,4,5);
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    void printNum(int... more){
        System.out.println(1 +new String(more,0,more.length));
    }
//    public void setName(String name) {
//        this.name = name;
//    }

    double getSalary() {
        return salary;
    }

    //    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public void raiseSalary(double percent){
//        salary += (salary*percent);
//    }
    @Override
    public int compareTo(Employee employee) {
        return Double.compare(this.salary, employee.salary);
    }
}

class Manager extends Employee {

    Manager(String name, int salary) {
        super(name, salary);
    }
}