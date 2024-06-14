class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int movs = 0;
        int expected = nums[0];
        
        for (int num : nums) {
            if (num < expected) {
                movs += expected - num;
            } else {
                expected = num;
            }
            expected++;
        }
        
        return movs;
    }
}