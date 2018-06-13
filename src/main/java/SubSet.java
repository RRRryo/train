import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a542901 on 13/06/2018.
 */
public class SubSet {

    public static int mSetsCount = 1;

    public static void getSubSetsByLiang(int[] sets) {
        int nbSubSet =(int) Math.pow(2,sets.length);
        int maxNum = 0;
        for (int i=0; i < nbSubSet ; i++) {
            String bitStr = Integer.toBinaryString(i);

            int sum = 0;
            int tmpMax = 0;
            for (int j = 0; j < bitStr.length(); j++) {
                if ( bitStr.charAt(j) == '1') {
                    //System.out.print(sets[j] + " ");
                    sum +=sets[j];
                    tmpMax++;
                }
            }
            if (sum == 10) {
                if (tmpMax > maxNum)  {
                    maxNum = tmpMax;
                }
                System.out.print(bitStr + "\t");
                System.out.print("sum=10 subset found: ");
                for (int j = 0; j < bitStr.length(); j++) {
                    if ( bitStr.charAt(j) == '1') {
                        System.out.print(sets[j] + " ");
                    }
                }
                System.out.print("\n");
            }


        }



    }

    
    public static void getSubSets(int[] sets) {

        if (null == sets) {
            System.out.println("null == sets");
            return;
        }

        int len = sets.length;
        // ???????
        int count = (int) Math.pow(2, len);

        System.out.println("empty : {}");
        // ??????
        for (int i = 1; i < count; i++) {
            // ???????????????0????????001,?????1
            String binaryStr = Integer.toBinaryString(i);
            System.out.print("on bit: " + binaryStr + ", his sub set: {");
            // ?????????
            int binLen = binaryStr.length();
            // ?????????(??????????)
            for (int j = len; j >= 0 && binLen > 0; j--) {
                // ??? ??1????????????
                if (binaryStr.charAt(binLen-1) == '1') {
                    System.out.print(sets[j-1] + ",");
                }
                binLen--;
            }
            System.out.println("}; ");
            // ????1
            mSetsCount++;
        }
    }

    void GetPowerSet2(int nArray[], int nLength)
    {
        int mark = 0;
        int i = 0;
        int nStart = 0;
        //nEnd =  2^nLength -1
        int nEnd = (1 << nLength) -1;
        boolean bNullSet = false;

        for (mark = nStart; mark <= nEnd; mark++)
        {
            bNullSet = true;
            for (i = 0; i < nLength; i++)
            {
                if (((1<<i)&mark) != 0) //???????
                {
                    bNullSet = false;
                    System.out.print(nArray[i] + "\t");
                }
            }
            if (bNullSet) //???
            {
                System.out.print("@\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        int nArray[] = {2,1,3,5,7};
        SubSet.getSubSetsByLiang(nArray);


    }
}
