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
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0].length;

        int[][] result = new int[rows][columns];

        for (int d = 0; d < intArrayTri.length; d++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    result[r][c] += intArrayTri[d][r][c];

                }
            }
        }
        return result;
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
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<uniArray.length;i++){
            sb.append(uniArray[i]);
            if (i <uniArray.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] unidim = new int[columns];
        int value = 1;
        for (int i = 0; i < columns; i++) {
            unidim[i] = value++;
        }
        return unidim;

    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidim = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bidim[i][j] = value++;
            }
        }
        return bidim;

    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridim = new int[depth][rows][columns];
        int value = 1;
        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    tridim[d][r][c] = value++;
                }
            }

        }
        return tridim;

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
