public class DL_List {

        private Node front = new Node();
        private Node rear = new Node();
        private int size = 0;

        DL_List () {

        }


    protected boolean isEmpty(){
        return size == 0;
    }
    protected int first(){
        if ( isEmpty() ) {
            System.out.println("Unavailable");
            return 0;
        }
        return front.getData();
    }

    protected int last(){
        if ( isEmpty() ) {
            System.out.println("Unavailable");
            return 0;
        }
        return rear.getData();
    }

    protected Node position( int point ) {
        if ( point >= size ) {
            System.out.println("Unavailable");
            return null;
        }

        Node current = front;
        for (int i = 0; i < point; i++) {
            current = current.getNext();
        }

        return current;
    }

    protected Node insertFirst( int element ) {
        Node insertion = new Node(element);
        if ( isEmpty() ) {
            front = insertion;
            rear = insertion;
        } else {
            insertion.setNext(front);
            front.setPrevious(insertion);
            front = insertion;
        }

        System.out.println();
        size++;
        System.out.println( "The inserted element is " + element + " at the head." );

        return insertion;
    }

    protected Node insertLast( int number ) {
        Node insertion = new Node(number);
        if ( isEmpty() ) {
            front = insertion;
            rear = insertion;
        } else {
            insertion.setPrevious(rear);
            rear.setNext(insertion);
            rear = insertion;
        }

        System.out.println();
        size++;
        System.out.println( "The inserted element is " + number + " at the end." );

        return insertion;
    }

    protected void insertBefore( Node pos, int element ) {
        if ( pos.getPrevious() == null ) {
            insertFirst(element);
        } else {

            Node insertion = new Node(element);
            insertion.setNext(pos);
            insertion.setPrevious(pos.getPrevious());
            (pos.getPrevious()).setNext(insertion);
            pos.setPrevious(insertion);

            System.out.println();
            size++;
            System.out.println( "The inserted element is " + element + " before the element " + pos.getData() );

        }

    }

    protected void insertAfter( Node pos, int number ) {
        if ( pos.getNext() == null ) {
            insertLast(number);
        } else {

            Node insertion = new Node(number);
            insertion.setNext(pos.getNext());
            insertion.setPrevious(pos);
            (pos.getNext()).setPrevious(insertion);
            pos.setNext(insertion);

            System.out.println();
            size++;
            System.out.println( "The element inserted is " + number + " after the element " + pos.getData() );

        }
    }

    protected int getSize(){
        return size;
    }

    protected int remove( Node pos ) {
        int re = pos.getData();

        System.out.println();
        System.out.println( "The element removed is " + re );

        if ( pos.getPrevious() == null || pos.getNext() == null ) {
            if (pos.getPrevious() == null) {
                front = front.getNext();
                if ( size > 1 ) {
                    front.setPrevious(null);
                    System.out.println( "The element is at the head, and it is linked to the element " + front.getData() );
                }
            }
            if (pos.getNext() == null) {
                rear = rear.getPrevious();
                if ( size > 1 ) {
                    rear.setNext(null);
                    System.out.println("The element is at the end, and it is linked to the element " + rear.getData());
                }
            }

            if ( pos.getPrevious() == null && pos.getNext() == null ) {
                System.out.println("There is only one element in the List, and now it has been removed.");
            }
            size--;
            return re;
        }

        (pos.getPrevious()).setNext(pos.getNext());
        (pos.getNext()).setPrevious(pos.getPrevious());
        System.out.println( "The removed element is between " + (pos.getPrevious()).getData() + " and " + (pos.getNext()).getData() );

        size--;
        return re;
    }

    protected void print_List(){
        System.out.println("The list is like:");
        if ( isEmpty() ) {
            System.out.println("There is no element in the List!");
            return;
        }
        Node current = front;
        for ( int i = 0; i < size; i++ ) {
            System.out.print( current.getData() + ", " );
            current = current.getNext();
        }
        System.out.println();
    }


}
