import java.util.HashMap;

//try using 1 hashmap

public class RansomNote{

    public static HashMap<String, Integer> getStringFrequency(String[] text){
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for(String word : text){
            if(!frequencies.containsKey(word))
                frequencies.put(word, 0);
            else
                frequencies.put(word, frequencies.get(word) + 1);
        }

        return frequencies;
    }

    public static boolean hasEnoughStrings(HashMap<String, Integer> magFrequency, HashMap<String, Integer> noteFrequency){

        for(HashMap.Entry<String, Integer> entry: noteFrequency.entrySet()){
            String word = entry.getKey();
            if(!magFrequency.containsKey(word) || magFrequency.get(word) < entry.getValue()){
                return false;
            }
        }

        return true;
    }

    public static boolean canBuildRansomNote(String[] note, String[] magazine){
        HashMap<String, Integer> magazineFrequency = getStringFrequency(magazine);
        HashMap<String, Integer> noteFrequency = getStringFrequency(note);

        return hasEnoughStrings(noteFrequency, magazineFrequency);
    }
    public static void main(String[] args){
        String[] note = {"I", "have", "your", "dog"};
        String[] magazine = {"I", "think", "blue", "moon", "covid", "fox", "howling"};

        System.out.println(canBuildRansomNote(note, magazine));
    }
}