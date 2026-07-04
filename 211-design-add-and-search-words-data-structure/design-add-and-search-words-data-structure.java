class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {

        if (node == null)
            return false;

        if (pos == word.length())
            return node.isEnd;

        char c = word.charAt(pos);

        if (c == '.') {

            for (TrieNode child : node.children) {
                if (child != null && dfs(word, pos + 1, child))
                    return true;
            }

            return false;
        }

        return dfs(word, pos + 1, node.children[c - 'a']);
    }
}