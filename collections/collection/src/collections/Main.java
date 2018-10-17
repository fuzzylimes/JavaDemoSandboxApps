package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Product door = new Product("Door", 35);
        Product floor = new Product("Floor", 10);
        Product window = new Product("Window", 25);

//        Don't need Generics on right side of assignment, gets inferred from left.
        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floor);
        products.add(window);
//        System.out.println(products);
        
//        Doing things the long way, we could write out an iterator that does the following:
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()) {
            Product product = productIterator.next();
            System.out.println(product);
        }
        
//        But there's an easier way to write this with a forEach method that will compile to the ablove:
        for (Product product : products) {
            System.out.println(product);
        }

//        Iterators will let us do things like remove items from a collection:
        final Iterator<Product> productIterator2 = products.iterator();
        while(productIterator2.hasNext()) {
            Product product = productIterator2.next();
            if (product.getWeight() > 30) {
                System.out.println("Item is greater than 30kg: " + product);
            } else {
                productIterator2.remove();
            }
        }
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(door));
        System.out.println(products.contains(window));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(door);

        products.removeAll(otherProducts);
        System.out.println(products);

    }
}
