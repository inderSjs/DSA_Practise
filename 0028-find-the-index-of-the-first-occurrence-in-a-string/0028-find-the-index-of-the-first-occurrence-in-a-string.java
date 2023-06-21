class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) ) {
            return 0;
        }
        int l = haystack.length();
        for(int i = 0; i < l; i++) {
            for(int j = i+1; j <= l; j++) {
                String sub = haystack.substring(i,j);
                if( sub.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}