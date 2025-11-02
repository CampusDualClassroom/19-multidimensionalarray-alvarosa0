package com.campusdual.classroom;

public class Exercise {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        if (intArrayTri == null || intArrayTri.length == 0) {
            return new int[0][0];
        }
        int depth = intArrayTri.length;
        int rows = intArrayTri[0].length;
        int cols = intArrayTri[0][0].length;

        int[][] flat = new int[rows][cols];

        for (int d = 0; d < depth; d++) {
            if (intArrayTri[d].length != rows) {
                throw new IllegalArgumentException("Todas las profundidades deben tener el mismo número de filas.");
            }
            for (int r = 0; r < rows; r++) {
                if (intArrayTri[d][r].length != cols) {
                    throw new IllegalArgumentException("Todas las filas deben tener el mismo número de columnas.");
                }
                for (int c = 0; c < cols; c++) {
                    flat[r][c] += intArrayTri[d][r][c];
                }
            }
        }

        return flat;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        if (intArrayBi == null || intArrayBi.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(stringFlatMatrixRow(intArrayBi, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        if (uniArray == null || uniArray.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(uniArray[i]);
        }
        return sb.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        if (columns <= 0) return new int[0];
        int[] arr = new int[columns];
        for (int c = 0; c < columns; c++) {
            arr[c] = c + 1;
        }
        return arr;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        if (rows <= 0 || columns <= 0) return new int[0][0];
        int[][] arr = new int[rows][columns];
        int val = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                arr[r][c] = val++;
            }
        }
        return arr;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        if (depth <= 0 || rows <= 0 || columns <= 0) return new int[0][0][0];
        int[][][] arr = new int[depth][rows][columns];
        int val = 1;
        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    arr[d][r][c] = val++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
