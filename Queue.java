
/**
 * Write a description of class MyQueue here.
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class Queue<E>
{
    public Node<E> head;
    public int counterMQ; //complexity counter for MyQueue
    public int cnt;
    public Queue(){
        head = null;
    }

    /**
     * Inserts the specified element into the queue.
     * @return the value of item thats added.
     */
    public E add(E item){
        if(head == null){ // if nothing has added yet. 
            head = new Node<E>(item);
            counterMQ++;
            cnt++;
            return item;
        }else{// if the head has some value already 
            //then create one node and connect it to the head 
            Node temp = new Node<E>(item);
            temp.next = head;
            head = temp;
            counterMQ++;
            cnt++;
            return item;
        }
    }

    /**
     * Retrieves, but does not remove, the head of the
     * queue.
     * @return the value of the head queue.
     */
    public E peek(){
        if(head == null) return null; // if the head is null
        else{// checks the value at the end of linked list  
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            return (E)curr.val;
        }
    }

    /**
     * Retrieves and removes the head of the queue.
     * @return the value of removed item.
     */
    public E remove(int index){
        E vals = get(index);
        Node<E> curr = head;
        if(index == 0){
            head = head.next;
            cnt--;
            return vals;
        }
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        Node<E> curr_next = curr.next;
        curr.next = curr_next.next;
        curr_next.next = null;
        cnt--;
        return vals;
    }
    //@return the value of complexity counter for MyQueue.
    public int showCounterMQ(){ 
        return counterMQ;
    }

    public int size(){
        return cnt;
    }

    E get(int index){
        Node<E> curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
}
