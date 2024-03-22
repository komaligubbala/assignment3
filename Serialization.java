import java.io.*;

// Define the Customer class
class Customer implements Serializable {
    private int id;
    private String name;
    private String contactNo;
    private String address;

    // Constructor
    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Serialization{
    public static void main(String[] args) {
        // Create a Customer object
        Customer customer = new Customer(50, "Padma sri", "9976719205", "Palakol");

        try {
            // Output stream to write object to a file
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            // Write the object to the file
            out.writeObject(customer);
            
            // Close the output stream
            out.close();
            fileOut.close();
            System.out.println("Customer object serialized to JavaObject.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
