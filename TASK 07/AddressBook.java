import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private String name;
    private String contact;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public AddressBook(String name, String contact, String email, String currentAddress, String permanentAddress) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public static void main(String[] args) {
        List<AddressBook> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Add contact");
            System.out.println("2. Get contact");
            System.out.println("3. Update contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter current address: ");
                    String currentAddress = scanner.nextLine();
                    System.out.print("Enter permanent address: ");
                    String permanentAddress = scanner.nextLine();

                    AddressBook newContact = new AddressBook(name, contact, email, currentAddress, permanentAddress);
                    contacts.add(newContact);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (AddressBook c : contacts) {
                        if (c.getName().equals(searchName)) {
                            System.out.println("Contact found:");
                            System.out.println("Name: " + c.getName());
                            System.out.println("Contact: " + c.getContact());
                            System.out.println("Email: " + c.getEmail());
                            System.out.println("Current Address: " + c.getCurrentAddress());
                            System.out.println("Permanent Address: " + c.getPermanentAddress());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
    System.out.print("Enter name: ");
    String updateName = scanner.nextLine();
    found = false;
    for (AddressBook c1 : contacts) {
        if (c1.getName().equals(updateName)) {
            System.out.print("Enter new contact: ");
            String updatedContact = scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new current address: ");
            String newCurrentAddress = scanner.nextLine();
            System.out.print("Enter new permanent address: ");
            String newPermanentAddress = scanner.nextLine();

            c1.setContact(updatedContact);
            c1.setEmail(newEmail);
            c1.setCurrentAddress(newCurrentAddress);
            c1.setPermanentAddress(newPermanentAddress);
            System.out.println("Contact updated.");
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Contact not found.");
    }
    break;
                case 4:
                    System.out.print("Enter name: ");
                    String deleteName = scanner.nextLine();
                    found = false;
                    for (AddressBook c2 : contacts) {
                        if (c2.getName().equals(deleteName)) {
                            contacts.remove(c2);
                            System.out.println("Contact deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}