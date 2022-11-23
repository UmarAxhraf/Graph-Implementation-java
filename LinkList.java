//package graph;

public class LinkList
{

    Vertex head = null;
    Vertex tail = null;


    public void insert(int data)
    {
        Vertex newNode = new Vertex(data);

        if (head == null)
        {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    //Retrieves and removes the head (first element) of this list.
    public Integer poll(){

        int ret = head.num;

        if(head == null)
            return null;

        Vertex temp = head;

        head = head.next;

        return ret;


    }


    public void display()
    {
        Vertex temp = head;

        while(temp!=null)
        {
            System.out.print(temp);

            temp = temp.next;
        }
        System.out.println();

    }

    boolean isEmpty(){

        return head == null;

    }
}