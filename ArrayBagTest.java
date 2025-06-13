import java.util.Arrays;

public class ArrayBagTest {
    
    public static void main(String[] args)
    {
        // Print to Console
        System.out.println("Resizeable Array Test Program:");
        System.out.println("=======================================");

        // Create two Bag objects
        BagInterface<String> bag1 = new ResizeableArrayBag<>();        
        BagInterface<String> bag2 = new ResizeableArrayBag<>();       

        // Filling Bags with Test Data
        System.out.println("Filling Bag One with Data: [a, b, c]");
        System.out.println("Filling Bag Two with Data: [b, b, d, e]");
        System.out.println("=======================================");

        // Bag One Data
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        // Bag Two Data
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        // Print to Arrays 
        System.out.printf("Bag One displayed as Array: %s", Arrays.toString( bag1.toArray()) );
        System.out.printf("%nBag Two displayed as Array: %s", Arrays.toString( bag2.toArray()) );



        // Test New Methods
        BagInterface<String> everything = new ResizeableArrayBag<>();
        BagInterface<String> intersection = new ResizeableArrayBag<>();
        BagInterface<String> difference = new ResizeableArrayBag<>();

        System.out.println("\n"); // Line Break

        // Union Method
        System.out.println("Union Method:");
        System.out.println("=======================================");

        everything = bag1.union((ResizeableArrayBag<String>) bag2);
        
        System.out.printf("Bag One union Bag Two: %s", Arrays.toString( everything.toArray()) );
        
        // Intersection Method
        System.out.println("\n\nIntersection Method:");
        System.out.println("=======================================");

        intersection = bag1.intersection((ResizeableArrayBag<String>) bag2);
        
        System.out.printf("Bag One intersection Bag Two: %s", Arrays.toString( intersection.toArray()) );
        
        // Difference Method
        System.out.println("\n\nDifference Method:");
        System.out.println("=======================================");

        difference = bag1.difference((ResizeableArrayBag<String>) bag2);
        
        System.out.printf("Bag One difference Bag Two: %s", Arrays.toString( difference.toArray()) );

        difference = bag2.difference((ResizeableArrayBag<String>) bag1);
        
        System.out.printf("\nBag Two difference Bag One: %s", Arrays.toString( difference.toArray()) );

    }

}
