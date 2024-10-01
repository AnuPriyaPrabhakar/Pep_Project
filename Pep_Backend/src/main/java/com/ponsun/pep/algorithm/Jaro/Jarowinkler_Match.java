package com.ponsun.pep.algorithm.Jaro;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
public class Jarowinkler_Match {
    public static double getJarowinklerMatching(String nametest1, String nametest2) {
        JaroWinklerSimilarity jaroWinkler = new JaroWinklerSimilarity();


        String  name1=removeDuplicateWords(nametest1);
        String name2=removeDuplicateWords(nametest2);

        // Tokenize the names by spaces
        ArrayList<String> token1 = tokenizeString(name1);
        ArrayList<String> token2 = tokenizeString(name2);


        int c=0;double sim=0;
        ArrayList<Double>similarity =new ArrayList<Double>();
        for(int n1=0;n1<token1.size();n1++) {
            for(int n2=0;n2<token2.size();n2++) {
                sim= jaroWinkler.apply(token1.get(n1),token2.get(n2));
                similarity.add(sim);
            }
        }
        double[] matchingper=Average(similarity);
        double finalmatchingPer=matchingper[2]*1e2;
//        System.out.println("similarity:"+similarity);

//        System.out.println("similarity:"+Arrays.toString(matchingper));
//        System.out.println("Final matching score between  "+nametest1+" and  "+nametest2+" :" +finalmatchingPer);
        return finalmatchingPer;
    }





    public static double[] Average(ArrayList<Double> numbers) {
        // Calculate the sum of all elements in the ArrayList
        double sum_above80 = 0;int c_above80=0;   double sum_below80 = 0;int c_below80=0;
        for (double number : numbers) {
            if(number==0) {
                continue;
            }else if(number>=0.8) {
                sum_above80 += number;
                c_above80++;
            }  else {
                sum_below80+=number;
                c_below80++;
            }
        }
        double avg_above80=sum_above80/c_above80;
        double avg_below80=sum_below80/c_below80;
        double[] matchingPer =new double[3];
        matchingPer[0]=avg_above80;
        matchingPer[1]=avg_below80;
        matchingPer[2]=(avg_below80+avg_above80)/2;


        return matchingPer;
    }



    public static String removeDuplicateWords(String str) {
        str=str.toLowerCase();
        String le = str.replaceAll("^\\s+", "");
        str = le.replaceAll("\\s+$", "");        String[] words = str.split("\\s+"); // Split the string into words
        Set<String> uniqueWords = new LinkedHashSet<>(); // Use LinkedHashSet to maintain insertion order

        for (String word : words) {
            uniqueWords.add(word); // Add each word to the set
        }

        return String.join(" ", uniqueWords); // Join the words back into a single string
    }
    // Method to tokenize a string by spaces
    public static ArrayList<String> tokenizeString(String str) {
        String[] tokens;
        if (str.contains(" ")) { // If the string contains spaces, split by space
            tokens = str.split(" ");
        } else { // Otherwise, return the single string as an array
            tokens = new String[] { str };
        }
        return new ArrayList<>(Arrays.asList(tokens));
    }
}