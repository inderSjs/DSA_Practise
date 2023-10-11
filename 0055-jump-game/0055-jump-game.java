class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        q.add(0);
        while(!q.isEmpty() ) {
            int idx = q.poll();
            for(int i = 1; i <= nums[idx]; i++) {
                int j = idx + i;
                if( j >= nums.length-1) {
                    return true;
                }
                if( !set.contains(j)) {
                    q.add(j);
                    set.add(j);
                }
                // q.add(j);
            }
        }
        return false;
    }
}