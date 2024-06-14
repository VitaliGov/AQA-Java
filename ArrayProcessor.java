public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Array must be 4x4 in size.");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Array must be 4x4 in size.");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data at [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        return sum;
    }
}