package adt;

public interface Adt<Person> {
    boolean add(Person person);

    boolean delete(int index);

    void search(String name);

    void viewAllContacts();
}
