package ex_2;

import java.util.*;

public class PhoneBook {
    private Map<String, String> phoneToSurname;
    private Map<String, Set<String>> surnameToPhones;

    public PhoneBook() {
        phoneToSurname = new HashMap<>();
        surnameToPhones = new HashMap<>();
    }

    public void add(String phoneNumber, String surname) {
        if (phoneToSurname.containsKey(phoneNumber)) {
            String oldSurname = phoneToSurname.get(phoneNumber);
            if (!oldSurname.equals(surname)) {
                surnameToPhones.get(oldSurname).remove(phoneNumber);
                if (surnameToPhones.get(oldSurname).isEmpty()) {
                    surnameToPhones.remove(oldSurname);
                }
                phoneToSurname.put(phoneNumber, surname);
                surnameToPhones.putIfAbsent(surname, new HashSet<>());
                surnameToPhones.get(surname).add(phoneNumber);
                System.out.println("Фамилия для номера " + phoneNumber + " обновлена с " + oldSurname + " на " + surname + ".");
            }
        } else {
            phoneToSurname.put(phoneNumber, surname);
            surnameToPhones.putIfAbsent(surname, new HashSet<>());
            surnameToPhones.get(surname).add(phoneNumber);
        }
    }

    public String getSurname(String phoneNumber) {
        return phoneToSurname.get(phoneNumber);
    }

    public Set<String> getPhoneNumbers(String surname) {
        return surnameToPhones.getOrDefault(surname, Collections.emptySet());
    }

    public void printSurname(String phoneNumber) {
        String surname = getSurname(phoneNumber);
        if (surname == null) {
            System.out.println("Для номера " + phoneNumber + " фамилии не найдены.");
        } else {
            System.out.println(phoneNumber + ": " + surname);
        }
    }

    public void printPhoneNumbers(String surname) {
        Set<String> phoneNumbers = getPhoneNumbers(surname);
        if (phoneNumbers.isEmpty()) {
            System.out.println("Для фамилии " + surname + " номера не найдены.");
        } else {
            for (String phoneNumber : phoneNumbers) {
                System.out.println(surname + ": " + phoneNumber);
            }
        }
    }

    public void printAll() {
        if (phoneToSurname.isEmpty()) {
            System.out.println("Справочник пуст.");
        } else {
            for (Map.Entry<String, String> entry : phoneToSurname.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}