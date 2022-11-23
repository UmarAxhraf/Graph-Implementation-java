//package graph;


import java.util.Scanner;

public class Graph
{

    Scanner scan = new Scanner(System.in);

    int size;

    Vertex[] arr;

    //constructor
    Graph(int size) {
        this.size = size;

        arr = new Vertex[size];

        for(int i=0; i<arr.length; i++){
            arr[i] = new Vertex();
            arr[i].list = new LinkList();
        }

        System.out.println("\nGraph Created....");


    }


    ////////////////////////// Insertion /////////////////////////
    public void addVertex() {

        int source = getValidInput(arr.length-1, "Source");
        int dest = getValidInput(arr.length-1, "destination");


        /*      source and destination insertion Example
        *       add 3 at 2
        *       and alternatively
        *       add 2 at 3
        */

        arr[source].list.insert(dest);
        arr[dest].list.insert(source);
    }


    ////////////////////////Depth first search /////////////////////
    // The function to do DFSeacrh traversal. It uses recursive DFS()
    void DFSeacrh() {

        int start = getValidInput(arr.length-1, "starting vertex");

        System.out.println("Starting Depth first search from vertex ("+ start  +")");

        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[size];

        // Call the recursive helper function to print DFSeacrh traversal
        DFS(start, visited);

        System.out.println("");
    }

    void DFS(int num,boolean visited[])  {
        // Mark the current node as visited and print it
        visited[num] = true;
        System.out.print(num+"  ");

        // Recur for all the vertices adjacent to this vertex
        LinkList i = arr[num].list;

        Vertex current = i.head;

        while (current != i.tail )
        {
            current = current.next;
            if (!visited[current.num])
                DFS(current.num, visited);
        }
    }



    ////////////////////// Breadth first search ///////////////////////
    void BFSeacrh() {

        int start = getValidInput(arr.length-1, "starting vertex");

        System.out.println("Starting Breadth first search from vertex ("+ start  +")");

        BFS(start);

        System.out.println("");
    }

    void BFS(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[size];

        // Create a queue for BFS
        LinkList queue = new LinkList();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.insert(s);

        while (!queue.isEmpty())
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            /* Get all adjacent vertices of the dequeued vertex s
            *  If a adjacent has not been visited, then mark it
            *  visited and enqueue it
            */
            Vertex current = arr[s].list.head;

            while (current!=null)
            {
                int n = current.num;

                if (!visited[n])
                {
                    visited[n] = true;
                    queue.insert(n);
                }

                current = current.next;

            }
        }
    }




    ///////////////////////// Display ////////////////////////////
    public void display() {

        if(isEmpty()){
            System.out.println("Graph is empty...");
            return;
        }

        for(int i=0; i<arr.length; i++)
        {
            System.out.print( i +" -> ");
                arr[i].list.display();
        }
    }

    ////////////////////// check graph is empty or not //////////////////

    boolean isEmpty(){


        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].list.isEmpty())
                return false;

        }

        return true;
    }



    ////////////////////// Validation of input ////////////////////////
    int getValidInput(int high,String name){

        int input = -1;

        while(true){

            System.out.print("Enter value of "+name+" : ");
            input = scan.nextInt();

            if(input<=high && input>=0)
                 break;
            else
                System.out.print("Wrong input....RE-");
        }

        return input;

    }



}