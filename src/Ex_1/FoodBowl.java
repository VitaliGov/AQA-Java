package Ex_1;

public class FoodBowl {
    private int food;

    public FoodBowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в миску.");
        } else {
            System.out.println("Количество еды должно быть положительным.");
        }
    }

    public void decreaseFood(int amount) {
        food -= amount;
    }
}

