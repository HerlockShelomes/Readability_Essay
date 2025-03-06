public class Bucket_Sort {

    protected static void evaluation ( int[] input, Linked_Bucket[] buckets ) {
        int test;
        for ( int i = 0; i < input.length; i++ ) {
            test = input[i]/25;
            if ( test == 4 ) {
                test--;
            }
            buckets[test].insertLast(input[i]);
        }
    }

    protected static void sort_list (Linked_Bucket unsorted) {
        int len = unsorted.getSize();
        if ( len == 0 ) {
            return;
        }

        for ( int i = 1; i < len; i++ ) {
            int t = i;
            while ( t > 0 && unsorted.position(t) < unsorted.position(t-1) ) {
                int change = unsorted.remove(t);
                unsorted.insertBefore(change, t-1);
                t--;
            }
        }

    }

    protected static void sort_lists ( Linked_Bucket[] all_unsorted ) {
        for ( int i = 0; i < all_unsorted.length; i++ ) {
            sort_list(all_unsorted[i]);
        }
    }

    protected static int[] put_together ( Linked_Bucket[] sorted ) {
        int leng = 0;
        for ( int i = 0; i < sorted.length; i++ ) {
            leng = leng + sorted[i].getSize();
        }

        int[] output = new int[leng];
        int index = 0;

        for ( int i = 0; i < sorted.length; i++ ) {
            for ( int k = 0; k < sorted[i].getSize(); k++, index++ ) {
                output[index] = sorted[i].position(k);
            }
        }

        return output;
    }

    protected static int[] Sort( int[] not_sorted ) {
        Linked_Bucket[] buckets = new Linked_Bucket[4];

        for ( int i = 0; i < buckets.length; i++ ) {
            var initialize = new Linked_Bucket();
            buckets[i] = initialize;
        }

        evaluation( not_sorted, buckets );

        sort_lists( buckets );

        return put_together( buckets );
    }
}
