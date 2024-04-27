class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if( ch == '(') {
                count++;
                sb.append(ch);
            } else if( ch == ')' && count > 0) {
                count--;
                sb.append(ch);
            } else if( ch == ')' && count <= 0) {
                
            }  else {
                sb.append(ch);
            }
        }
        String temp = sb.toString();
        if( count == 0) {
            return temp;
        }
        int l = temp.length();
        StringBuilder sb1 = new StringBuilder();
        for(int i = l-1; i >= 0; i--) {
            char c = temp.charAt(i);
            if( count != 0 && c == '(') {
                count--;
            } else {
                sb1.append(c);
            }
        }
        return sb1.reverse().toString();
    }
}