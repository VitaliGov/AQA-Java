package Ex_1;

public abstract class Animal {
    protected String name;
    static int totalAnimals = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Пушок");

        System.out.println("Всего животных: " + Animal.totalAnimals);
        System.out.println("Всего собак: " + Dog.totalDogs);
        System.out.println("Всего котов: " + Cat.totalCats);

        dog1.run(150);
        dog2.swim(5);
        cat1.run(250);
        cat2.swim(1);

        FoodBowl bowl = new FoodBowl(20);
        bowl.addFood(30);


        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            String status = cat.isSatiety() ? "сыт" : "голоден";
            System.out.println(cat.name + " " + status);
        }
    }
}

