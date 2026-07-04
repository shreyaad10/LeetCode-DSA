class Solution {

    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];
        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited, int ans) {

        visited[node] = true;

        for (int[] edge : graph[node]) {

            ans = Math.min(ans, edge[1]);

            if (!visited[edge[0]]) {
                ans = dfs(edge[0], graph, visited, ans);
            }
        }

        return ans;
    }
}