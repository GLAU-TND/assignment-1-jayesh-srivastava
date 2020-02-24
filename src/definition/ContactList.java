package definition;

import adt.Adt;

import java.util.ArrayList;

public class ContactList<Person> implements Adt<Person> {
    ArrayList aon = new ArrayList<String>();
    ArrayList afn = new ArrayList<String>();
    private Node<Person> head;
    private int s = 0;
    private int c = 0;

    private void addFirst(Person persondata) {
        head = new Node<>(persondata, head);
        s++;
    }

    private void addAfter(Node<Person> personnode, Person persondata) {
        personnode.next = new Node<>(persondata, personnode.next);
        s++;
    }

    public int getSize() {
        return s;
    }

    public void add(int index, Person persondata) {
        if (index < 0 || index > s) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (s == 0) {
            addFirst(persondata);
        } else {
            Node<Person> temp = getNode(index - 1);
            addAfter(temp, persondata);
        }
    }

    private Node<Person> getNode(int index) {
        Node<Person> res = head;
        for (int i = 0; i < index; i++) {
            res = res.getNext();
        }
        return res;
    }

    public void setName(String firstname, String lastname) {
        aon.add(firstname + " " + lastname);
    }

    public ArrayList getArrayOfNames() {
        return aon;
    }

    @Override
    public boolean add(Person persondata) {
        add(s, persondata);
        return true;
    }

    private Person removeFirst() {
        Person res = null;

        // store the head node's reference in a temp variable.
        Node<Person> temp = head;

        // check to see if the head isn't null.
        if (head != null) {

            // move the head node's reference to the immediate next node.
            head = head.getNext();
        }

        // return the old head node's data.
        // check to see if the temp variable isn't null.
        if (temp != null) {

            // decrease the size of the linked list
            s--;

            res = temp.getData();
        }

        return res;
    }


    private Person removeAfter(Node<Person> node) {
        Person res = null;

        // store the node to be deleted in a temp variable
        Node<Person> temp = node.getNext();

        // check if the temp variable is not null
        if (temp != null) {
            // change the next reference of the previous node
            node.next = temp.getNext();

            // decrease the size of the linked list
            s--;

            // set the data of the temp node (deleted node) to the response
            res = temp.getData();
        }
        if (temp == null) {
            node = null;
            s--;
        }
        return res;
    }

    @Override
    public boolean delete(int index) {
        boolean res = false;
        if (index - 1 < 0 || (index - 1) > getSize()) {
            throw new IndexOutOfBoundsException(Integer.toString(index - 1));
        } else if (index - 1 == 0) { /* check if the index is zero*/
            removeFirst();
            aon.remove(index - 1);
            res = true;
        } else {
            Node<Person> previousnode = getNode(index - 1);
            removeAfter(previousnode);
            aon.remove(index - 1);
            res = true;
        }
        return res;
    }

    public void setFirstNameInList(String name) {
        afn.add(name);
    }

    public ArrayList getArrayOfFirstName() {
        return afn;
    }

    @Override
    public void search(String name) {
        for (int i = 0; i < afn.size(); i++) {
            if (name.compareTo(afn.get(i).toString()) == 0) {
                c++;
            }
        }
        if (c != 0) {
            System.out.println(c + " match found!");
            for (int i = 0; i < afn.size(); i++) {
                if (name.compareTo(afn.get(i).toString()) == 0) {
                    Node<Person> personnode = getNode(i);
                    System.out.println(personnode.getData().toString());
                }
            }
        } else {
            System.out.println("NO MATCH FOUND!");
        }


    }

    @Override
    public void viewAllContacts() {
        if (s != 0) {
            System.out.println("---Here are your all contacts---");
            for (int i = 0; i < s; i++) {
                // fetch the data for the current node
                Person d = this.getNode(i).getData();
                System.out.print(d);
            }
        } else {
            System.out.println("NO RESULTS FOUND!");
        }
    }

    private static class Node<Person> {
        private Person d;
        private Node<Person> next;

        private Node(Person d, Node<Person> next) {
            this.d = d;
            this.next = next;
        }

        private Person getData() {
            return d;
        }

        private void setData(Person d) {
            this.d = d;
        }

        private Node<Person> getNext() {
            return next;
        }

        private void setNext(Node<Person> next) {
            this.next = next;
        }
    }
}
}
