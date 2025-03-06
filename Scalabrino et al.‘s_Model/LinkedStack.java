public class LinkedStack {
    private static Node top = new Node();
    private static int size = 0;

    protected static int size(){
        return size;
    }

    protected static boolean isEmpty(){
        return size == 0;
    }

    protected static int top(){
        return top.data;
    }

    protected static void push(int insert){
        Node insertion = new Node(insert);
        if ( size != 0  ){
            insertion.next = top;
        }
        top = insertion;
        size++;
    }

    protected static int pop(){
        int record = 0;
        if ( size > 0 ) {
            record = top.data;
            top = top.next;
            size--;
        }

        return record;
    }

    protected static void Print_List(){
        Node current = top;
        System.out.println("The list is like below...");
        if ( isEmpty() ) {
            System.out.println("There is no element in the list!");
        }
        System.out.println( "The size of the list is " + size );
        for ( int i = 0; i < size && current != null; i++ ) {
            System.out.print( current.data + ", " );
            current = current.next;
        }

        System.out.println();
    }
}
