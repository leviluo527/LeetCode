/*Solution: Level Order Iterative
* Time: O(N*5^(N/2 + 1))
* Space: O(N*5^(n/2))
*/
class Solution {
    public char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'}, 
        {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    
    public List<String> findStrobogrammatic(int n) {
        Queue<String> q = new LinkedList<>();
        int currStringsLength;
        
        // When n is even, it means when decreasing by 2 we will go till 0.
        if (n % 2 == 0) {
            // We will start with 0-digit strobogrammatic numbers.
            currStringsLength = 0;
            q.add("");
        } else {
            // We will start with 1-digit strobogrammatic numbers.
            currStringsLength = 1;
            q.add("0");
            q.add("1");
            q.add("8");
        }
        
        while (currStringsLength < n) {
            currStringsLength += 2;
            for (int i = q.size(); i > 0; --i) {
                String number = q.poll();
                
                for (char[] pair : reversiblePairs) {
                    if (currStringsLength != n || pair[0] != '0') {
                        q.add(pair[0] + number + pair[1]);
                    }
                }
            }
        }
        
        List<String> stroboNums = new ArrayList<>();
        while (!q.isEmpty()) {
            stroboNums.add(q.poll());
        }
        
        return stroboNums;
    }
}