package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private ArrayList<String> wordSet;
    private Hashmap<<String>,ArrayList<String>> lettersToWord = new Hashmap<<String>,<ArrayList<String>>();
    private Hashmap<<String>,ArrayList<String>> sizeToWord = new Hashmap<<String>,ArrayList<String>>();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
        }
    }

    public boolean isGoodWord(String word, String base) {
       if(wordSet.contains(word) && !word.contains(base))
        return true;
        else
            return false;
    }

    public ArrayList<String> getAnagrams(String word) {
        //ArrayList<String> result = new ArrayList<String>();

        //step-3
        ArrayList<String> temp_words1 = new ArrayList<String>();
        String sortWord;
        sortWord = alphabeticalOrder(word);
        for(i=0;i<wordSet.size();i++)
        { 

        if (lettersToWord.containsKey(alphabeticalOrder(wordSet[i])){
            temp_words1 = lettersToWord.get(sortWord);
            temp_words1.add(word);
        }
        else{
            temp_words1.add(wordSet[i]);
            lettersToWord.put(sortWord,temp_words1)
        }
        
        }
        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();

        String sortedWord = alphabeticalOrder(word);
        String newWord;
        for(char c = 'a'; c<='z'; c++){
            newWord = c+ sortedWord;
            newWord = alphabeticalOrder(newWord);

            if(lettersToWord.containsKey(newWord)){
                result.addAll(lettersToWord.get(newWord));
                
            }
        }

        // delete all bad words
        for (int i = 0; i<result.size();i++)
        {
            //Log.d("AD list", result.get(i));
            if(!isGoodWord(result.get(i),word))
            {
               // Log.d("AD removed",result.remove(i))
                result.remove(i);
            }
        }
        return result;
    }



//    ArrayList<String> temp_words2 = new ArrayList<String>();
//    int l = word.length();
//    if(sizeToWord.containsKey(i)){
//        temp_words2 = sizeToWord.get(l);
//        temp_words2.add(word);
//        sizeToWord.put(1)
//    }
//
//
//    if(j == lengthWords.size() - 1 && word == null ){
//        for(j=0;j<i;j++)
//        {
//            if(getAnagramsWithOneMoreLetter
//                (lengthWords.get(j)).size()
//                >= MIN_NUM_ANAGRAMS){
//                word = lengthWords.get(j);
//            break;
//            }
//        }
//    }
//
//    if(wordLength < MAX_WORD_LENGTH)
//        wordLength++;
//    return word;
//   }


    public String pickGoodStarterWord() {
        return "stop";
    }
// }
