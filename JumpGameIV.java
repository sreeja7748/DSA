import java.util.*;

class JumpGameIV {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store all indices for each value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int curr = queue.poll();

                // Reached last index
                if (curr == n - 1) {
                    return jumps;
                }

                List<Integer> nextIndices =
                        map.getOrDefault(arr[curr], new ArrayList<>());

                // Same value jumps
                for (int next : nextIndices) {

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }

                // Remove to avoid repeated work
                map.remove(arr[curr]);

                // Move right
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Move left
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }

            jumps++;
        }

        return -1;
    }

    public static void main(String[] args) {

        JumpGameIV obj = new JumpGameIV();

        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};

        System.out.println(obj.minJumps(arr));
    }
}