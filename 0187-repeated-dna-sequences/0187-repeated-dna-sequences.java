class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        int n = s.length();
        // System.out.println(n);
        for(int i = 0; i <= n-10; i++) {
            String substr = s.substring(i, i+10);
            if( set.contains(substr)) {
                list.add(substr);
            }
            set.add(substr);
        }
        return new ArrayList<>(list);
    }
}