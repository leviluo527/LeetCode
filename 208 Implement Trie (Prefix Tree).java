/*Solution: OOD, create a trienode class with child[]
* Time: O(words)
* Space: O(words)
*/
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur = cur.child[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] child = new TrieNode[26];
}
