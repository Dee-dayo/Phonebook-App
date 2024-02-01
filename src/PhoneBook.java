import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private Scanner input = new Scanner(System.in);
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> numbers = new ArrayList<>();

    public PhoneBook() {
    }

    public String welcomePage() {
        return "\nPHONEBOOK\n1. Save a contact\n2. View Saved Contacts\n3. Search Saved Contacts\n4. Delete a contact\n5. Exit";
    }

    public void createContact(String name, String number) {
        names.add(name);
        numbers.add(number);
    }

    public void viewContacts(){
        if (names.isEmpty()){
            System.out.println("There are no saved contacts!!!");
        } else {
            for (int index = 0; index < names.size(); index++) {
                System.out.println((index+1) + " Name: " + names.get(index) + "\t\tNumber: " + numbers.get(index));
            }
        }
    }

    public void searchContactsByName(String search){
        boolean isInContact = false;

        for (int index = 0; index< names.size(); index++){
            if (search.equalsIgnoreCase(names.get(index))){
                System.out.println("Name: " + names.get(index) + "\t\tNumber: " + numbers.get(index));
                isInContact = true;
            }
        }

        if (!isInContact) {
            System.out.println("Contact not found in Contact List");
        }
    }


    public void searchContactByNumber(String search) {
        boolean isInContact = false;

        for (int index = 0; index< numbers.size(); index++){
            if (search.equalsIgnoreCase(numbers.get(index))){
                System.out.println("Name: " + names.get(index) + "\t\tNumber: " + numbers.get(index));
                isInContact = true;
            }
        }

        if (!isInContact) {
            System.out.println("Contact not found in Contact List");
        }
    }

    public void deleteAContact(int number) {
        for (int index = 0; index< names.size(); index++){
            names.remove(number - 1);
            numbers.remove(number - 1);
        }
    }

    public void mainApp() {

        int option;
        do {
            System.out.println(welcomePage());
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\nEnter a name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Phone number: ");
                    String number = input.next();
                    if (number.length() == 11 && number.startsWith("0")) {
                        createContact(name, number);
                        System.out.println("You saved a contact successfully");
                    } else {
                        System.out.print("You entered an invalid number\nContact not saved\n");
                    }
                    break;

                case 2:
                    System.out.println("\nSAVED CONTACTS");
                    viewContacts();
                    break;

                case 3:
                    System.out.println("\n1. Search by name\n2. Search by number");
                    int choose = input.nextInt();

                    switch (choose) {
                        case 1:
                            input.nextLine();
                            System.out.print("\nEnter the fullname you want to search for: ");
                            String searchByName = input.nextLine();
                            searchContactsByName(searchByName);
                            break;

                        case 2:
                            input.nextLine();
                            System.out.print("\nEnter the number you want to search for: ");
                            String searchByNumber = input.nextLine();
                            searchContactByNumber(searchByNumber);
                            break;

                        default:
                            System.out.print("You entered a wrong number");
                            break;
                    }
                    break;

                case 4:
                    if (names.isEmpty()) {
                        System.out.println("No contact to delete");
                    } else {
                        System.out.print("Enter the number of contact you want to delete: ");
                        int delete = input.nextInt();
                        deleteAContact(delete);
                        System.out.println("Contact Deleted Successfully");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!!!");
                    break;

                default:
                    System.out.println("You entered a wrong input");
                    break;
            }
        } while (option != 5);
    }
}
