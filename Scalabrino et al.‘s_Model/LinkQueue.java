public class LinkQueue {
    private static Node front= new Node();
    private static Node rear = new Node();
    private static int size = 0;
    public static void enqueue ( int insertion ) {
        Node insert = new Node ( insertion );
        if ( isEmpty() ) {
            front = insert;
        }// If there is no element in the array...

        rear.Next = insert;
        rear = insert;//Insert the node

        size++;//Change the size.

    }

    public static int dequeue (  ) {
        int turn = 0;
        if ( size > 0 ) {
            turn = front.Data;
            front = front.Next;
            size--;
        }
        return turn;
    }

    public static int front(  ) {
        return front.Data;
    }


    public static Boolean isEmpty(  ) {
        return size == 0;
    }

    public static int rear(  ) {
        return rear.Data;
    }

    public static int size(  ) {
        return size;
    }

    public static void Print_Q (  ) {
        Node current = new Node();
        current = front;
        System.out.println( "The size of the Queue is " + size );
        System.out.println("The Queue is like:");
        if ( isEmpty() ) {System.out.println("There is no element in the Queue!");}
        while ( current != null ) {
            System.out.print( current.Data + ", ");
            current = current.Next;
        }
        System.out.println();
    }

}
