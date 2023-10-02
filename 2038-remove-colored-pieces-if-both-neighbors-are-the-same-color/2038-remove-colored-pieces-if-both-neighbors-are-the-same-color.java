class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        int l = colors.length();
        for(int i = 1; i < l-1; i++) {
            char ch = colors.charAt(i);
            char prev = colors.charAt(i-1);
            char next = colors.charAt(i+1);
            if( ch == 'A' && prev == 'A' && next == 'A') {
                a++;
            }
            if( ch == 'B' && prev == 'B' && next == 'B' ) {
                b++;
            }
        }
        if( a > b ) {
            return true;
        }
        return false;
    }
}