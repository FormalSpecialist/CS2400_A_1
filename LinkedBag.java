// This Class impliments a bag using a linked list structure. As such, it allows for an ever changing number of 
// elements and contains a variety of member methods to change the contents of the bag.

public class LinkedBag<T> implements BagInterface<T>{
    
    private Node<T> firstNode;
    private int numEntries;

    public LinkedBag()
    {
        firstNode = null;
        numEntries = 0;
    }

    /** Returns the current number of elements in the Bag
     *  @return integer of the number of elements in the bag */

    public int getCurrentSize()
    {
        return numEntries;
    }

    /** Determines whether the Bag has no elements
     *  @return True if Bag is empty, False is bag has elements */

    public boolean isEmpty()
    {
        return numEntries == 0;
    }

    /** Adds a new element to the Bag
     *  @param newEntry, the object to be added to the Bag
     *  @return True if the object was successfully added, False if it was unable to be added */

    public boolean add( T newEntry )
    {
        Node<T> newNode = new Node<T>(newEntry);

        if ( isEmpty() )
        {
            firstNode = newNode;
        }
        else
        {
            newNode.setNext( firstNode );
            firstNode = newNode;
        }

        numEntries++;

        return true;

    }

    /** Locates a given entry within the bag.
     *  @return A Node containing the specified entry, otherwise null */

    private Node<T> getReferenceTo( T anEntry )
    {

        boolean found = false;
        Node<T> currentNode = firstNode;

        while ( !found && ( currentNode != null ) )
        {

            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNext();
            }

        }

