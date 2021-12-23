class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;
        boolean[] isVisited = new boolean[N];
        //HashMap<Character, Integer> map = new HashMap<>();
        //System.out.println(this.helper(strs[0], strs[1]));
        List<List<String>> listOfLists = new ArrayList<List<String>>();
        for(int i = 0; i < N; i++) {
            if( !isVisited[i] ) {
                isVisited[i] = true;
                List<String> al = new ArrayList<>();
                al.add(strs[i]);
                int j  = i + 1;
                while( j < (N)) {
                    if( !isVisited[j] ) {
                        boolean bool = this.helper(strs[i], strs[j]); 
                            if( bool ) {
                                isVisited[j] = true;
                                al.add(strs[j]);
                            }
                        }
                    j++;
                }
                /* for(int j = i+1; j < N; j++) {
                    if( !isVisited[j] ) {
                        boolean bool = this.helper(strs[i], strs[j]); 
                            if( bool ) {
                                isVisited[j] = true;
                                al.add(strs[j]);
                            }
                        }
                    }*/
                
                listOfLists.add(al);
            }
        }
        return listOfLists;
    }
    
    public boolean helper(String s1, String s2) {
        if( s1.length() != s2.length()) {
            return false;
        }
       if( s1.length() == 0 && s2.length() == 0) {
            return true;
        } 
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            if( map.containsKey(s1.charAt(i))) {
                int value = map.get(s1.charAt(i));
                value = value + 1;
                map.replace(s1.charAt(i), value);
            } else {
                map.put(s1.charAt(i),1);
            }
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s2.length(); i++) {
            if( !map.containsKey(s2.charAt(i))) {
                return false;
            } else if ( map1.containsKey(s2.charAt(i))) {
                int value = map1.get(s2.charAt(i));
                value = value + 1;
                map1.replace(s2.charAt(i), value);
            } else {
                map1.put(s2.charAt(i), 1);
            }
        }
        if( map.size() != map1.size()) {
            return false;
        } 
        char[] s11 = s1.toCharArray();
        Arrays.sort(s11);
        String t1 = new String(s11);
        char[] s22 = s2.toCharArray();
        Arrays.sort(s22);
        String t2 = new String(s22);
        for( int i = 0; i < t1.length(); i++) {
            int v1 = map.get(t1.charAt(i));
            int v2 = map1.get(t2.charAt(i));
            if( v1 != v2) {
                return false;
            }
        }
        return true;
    }
}