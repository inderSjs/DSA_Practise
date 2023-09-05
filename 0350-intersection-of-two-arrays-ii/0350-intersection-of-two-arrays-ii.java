class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            if( map.containsKey(num) ) {
                int x = map.get(num);
                map.put(num, x+1);
            } else {
                map.put(num, 1);
            }
        }
        for(int num: nums2) {
            if( map.containsKey(num) ) {
                result.add(num);
                int temp = map.get(num);
                if( temp == 1 ) {
                    map.remove(num);
                } else {
                    map.put(num, temp-1);
                }
            }
        }
        int[] re = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}