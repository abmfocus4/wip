# In Python 3, strings natively handle Unicode code points, so a standard collections.Counter or standard dict works out of the box:

from collections import Counter

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        return Counter(s) == Counter(t)