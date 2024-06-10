package Ex_1;

public class Cat extends Ex_1.Animal {
    static int totalCats = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        this.satiety = false;
        totalCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(FoodBowl bowl) {
        if (bowl.getFood() >= 10) {
            bowl.decreaseFood(10);
            this.satiety = true;
            System.out.println(name + " поел и стал сытым.");
        } else {
            System.out.println(name + " не хватает еды в миске.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}
