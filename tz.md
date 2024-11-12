Дан список  BankAccount {Person owner, String IBAN, double balance).
Класс Person состоит из {String fName, String lName String email). 
Используя stream необходимо получить:

map где ключом будет owner (Person), а значением будет баланс (Double)
map где ключом будет IBAN (String), а значением будет owner (Person)
map где ключом будет IBAN (String), а значением будет строка  J.Jack (т.e. первая 
буква fName и lName)

В рамках данной задачи person и account  уникальны и у каждого owner a единственный счет.
