import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
class MainTest {
    private  List<BankAccount> accounts;
    @BeforeEach
    void setUp() {
        accounts = new ArrayList<>(List.of(
                new BankAccount( new Person("Олег","Ольховский", "oleg111@gmail.com"), "DE00006",3243.55),
                new BankAccount(new Person("Дмитрий","Миллер", "dmitriymuller@gmail.com"), "DE00005",785.11),
                new BankAccount(new Person("Анна","Мюллер", "annamuller@gmail.com"), "DE00004",3765.30),
                new BankAccount(new Person("Никита","Немцев", "nickitanem@gmail.com"), "DE00003",15.20),
                new BankAccount(new Person("Михаил","Трутнев", "michailtrutnew@gmail.com"), "DE00002",11900.35),
                new BankAccount( new Person("Данил","Грушевский", "danikgrus@gmail.com"), "DE00001",799.25)
        ));
    }
    @Test

    /*НЕ РАБОТАЕТ ТЕСТ. ДОЛГО ИСКАЛА ПРОБЛЕМУ, пока не дошло что хэшмап не гарантирует порядок по алфавиту и тд.
     нашла решение сначала, в гугле. использовать
                LinkedHashMap вместо HashMap. Но для этого избежать повтора фамилий. Поняла в итоге,
                 что не подойдет, когда фамилия это ключ. Тогда тоже будет же некорректно,
                если фамилия все же одинаковая у другой персоны. Бросила все и смирилась.
            Несколько раз переписывала тест заново, типа "вдруг попаду и актуальрезульт совпадет".
            Не фартануло))) Прописала просто по алфавиту в экспектед фамилии.
     */
    void test_map_owner_balance(){
    Map<Person,Double> expresult = new HashMap<>();
        expresult.put(new Person("Данил","Грушевский", "danikgrus@gmail.com"), 799.25);
        expresult.put(new Person("Дмитрий","Миллер", "dmitriymuller@gmail.com"), 785.11);
        expresult.put(new Person("Анна","Мюллер", "annamuller@gmail.com"), 3765.30);
        expresult.put(new Person("Никита","Немцев", "nickitanem@gmail.comm"), 15.20);
        expresult.put(new Person("Олег","Ольховский", "oleg111@gmail.com"), 3243.55);
        expresult.put(new Person("Михаил","Трутнев", "michailtrutnew@gmail.com"), 11900.35);
        Assertions.assertEquals(expresult, Main.mapOwnerToBalance(accounts));
    }
    @Test
    @DisplayName("ключ owner значениe баланс если лист null(пустая мап)")
    void test_PustoiMap_OwnerBalance_ListNull() {
        Map<Person, Double> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapOwnerToBalance(null));
    }
    @Test
    @DisplayName("ключ IBAN (String), а значениe owner (Person)")
    void test_Map_IbanOwner(){
        Map<String, Person> expectedMap = Map.of(
                "DE00006", new Person("Олег","Ольховский", "oleg111@gmail.com"),
                "DE00005", new Person("Дмитрий","Миллер", "dmitriymuller@gmail.com"),
                "DE00004", new Person("Анна","Мюллер", "annamuller@gmail.com"),
                "DE00003", new Person("Никита","Немцев", "nickitanem@gmail.com"),
                "DE00002", new Person("Михаил","Трутнев", "michailtrutnew@gmail.com"),
                "DE00001", new Person("Данил","Грушевский", "danikgrus@gmail.com")
        );
        Assertions.assertEquals(expectedMap, Main.mapIbanToOwner(accounts));
    }
    @Test
    @DisplayName("ключ IBAN (String), а значениe owner (Person) если лист null(пустая мап)")
    void test_PustoiMap_IbanOwner_ListNull() {
        Map<String, Person> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapIbanToOwner(null));
    }
    @Test
    @DisplayName("ключIBAN значение строка J.Jack (т.e. первая буква fName и lName)")
    void test_Map_Iban0charFnameLname(){
        Map<String, String> expectedMap = Map.of(
                "DE00006", "О. Ольховский",
                "DE00005", "Д. Миллер",
                "DE00004", "А. Мюллер",
                "DE00003", "Н. Немцев",
                "DE00002", "М. Трутнев",
                "DE00001", "Д. Грушевский"
        );
        Assertions.assertEquals(expectedMap, Main.mapIbanToNameString(accounts));
    }
    @Test
    @DisplayName("пустой мап если лист null ключIBAN значение строка J.Jack (т.e. первая буква fName и lName)")
    void test_PustoiMap_Iban0charFnameLname_ListNull() {
        Map<String, String> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapIbanToNameString(null));
    }
}
