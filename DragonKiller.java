/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dragonkiller;

/**
 *
 * @author arnol
 */
//Create a program using a console application name "DragonKiller". 
//The program should ask the user to enter his/her name and surname. 
//Create a method name RemoveSpace() to remove space between the name and the surname entered by the user. 
//Count the number of characters within the newly created string (nameSurname). 
//The total number of characters (Name and Surname) should be used as the size of your arrayDragon (type integer). 
//Populate your arrayDragon with a series of odd random numbers between 10 and 50.
//Display all arrayDragon elements and their corresponding indexes before executing. 
//The insertionSort method allows the user to enter a value from the arrayDragon element 
//to search for and be removed (Killed).
//• Loop through the array until you find the value 
//(Use the binarySearch to locate the value with in your array) and kill that value from the arrayDragon. 
//By replacing the value findDragon with a Zero (0)
//• Print out arrayDragon with the killed element.
//NB
//Use NetBeans to create this program and submit all screenshots of your program output and the java code

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DragonKiller {
    public static void printArray(int[] array, String boxText) {
        System.out.println("------------------------");
        System.out.println(boxText);
        int x = 0;
        for (int i : array) {
            System.out.println("arrayDragon[" + x + "] = " + i);
            x++;
        }
        System.out.println("------------------------\n");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Gets name and surname as text input and removes all the white spaces
        System.out.print("Please enter your name and surname : ");
        String name;
        name = scanner.nextLine().trim();

        // Stores the string in a variable
        String nameSurname = name.replace(" ", "");

        // Creates and stores length
        int sizeOfFullName = nameSurname.length();
        System.out.println(nameSurname + " : has a length of [" + sizeOfFullName + "] characters");
        int[] arrayDragon = new int[sizeOfFullName];

        // Loops through each item in the array
        Random random = new Random();
        for (int i = 0; i < sizeOfFullName; i++) {
            int randomInt = random.nextInt(40);
            arrayDragon[i] = randomInt + 10;
        }

        // Display array to user
        System.out.println(Arrays.toString(arrayDragon));
        Arrays.sort(arrayDragon);

        // User input for number
        System.out.print("Please choose a number in the array: ");
        int getNum = scanner.nextInt();
        int index = Arrays.binarySearch(arrayDragon, getNum);

        // Make sure user guessed number from array
        if (index < 0) {
            System.out.println("The array does not have such a value. Program will now close");
        } else {
            arrayDragon[index] = 0;
            printArray(arrayDragon, "Sorted arrayDragon with removed item");
            System.out.println("The number " + getNum + " was removed at index=[" + index + "]");
        }
    }
}