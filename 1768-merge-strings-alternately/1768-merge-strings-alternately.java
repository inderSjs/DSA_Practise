class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int l1 = word1.length();
        int l2 = word2.length();
        int p1 = 0;
        int p2 = 0;
        while ( p1 < l1 && p2 < l2) {
            if( p1 <= p2) {
                result = result + word1.charAt(p1);
                p1++;
            } else {
                result = result + word2.charAt(p2);
                p2++;
            }
        }
        while( p1 < l1) {
            result = result + word1.charAt(p1);
            p1++;
        }
        while( p2 < l2) {
            result += word2.charAt(p2);
            p2++;
        }
        return result;
    }
}