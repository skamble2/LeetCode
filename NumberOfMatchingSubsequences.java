import java.util.HashMap;
import java.util.Map;


public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {

        Map<String,Integer> mp = new HashMap<>();

        for(String word : words) {
            mp.put(word, mp.getOrDefault(word,0)+1);
        }

        int res = 0;

        char ch[] = s.toCharArray();

        for(String word : mp.keySet()) {

            char temp[] = word.toCharArray();
            int i=0;
            int j=0;

            while(i<ch.length && j<temp.length) {
                if(ch[i]==temp[j]){
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            if(j==temp.length) {
                res += mp.get(word);
            }
        }

        return res;
    }
}
