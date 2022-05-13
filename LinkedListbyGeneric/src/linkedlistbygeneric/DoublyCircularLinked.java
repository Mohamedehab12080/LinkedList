
package linkedlistbygeneric;

public class DoublyCircularLinked <T>{
    private Node<T>head; // The First reference to the First Node in Linked List
    private  Node<T>tail;// The End Reference Null 
    private int size=0;
    
    public void add_last(T value)
    {
        Node <T> newNode=new Node<>(value);
        if(head==null)
        {
            head=tail=newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail=newNode;
            tail.setNext(head);
            head.setPrev(tail);
        }
        size++;
    }
      public void add_First(T value)
    {
        Node <T> newNode=new Node<>(value);
        if(head==null)
        {
            head=tail=newNode;
        }
        else
        {
            newNode.setNext(head);
            head=newNode;
            tail.setNext(head);
            head.setPrev(tail);
        }
        size++;
    }
            public void addByIndex(T value,int index)
            {
                if(index>=0&&index<=size)
                {
                    if(index==size)add_last(value);
                    else{
                        Node<T> newNode=new Node<>(value);
                        Node curr=head;
                        int i=0;
                        while (i!=index&&curr!=null)
                        {
                            if(i==index-1)
                            {
                                newNode.setPrev(curr);
                                newNode.setNext(curr.getNext());
                                curr.setNext(newNode);
                            }
                            curr=curr.getNext();
                            i++;
                        }
                    }
                    size++;
                }
            }
             @Override
    public String toString()
    {
        String s="";
        Node<T> current=head;
        while (current!=null)
        {
            s+=current.getData()+" ";
            current=current.getNext();
        }
        return s;
    }
}
