/*
Author: Schuyler Asplin

CSCD 300 prog7

Singly Linked List Class. Lists store records.
 */


public class SLL {

    protected Node head;
    protected Node tail;


    int size = 0;

    //contructor
    public SLL() {
        head = new Node();
        tail = new Node();
        head.setNext(tail);
    }

    // add Node to a list. realized after writing that it doesnt
    // need to add at list end, before tail.
    public void insert(float id, String name){
        if (size == 0) {
            Node newNode = new Node(id, name);
            head.setNext(newNode);
            newNode.setNext(tail);

        }
        else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.getNext();
            }
            Node newNode = new Node(id, name);
            newNode.setNext(tail);
            temp.setNext(newNode);
        }
        size++;
    }

    //searches a single list for an id match, and deletes/ returns the node if
    //it exists. else, returns null. called by HashTable tableRemoveNode method
    public Node listRemoveNode(float idQuery) {
        if (size == 0) { return null; }
        else if (size == 1 && head.next.id == idQuery) {
            Node temp = head.getNext();
            head.setNext(tail);
            return temp;
        }
        else {
            Node cursor = head.getNext();
            Node cursorPrev = head;

            while (cursor != tail) {
                if (cursor.id == idQuery) { // we've found a match
                    if (cursor.next == tail) {// if cursor is last node in list
                        cursorPrev.setNext(tail);
                        size--;
                        return cursor;
                    }
                    else { // if cursor is NOT last node in list
                        cursorPrev.setNext(cursor.getNext());
                        size--;
                        return cursor;
                    }
                }

                cursor = cursor.next;
                cursorPrev = cursorPrev.next;
            }
            return null;
        }
    }


    public static void printList(SLL list){ // calls Node class print method
        if (list == null) {
            System.out.println("list is null");
            return;
        }
        else if (list.head.next == list.tail) {
            return;
        }
        Node temp = list.head.getNext();
        while(temp != list.tail){
            temp.printNode();
            temp = temp.getNext();
        }
    }


}
