import java.util.HashMap;
import java.util.Map;

public class EmployeeDatabase {
    private static Map<String, Employee> employees = new HashMap<>();

    static {
        employees.put("OğuzhanCantekin", new Employee("OğuzhanCantekin", "12345"));
        employees.put("employee", new Employee("employee", "password"));
        employees.put("1", new Employee("1", "1"));
        // Diğer çalışanları burada ekleyebilirsiniz.
    }

    public static Employee getEmployeeByUsername(String username) {
        return employees.get(username);
    }

    public static boolean isValidEmployee(String username, String password) {
        Employee employee = getEmployeeByUsername(username);
        return employee != null && employee.getPassword().equals(password);
    }
}
