package io.archie.algorithm.leetcode;

/**
 * Z字变换
 */
public class Code6 {

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        String a1 = """
            P   A
            A P L
            Y   I
            """;
        Code6 code6 = new Code6();
        System.out.println(code6.convert(s1, 3));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            sb[i].append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder item : sb) {
            res.append(item.toString());
        }
        return res.toString();
    }
}
