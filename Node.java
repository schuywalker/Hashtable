/*
Author: Schuyler Asplin

EWU CSCD 300 Data Structures prog7
Professor Bojian Xu 

Node class. Each node is either a head/tail dummy node, or it
represents a student record.
 */

public class Node {

    //data fields
    protected Node next = null;
    protected float id;
    protected String name;

    //constructors
    public Node(){}

    public Node(float id, String name){
        this.id = id;
        this.name = name;
    }

    //methods
    public void printNode(){ System.out.println(this.id + "," + this.name); }
    public String getName(){ return this.name; }
    public Node getNext(){ return this.next; }
    public void setNext(Node next){ this.next = next; }
    public void setId(float id){ this.id = id; }
    public void setName(String name){ this.name = name; }


}
