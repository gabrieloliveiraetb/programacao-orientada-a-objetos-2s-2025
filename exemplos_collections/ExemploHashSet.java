package exemplos_collections;

import java.util.HashSet;

public class ExemploHashSet {
    
    public static void main(String[] args) {

        HashSet<Integer> inteiros = new HashSet<Integer>();

        inteiros.add(1);
        inteiros.add(2);
        inteiros.add(3);
        inteiros.add(4);

        for (Integer i : inteiros) {
            System.out.println(i);
        }

        if (inteiros.contains(3)) {
            System.out.println("3 está na lista");
        }

        inteiros.remove(3);

        if (!inteiros.contains(3)) {
            System.out.println("3 não está na lista");
        }
        
    }
}