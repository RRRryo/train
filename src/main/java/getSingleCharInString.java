import java.util.HashMap;
import java.util.Map;

/**
 * Created by a542901 on 13/06/2018.
 */
public class getSingleCharInString {
    public static void main(String[] args) {
        String str= "ABCDAAV";
        char c[] = str.toCharArray();
        Map<String,Integer> letterCountMap = new HashMap<>();

        for (int i=0; i< c.length; i++) {
            String letter = String.valueOf(c[i]);
            if (!letterCountMap.containsKey(letter)){
                letterCountMap.put(letter,1);
            } else {
                int count = letterCountMap.get(letter);
                letterCountMap.put(letter,count+1);
            }
        }

        for (Map.Entry<String,Integer> entry : letterCountMap.entrySet()) {
            if (entry.getValue() ==1) {
                System.out.println(entry.getKey());
            }
        }
        int i = 7/5;
        System.out.println(7/2);
    }


}
