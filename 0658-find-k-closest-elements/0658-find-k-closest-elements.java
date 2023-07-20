class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int a = Math.abs(x - arr[i]);
            List<Integer> temp = new ArrayList<>();
            temp.add(a);
            temp.add(arr[i]);
            list.add(temp);
            // nums[i][1] = i;nums[i][0] = a;
            
        }
        Collections.sort(list, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a1, List<Integer> a2) {
                if( a1.get(0) == a2.get(0) ) {
                    return a1.get(1)-a2.get(1);
                }
                return a1.get(0) - a2.get(0);
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(list.get(i).get(1));
        }
        Collections.sort(result);
        return result;
    }
}