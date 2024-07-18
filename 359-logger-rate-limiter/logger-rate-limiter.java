// explanation: https://leetcode.com/problems/logger-rate-limiter/solutions/365306/Simple-Two-HashMap-Solution-with-O(1)-time-and-little-memory/comments/903923
class Logger {
    Map<String, Integer> oldMap;
    Map<String, Integer> latestMap;
    int recentMsgTime;
    public Logger() {
        this.oldMap = new HashMap();
        this.latestMap = new HashMap();
        this.recentMsgTime = Integer.MIN_VALUE;
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (recentMsgTime <= timestamp - 10) {
            Map<String, Integer> t = oldMap; 
            oldMap = latestMap;
            latestMap = t;
            latestMap.clear();
            recentMsgTime = timestamp;
        }

        if (oldMap.containsKey(message)) {
            int oldTimestamp = oldMap.get(message);
            if (!(oldTimestamp <= timestamp - 10)) {
                return false;
            }  
        }

                        
        if (latestMap.containsKey(message)) {
            return false;
        }


        latestMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */