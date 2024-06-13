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
}
