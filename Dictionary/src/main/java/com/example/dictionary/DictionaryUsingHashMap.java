package com.example.dictionary;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryUsingHashMap {
    private HashMap<String,String> dictionary;
    public DictionaryUsingHashMap(){
        dictionary = new HashMap<String,String>();
        addListOfWords();
    }
    public boolean  addWord(String word, String meaning){
        dictionary.put(word,meaning);
        return true;
    }

    public String[] getSuggestions(String word){
        String[] suggestion = new String[5];
        int i=0;
        for(Map.Entry<String,String> entry : dictionary.entrySet()){
            int lastIndex = Math.min(word.length(),entry.getKey().length());
            if(word.compareTo(entry.getKey().substring(0,lastIndex)) == 0){
                suggestion[i++]=entry.getKey();
            }
            if(i==4)break;
        }
        return suggestion;
    }

    public String fidMeaning(String word){
        if(!dictionary.containsKey(word)){
            return "Given word not found";
        }
        else  return dictionary.get(word);
    }

    private void addListOfWords(){
        addWord("shubh","Auspicious");
        addWord("affect","Influence");
        addWord("effect","Result");
        addWord("buy","purchase");

    }
}


