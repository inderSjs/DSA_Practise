// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = s.length();
        for(int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if( map.containsKey(ch) ) {
                map.put( ch, i);
            }
            map.put(ch, i);
        }
        int i = 0;
        while( i < l) {
            char first = s.charAt(i);
            int currWindow = map.get(first);
            for(int j = i+1; j < currWindow; j++) {
                char temp = s.charAt(j);
                int lastIdx = map.get(temp);
                currWindow = Math.max(currWindow, lastIdx);
            }
            result.add(currWindow-i+1);
            i = currWindow+1;
        }
        return result;
    }
}