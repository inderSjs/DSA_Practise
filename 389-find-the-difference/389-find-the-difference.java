class Solution {
    public char findTheDifference(String s, String t) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        char[] arr1 = t.toCharArray();
        Arrays.sort(arr1);
        for(int i = 0; i < s.length(); i++) {
            if( arr[i] != arr1[i]) {
                return arr1[i];
            }
        }
        return arr1[arr1.length-1];
    }
}