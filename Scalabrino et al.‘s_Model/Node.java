public class Node {
    private int data;
    private Node previous;
    private Node next;

    Node ( int insert ) {
        this.data = insert;
        this.next = null;
        this.previous = null;
    }

    Node (  ) {
        this.previous = null;
        this.next = null;
        this.data = 0;
    }

    int getData () {
        return this.data;
    }

    int setData( int number ) {
        return this.data;
    }

    Node getPrevious () {
//        if ( this.previous != null ) {
//            System.out.println("The element before this Node is: " + this.previous.data);
//        }
        return this.previous;
    }

    Node getNext () {
//        if ( this.next != null ) {
//            System.out.println( "The element after this Node is: " + this.next.data );
//        }
        return this.next;
    }

    Node setPrevious( Node target ) {
        this.previous = target;
        return this.previous;
    }

    Node setNext ( Node target ) {
        this.next = target;
        return this.next;
    }
}
