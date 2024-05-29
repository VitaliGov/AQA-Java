public class Person {
    private String fullName;
    private int age;
    private String phoneNumber;

    public Person(String fullName, int age, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Возраст: " + age);
        System.out.println("Телефон: " + phoneNumber);
    }
}

