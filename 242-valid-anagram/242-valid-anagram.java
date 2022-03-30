class Solution {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length() ) {
            return false;
        }
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        String a = new String(s1);
        char[] s2 = t.toCharArray();
        Arrays.sort(s2);
        String b = new String(s2);
        return a.equals(b);
    }
}