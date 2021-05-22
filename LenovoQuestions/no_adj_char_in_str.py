//No adjacent characters in the string

int numDeletions(string str){
    int length = str.length();
    int deletions = 0;
    for(int i = 0; i<length; i++){
        if(str[i] == str[i+1]){
            deletions++;
        }
    }
    return deletions;
}

int main(){
    string str = "bubblegum";
    cout << "Ans: " << numDeletions(str);
}

# PYTHON SCRIPT
# for _ in range(t): if not using the counter

def numDeletions(string s):
    deletions = 0
    for i in range(len(s)):
        if(s[i] == s[i+1])
            deletions += 1
    print(deletions)
