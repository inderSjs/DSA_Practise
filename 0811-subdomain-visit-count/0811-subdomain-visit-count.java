class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: cpdomains){
            String[] count = str.split(" ");
            String[] dm = count[1].split("\\.");
            String []domain = helper(dm);
            for(int i = 0; i < domain.length; i++) {
                int cnt = Integer.parseInt(count[0]);
                if( map.containsKey(domain[i])) {
                    int temp = map.get(domain[i]);
                    map.put(domain[i], temp + cnt);
                } else {
                    map.put(domain[i], cnt);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(String s: map.keySet() ) {
            String temp = map.get(s).toString() + " " + s;
            result.add(temp);
        }
        return result;
    }
    
    private String[] helper(String[] domains) {
        int n = domains.length-1;
        String[] result = new String[n+1];
        result[n] = domains[n];
        String temp = domains[n]; 
        for(int i = n-1; i >= 0; i--) {
            temp = domains[i] + "." + temp;
            result[i] = temp;
        }
        return result;
    }
}