public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0, hi = 1, mid;

        int[] res = new int[2];

        while(lo<=hi) {
            mid = lo + (hi-lo)/2;

            int j = 1, tot = 0, num = 0, den = 0;

            double maxFac = 0;

            for(int i=0; i<arr.length; ++i) {
                while(j<arr.length && arr[i]>=arr[j]*mid) {
                    ++j;
                }

                tot += arr.length - j;

                if(j<arr.length && maxFac < arr[i]*1.0/arr[j]) {
                    maxFac = arr[i] * 1.0/arr[j];
                    num = i;
                    den = j;
                }
            }

            if(tot==k) {
                res[0] = arr[num];
                res[1] = arr[den];
                break;
            }

            if(tot>k) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return res;
    }
}
