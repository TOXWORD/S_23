import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocalMax {

    private double[][] matr;
    private double[][] maxPos;
    private int sizeX;
    private int sizeY;
    private final String PATHNAME = "input.txt";

    LocalMax() throws FileNotFoundException {
        File f = new File(PATHNAME);
        try (Scanner sc = new Scanner(f)) {
            sizeX = sc.nextInt();
            sizeY = sc.nextInt();
        }
        matr = new double[sizeX + 2][sizeY + 2];
        maxPos = new double[sizeX * sizeY][3];
    }

    public void readMatrix() throws FileNotFoundException {
        File f = new File(PATHNAME);
        try (Scanner sc = new Scanner(f)) {
            sc.nextInt();
            sc.nextInt();

            for (int i = 0; i < sizeX + 2; i++) {
                for (int j = 0; j < sizeY + 2; j++) {
                    matr[i][j] = Double.MAX_VALUE;
                }
            }

            for (int i = 1; i < sizeX + 1; i++) {
                for (int j = 1; j < sizeY + 1; j++) {
                    matr[i][j] = sc.nextDouble();
                }
            }

            for (int i = 1; i < sizeX + 1; i++) {
                for (int j = 1; j < sizeY + 1; j++) {
                    System.out.print(matr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

    }

    public void findMaxMin() {

        int pos = 0;
        double max = Double.MIN_VALUE;

        for (int i = 1; i < sizeX + 1; i++) {
            for (int j = 1; j < sizeY + 1; j++) {
                if (matr[i][j] < matr[i - 1][j] && matr[i][j] < matr[i + 1][j] && matr[i][j] < matr[i][j - 1] && matr[i][j] < matr[i][j + 1]) {

                    if (matr[i][j] > max) {
                        max = matr[i][j];
                    }

                    maxPos[pos][0] = matr[i][j];
                    maxPos[pos][1] = i;
                    maxPos[pos][2] = j;
                    pos++;

                }
            }
        }

        if (pos == 0) {
            System.out.println("No elements found");
            return;
        }

        for (int i = 0; i < pos; i++) {
            if (maxPos[i][0] == max) {
                System.out.println("Element: " + maxPos[i][0] + "\nRow: " + (int)maxPos[i][1] + "\nColumn: " + (int)maxPos[i][2] + "\n");
            }
        }

    }

}
