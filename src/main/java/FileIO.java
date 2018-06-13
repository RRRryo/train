import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by Administrator on 6/13/2018.
 */
public class FileIO {

    public static void main(String[] args) {

        int[] array = {2,1,5,4};

        FileIO.oneLineWrite(array);

        try {
            List<String> strlist = Files.readAllLines(Paths.get("file.txt"));

            for(String str : strlist) {
                str = str.replace("[","").replace("]","");
                String[]  strArray =str.split(",");
                System.out.println(str);
                List<Integer> newList = new ArrayList<>();
                for (String s : strArray) {
                    newList.add(Integer.parseInt(s.trim()));
                }
                Collections.sort(newList, (o1, o2) -> o2 - o1);
                System.out.print(newList);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }



    public static void oneLineWrite(int[] array){

        String str= Arrays.toString(array);

        try {
            Files.write(Paths.get("file.txt"),
                    str.getBytes("utf-8"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
