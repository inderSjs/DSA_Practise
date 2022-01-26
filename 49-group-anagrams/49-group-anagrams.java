class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        boolean[] isVisited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++) {
            if( !isVisited[i]) {
                char[] ch = strs[i].toCharArray();
                Arrays.sort(ch);
                String s1 = String.valueOf(ch);
                if( map.containsKey(s1) ) {
                    List<String> temp = map.get(s1);
                    temp.add(strs[i]);
                    map.replace(s1, temp);
                } else {
                    List<String> ls = new ArrayList<>();
                    ls.add(strs[i]);
                    map.put(s1,ls);
                }
                isVisited[i] = true;
            }
        }
        return new ArrayList(map.values());
    }
}