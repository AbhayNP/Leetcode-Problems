class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int left = 0;
        int right = limit;
        int[] bucket = new int[limit + 1];
        for (int p : people) bucket[p]++;
        
        while (left <= right) {
            while (left <= right && bucket[left] <= 0) left++;
            while (left <= right && bucket[right] <= 0) right--;
            
            if (left > right) {
               break; 
            }
            // if (bucket[left] <= 0 && bucket[right] <= 0) {
            //     break;
            // }
            if (left + right <= limit) {
                bucket[left]--;
            }
            bucket[right]--;
            count++;
        }
        return count;
    }
}