import java.util.*;

public class Find_Minimum_II {

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
            else if (nums[mid] < nums[right]) {
                right = mid;
            }

            // When duplicates exist
            else {
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 0, 1};

        System.out.println("Minimum element is: " + findMin(nums));
    }
}