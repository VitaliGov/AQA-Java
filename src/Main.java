public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];

        empArray[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer", "ivivan@aston.com", "892312312", 30000.75, 30);
        empArray[1] = new Employee("Petrov Petr Petrovich", "Manager", "petrov@aston.com", "892312313", 40000.28, 35);
        empArray[2] = new Employee("Sidorov Sidor Sidorovich", "QA_Engineer", "sidorov@aston.com", "892312314", 45000.29, 28);
        empArray[3] = new Employee("Kuznetsov Kuzma Kuzmich", "Designer", "kuznetsov@aston.com", "892312315", 35000.17, 32);
        empArray[4] = new Employee("Smirnov Sergey Sergeich", "Analyst", "smirnov@aston.com", "892312316", 38000.39, 29);

        for (Employee emp : empArray) {
            emp.printInfo();
            System.out.println();
        }

        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan Ivanovich", 30, "892312312");
        persArray[1] = new Person("Petrov Petr Petrovich", 35, "892312313");
        persArray[2] = new Person("Sidorov Sidor Sidorovich", 28, "892312314");
        persArray[3] = new Person("Kuznetsov Kuzma Kuzmich", 32, "892312315");
        persArray[4] = new Person("Smirnov Sergey Sergeich", 29, "892312316");

        for (Person person : persArray) {
            person.printInfo();
            System.out.println();
        }

        Park park = new Park(5);

        park.addAttraction("Колесо обозрения", "10:00 - 22:00", 150);
        park.addAttraction("Американские горки", "11:00 - 20:00", 300);
        park.addAttraction("Карусель", "09:00 - 19:00", 100);
        park.addAttraction("Дом страха", "12:00 - 23:00", 250);
        park.addAttraction("Автодром", "10:00 - 21:00", 200);

        park.addAttraction("Супер 8", "09:00 - 21:00", 200);

        park.printAttractions();
    }
}
