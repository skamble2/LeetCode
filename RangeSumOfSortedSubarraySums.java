public class RangeSumOfSortedSubarraySums {
    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int maxSum = 0;

        for(int num : nums) {
            maxSum += num;
        }

        int[] count = new int[maxSum + 1];

        for(int i=0; i<n; i++) {
            int sum = 0;

            for(int j=i; j<n; j++) {
                sum += nums[j];
                count[sum]++;
            }
        }

        for(int i=1; i<=maxSum; i++) {
            count[i] += count[i-1];
        }

        long res = 0;

        for(int sum=1, k=1; sum<=maxSum; sum++) {
            while(k<=count[sum]) {
                if(k>=left && k<=right) {
                    res = (res+sum) % MOD;
                }

                k++;
            }
        }

        return (int) res;
    }
}
