package codinguniwork.software2.week3;
public class week3exercise2 {

    public static int[][] rasterise(int[] data, int width) {
        if (data.length % width != 0) {
            return null;
        }
        int[][] raster = new int[data.length / width][width];
        for (int i = 0; i < data.length; i++) {
            raster[i / width][i % width] = data[i];
        }
        return raster;
    }

    public static void print(int[][] raster) {
        if (raster == null) {
            System.out.println("null \n");
            return;
        }
        for (int r = 0; r < raster.length; r++) {
            for (int c = 0; c < raster[r].length; c++) {
                System.out.print(raster[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(int[] data) {
        if (data == null) {
            System.out.println("null \n");
            return;
        }
        for (int r = 0; r < data.length; r++) {
            System.out.print(data[r] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        week3exercise2.print(week3exercise2.rasterise(data, 2));
        week3exercise2.print(week3exercise2.rasterise(data, 5));
        week3exercise2.print(week3exercise2.rasterise(data, 4));
        week3exercise2.print(week3exercise2.rasterise(data, 8));
    }
}
