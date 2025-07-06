import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeApp {
    static List<Employee> employees = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        System.out.println("Employee App ");

        addEmployee("Charan", "Engineering", 75000.00);
        addEmployee("Lahari", "HR", 50000.00);

        viewEmployees();

        updateEmployeeSalary(1, 80000.00);

        viewEmployees();

        deleteEmployee(1);

        viewEmployees();
    }

    static void addEmployee(String name, String dept, double salary) {
        Employee emp = new Employee(nextId++, name, dept, salary);
        employees.add(emp);
        System.out.println("Employee added: " + emp.name);
    }

    static void viewEmployees() {
        System.out.println("\nCurrent Employees:");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("ID | Name | Department | Salary");
            for (Employee e : employees) {
                System.out.printf("%d | %s | %s | %.2f%n",
                        e.id, e.name, e.department, e.salary);
            }
        }
    }

    static void updateEmployeeSalary(int id, double newSalary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary = newSalary;
                System.out.println("Updated salary for employee ID " + id);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    static void deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.id == id) {
                iterator.remove();
                System.out.println("Deleted employee ID " + id);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
}
