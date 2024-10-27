import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {
    private static Map<String, Customer> customers = new HashMap<>();

    static {
        customers.put("12345678901", new Customer("12345678901", "1"));
        customers.put("98765432109", new Customer("98765432109", "sifre2"));
        customers.put("123", new Customer("123", "123"));
    }

    public static Customer getCustomerByTcNumber(String tcNumber) {
        return customers.get(tcNumber);
    }

    public static boolean isValidCustomer(String tcNumber, String password) {
        Customer customer = getCustomerByTcNumber(tcNumber);
        return customer != null && customer.getPassword().equals(password);
    }

    public static void addCustomer(String tcNumber, String password) {
        customers.put(tcNumber, new Customer(tcNumber, password));
    }
}
