public class Linked_Bucket {

        private Node front = new Node();
        private Node rear = new Node();
        private int size = 0;



    protected boolean isEmpty(){
        return size == 0;
    }
    protected int first(Linked_Bucket k){
        if ( isEmpty() ) {
            System.out.println("Unavailable");
            return 0;
        }
        return front.data;
    }

    protected int last(){
        if ( isEmpty() ) {
            System.out.println("Unavailable");
            return 0;
        }
        return rear.data;
    }

    protected int position( int point ) {
        if ( point >= size ) {
            System.out.println("Unavailable");
            return 0;
        }

        Node current = front;
        for (int i = 0; i < point; i++) {
            current = current.next;
        }

        return current.data;
    }

    protected void insertFirst( int element ) {
        Node insertion = new Node(element);
        if ( isEmpty() ) {
            front = insertion;
            rear = insertion;
        } else {
            insertion.next = front;
            front.previous = insertion;
            front = insertion;
        }

        size++;
    }

    protected void insertLast( int number ) {
        Node insertion = new Node(number);
        if ( isEmpty() ) {
            front = insertion;
            rear = insertion;
        } else {
            insertion.previous = rear;
            rear.next = insertion;
            rear = insertion;
        }

        size++;
    }

    protected void insertBefore( int element, int pos ) {
        if ( pos == 0 ) {
            insertFirst(element);
        } else if ( pos >= size ) {
            System.out.println("Inserting at the end...");
            insertLast(element);
        } else {
            Node current = front;
            for ( int i = 0; i < pos; i++ ) {
                current = current.next;
            }

            Node insertion = new Node(element);
            insertion.next = current;
            insertion.previous = current.previous;
            current.previous.next = insertion;
            current.previous = insertion;

            size++;
        }

    }

    protected void insertAfter( int number, int pos ) {
        if ( pos >= size ) {
            System.out.println("Inserting at the end...");
            insertLast(number);
        } else {
            Node current = front;
            for ( int i = 0; i < pos; i++ ) {
                current = current.next;
            }

            Node insertion = new Node(number);
            insertion.next = current.next;
            insertion.previous = current;
            current.next.previous = insertion;
            current.next = insertion;
        }

        size++;
    }

    protected int getSize(){
        return size;
    }

    protected int remove( int pos ) {
        if ( isEmpty() ) {
            System.out.println("No element in the list!");
            return 0;
        }

        if ( size == 1 ) {
            int re = front.data;
            front =null;
            rear = null;
            System.out.println("There is no element in the list anymore." );
            size--;
            return re;
        }

        if ( pos == 0 ) {
            int re = front.data;
            front = front.next;
            front.previous = null;
            size--;
            return re;
        }
        if ( pos >= size - 1 ) {
            int re = rear.data;
            rear = rear.previous;
            rear.next = null;
            size--;
            return re;
        }

        Node current = front;
        for ( int i = 0; i < pos; i++ ) {
            current = current.next;
        }

        int re = current.data;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return re;
    }

    protected void print_List(){
        System.out.println("The list is like:");
        Node current = front;
        for ( int i = 0; i < size; i++ ) {
            System.out.print( current.data + ", " );
            current = current.next;
        }
        System.out.println();
    }


}
