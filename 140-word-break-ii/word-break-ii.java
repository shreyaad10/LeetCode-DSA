class Solution {

    private Set<String> dict;
    private Map<String, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return dfs(s);
    }

    private List<String> dfs(String s) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : dict) {

            if (s.startsWith(word)) {

                List<String> suffixWays = dfs(s.substring(word.length()));

                for (String suffix : suffixWays) {

                    if (suffix.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, result);

        return result;
    }
}