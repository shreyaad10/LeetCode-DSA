import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        TreeSet<Integer> values = new TreeSet<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            values.add(e[2]);
        }

        // Topological order
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph[u]) {
                if (--indegree[edge[0]] == 0)
                    q.offer(edge[0]);
            }
        }

        List<Integer> costs = new ArrayList<>(values);

        int left = 0;
        int right = costs.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int limit = costs.get(mid);

            if (can(limit, graph, topo, online, k, n)) {
                ans = limit;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int limit,
                        List<int[]>[] graph,
                        List<Integer> topo,
                        boolean[] online,
                        long k,
                        int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}