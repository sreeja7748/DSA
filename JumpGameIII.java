import java.util.*;

class JumpGameIII {

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {

        // Out of bounds or already visited
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        // Found zero
        if (arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        // Jump forward or backward
        return dfs(arr, index + arr[index], visited) ||
               dfs(arr, index - arr[index], visited);
    }

    public static void main(String[] args) {

        JumpGameIII obj = new JumpGameIII();

        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;

        System.out.println(obj.canReach(arr, start));
    }
}