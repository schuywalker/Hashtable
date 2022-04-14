/*
Author: Schuyler Asplin

CSCD 300 prog7

HashChain class holds main method and hash function method
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class HashChain {
    public static void main(String[] args){



        HashTable hashTable = new HashTable(5);

//  ~~~~~~~~ hash and enter values from map to hash table
    File file = new File(args[0]);


    try {
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            //split file line
            String[] line = scanner.nextLine().split(",",2);
            float id = Float.parseFloat(line[0]);
            String value = line[1];
            // hash id using hash function to which list it belongs to in the hashTable
            int bucket = hash(id);
            //insert node into the list that it's table location points to
               SLL temp = hashTable.table[bucket];
               temp.insert(id, value);
        }

    scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File Not Found.");
    }

    // ~~~~~~~~~~~~~~~~ menu ~~~~~~~~~~~~~~~~
        displayMenu();

        try {
            Scanner input = new Scanner(System.in);

            String choice = input.next();

            while (!choice.equals("5")) { // 5 ends while loop and program
                if (choice.equals("1")){ // update name if id exists, if not insert as new node
                    System.out.println("Input the student id: ");
                    float tempId = input.nextFloat();
                    System.out.println("Input the student name: ");
                    String tempName = input.next();

                    try {
                        hashTable.searchId(tempId).setName(tempName);
                        System.out.println("The student was exiting and the record has been updated.");

                    } catch (NullPointerException e) {
                        hashTable.table[hash(tempId)].insert(tempId, tempName);
                        System.out.println("The new student has been added successfully.");
                        //hashTable.printTable();
                    }
                }
                else if(choice.equals("2")){  // delete
                    System.out.println("Input the student id: ");

                        Node deleteStudent = hashTable.tableRemoveNode(input.nextFloat());
                        if (deleteStudent == null) { System.out.println("No such student exists."); }
                        else {
                            System.out.println("The student has been deleted successfully.");
                        }
                        //hashTable.printTable();


                    }
                else if(choice.equals("3")){ // search for student by id
                        System.out.println("Input the student id: ");
                        Node student = hashTable.searchId(input.nextFloat());
                        if (student == null) {
                            System.out.println("No such student exists.");
                        }
                        else {
                            System.out.println("Student id:"+student.id + "Student name:"+student.name);
                        }
                }
                else if(choice.equals("4")){ // print table
                    hashTable.printTable();
                }

                displayMenu();
                choice = input.next();
            }
        } catch (Exception e) {
            System.out.println("exception e caught");
        }



    }
    public static void displayMenu(){
        System.out.println("\nChoose one of the following options");
        System.out.println("===================================");
        System.out.println("1) Insert/ Update a new student record ");
        System.out.println("2) delete a student record");
        System.out.println("3) search for a student record");
        System.out.println("4) print all the student records");
        System.out.println("5) quit");
        System.out.println("\nYour choice: ");
    }

    public static int hash(float x){
        return (int)(((7*x) + 29) % 5);

    }
}
