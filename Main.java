public class Main {

    static int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    static int[] array2 = new int[100];
    static int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    static int size = 5;
    static int[][] crossArray;
    static int[] OneTwoArray;

    public static void main(String[] args) {
        printThreeWords(); // 1
        checkSumSign(); // 2
        printColor(); // 3
        compareNumbers(); // 4
        System.out.println(sum2(5, 6)); // 5
        printNum(-10); // 6
        System.out.println(printNumTruFal(-5)); // 7
        printMulti("Vitali", 3); // 8
        System.out.println(printYear(2020)); // 9

        esyArray(array1); // 10
        printArray(array1);

        Array100(array2); // 11
        printArray(array2);

        arraySix(array3); // 12
        printArray(array3);


        crossArray = createCrossArray(size); // 13
        printArray(crossArray);

        OneTwoArray = OneTwoArray(10, 5); // 14
        printArray(OneTwoArray);
    }

    // 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2
    public static void checkSumSign() {
        int a = 5, b = -3, sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3
    public static void printColor() {
        int value = 175;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4
    public static void compareNumbers() {
        int a = 10, b = 20;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5
    public static boolean sum2(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6
    public static void printNum(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7
    public static boolean printNumTruFal(int number) {
        return number < 0;
    }

    // 8
    public static void printMulti(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    // 9
    public static boolean printYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 10
    public static void esyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    // 11
    public static void Array100(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    // 12
    public static void arraySix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    //13
    public static int[][] createCrossArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - 1 - i] = 1;
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // 14
    public static int[] OneTwoArray(int len, int initialValue) {
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = initialValue;
        }
        return newArray;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
