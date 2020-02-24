package main;
import definition.ContactList;
import definition.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactlist = new ContactList();
        String firstname;
        String lastname;
        String mail;
        boolean f = true;
        while (f == true) {
            System.out.println();
            System.out.println("welcome to Jayesh's contact list");
            System.out.println("Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");
            int n = scanner.nextInt();
            scanner.nextLine();
            switch (n) {
                case 1:
                    String[] contactnumber = new String[3];
                    System.out.println("You have chosen to add a new contact: \n" +
                            "Please enter the name of the Person");
                    System.out.print("First Name: ");
                    firstname = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastname = scanner.nextLine();
                    contactlist.setName(firstname, lastname);
                    contactlist.setFirstNameInList(firstname);
                    System.out.print("Contact Number:");
                    contactnumber[0] = scanner.nextLine();
                    for (int i = 1; i <= 2; i++) {
                        System.out.print("Would you like to add new Number (y/n): ");
                        char res = scanner.next().charAt(0);
                        if (res == 'y') {
                            System.out.print("Contact Number: ");
                            contactnumber[i] = scanner.next();
                        } else {
                            break;
                        }
                    }
                    System.out.print("Would you like to add email (y/n): ");
                    char res = scanner.next().charAt(0);
                    if (res == 'y') {
                        System.out.print("Enter the Email:");
                        mail = scanner.next();
                    } else {
                        mail = null;
                    }
                    Person person = new Person(firstname, lastname, contactnumber, mail);

                    contactlist.add(person);
                    break;
                case 2:
                    contactlist.viewAllContacts();
                    break;
                case 3:
                    System.out.println("You could search for a contact from there contact name");
                    String n1 = scanner.next();
                    contactlist.search(n1);
                    break;
                case 4:
                    System.out.println("Here are your contacts");
                    for (int i = 0; i < contactlist.getArrayOfNames().size(); i++) {
                        System.out.println((i + 1) + ". " + contactlist.getArrayOfNames().get(i));
                    }
                    if (contactlist.getArrayOfNames().size() != 0) {
                        System.out.println("Press the number against the contact to delete it: ");

                        int index = scanner.nextInt();
                        String tempName = contactlist.getArrayOfNames().get(index - 1).toString();
                        contactlist.delete(index);
                        System.out.println(tempName + " has been deleted from your contacts");
                    } else {
                        System.out.println("NO CONTACTS AVAILABLE");
                    }
                    break;
                case 5:
                    System.out.println("Thank You For Using Our Services");
                    f = false;
                    break;
                default:
                    System.out.println("Invailid Input enter the right input:");
                    break;
            }

        }
    }
}
