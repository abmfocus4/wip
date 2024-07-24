class TimeMap {

    class Value {
        String value;
        Integer timestamp;
        Value() {
            this.value = null;
            this.timestamp = null;
        }

        Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Value>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key) == false) {
            map.put(key, new ArrayList());
        }

        map.get(key).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // get timestamp_prev <= timestamp (largest timestamp_prev)
        if (map.containsKey(key) == false) {
            return "";
        }

        List<Value> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int midTimestamp = list.get(mid).timestamp;
            if (midTimestamp <= timestamp) {
                ans = left;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (ans == -1) {
            return "";
        } else {
            return list.get(ans).value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */