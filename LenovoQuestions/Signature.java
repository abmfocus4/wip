// number of elements to remove from each string to make them anagrams to each other

public class Signature{

    public static int NUM_ALPHABETS = 26;

    public static int[] getStringSignature(String str){
        int offset = (int) 'a';
        int[] countArray = new int[NUM_ALPHABETS];
        for(int i = 0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            countArray[c - offset]++;
        }

        return countArray;
    }

    public static int delta(int[] sig1, int[] sig2) {
        //if arrays are not equal do some error handling
        int delta = 0;
        for(int i = 0; i<sig1.length; i++){
            int difference = Math.abs(sig1[i] - sig2[i]);
            delta += difference;
        }

        return delta;
    }

    public static int numDeletions(String first, String second){
        int[] firstSignature = getStringSignature(first);
        int[] secondSignature = getStringSignature(second);
        int numDeletions = delta(firstSignature, secondSignature);
    }
    public static void main(String args[])
    {
        //fill in with test cases
    }
}