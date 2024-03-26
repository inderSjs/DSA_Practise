class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int l1 = word.length();
        int l2 = abbr.length();
        int i = 0;
        int j = 0;
        while( i < l1 && j < l2) {
            if( word.charAt(i) == abbr.charAt(j) ) {
                i++;
                j++;
                continue;
            }
            if( abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while( j < l2 && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            int num = Integer.valueOf(abbr.substring(start,j));
            i = i + num;
        }
        return i == l1 && j == l2;
    }
}