class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if( !map.containsKey(key) ) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for(Map.Entry<String, List<String>> el: map.entrySet() ) {
            result.add(new ArrayList<>(el.getValue()));
        }
        return result;
    }
}