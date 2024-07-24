class TimeMap {
// key: string
// value: List<string, int>

// ds:
// 1. stores key value pair
// 2. return "" if key does not exist. return value if key exists and timestamp_prev <= timestamp

// quick lookups : hash map
// key is string and value: some sort of ordering needs to be maintained

    Map<String, TreeMap<Integer, String>> keyTimeValMap;
    public TimeMap() {
        this.keyTimeValMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeValMap.containsKey(key)) {
            keyTimeValMap.put(key, new TreeMap<>());
        }

        keyTimeValMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (keyTimeValMap.containsKey(key) == false) {
            return "";
        }
        
        Integer floorKey = keyTimeValMap.get(key).floorKey(timestamp);
        if (floorKey != null) {
            return keyTimeValMap.get(key).get(floorKey);
        }

        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */