//package graph;

import java.util.Scanner;

public class GraphDemo {


    static Scanner scan = new Scanner(System.in);

    public static void main(String shami[])throws Exception
    {



        System.out.print("Enter size of graph : ");
        int size  = scan.nextInt();

        Graph g = new Graph(size);

        waitScreen();


        while(true)
        {
                maintainConsole();

                System.out.print("Select Option : \n"
                                                +"1.Add vertex\n"
                                                +"2.Display\n"
                                                +"3.Depth first search\n"
                                                +"4.Breadth first search\n"
                                                +"99.Exit\n"
                                                +"Choice : ");

                int op = scan.nextInt();
                System.out.println();

                switch(op)
                {
                        case 1:
                                g.addVertex();
                                break;
                        case 2:
                                g.display();
                                break;
                        case 3:
                                g.DFSeacrh();
                                break;
                        case 4:
                                g.BFSeacrh();
                                break;
                        case 99:
                                System.out.println("Ok Bye...\n");
                                return;
                        default:
                                System.out.println("\nWrong choice...!");
                                break;

                }//switch end



                waitScreen();

		}//while loop end

    }

	//this method clears console screen and prints the header on console
	static void maintainConsole()throws Exception
	{
		//cmd command for clearing console screen
		new  ProcessBuilder ( "cmd", "/c" , "cls") .inheritIO() .start() .waitFor();

		//header line
		System.out.println("==============  Graph Demo ==============\n");
	}

	static void waitScreen()
	{
		System.out.print("\nPress enter key to continue . . .");
		scan.nextLine();
		scan.nextLine();
	}

}
