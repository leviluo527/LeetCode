/*Solution1: Use Trie to search
* Time: O(S): S = all characters in the String[]
* Space: O(S)
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";  
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();     
        String q = ""; 
        for (int i = 0; i < strs.length ; i++) {
            trie.insert(strs[i]);
            if (q.length() < strs[i].length()) {
                q = strs[i];
            }
        }
        return trie.searchLongestPrefix(q);
    }
    
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.put(c, new TrieNode());
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }

        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.children[curLetter - 'a'] != null && (node.getLinks() == 1) && (!node.isWord)) {
                    prefix.append(curLetter);
                    node = node.children[curLetter - 'a'];
                }
                else
                    return prefix.toString();
            }
            return prefix.toString();
        }

        class TrieNode {
            boolean isWord;
            TrieNode[] children;
            int size;
            public TrieNode() {
                children = new TrieNode[26];
            }

            private void put(char cur, TrieNode node) {
                children[cur - 'a'] = node;
                size++;
            }

            private int getLinks() {
                return size;
            }
        }
    }
}

/*Solution2:Use Divide & Conquer
* Time: O(S)
* Space: O(m * logn) : m = each single word length, n = String[].length 
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }

        int mid = l + (r - l) / 2;
        String left = longestCommonPrefix(strs, l, mid);
        String right = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(left, right);
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}

/*Solution3: Use Binary Search
* Time: O(S * logm)
* Space: O(1)
*/
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}