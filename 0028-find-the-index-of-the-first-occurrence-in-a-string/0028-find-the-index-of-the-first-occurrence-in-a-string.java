class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if( nl > hl) {
            return -1;
        }
        for(int i = 0; i <= hl-nl; i++) {
            String temp = haystack.substring(i, i+nl);
            if( temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}