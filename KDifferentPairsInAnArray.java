import java.util.*;

public class KDifferentPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        Set<Integer> s = new HashSet<>();

        for(int num : nums) {
            if(s.contains(num-k) || s.contains(num+k)) {
                set.add(new ArrayList<>(Arrays.asList(num, num-k)));
            }

            s.add(num);
        }

        return set.size();
    }
}
