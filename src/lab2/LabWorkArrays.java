package lab2;

/**
 * First lab
 */

public class LabWorkArrays {

    private int[][] array = {{3, 250, 11, -12345, 0, -5}, {129845}, {-1773,766, 847758}, {3444, 56, 9, 78, 43}};

    public int findMaxElementInRaw() {
        // будем считать, что дан массив целочисленных значений int и присудим контрольному значение минимально возможное.
        int maxArrayElement = Integer.MIN_VALUE;
        // итерируем внешний массив
        for (int i = 0; i < array.length; i++) {
            // итерируем вложенный массив
            for (int k = 0; k < array[i].length; k++) {
                //значит дошли до конца вложенного массива(или массив состоит из одного элемента), значит он был упорядочен по возрастанию, и текущий элемент самый большой.
                if (k == array[i].length - 1) {
                    // проверяем больше ли новое значение уже имеющегося
                    if (array[i][k] > maxArrayElement) {
                        maxArrayElement = array[i][k];
                    }
                } else {
                    //прекращаем итерацию, так как последующее значение меньше предыдущего
                    if (array[i][k] > array[i][k+1]) {
                        break;
                    }
                }
            }
        }

        return maxArrayElement;
    }
}
