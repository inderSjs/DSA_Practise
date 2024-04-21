class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            int in = edge[0];
            int out = edge[1];
            indegree[in]++;
            if( !map.containsKey(out) ) {
                map.put(out, new ArrayList<>() );
            }
            map.get(out).add(in);
        }
        int count = 0;
        int[] result = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if( indegree[i] == 0) {
                q.add(i);
                result[count] = i;
                count++;
            }
        }
        while( !q.isEmpty() ) {
            int vertex = q.poll();
            List<Integer> li = map.get(vertex);
            if( li != null ) {
                for(int i = 0; i < li.size(); i++) {
                    indegree[li.get(i)]--;
                    if( indegree[li.get(i)] == 0 ) {
                        result[count] = li.get(i);
                        count++;
                        q.add(li.get(i));
                    }
                }
            }
        }
        if( count != numCourses) {
            return new int[0];
        }
        return result;
    }
}