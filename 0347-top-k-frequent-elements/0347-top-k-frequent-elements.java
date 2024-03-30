class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if( !map.containsKey(num) ) {
                map.put(num,0);
            }
            int count = map.get(num);
            count++;
            map.put(num, count);
        }
        int n = nums.length;
        List<Integer>[] bucket = new ArrayList[n+1];
        for(Map.Entry<Integer, Integer> el: map.entrySet()) {
            int key = el.getKey();
            int freq = el.getValue();
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        int t = k;
        for(int i = n; i >= 0 && t > 0; i--) {
            if( bucket[i] != null) {
                List<Integer> list = bucket[i];
                for(int j = 0; j < list.size() && t > 0; j++) {
                    ans.add(list.get(j));
                    t--;
                }
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}