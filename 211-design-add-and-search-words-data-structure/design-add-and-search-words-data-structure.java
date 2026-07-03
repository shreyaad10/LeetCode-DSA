class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {

        if (node == null)
            return false;

        if (pos == word.length())
            return node.isEnd;

        char ch = word.charAt(pos);

        if (ch == '.') {

            for (TrieNode child : node.children) {
                if (child != null && dfs(word, pos + 1, child))
                    return true;
            }

            return false;
        }

        return dfs(word, pos + 1, node.children[ch - 'a']);
    }
}