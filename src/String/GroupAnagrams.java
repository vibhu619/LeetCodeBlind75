package String;
//Given an array of strings strs, group the
//        anagrams
//        together. You can return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans=groupAnagrams(strs);
        for(List<String> l: ans){
            System.out.println(l);
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //1. Iterate through words in array
        //2.for each word, create a new_word, which is a sorted form of current word
        //3. create a map with key as string and value as array[string], and store this new_word as a key with word as value in array
        //4. do for each word
        //Logic: Anagram can have different sequence of alphabets but if u sort all the anagrams it will become a same word for all anagrams, hence u can easily store in map
        //example : (ate,eat,tea) ---> when sort them all ,they become aet
        //hence in map: aet : (ate,eat,tea)

        HashMap<String,List<String>> m=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String word=strs[i];
            String newWord=sortWord(word);
            if (!m.containsKey(newWord)) {
                m.put(newWord, new ArrayList<>());   //create a new entry in a map, with sorted word and a list as value.
            }

            m.get(newWord).add(word); //u have to add the current word in the list which is value for the sorted word, no matter what
        }

        return new ArrayList<>(m.values());
    }

    private static String sortWord(String w){
        char[] chr=w.toCharArray();
        Arrays.sort(chr);
        return new String(chr);
    }
}
