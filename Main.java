import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
    }
    //map где ключом будет owner (Person), а значением будет баланс (Double)
    public static Map<Person,Double> mapOwnerToBalance(List<BankAccount> accounts){
        if (accounts == null) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap(BankAccount::getOwner, BankAccount::getBalance));
    }
    //map где ключом будет IBAN (String), а значением будет owner (Person)
    public static Map<String, Person> mapIbanToOwner(List<BankAccount> accounts){
        if (accounts == null) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap( BankAccount::getIBAN, BankAccount::getOwner  ));
    }
    //map где ключом будет IBAN (String), а значением будет строка  J.Jack (т.e. первая буква fName и lName)
    public static Map<String, String> mapIbanToNameString(List<BankAccount> accounts){
        if (accounts == null) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap( BankAccount::getIBAN, ba -> ba.getOwner().getfName().charAt(0) + ". " + ba.getOwner().getlName()   ));
    }
}