package Encode;

import java.util.ArrayList;
import java.util.Scanner;

public class Encode {
    public static <string> void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("##########                  welcome in encode program                    #############");
        ArrayList<Integer> postions = new ArrayList<Integer>();
        ArrayList<Integer> listOfLength = new ArrayList<Integer>();
        ArrayList<Character> listNextSymbol = new ArrayList<Character>();
        String word;
        int searchSize;
        int lookSize;
        System.out.println("Enter text :  ");
        word = input.next();
        System.out.println("Enter the search size:  ");
        searchSize = input.nextInt();
        System.out.println("Enter the Look a head size:  ");
        lookSize =  input.nextInt();
        int wordSize = word.length();
        for (int i = 0;i < wordSize;i++){// ( i ) is iterator always stop at the start of the look ahead buffer
            String search,look;
            if (i < searchSize)  search = word.substring(0,i);

            else  search = word.substring(i-searchSize,i);//the search size form i-searchSize to i

            if (wordSize-i < lookSize)  look = word.substring(i,wordSize);//when the look in the right side of the text

            else  look = word.substring(i,i+lookSize);//when the look in the left side or in middle of the text

            int postion = 0;
            //System.out.println(search+" -> "+look);
            for (int index = 1;index <= look.length();index++){//index 1 and <= because the last index in substring not included
                if (search.lastIndexOf(look.substring(0,index)) == -1||index==look.length()){// ||index==look.length() to collect the last index in look
                    postions.add(postion);
                    // the length of symbol we find
                    listOfLength.add(index-1);
                    listNextSymbol.add(look.charAt(index - 1));
                    i += index - 1;
                    break;
                }
                else{
                    int indexOfSymbol = search.lastIndexOf(look.substring(0,index));//index of the symbol in the search
                    postion = search.length()-indexOfSymbol;//the length between the look and the symbol
                }

            }
        }
        for (int tag=0;tag<postions.size();tag++){
            System.out.println("<"+postions.get(tag)+" , "+listOfLength.get(tag)+" , "+listNextSymbol.get(tag)+">");
        }
        System.out.println("num of tags= "+postions.size());
        System.out.print("##########                  END                    #############");
    }
    // Test case
// ABAABABAABBBBBBBBBBBBA
// 12
// 11
}
