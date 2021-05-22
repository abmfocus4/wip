from collections import Counter

def check(cnt):
    ls = cnt.values()
    try:
        ls.remove(0)
    except:
        pass
    if len(set(ls)) == 1:
        return True
    else:
        return False

def isValid(s):
    # A Counter is a dict subclass for counting hashable objects. 
    cnt = Counter(s)
    if check(cnt):
        return "YES"
    for i in cnt.keys():
        cnt[i] -= 1
        if check(cnt):
            return "YES"
        else:
            cnt[i] += 1
    return "NO"

s = raw_input().strip()
result = isValid(s)
print(result)