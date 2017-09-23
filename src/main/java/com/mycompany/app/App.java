package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spark.template.mustache.MustacheTemplateEngine;


import spark.ModelAndView;

import java.util.*;
/**
 * Hello world!
 *

 */


public class App 
{
 
    
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
           if (arr == null) return false;
         String kelime1="",kelime2="";
         kelime1 = word1 + word2;
         kelime2= word2 + word1 ;
         for(int i=0;i<arr.size();i++){     
         if(arr.get(i).equalsIgnoreCase(word1) || arr.get(i).equalsIgnoreCase(word2))
            return true;

       }
      return false;
      }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");
       
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            //int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            String line=sc1.next().replaceAll("\\s","");
            inputList.add(line);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.searchWord(inputList,input1,input2);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}


  

