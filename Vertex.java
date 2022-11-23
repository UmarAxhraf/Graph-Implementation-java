//package graph;

public class Vertex
{
    int num;

    Vertex next = null;

    LinkList list;

    //empty constructor
    Vertex(){}

    //data pass constructor
    Vertex(int data)
    {
        this.num = data;
    }

    @Override
    public String toString() {
        return num+"  ";
    }


}