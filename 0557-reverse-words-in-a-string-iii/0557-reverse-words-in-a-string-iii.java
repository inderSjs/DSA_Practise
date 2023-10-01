class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] arr = s.split(" ");
        for(String str: arr) {
            int l = str.length();
            for(int i = l-1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            result.append(" ");
        }
        return result.toString().strip();
    }
}