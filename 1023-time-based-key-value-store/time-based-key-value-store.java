class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;
    
    public TimeMap() {
        keyTimeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        if (timestamp < keyTimeMap.get(key).get(0).getKey()) {
            return "";
        }
        
        // Using binary search on the list of pairs.
        int ans = -1;
        int left = 0;
        int right = keyTimeMap.get(key).size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (ans == -1) {
            return "";
        }
                
        return keyTimeMap.get(key).get(ans).getValue();
    }
}