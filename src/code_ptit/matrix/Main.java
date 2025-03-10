package code_ptit.matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("CODE.cpp"));
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            Matrix matrix = new Matrix(n, m);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    matrix.setPosition(i, j, scanner.nextInt());
                }
            }
            matrix.sort(k - 1);
            System.out.print(matrix);
        }
    }
}
