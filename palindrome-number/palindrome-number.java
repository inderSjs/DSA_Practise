class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int temp = x;
        while ( temp != 0 ) {
            int y = temp % 10;
            list.add(y);
            temp = temp/10;
        }
        int j = list.size()-1;
        for(int i = 0; i < list.size(); i++) {
            if ( list.get(i) != list.get(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
}