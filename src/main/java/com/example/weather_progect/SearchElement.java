package com.example.weather_progect;

import java.util.ArrayList;

public class SearchElement {

    public static ArrayList<String> num = new ArrayList<>();
    public static ArrayList<Double> num_2 = new ArrayList<>();
    public SearchElement(String arr)
    {
        char[] charArray = arr.toCharArray();

        String s = "";

        for(int i = 0; i < charArray.length; i++)
        {
            try {

                if(charArray[i] == ',' || charArray[i] == '}')
                {
                    num.add(s);
                    s = "";
                    continue;
                }
                else if (charArray[i] == '.')
                {
                    s+=".";
                }
                else
                {
                    int num_1 = Integer.parseInt (String.valueOf(charArray[i]));
                    String str=String.valueOf(num_1);
                    s+=str;
                }

            }
            catch (NumberFormatException e)
            {

            }

        }

        get_double();

    }

    public void get_double()
    {
        for(String person : num){

            Double i = Double.parseDouble(String.valueOf(person));

            num_2.add(i);

        }
    }
    public void Clear()
    {
        num.clear();
        num_2.clear();
    }


    public double get_element(int i)
    {
        return num_2.get(i);
    }
}
