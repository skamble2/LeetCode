import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int N = position.length;
        int start = 1;
        int end = (position[N - 1] - position[0]) / (m-1);



        while(start <= end) {
            int mid = (start + end) / 2;

            if(ballsCanPlace(position, mid, m)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private boolean ballsCanPlace(int[] position, int mid, int m) {
        int cnt = 1;
        int last = position[0];

        for(int i=1; i<position.length; i++) {
            if(position[i] - last >= mid) {
                cnt++;
                last = position[i];

                if(cnt == m) return true;
            }
        }
        return false;
    }
}
