import java.util.Arrays;

public class SuccessfullPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int N = spells.length;
        int M = potions.length;

        int[] ans = new int[N];

        Arrays.sort(potions);

        for(int i=0; i<N; i++) {
            ans[i] = binarySearch(spells[i], potions, success);
        }

        return ans;
    }

    public int binarySearch(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(((long) potions[mid]) * spell >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return potions.length-left;
    }
}
