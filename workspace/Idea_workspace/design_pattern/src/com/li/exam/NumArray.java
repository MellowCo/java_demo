package com.li.exam;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 16:57
 */
    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;

            for (int i1 = i; i1 <= j; i1++) {
                sum += nums[i1];
            }

            return sum;
        }


    }
