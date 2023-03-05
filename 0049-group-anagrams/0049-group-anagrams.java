// Time Complexity : O(nklogk) where n is size of array and k is the length of the longest string in the array
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2 strings are anagrams if their sorted strings are equal
// I used the sorted string as key of the hashmap and the values with
// sort equal to key



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