class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if( strs.length == 0 ) {
            return new ArrayList();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String a = new String(arr);
            if( map.containsKey(a) ) {
                List<String> list = map.get(a);
                list.add(strs[i]);
                map.replace(a, list);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(a, temp);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> set: map.entrySet() ) {
            result.add(set.getValue());
        }
        return result;
    }
}