        return currentNode;


    }

    /** Removes an element from the Bag and returns it, if possible
     *  @return returns an object in the bag or returns null if there is no object to remove */

    public T remove()
    {
        T data = null;

        if ( firstNode != null )
        {
            data = firstNode.getData();
            firstNode = firstNode.getNext();
            numEntries--;
        }

        return data;
    }

    /** Removes an occurance of a specified element from the Bag if possible
     *  @param anEntry The object to be removed
     *  @return True if the specified object, anEntry, was found and removed from the Bag, otherwise False */

    public boolean remove( T anEntry )
    {
        boolean result = false;
        Node<T> targetNode = getReferenceTo(anEntry);

        if ( targetNode != null )
        {

            targetNode.setData( firstNode.getData() );

            remove();

            result = true;

        }

        return result;

    }

    /** Removes all entries from the bag */

    public void clear()
    {
        while( !isEmpty() )
        {
            remove();
        }
    }

    /** Counts the number of times a given entry apears in the bag 
     *  @param anEntry Entry to be counted
     *  @return Number of times an Entry appears in the bag */

    public int frequencyOf( T anEntry )
    {

        int frequency = 0;
        //int counter = 0;
        Node<T> currentNode = firstNode;

        while ( currentNode != null ) // REMOVED //     counter < numEntries && 
        {
            if ( anEntry.equals(currentNode.getData())  )
            {
                frequency++;
            }

            currentNode = currentNode.getNext();
            //counter++;
        }

        return frequency;

    }

    /** Counts the number of times a given entry apears in the bag 
     *  @param anEntry Entry to be found in the bag
     *  @return True if anEntry is found in the bag */

    public boolean contains( T anEntry )
    {

        boolean found = false;
        Node<T> currentNode = firstNode;

        while ( !found && currentNode != null )
        {
            if ( anEntry.equals(currentNode.getData())  )
            {
                found = true;
            }

            currentNode = currentNode.getNext();
        }

        return found;

    }

    /** Retrives all entries that are in the bag and places them in a returned array 
     *  @return A newly allocated array of all entries in the bag */

    public T[] toArray()
    {
        // Cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")

        T[] result = (T[])new Object[numEntries]; // Unchecked Cast

        int index = 0;
        Node<T> currentNode = firstNode; 

        while ( index < numEntries && currentNode != null )
        {

            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNext();

        }

        return result;

    }




    /** Combines the contents of two bags into a single bag, does not affect duplicates or order of objects. 
     *  @param secondBag An additional bag object which will be combined with the bag object recieving the call.
     *  @return A bag object of some size containing the contents of the bag object and the parameter secondBag.
    */

    public LinkedBag<T> union( LinkedBag<T> secondBag )
    {
        // Creates a New Linked bag which will hold the combined contents of both bags
        LinkedBag<T> everything = new LinkedBag<>();
        
        // Integer to hold entries for secondBag
        int num = secondBag.numEntries;

        // Initial Node to object recieving the call
        Node<T> currentNode = secondBag.firstNode;

        // Loop through the main objects in secondBag, and add the data to 'everything'
        for (int i = 0; i < num; i++ )
        {
            everything.add( currentNode.getData() );
            currentNode = currentNode.getNext();
        } // end for

        currentNode = firstNode;

        // Loop through the main objects in the bag recieving the call, and add the data to 'everything'
        for (int i = 0; i < numEntries; i++ )
        {
            everything.add( currentNode.getData() );
            currentNode = currentNode.getNext();
        } // end for

        return everything;

    }

    /** Compares two bag objects and creates an additional bag object which holds the overlapping values between the two bags
     *  @param secondBag An additional bag object which will be comapred with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the duplicate contents of the bag object and the parameter secondBag. */

    public LinkedBag<T> intersection( LinkedBag<T> secondBag )
    {

        // Creates a New Linked bag which will hold the duplicate combined contents of both bags
        LinkedBag<T> commonItems = new LinkedBag<T>();

        
        Node<T> currentNode = firstNode;
        T data;
        
        // Variables used to hold the frequency of data in each bag, and the number of times to add the frequency to the bag
        int countA, countB, addNumber;

        // While Loop to determine whether the current Node is of null value
        while ( currentNode != null )
        {
            // If statement determines whether the current data within currentNode is already within the bag, commonItems, 
            // i.e. meaning it would be a duplicate that should not be added.
            if ( !commonItems.contains( currentNode.getData() ) )
            {

                data = currentNode.getData();
                
                // Retrive the frequencies of data in each bag
                countA = frequencyOf( data );
                countB = secondBag.frequencyOf( data );

                // Determine what the total number of duplicates between the bags are
                if ( countA >= countB )
                    addNumber = countB;
                else
                    addNumber = countA;

                // Add the number of duplicates into the new bag
                for ( int i = 0; i < addNumber; i++ )
                {
                    commonItems.add( data );
                }

            }

            // Retrive next node to test
            currentNode = currentNode.getNext();

        }

        // Return the new bag
        return( commonItems );

    }

    /** Compares two bag objects and creates an additional bag object which holds the non-overlapping objects from the object which recieved the call.
     *  @param secondBag An additional bag object which will be compared with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the NON-duplicate contents of the bag object recieving the call. */

    public LinkedBag<T> difference( LinkedBag<T> secondBag )
    {
        // Creates a New Linked bag which will hold the duplicate combined contents of both bags
        LinkedBag<T> leftOver = new LinkedBag<>();
        
        Node<T> currentNode = firstNode;
        T data;
        
        // Variables used to hold the frequency of data in each bag, and the number of times to add the frequency to the bag
        int countA, countB, addNumber;

        // While Loop to determine whether the current Node is of null value
        while ( currentNode != null )
        {
            // If statement determines whether the current data within currentNode is already within the bag, currentNode, 
            // i.e. meaning it would be a duplicate that should not be added.
            if ( !leftOver.contains( currentNode.getData() ) )
            {

                data = currentNode.getData();
                
                // Retrive the frequencies of data in each bag
                countA = frequencyOf( data );
                countB = secondBag.frequencyOf( data );

                // Determine the total number of non-duplicates between the bags
                addNumber = (countA - countB);

                // Add the number of non-duplicates into the new bag
                for ( int i = 0; i < addNumber; i++ )
                {
                    leftOver.add( data );
                }

            }

            // Retrive next node to test
            currentNode = currentNode.getNext();

        }

        // Return the new bag
        return( leftOver );

    }



    // Node Class, which allows the LinkedBag to function as a linked list, with properties for data and next node,
    // in addition to the proper methods to access and modify these properties.
    private class Node<T> 
    {

        private T data;
        private Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node<T> getNext()
        {
            return next;
        }

        public void setNext(Node<T> next)
        {
            this.next = next;
        }

    }



    @Override
    public ResizeableArrayBag<T> union(ResizeableArrayBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'union'");
    }

    @Override
    public ResizeableArrayBag<T> intersection(ResizeableArrayBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }

    @Override
    public ResizeableArrayBag<T> difference(ResizeableArrayBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'difference'");
    }


}
