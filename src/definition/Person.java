package definition;

public class Person {
    private String firstname;
    private String lastname;
    private String[] contact;
    private String mail;

    public Person(String firstname, String lastname, String[] contact, String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.mail = mail;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("-------- * -------- * -------- * --------\n");
        sb.append("First Name: ").append(firstname).append('\n');
        sb.append("Last Name: ").append(lastname).append('\n');
        sb.append("Contact No: ");
        for (int i = 0; i < this.contact.length; i++) {
            sb.append((this.contact[0] != null && i == 0 ? this.contact[0] : "") + (this.contact[1] != null && i == 1 ? ", " + this.contact[1] : "") +
                    (this.contact[2] != null && i == 2 ? ", " + this.contact[i] : ""));
        }
        sb.append("\nEmail: ").append((mail != null ? mail : "")).append('\n');
        sb.append("-------- * -------- * -------- * --------\n");
        return sb.toString();
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String[] getContactNo() {
        return contact;
    }

    public void setContactNo(String[] contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }
}
