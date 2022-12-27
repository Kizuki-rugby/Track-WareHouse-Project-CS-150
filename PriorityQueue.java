
/**
 * Write a description of class PriorityQueue here.
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class PriorityQueue <E> {
    public Node<E> head;
    public int cnt;
    public PriorityQueue(){
        head = null;
    }

    /**
     * Inserts the specified element into the queue.
     * @return the value of item thats added.
     */
    public E add(E item){
        if(head == null){ // if nothing has added yet. 
            head = new Node(item);
            cnt++;
            return item;
        }else{// if the head has some value already 
            cnt++;
            Node<E> first = new Node(item);
            Node<E> temp = new Node();
            first.next = head;
            head = first;
            Node<E> curr = head;
            if(curr.next.next == null){
                if ((int)curr.val  > (int)curr.next.val ) { 
                    temp.val = curr.val; 
                    curr.val = curr.next.val; 
                    curr.next.val = temp.val;
                } 
            }else{
                while(curr.next.next != null){
                    if ((int)curr.val  > (int)curr.next.val ) { 
                        temp.val = curr.val; 
                        curr.val = curr.next.val; 
                        curr.next.val = temp.val;
                    } 
                    curr = curr.next;
                }
                if ((int)curr.val  > (int)curr.next.val ) { 
                    temp.val = curr.val; 
                    curr.val = curr.next.val; 
                    curr.next.val = temp.val;
                } 
            }
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
    public E remove(){
        E result;
        if(head == null) return null;
        else if(head.next == null){// if the queue is only consisted with one node 
            result = (E)head.val;
            head = null;
            cnt--;
            return result;
        }else{ // if there are more than 1 node.
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            result = (E)curr.val;
            curr = head;
            while(curr.next.next != null){
                curr = curr.next;
            }
            curr.next = null;
            cnt--;
            return result;
        }
    }

    public int size(){
        return cnt;
    }

    public double getX(Warehouse warehouse){
        return warehouse.getX();
    }

    public double getY(Warehouse warehouse){
        return warehouse.getY();
    }

}
