package dynamicprograming;

/**
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n] 。
 * 矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。
 * 我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。
 * 从左上角到右下角，会有很多不同的路径可以走。我们把每条路径经过的数字加起来看作路径的长度。
 * 那从左上角移动到右下角的最短路径长度是多少呢？
 */
public class MinLenOfMatrix {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5}, {2, 1, 3}, {5, 2, 6}};

/*        minLenByBackTracking(matrix, 3, 0, 0, matrix[0][0]);
        System.out.println(ans);*/

        System.out.println(minLenByDynamicPrograming(matrix,matrix.length));
    }

    public static int minLenByDynamicPrograming(int[][] matrix, int n) {
        // 通过len[i][j]表示从matrix[0][0]位置到i，j位置的最短长度
        int[][] len = new int[n][n];
        len[0][0] = matrix[0][0];
        if (n == 1) {
            return len[0][0];
        }

        for (int i = 1; i <= n - 1; i++) {
            len[i][0] = matrix[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j <= n - 1; j++) {
            len[0][j] = matrix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                len[i][j] = Math.min(len[i - 1][j] + matrix[i][j], len[i][j - 1] + matrix[i][j]);
            }
        }
        return len[n - 1][n - 1];
    }

    public static void minLenByBackTracking(int[][] matrix, int n, int i, int j, int len) {
        if (i == n - 1 && j == n - 1) {
            ans = Math.min(ans, len);
            return;
        }
        if (i < n - 1) {
            // 可以往下走
            minLenByBackTracking(matrix, n, i + 1, j, len + matrix[i + 1][j]);
        }
        if (j < n - 1) {
            // 可以往右走
            minLenByBackTracking(matrix, n, i, j + 1, len + matrix[i][j + 1]);
        }
    }


}
