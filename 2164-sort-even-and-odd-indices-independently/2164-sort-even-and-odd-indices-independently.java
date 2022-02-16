class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if( i%2 == 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int k = 0;
        int l = list2.size()-1;
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i = 0; i < nums.length; i++) {
            if( i%2 == 0) {
                nums[i] = list1.get(k);
                k++;
            } else {
                nums[i] = list2.get(l);
                l--;
            }
        }
        return nums;
    }
}