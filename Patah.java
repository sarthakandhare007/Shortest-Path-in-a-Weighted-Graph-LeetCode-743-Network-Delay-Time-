import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>())
                 .add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if (time > dist[node]) continue;

            if (!graph.containsKey(node)) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0], weight = nei[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NetworkDelayTime solver = new NetworkDelayTime();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println("Output: " + solver.networkDelayTime(times, n, k)); // 2
    }
}
