package test;

import java.util.Arrays;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[] num = {2, 5, 5, 11};
        int target = 10;
        int[] two = twoSum(num, target);
        System.out.println(Arrays.toString(two));
    }
    public static int[] twoSum(int[] nums, int target) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    int[] two = {i, j};
                    return two;
                }
            }
        }
        return null;
    }
}
