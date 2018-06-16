package Array;

/**
 * Created by Administrator on 6/15/2018.
 */
public class Closest3Sum {

    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int nb = (int)Math.pow(2,nums.length);
        int closest = Integer.MAX_VALUE;

        for (int i=0; i<nb; i++) {
            int sum = 0;
            String bitStr = Integer.toBinaryString(i);
            if (bitStr.length() - bitStr.replace("1","").length() == 3){
                for (int j=0; j<bitStr.length(); j++) {
                    if (bitStr.charAt(bitStr.length()-1-j) == '1') {
                        sum+=nums[nums.length-1-j];
                    }
                }
                if (Math.abs(sum - target) < result) {
                    result = Math.abs(sum - target);
                    closest = sum;
                }
            }

        }

        return closest;

    }

    public static void main(String[] args) {
        int[] i = new int[]{-1,2,1,-4};
        System.out.println(Closest3Sum.threeSumClosest(i,1));
    }

}
