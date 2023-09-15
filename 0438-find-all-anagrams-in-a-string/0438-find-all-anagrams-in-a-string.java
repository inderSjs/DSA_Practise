class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        String pn = new String(arr);
        int l = s.length();
        int n = p.length();
        if( n > l) {
            return result;
        }
        for(int i = 0; i <= l-n; i++) {
            String temp = s.substring(i, i+n);
            char[] ar = temp.toCharArray();
            Arrays.sort(ar);
            String sn = new String(ar);
            if( pn.equals(sn)) {
                result.add(i);
            }
        }
        return result;
    }
}