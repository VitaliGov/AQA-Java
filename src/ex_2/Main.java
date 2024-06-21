package ex_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 2: \nТелефонный справочник:\n");
        PhoneBook phoneDirectory = new PhoneBook();

        phoneDirectory.add("+375 29 123-45-68", "Ivanov");
        phoneDirectory.add("+375 29 234-56-78", "Petrov");
        phoneDirectory.add("+375 29 345-67-88", "Ivanov");
        phoneDirectory.add("+375 29 456-78-94", "Sidorov");
        phoneDirectory.add("+375 29 567-89-03", "Ivanov");
        phoneDirectory.add("+375 29 678-90-12", "Ivanov");
        phoneDirectory.add("+375 29 678-90-12", "Burenkov");

        System.out.println("Печатаем фамилии для различных номеров телефонов:");
        phoneDirectory.printSurname("+375 29 123-45-68");
        phoneDirectory.printSurname("+375 29 234-56-78");
        phoneDirectory.printSurname("+375 29 456-78-94");

        System.out.println("\nПечатаем номера телефонов для различных фамилий:");
        phoneDirectory.printPhoneNumbers("Ivanov");
        phoneDirectory.printPhoneNumbers("Petrov");
        phoneDirectory.printPhoneNumbers("Sidorov");
        phoneDirectory.printPhoneNumbers("Burenkov");

        System.out.println("\nПечатаем все записи в справочнике:");
        phoneDirectory.printAll();
    }
}