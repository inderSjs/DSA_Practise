class Solution {
        
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            int out = edge[1];
            int in = edge[0];
            indegree[out]++;
            if( !map.containsKey(in) ) {
                map.put(in, new ArrayList<>());
            }
            map.get(in).add(out);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if( indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while( !q.isEmpty() ) {
            int course = q.poll();
            List<Integer> li = map.get(course);
            if( li != null ) {
                for(int i = 0; i < li.size(); i++) {
                    indegree[li.get(i)]--;
                    if( indegree[li.get(i)] == 0 ) {
                        q.add(li.get(i));
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}