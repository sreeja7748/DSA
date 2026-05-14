import java.util.*;

public class Good_Array {

    public static boolean isGood(int[] nums) {

        int n = nums.length - 1;

        int[] freq = new int[n + 1];

        for (int num : nums) {

            // Check valid range
            if (num < 1 || num > n) {
                return false;
            }

            freq[num]++;
        }

        // Numbers 1 to n-1 should appear once
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // Number n should appear twice
        return freq[n] == 2;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 3, 2};

        if (isGood(nums)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}