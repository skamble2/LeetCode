public class FriendsOfApproximateAges {
    public int numFriendRequests(int[] ages) {
        int res = 0;

        int[] ageFreq = new int[121];

        for (int age : ages) {
            ageFreq[age]++;
        }

        for (int age : ages) {
            int minValidAge = ((int)(0.5 * age) + 7) + 1;
            int maxValidAge = age;

            for (int j=minValidAge; j<=maxValidAge; j++) {
                res += ageFreq[j];

                if (j == age) {
                    res--;
                }
            }
        }

        return res;

    }
}
