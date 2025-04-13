package io.archie.algorithm.leetcodeHot;

/**
 * 最大正方形 <a href='https://leetcode.cn/problems/maximal-square/description/?envType=problem-list-v2&envId=2cktkvj'/><br>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @Author: MrArchie
 * @Date: 2025/4/12 22:50
 */
public class Code221 {

    /**
     * 思路：暴力解法，找到每一个1时，判断下方、右方最长为1的只记录maxSquare 1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        Code221 code221 = new Code221();

        char[][] matrix1 = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}};
        int ans1 = code221.maximalSquare(matrix1);
        System.out.println("ans1 = " + ans1);
    }
}
