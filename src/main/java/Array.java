import java.util.*;

/**
 * Created by a542901 on 15/06/2018.
 */
public class Array {

    public int[] twoSum(int[] nums, int target) {

        for (int i=0 ; i<nums.length;i++) {
            for (int j=1; j<nums.length;j++) {
                if (i !=j && nums[i] + nums[j]==target) {
                    System.out.println(nums[i] + " " +nums[j]);
                    return new int[]{i ,j};
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSumZero(int[] nums) {
        int length = nums.length;
        int nb = (int)Math.pow(2,length);
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<nb;i++) {
            String bitStr = Integer.toBinaryString(i);
            if(bitStr.length() - bitStr.replaceAll("1","").length() == 3) {
                int sum = 0;
                for (int j = 0; j < bitStr.length();j++){
                    if (bitStr.charAt(j) == '1') {
                        sum += nums[j];
                    }
                }
                if (sum==0){
                    Integer[] res = new Integer[3];
                    int x=0;
                    for (int j = 0; j < bitStr.length();j++){
                        if (bitStr.charAt(j) == '1') {
                            res[x] = nums[j];
                            x++;
                        }
                    }

                    Arrays.sort(res);
                    set.add(Arrays.asList(res));
                }

            }
        }

        List list = new ArrayList<>();
        list.addAll(set);
        return (List<List<Integer>>)list;
    }

    public static void main(String[] args) {
        int[] i = new int[]{3,0,-2,-1,1,2};
        //Arrays.sort(i);
        Array.threeSumZero(i);
    }

}
