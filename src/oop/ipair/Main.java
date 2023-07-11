package oop.ipair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IPair> list = new ArrayList<>(){
            {
                add(new IPair(3, 6));
                add(new IPair(2, 1));
                add(new IPair(5, 9));
                add(new IPair(4,3));
                add(new IPair(3, 4));
            }
        };

        for(IPair pair:list){
            if(pair.equals(new IPair(3, 4))){
                System.out.println("Yes");
            }
        }
    }
}
