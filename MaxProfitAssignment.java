public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = 0;

        for(int diff :difficulty) {
            maxDiff = Math.max(maxDiff, diff);
        }

        int[] maxProfit = new int[maxDiff+1];

        for(int i=0; i<difficulty.length; i++) {
            maxProfit[difficulty[i]] = Math.max(maxProfit[difficulty[i]], profit[i]);
        }

        for(int i=1; i<=maxDiff; i++) {
            maxProfit[i] = Math.max(maxProfit[i], maxProfit[i-1]);
        }

        int tot = 0;

        for(int ab : worker) {
            if(ab>maxDiff) {
                tot += maxProfit[maxDiff];
            } else {
                tot += maxProfit[ab];
            }
        }

        return tot;
    }
}
