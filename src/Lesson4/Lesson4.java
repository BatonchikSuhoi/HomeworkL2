package Lesson4;

import java.util.*;

public class Lesson4 {

    public static void main(String[] args) {
        bubbleSortTest();
        //myArrayTest();
        //arrayTest();
        //linkedListTest();
        //hashMapTest();
    }

    private static void bubbleSortTest(){
        MyArrayList<String> myArrayList = new MyArrayList<String>();

        myArrayList.add("Alex");
        myArrayList.add("Maxon");
        myArrayList.add("Jeremy");
        myArrayList.add("William");
        myArrayList.add("Kobe");
        myArrayList.add("German");
        myArrayList.add("Bro");


        for (int i = 0; i < myArrayList.size(); i++){
            System.out.println(myArrayList.get(i) + "   " + myArrayList.get(i).hashCode());
        }

        MyArrayList.staticBubbleSort(myArrayList);
        //myArrayList.bubbleSort();
        System.out.println(" ");
        System.out.println("Sorted list");

        for (int i = 0; i < myArrayList.size(); i++){
            System.out.println(myArrayList.get(i) + "   " + myArrayList.get(i).hashCode());
        }

    }

    private static void myArrayTest(){
        MyArrayList<String> myStringArray = new MyArrayList<String>();

        ArrayList<String> listString = new ArrayList<String>();

        for (int i = 0; i < 11; i++){
            String s = ("String number " + i);
            listString.add(s);
        }

        MyArrayList<String> myStringArray2 = new MyArrayList<String>(listString);

        for (int i = 0; i < myStringArray2.size(); i++){
            System.out.println(myStringArray2.get(i));
        }

        for (int i = 0; i < 10; i++){
            String s = "String number " + i;
            myStringArray.add(i,s);
        }
        myStringArray.add(myStringArray.size()/2,"Add string to middle");
        myStringArray.add(0,"Add string to top");
        myStringArray.remove(1);
        myStringArray.addAll(List.of("String number 77", "String number 99"));
        myStringArray.add(myStringArray.size(),"Add string to end");
        myStringArray.removeAll(List.of("String number 7", "String number 9"));

        for (int i = 0; i < myStringArray.size(); i++){
            System.out.println(myStringArray.get(i));
        }
    }

    private static void arrayTest(){
        ArrayList<String> listString = new ArrayList<String>();

        for (int i = 0; i < 11; i++){
            String s = ("String number " + i);
            listString.add(s);
        }
        listString.add(listString.size()/2,"Add string to middle");
        listString.add(0,"Add string to top");
        listString.add(listString.size(),"Add string to end");
        listString.remove(1);
        listString.removeAll(List.of("String number 7", "String number 9"));

        for (String s : listString) {
            System.out.println(s);
        }
        System.out.println(listString.size());
    }

    private static void linkedListTest(){
        LinkedList<String> linkedList = new LinkedList<String>();

        for (int i = 0; i < 10; i++){
            String s = ("String number " + i);
            linkedList.add(s);
        }
        linkedList.add(linkedList.size()/2, "Add string to middle");
        linkedList.addFirst("Add string to top");
        linkedList.addLast("Add string to end");
        linkedList.remove(2);
        linkedList.removeAll(List.of("String number 7", "String number 9"));

        for (String s : linkedList) {
            System.out.println(s);
        }

    }

    public static void hashMapTest(){
        HashMap<String, Integer> hashMap = new HashMap<String , Integer>();

        for (int i = 0; i < 10; i++){
            String k = ("Key"+i);
            hashMap.put(k,i);
        }
        hashMap.remove("Key5");
        hashMap.remove("Key6");

        for (Map.Entry<String, Integer> m : hashMap.entrySet()){
            System.out.println(m);
        }
    }

}
