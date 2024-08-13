import java.util.Arrays;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][3];

        for (int i=0; i<n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            ans[arr[i][2]] = binarySearch(arr, i, n-1, arr[i][1]);
        }

        return ans;
    }

    public int binarySearch(int[][] arr, int low, int high, int target) {
        int res = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(arr[mid][0] >= target) {
                res = arr[mid][2];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}
