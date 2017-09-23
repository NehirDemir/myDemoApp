package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *

 */


public class App 
{

    public static void main( String[] args )
    {
                System.out.println( "Hello World!" );
    }
      public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
      }
      public static boolean searchWord(ArrayList<String> arr,String word1,String word2)
      {
         String kelime1="",kelime2="";
         kelime1 = word1 + word2;
         kelime2= word2 + word1 ;
         for(int i=0;i<arr.size;i++){     
         if(arr.get(i).equalsIgnoreCase(word1) || arr.get(i).equalsIgnoreCase(word2))
            return true;

       }
      return false;
      }

  
}
