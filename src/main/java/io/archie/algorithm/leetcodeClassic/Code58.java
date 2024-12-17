package io.archie.algorithm.leetcodeClassic;

public class Code58 {

    public static void main(String[] args) {
        Code58 code58 = new Code58();

        String s = "Hello World";
        int ans1 = code58.lengthOfLastWord(s);
        System.out.println(ans1);

        String s1 = "   fly me   to   the moon  ";
        int ans2 = code58.lengthOfLastWord(s1);
        System.out.println(ans2);
    }

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0;
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                flag = true;
            }
            if (s.charAt(i) == ' ' && flag) {
                return count;
            }
        }
        return count;
    }
}
