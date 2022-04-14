/*
Author: Schuyler Asplin

CSCD 300 prog7

HashTable is the class for the array of Singly Linked Lists.
Array holds pointers to lists which hold student records as Nodes
 */


public class HashTable {

    int size;
    protected SLL[] table;

    //constructor

    public HashTable(int table_size){
        size = 0;
        table = new SLL[table_size];
        for (int i = 0; i < table_size; i++){
            table[i] = new SLL();
        }
    }

    // methods
    public Node searchId(float idQuery){
        for (int i = 0; i < table.length; i++){
            Node temp = table[i].head;
            while (temp != null){
//                int safety = 0; /// these lines for preventing infinite loop
//                safety++;
//                if (safety > 15) {
//                    System.out.println("15 nodes in list? uh oh");
//                    break;
//                }
                if (temp.id == idQuery) {
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }
    public Node searchName(String nameQuery){
        for (int i = 0; i < table.length; i++){
            Node temp = table[i].head;
            while (temp != null){
//                int safety = 0; /// these lines for preventing infinite loop
//                safety++;
//                if (safety > 15) {
//                    System.out.println("?");
//                    break;
//                }

                if (temp.name.equals(nameQuery)) {
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public Node tableRemoveNode(float id){ // calls SLL listRemoveNode
        for (int i = 0; i < table.length; i++){
            Node temp = table[i].listRemoveNode(id);
            if (temp != null && temp.id == id) {
                return temp;
            }
        }
        return null;
    }

    public void printTable(){ // calls SLL class print method
        for (int i = 0; i < table.length; i++){
            SLL.printList(table[i]);
        }
    }


}
