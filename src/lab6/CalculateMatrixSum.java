package lab6;

import java.io.*;
import java.util.Scanner;

public class CalculateMatrixSum {

    // Додати path в який буде відбуватися збереження документів
    public static final String MAIN_PATH = "C:/Users/User/IdeaProjects/";

    // Тестові матриці, для початку роботи програми. Для зручності використані тільки одноцифрові значення.
    private int[][] testMatrixA = new int[][]{{3, 6, 9}, {2, 3, 5}, {1, 2, 7}};
    private int[][] testMatrixB = new int[][]{{1, 7, 0}, {2, 2, 5}, {1, 5, 3}};

    //робочі матриці
    private int[][] matrixA; //first matrix
    private int[][] matrixB; //second matrix
    private int[][] matrixC; //second matrix

    private int rows;
    private int columns;

    //конструктор
    public CalculateMatrixSum() {
        writeMatrix("afile.txt", testMatrixA);
        writeMatrix("bfile.txt", testMatrixB);

        readMatrix("afile.txt");
        readMatrix("bfile.txt");

        sumMatrix();
    }

    //Сума матриць обчислюється і зберігається в файл
    public void sumMatrix() {
        matrixC = new int[rows][columns];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        writeMatrix("cfile.txt", matrixC);
    }

    //зчитування матриць
    public void readMatrix(String fileName) {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(MAIN_PATH + fileName)));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().trim().split(" ");
                columns = Integer.parseInt(line[0]);
                rows = line.length / columns;
                //в цьому місці можна було б ввести спільну змінну, яка позначала б матрицю, для якої треба зчитати дані
                // і як параметр в метод readMatrix подавати відповідну матрицю. Тоді можна було б використовувати однаковий
                // код для обох матриць. нажаль з незрозумілої для мене причини, не передалися посиланнями матриці як параметри, тому поки що так.
                int lineIndex = 1;
                if (fileName.equals("afile.txt")) {
                    matrixA = new int[rows][columns];
                    for (int j = 0; j < matrixA.length; j++) {
                        for (int k = 0; k < matrixA[j].length; k++) {
                            if (lineIndex < line.length) {
                                matrixA[j][k] = Integer.parseInt(line[lineIndex]);
                                lineIndex++;
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    matrixB = new int[rows][columns];
                    for (int j = 0; j < matrixB.length; j++) {
                        for (int k = 0; k < matrixB[j].length; k++) {
                            if (lineIndex < line.length) {
                                matrixB[j][k] = Integer.parseInt(line[lineIndex]);
                                lineIndex++;
                            } else {
                                break;
                            }
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Запис матриць
    void writeMatrix(String fileName, int[][] matrix) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(MAIN_PATH + fileName));
            bw.write(matrix[0].length + " ");// перца цифра, що позначає кількість стовпців
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    bw.write(anInt + " ");
                }
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

