# s,n = input().strip(), int(input().strip())

def countRepeatedString(s, n):
    int repeatedString = s.count("a") * (n // len(s))
    int remainingString = s[: (n % len(s))].count("a")

    int totalRepeats = repeatedString + remainingString

    print(totalRepeats)