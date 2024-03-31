class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = len-1;
        String str = s.toLowerCase();
        while(i < j) {
            char a = str.charAt(i);
            char b = str.charAt(j);
            if( !Character.isLetterOrDigit(a) ) {
                i++;
                continue;
            }
            if( !Character.isLetterOrDigit(b) ) {
                j--;
                continue;
            }
            if( a != b ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}