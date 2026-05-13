import java.util.*;

class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }

            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            int freq = count.get(nums[i]);

            if (freq > degree) {
                degree = freq;
                minLength = i - first.get(nums[i]) + 1;
            }
            else if (freq == degree) {
                minLength = Math.min(minLength,
                        i - first.get(nums[i]) + 1);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {

        DegreeOfArray obj = new DegreeOfArray();

        int[] nums = {1, 2, 2, 3, 1};

        System.out.println(obj.findShortestSubArray(nums));
    }
}