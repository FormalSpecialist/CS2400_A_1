/** An interface that describes the operations of a bag of objects */
public interface BagInterface<T> 
{
    
    /** Returns the current number of elements in the Bag
     *  @return integer of the number of elements in the bag */
    public int getCurrentSize();

    /** Determines whether the Bag has no elements
     *  @return True if Bag is empty, False is bag has elements */
    public boolean isEmpty();

    /** Adds a new element to the Bag
     *  @param newEntry, the object to be added to the Bag
     *  @return True if the object was successfully added, False if it was unable to be added */
    public boolean add( T newEntry );

    /** Removes an element from the Bag and returns it, if possible
     *  @return returns an object in the bag or returns null if there is no object to remove */
    public T remove();

    /** Removes an occurance of a specified element from the Bag if possible
     *  @param anEntry The object to be removed
     *  @return True if the specified object, anEntry, was found and removed from the Bag, otherwise False */
    public boolean remove( T anEntry );

    /** Removes all entries from the bag */
    public void clear();

    /** Counts the number of times a given entry apears in the bag 
     *  @param anEntry Entry to be counted
     *  @return Number of times an Entry appears in the bag */
    public int frequencyOf( T anEntry );

    /** Counts the number of times a given entry apears in the bag 
     *  @param anEntry Entry to be found in the bag
     *  @return True if anEntry is found in the bag */
    public boolean contains( T anEntry );

    /** Retrives all entries that are in the bag and places them in a returned array 
     *  @return A newly allocated array of all entries in the bag */
    public T[] toArray();



    /** Combines the contents of two bags into a single bag, does not affect duplicates or order of objects.
     *  @param secondBag Another bag whose contents will be combined with this bag.
     *  @return A new bag containing the contents of this bag and secondBag. */
    public LinkedBag<T> union(LinkedBag<T> secondBag);

    /** Combines the contents of two bags into a single bag, does not affect duplicates or order of objects.
     *  @param secondBag Another bag whose contents will be combined with this bag.
     *  @return A new bag containing the contents of this bag and secondBag. */
    public ResizeableArrayBag<T> union(ResizeableArrayBag<T> secondBag);


    /** Creates a new bag containing the overlapping values between this bag and another bag.
     *  @param secondBag Another bag to compare with this bag.
     *  @return A new bag containing only the duplicate contents of this bag and secondBag. */
    public LinkedBag<T> intersection(LinkedBag<T> secondBag);

    /** Creates a new bag containing the overlapping values between this bag and another bag.
     *  @param secondBag Another bag to compare with this bag.
     *  @return A new bag containing only the duplicate contents of this bag and secondBag. */
    public ResizeableArrayBag<T> intersection(ResizeableArrayBag<T> secondBag);


    /** Creates a new bag containing the non-overlapping objects from this bag compared to another bag.
     *  @param secondBag Another bag to compare with this bag.
     *  @return A new bag containing only the non-duplicate contents of this bag. */
    public LinkedBag<T> difference(LinkedBag<T> secondBag);

    /** Creates a new bag containing the non-overlapping objects from this bag compared to another bag.
     *  @param secondBag Another bag to compare with this bag.
     *  @return A new bag containing only the non-duplicate contents of this bag. */
    public ResizeableArrayBag<T> difference(ResizeableArrayBag<T> secondBag);

} // End BagInterface
