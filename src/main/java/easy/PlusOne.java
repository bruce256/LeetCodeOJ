package easy;

import java.util.Arrays;

/**
 * @author LvSheng
 * @date 2021/10/14
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;

        int jinwei = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += jinwei;
            if (digits[i] > 9) {
                digits[i] %= 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
        }
        if (jinwei == 1) {
            digits = new int[digits.length + 1];
            Arrays.fill(digits, 0);
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[]   digits1 = {1, 2, 3};
        System.out.println(plusOne.plusOne(digits1));
        System.out.println(plusOne.plusOne(new int[] {1, 2, 3, 4}));
        System.out.println(plusOne.plusOne(new int[] {9, 9, 9}));
    }
}
