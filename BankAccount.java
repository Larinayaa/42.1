public class BankAccount { //стандарт
    private Person owner;
    private String IBAN;
    private double balance;

    public BankAccount(Person owner, String IBAN, double balance) {
        this.owner = owner;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", IBAN, balance, owner );
    }

    public Person getOwner() {
        return owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }
}