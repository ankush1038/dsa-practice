//class Solution {
//    public int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//        int number = 1;
//        for(int i=0; i<nums.length; i++){
//            if(number == nums[i]){
//                number++;
//            }
//        }
//        return number;
//    }
//}

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;

    }
}