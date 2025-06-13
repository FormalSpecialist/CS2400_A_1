//

public class ResizeableArrayBag<T> implements BagInterface<T> {
    
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private boolean intergrityOK = false;
    private int numEntries;

    /** Creates an empty bag of an initial capacity of DEFAULT_CAPACITY (25) */

    public ResizeableArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[DEFAULT_CAPACITY];
        bag = tempBag;
    }

    /** Creates an empty bag of an initial capacity user choice
     *  @param desiredCapacity The integer capacity desired */

    public ResizeableArrayBag( int desiredCapacity )
    {
        if ( desiredCapacity <= MAX_CAPACITY )
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
        }
        else
        {
            throw new IllegalStateException("Attempt ot create a bag whose capacity exceeds allowed maximum.");
        }
    }

    /** Throws an exception if this object is not initialized */
    private void checkIntegrity()
    {
        if(!intergrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
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
        checkIntegrity();

        boolean result = true;
        
        if ( isFull() )
        {
            result = false;
        }
        else
        { // Assertion: result is true here
            bag[numEntries] = newEntry;
            numEntries++;
        }

        return result;

    }

    /** Removes an element from the Bag and returns it, if possible
     *  @return returns an object in the bag or returns null if there is no object to remove */

    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numEntries - 1);
        return result;
    }

    /** Removes an occurance of a specified element from the Bag if possible
     *  @param anEntry The object to be removed
     *  @return True if the specified object, anEntry, was found and removed from the Bag, otherwise False */

    public boolean remove( T anEntry )
    {
        checkIntegrity();
        
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);

        return anEntry.equals(result);

    }

    /** Locates a given entrywithin the array bag.
     * @param anEntry the enrty to find the index of 
     * @return index of the entry, if located, -1 otherwise
     *  Precondition: checkIntegrity has been called. */

    private int getIndexOf(T anEntry )
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while ( !found && (index < numEntries) )
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
        }

        return where;
    }

    /** Removes and returns the entry at a given index within the array bag.
     *  @param givenIndex the idex of the object to be removed
     *  @return return the entry at the given index, otherwise return null */

    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numEntries - 1];
            bag[numEntries - 1] = null;
            numEntries--;
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

        checkIntegrity();

        int counter = 0;

        for ( int index = 0; index < numEntries; index++ )
        {
            if ( anEntry.equals(bag[index]) )
                counter++;
        }

        return counter;

    }

    /** Counts the number of times a given entry apears in the bag 
     *  @param anEntry Entry to be found in the bag
     *  @return True if anEntry is found in the bag */

    public boolean contains( T anEntry )
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    /** Retrives all entries that are in the bag and places them in a returned array 
     *  @return A newly allocated array of all entries in the bag */

    public T[] toArray()
    {
        // Cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")

        T[] result = (T[])new Object[numEntries]; // Unchecked Cast

        for ( int i = 0; i < numEntries; i++ )
            result[i] = bag[i];

        return result;

    }

    /** Sees whether the bag is full
     *  @return true if the bag is full, or false if not */
    public boolean isFull()
    {
        return numEntries == bag.length;
    }




    /** Combines the contents of two bags into a single bag, does not affect duplicates or order of objects. 
     *  @param secondBag An additional bag object which will be combined with the bag object recieving the call.
     *  @return A bag object of some size containing the contents of the bag object and the parameter secondBag.
    */

    public ResizeableArrayBag<T> union( ResizeableArrayBag<T> secondBag )
    {
        
        //ResizeableArrayBag<T> bag = new ResizeableArrayBag<>();

        return secondBag;

    }

    /** Compares two bag objects and creates an additional bag object which holds the overlapping values between the two bags
     *  @param secondBag An additional bag object which will be comapred with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the duplicate contents of the bag object and the parameter secondBag. */

    public ResizeableArrayBag<T> intersection( ResizeableArrayBag<T> secondBag )
    {

        return secondBag;

    }

    /** Compares two bag objects and creates an additional bag object which holds the non-overlapping objects from the object which recieved the call.
     *  @param secondBag An additional bag object which will be compared with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the NON-duplicate contents of the bag object recieving the call. */

    public ResizeableArrayBag<T> difference( ResizeableArrayBag<T> secondBag )
    {
        
        return secondBag;

    }
    
    
    @Override
    public LinkedBag<T> union(LinkedBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'union'");
    }

    @Override
    public LinkedBag<T> intersection(LinkedBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }

    @Override
    public LinkedBag<T> difference(LinkedBag<T> secondBag) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'difference'");
    }

}
