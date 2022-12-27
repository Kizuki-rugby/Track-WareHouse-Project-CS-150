
/**
 * Write a description of class LinkedList here.
 *
 * @author Kizuki Koyasu
 * @version Ver.1
 */
public class LinkedList<E>
{
    Node head;
    E val;
    public LinkedList(){
        head = null;
        val = null;
    }

    /**
     * this method will add new Linked list at the end of the linked list 
     * @param int e
     */
    public void add(int e){
        if(head == null){
            head = new Node(e);
        }else{
            Node curr = head; 
            while(curr.next != null) { 
                curr = curr.next;
            }
            curr.next = new Node(e); 
        }
    }

    /**
     * This method will add a Node to specified index with a specified value 
     * @param int index, int e
     */
    public void add(int index, int e){
        if(index == 0){
            Node temp = head;
            head = new Node(e);
            head.next = temp;
        }else{
            Node curr = head;
            int i = 0;
            while(i != index-1){
                curr = curr.next;
                i++;
            }
            Node temp = curr.next.next;
            curr.next = new Node(e);
            curr.next.next = temp;
        }

    }

    /**
     * This method will get the value of linked list using index parameter.
     * @param int index
     * @return returns to the value of number that index specified. 
     */
    public E get(int index){
        Node curr = head;
        int i = 0;
        while(i != index){
            curr = curr.next;
            i++;
        }
        return (E)curr.val;
    }

    /**
     * clear the entire linked list. 
     * once the head is assigned to be null, the rest will be collected by garbage collector.
     */
    public void clear(){
        head = null;
    }

    /**
     * @return returns true if the head is equal to null, otherwise, it returns to false.
     */
    public boolean isEmpty(){
        if(head == null) return true;
        else return false;
    }

    /**
     * this will remove the index of Node
     * basically this can be done by shifting an arror to another node and that without an arrow will be collected by garbage collecter
     * @param int index
     * @return returns to an integer that has been removed
     */
    public E intRemove(int index){
        Node curr = head;
        int i = 0;
        while(i != index-1){
            curr = curr.next;
            i++;
        }
        E temp = (E)curr.next.val;
        curr.next = curr.next.next;
        return temp;
    }

    /**
     * @return returns to the length of linked list using a counter variable decleared within a method. 
     */
    public int size(){
        Node curr = head;
        int counter = 0;
        if(curr == null){
            counter = 0;}
        else{
            counter = 1;
            while(curr.next != null){
                counter++;
                curr = curr.next;
            }
        }
        return counter;
    }

    /**
     * This method will not be used for linked list.
     */
    public int arraySize(){
        return -1; 
    }

    /**
     * goes through entire linked list and convert the values to string 
     * @return convert values of nodes to string.
     */
    public String toString(){
        Node curr = head;
        String str = "";
        String add = "";
        while(curr != null){
            add = String.valueOf(curr.val) + " ";
            str = str+add;
            curr = curr.next;
        }
        return str;
    }

}

