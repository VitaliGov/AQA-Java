public class Park {
    private Attraction[] attractions;
    private int size;
    private int currentIndex;

    public Park(int size) {
        this.size = size;
        this.attractions = new Attraction[size];
        this.currentIndex = 0;
    }

    public void addAttraction(String name, String workingHours, double cost) {
        if (currentIndex < size) {
            attractions[currentIndex++] = new Attraction(name, workingHours, cost);
            System.out.println("Аттракцион добавлен: " + name);
        } else {
            System.out.println("Невозможно добавить аттракцион: " + name + ". Парк заполнен.");
        }
    }

    public void printAttractions() {
        for (int i = 0; i < currentIndex; i++) {
            attractions[i].printInfo();
        }
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " рублей");
            System.out.println();
        }
    }
}
