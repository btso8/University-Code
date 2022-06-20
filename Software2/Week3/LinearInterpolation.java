package University-Code.Software2.Week3;
public class LinearInterpolation {

    public static int[] resample(int[] data) {
        int[] sample = new int[2 * (data.length - 1) + 1];
        for (int i = 0; i < data.length; i++) {
            sample[2 * i] = data[i];
        }
        for (int i = 1; i < sample.length - 1; i += 2) {
            sample[i] = (int) Math.round((sample[i - 1] + sample[i + 1]) / 2.0);
        }
        return sample;
    }

    public static int[] resample(int[] data, int scale) {
        int[] sample = new int[scale * (data.length - 1) + 1];
        for (int i = 0; i < data.length; i++) {
            sample[scale * i] = data[i];
        }
        for (int i = 0; i < sample.length - 1; i += scale) {
            for (int j = 1; j < scale; j++) {
                sample[i + j] = (int) Math.round((sample[i] * (scale - j) 
                                                + sample[i + scale] * j)
                                                / (double)scale);
            }

        }
        return sample;
    }

    public static int[] getColumn(int[][] data, int col) {
        int[] column = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            column[i] = data[i][col];
        }
        return column;
    }

    public static int[][] resample(int[][] data) {
        int[][] sample = new int[2 * (data.length - 1) + 1][2 * (data[0].length - 1) + 1];

        for (int r = 0; r < data.length; r++) {
            sample[2 * r] = resample(data[r]);
        }

        for (int col = 0; col < sample[0].length; col++) {
            int[] datapoints = new int[data.length];
            for (int r = 0; r < data.length; r++) {
                datapoints[r] = sample[2 * r][col];
            }
            int[] resampleCol = resample(datapoints);
            for (int i = 0; i < resampleCol.length; i++) {
                sample[i][col] = resampleCol[i];
            }
        }
        return sample;
    }

    public static int[][] resample(int[][] data, int scale) {
        int[][] sample = new int[scale*(data.length-1)+1][scale*(data[0].length-1)+1];

        for (int r = 0; r < data.length; r++) {
            sample[scale*r] = resample(data[r], scale);
        }

        for (int col = 0; col < sample[0].length; col++) {
            int[] datapoints = new int[data.length];
            for (int r = 0; r < data.length; r++) {
                datapoints[r] = sample[scale * r][col];
            }
            int[] resampleCol = resample(datapoints, scale);
            for (int i = 0; i < resampleCol.length; i++) {
                sample[i][col] = resampleCol[i];
            }
        }
        return sample;
    }

    public static void main(String[] args) {
        int[] data = { 1, 5, 13, 21 };
        week3exercise2.print(linearinterpolation.resample(data));
        week3exercise2.print(linearinterpolation.resample(data,3));
        int[] data2 = {1,4,7,16};
        week3exercise2.print(linearinterpolation.resample(data2,3));
        int[][] image = { { 1, 5, 7 }, { 5, 7, 7 } };
        week3exercise2.print(linearinterpolation.resample(image));
        week3exercise2.print(linearinterpolation.resample(image,3));
    }
}
