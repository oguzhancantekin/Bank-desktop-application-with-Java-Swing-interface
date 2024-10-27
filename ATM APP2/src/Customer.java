import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String tcNumber;
    private String password;
    private double money; // money olarak değiştirildi

    // Müşteri veritabanı
    public static Map<String, Customer> customers = new HashMap<>();

    public Customer(String tcNumber, String password) {
        this.tcNumber = tcNumber;
        this.password = password;
        this.money = 1000.0; // Başlangıç para miktarı olarak 1000 TL
    }

    public String getTcNumber() {
        return tcNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
       this.password=password ;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    // Müşteri eklemek için statik bir metot
    public static void addCustomer(String tcNumber, String password) {
        customers.put(tcNumber, new Customer(tcNumber, password));
    }

    // TC numarasına göre müşteri getiren statik bir metot
    public static Customer getCustomerByTcNumber(String tcNumber) {
        return customers.get(tcNumber);
    }

    // Geçerli bir müşteri olup olmadığını kontrol eden statik bir metot
    public static boolean isValidCustomer(String tcNumber, String password) {
        Customer customer = getCustomerByTcNumber(tcNumber);
        return customer != null && customer.getPassword().equals(password);
    }
}
