/**
 * Created by a542901 on 13/06/2018.
 */
public class InverseString {

    public static void main(String[] args) {
        String str = "hello";


        char[] chars = str.toCharArray();

        for (int i=0 ; i < chars.length/2 ; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] =tmp;
        }

        System.out.println(chars);

    }
}
