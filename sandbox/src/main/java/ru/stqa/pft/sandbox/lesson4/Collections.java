package ru.stqa.pft.sandbox.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String[] args){
        String[] languages = {"Java","C#","Phyton","PHP" };

        /*String[] languages = new String[4];
        languages[0] = "Java";
        languages[1] = "C#";
        languages[2] = "Phyton";
        languages[3] = "PHP";*/

       // for (int i = 0; i < languages.length; i++)


        for (String l : languages)
        {
            System.out.println("Я хочу выучить " + l);
        }


        List<String> langs = Arrays.asList("Java","C#","Phyton");
       /* List<String> langs = new ArrayList<String>();
        langs.add("Java");
        langs.add("C#");
        langs.add("Phyton");
         for (int n = 1; n < langs.size(); n++)
        {
            System.out.println("Я хочу выучить " + langs.get(n) + "\n");
        }
        Если тип элемента списка не указан, в перечислении используется Object*/
        for (String l : langs)
        {
            System.out.println("Я хочу выучить " + l + "\n");
        }


    }
}
