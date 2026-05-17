import java.util.*;

class FindAllPeople {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;

        while (i < meetings.length) {

            int time = meetings[i][2];

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            // Meetings with same time
            while (i < meetings.length && meetings[i][2] == time) {

                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);

                i++;
            }

            Queue<Integer> queue = new LinkedList<>();

            // Start from people who know secret
            for (int person : people) {
                if (knows[person]) {
                    queue.offer(person);
                }
            }

            Set<Integer> visited = new HashSet<>();

            while (!queue.isEmpty()) {

                int curr = queue.poll();

                if (visited.contains(curr)) {
                    continue;
                }

                visited.add(curr);
                knows[curr] = true;

                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (knows[j]) {
                result.add(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FindAllPeople obj = new FindAllPeople();

        int n = 6;

        int[][] meetings = {
                {1, 2, 5},
                {2, 3, 8},
                {1, 5, 10}
        };

        int firstPerson = 1;

        System.out.println(obj.findAllPeople(n, meetings, firstPerson));
    }
}