package interfaces;

import java.util.Arrays;

public class InterfaceDemo1 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("张三", 500);
        employees[1] = new Employee("李四", 1500);
        employees[2] = new Employee("王五", 2500);
        Arrays.sort(employees);

        for (Employee e :
                employees) {
            System.out.println("Name: " + e.getName() + " Salary: " + e.getSalary());
        }
    }
}

class Employee implements Comparable<Employee> {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    /**
     * 比较
     *
     * @param o 传进来的参数
     * @return 如果传进来的o小与本对象返回正数
     */
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }

    public int getSalary() {
        return salary;
    }
}