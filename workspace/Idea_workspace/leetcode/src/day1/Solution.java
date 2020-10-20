package day1;

import java.util.*;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-25 10:16
 */
class Solution {
   /*
   给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

    示例 1:

    输入: [10,2]
    输出: 210
    示例 2:

    输入: [3,30,34,5,9]
    输出: 9534330
    说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
    */

    class LargestNumberSort implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new LargestNumberSort());

        String s = Arrays.toString(strings);
        return s.substring(1, s.length() - 1).replaceAll(",", "").replaceAll(" ", "");
    }


    //给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。


    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> test = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (!test.containsKey(target - nums[i])) {
                test.put(nums[i], i);
            } else {
                return new int[]{test.get(target - nums[i]), i};
            }
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode cu = l3;
        ListNode p = l1, q = l2;
        int a = 0;

        while (p != null || q != null) {

            int one = (p != null) ? p.val : 0;
            int two = (q != null) ? q.val : 0;

            int sum = one + two + a;
            a = (one + two) / 10;

            cu.next = new ListNode(sum % 10);
            cu = cu.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }
        }

        if (a > 1) {
            cu.next = new ListNode(a);
        }


        return l3.next;
    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        int n = s.length();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                max = Math.max(max, i - j);
            } else {
                set.remove(s.charAt(j++));
            }
        }


        return max;
    }

    public static void quick(int[] args) {

        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        for (int arg : args) {
            System.out.print(arg + " ");
        }

    }


    public static void main(String[] args) {
        int[] one = {3, 30, 34, 5, 9};
        System.out.println(new Solution().largestNumber(one));

        quick(one);

        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println(lengthOfLongestSubstring("au"));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}