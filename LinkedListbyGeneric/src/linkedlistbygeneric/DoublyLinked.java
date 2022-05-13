
package linkedlistbygeneric;

import java.util.LinkedList;
import javax.swing.text.html.HTMLEditorKit;

public class DoublyLinked<T> {
    
    private Node<T>head; // The First reference to the First Node in Linked List
    private  Node<T>tail;// The End Reference Null 
    private Node <T>prev;
    private int size=0;
    public void addByIndexs(T value,int index)
    {
        if(index>=0&&index<=size)
        {
            if(index==0)add_First(value);
            else if(index==size)add_Last(value);
            else{
                Node<T> newNode=new Node<>(value);
                Node curr=head;
                int i=0;
                while (i!=index&&curr!=null)
                {
                    if(i==index-1)
                    {
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
    public void add_Last(T element)
    {
        Node<T> newNode=new Node<>(element);
       if(head==null)
       {
           head=tail=newNode;
       }
       else{
           tail.setNext(newNode);
           tail=newNode;
           tail.setNext(head);
       }
      size++;
    }
    public void add_First(T element)
    {
        Node <T> newNode=new Node<>(element);
        if(head==null)
        {
            head=tail=newNode;
        }
        else
        {
            newNode.setNext(head);
            head=newNode;
            head.setNext(tail);
        }
        size++;
    }
   
    public void addByIndex(T value,int index) // 2:2
    {
        if(index>=0&&index<=size)
        {
            if(index==0)add_First(value);
           else if(index==size)add_Last(value);
           else{
               Node <T> newNode=new Node<>(value);
               Node <T>curr=head;
                int i=0;
                while(i!=index&&curr!=null)
                {
                    if(i==index-1)
                    {
                        newNode.setNext(curr.getNext());
                        curr.setNext(newNode);
                    }
                    curr=curr.getNext();
                    i++;
                }
                size++;
           }
        }
    }
    public void deleteByIbndex(int index) 
            // if Linked List Empty
            //if index>=0 , index<size
            // if The delete on the First element index=0 then head=head.next;
            //if The delete on the last element index=size-1;
    {
       if(index>=0&&index<size)
       {
           if(index==0)
           {
               head=head.getNext();// Deleting the First element
           }else if(index==size-1) //The Last element
           {
               int i=0;
               Node<T> current=head;
               while (current!=null&& i!=index)
               {
                   if(i==index-1)
                   {
                       tail=current;
                       tail.setNext(null);
                   }
                    i++;
                   current=current.getNext();
               }
           }else 
           {
               int i=0;
               Node<T>curr=head;
               while (i!=index&&curr!=null)
               {
                   if(i==index-1){
                   curr.setNext(curr.getNext().getNext());
                   }
                   curr=curr.getNext();
                   i++;
               }
           }
           size--;
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
    public void delete_First()
    {
        deleteByIbndex(0);
    }
    public void delete_Last()
    {
        deleteByIbndex(size-1);
    }
    
    public static void main(String[] args) 
    {
//        Linked<Integer> link=new Linked<>();
//       link.add_Last(1);
//       link.add_Last(2);
//       link.add_First(0);
//       link.add_Last(3);
//       link.addByIndex(2, 4);
//        System.out.println(link.toString());
//        Linked<String> ll=new Linked<>();
//        ll.add_First("MOhamed");
//        ll.add_First("BOB");
       DoublyCircularLinked<Integer> ls=new DoublyCircularLinked<>();
       ls.add_last(5);
       ls.add_last(6);
       ls.add_last(7);
       ls.addByIndex(8,3);
        System.out.println(ls.toString()+" ");
    }
}
