//class Solution {
//    public int minEatingSpeed(int[] piles, int h) {
//        int max = getMax(piles);
//        for(int k=1; k<=max; k++){
//            long totalHours = 0;
//
//            for(int i=0; i<piles.length; i++){
//                int pile = piles[i];
//                if(pile%k == 0){
//                    totalHours += pile/k;
//                } else{
//                    totalHours += pile/k + 1;
//                }
//            }
//            if(totalHours <= h){
//                return k;
//            }
//        }
//        return -1;
//    }
//
//    private int getMax(int[] piles){
//        int max = piles[0];
//        for(int pile: piles){
//            if(pile > max) max = pile;
//        }
//        return max;
//    }
//}

class KokoBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
                if (totalHours > h) break;
            }

            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
