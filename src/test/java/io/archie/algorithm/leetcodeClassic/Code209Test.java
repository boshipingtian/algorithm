package io.archie.algorithm.leetcodeClassic;


import org.junit.Assert;
import org.junit.Test;

public class Code209Test {

    @Test
    public void minSubArrayLen() {
        int[] test1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;

        int[] test2 = {1, 4, 4};
        int target2 = 4;

        int[] test3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        Assert.assertEquals(2, Code209.minSubArrayLen1(target1, test1));
        Assert.assertEquals(1, Code209.minSubArrayLen1(target2, test2));
        Assert.assertEquals(0, Code209.minSubArrayLen1(target3, test3));
    }
}