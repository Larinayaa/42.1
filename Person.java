import java.util.Objects; //стандарт
public class Person {
    private String fName;
    private String lName;
    private String email;
    public Person(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("%s %s (%s)", fName, lName,email);
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (!Objects.equals(fName, person.fName)) return false;
        if (!Objects.equals(lName, person.lName)) return false;
        return Objects.equals(email, person.email);
    }
    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}