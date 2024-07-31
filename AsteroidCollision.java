class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int peek = -1;
        loop:
        for(int i=0; i<asteroids.length; i++) {
            if(asteroids[i]>0) {
                asteroids[++peek] = asteroids[i];
                continue;
            }

            while(peek>=0 && asteroids[peek]>0) {
                if(asteroids[peek]<Math.abs(asteroids[i])) peek--;
                else if(asteroids[peek]>Math.abs(asteroids[i])) continue loop;
                else {
                    peek--;
                    continue loop;
                }
            }

            asteroids[++peek] = asteroids[i];
        }

        int[] ans = new int[peek+1];
        for(int i=0; i<=peek; i++) ans[i] = asteroids[i];


        return ans;
    }
}