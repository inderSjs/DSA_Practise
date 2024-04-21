class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            if( !map.containsKey(temp) ) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        for(Map.Entry<String, List<String>> el: map.entrySet() ) {
            List<String> li = new ArrayList<>();
            for(String s: el.getValue() ) {
                li.add(s);
            }
            result.add(li);
        }
        return result;
    }
}