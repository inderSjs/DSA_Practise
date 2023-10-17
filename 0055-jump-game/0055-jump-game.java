class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if( n == 1) {
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while( !q.isEmpty() ) {
            int idx = q.poll();
            for(int i = 1; i <= nums[idx]; i++) {
                int index = i + idx;
                if( index < n && !set.contains(index)) {
                    q.add(index);
                    set.add(index);
                }
                if( index >= (n-1)) {
                    return true;
                }
            }
        }
        return false;
    }
}