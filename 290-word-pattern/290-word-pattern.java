class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] temp = s.split(" ");
        if( pattern.length() != temp.length ) {
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for( int i = 0; i < pattern.length(); i++ ) {
            if( map.containsKey(temp[i]) ) {
                Character t1 = map.get(temp[i]);
                System.out.println(t1);
                System.out.println( pattern.charAt(i) );
                if( t1 != pattern.charAt(i) ) {
                    System.out.println("in here");
                    return false;
                }
            } else {
                if( map.containsValue(pattern.charAt(i))) {
                    return false;
                }
                map.put(temp[i], pattern.charAt(i));
            }
        }
        return true;
    }
}