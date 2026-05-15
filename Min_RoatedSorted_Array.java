import java.util.*;

public class Min_RoatedSorted_Array {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Minimum lies in left half including mid
            else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Minimum element is: " + findMin(nums));
    }
}