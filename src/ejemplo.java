import java.util.Scanner;

public class ejemplo {

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de la primera matriz: ");
        int filasA = input.nextInt();

        System.out.print("Ingrese el número de columnas de la primera matriz: ");
        int columnasA = input.nextInt();

        System.out.print("Ingrese el número de filas de la segunda matriz: ");
        int filasB = input.nextInt();

        System.out.print("Ingrese el número de columnas de la segunda matriz: ");
        int columnasB = input.nextInt();

        if (columnasA != filasB) {
            System.out.println("No se puede multiplicar estas matrices, El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.");
            return;
        }

        int[][] matrizA = leerMatriz("Matriz A", filasA, columnasA, input);
        int[][] matrizB = leerMatriz("Matriz B", filasB, columnasB, input);

        int[][] resultado = multiplicarMatrices(matrizA, matrizB);

        System.out.println("Resultado de la multiplicación de las matrices:");
        imprimirMatriz(resultado);

        input.close();
    }

    public static int[][] leerMatriz(String nombre, int filas, int columnas, Scanner input) {
        System.out.println("Ingrese los valores para la " + nombre + ":");
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(nombre + "[" + (i + 0) + "][" + (j + 0) + "]: ");
                matriz[i][j] = input.nextInt();
            }
        }

        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicarMatrices(int[][] A, int[][] B) {
        int filasA = A.length;
        int columnasA = A[0].length;
        int columnasB = B[0].length;
        int[][] resultado = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return resultado;
    }
}
