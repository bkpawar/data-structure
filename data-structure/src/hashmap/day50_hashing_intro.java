/**
 * Hashmap is a key value pair
 */
import java.util.*;
public  class day50_hashing_intro {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static void hash_map_example(){
        map.put("India", 100);
        map.put("New India", 101);
    }
    public static void display_map(){
        //for(String myMap : map){
      //      System.out.println(myMap);
        //}
    }
    public static void main(String[]args){
        hash_map_example();
        display_map();
    }
}
