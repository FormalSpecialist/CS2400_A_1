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
     *  @param secondBag An additional bag object which will be combined with the bag object recieving the call.
     *  @return A bag object of some size containing the contents of the bag object and the parameter secondBag. */
    public LinkedBag<T> union( LinkedBag<T> secondBag );

    /** Compares two bag objects and creates an additional bag object which holds the overlapping values between the two bags
     *  @param secondBag An additional bag object which will be comapred with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the duplicate contents of the bag object and the parameter secondBag. */
    public LinkedBag<T> intersection( LinkedBag<T> secondBag );

    /** Compares two bag objects and creates an additional bag object which holds the non-overlapping objects from the object which recieved the call.
     *  @param secondBag An additional bag object which will be compared with the bag object recieving the call.
     *  @return A bag object of some size containing ONLY the NON-duplicate contents of the bag object recieving the call. */
    public LinkedBag<T> difference( LinkedBag<T> secondBag );

} // End BagInterface
