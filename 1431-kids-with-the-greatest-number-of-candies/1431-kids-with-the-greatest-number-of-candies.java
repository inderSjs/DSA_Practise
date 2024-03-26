class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int greatest = 0;
        for( int num: candies ) {
            greatest = Math.max(num, greatest);
        }
        for(int num: candies) {
            if( (num + extraCandies) >= greatest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}