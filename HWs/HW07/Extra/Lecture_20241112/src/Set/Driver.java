package Set;

public class Driver {
    public static void main(String[] args) {
        ArraySet<Integer> set = new ArraySet<>();
        System.out.println("\n!!! Created empty set, <> !!!");
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, <10> !!!");
        System.out.println("Added? " + set.add(10));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, <10 20> !!!");
        System.out.println("Added? " + set.add(20));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, <10 20 30> !!!");
        System.out.println("Added? " + set.add(30));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, <10 20 30 40> !!!");
        System.out.println("Added? " + set.add(40));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, <10 20 30 40 50> !!!");
        System.out.println("Added? " + set.add(50));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! NOT added, <10 20 30 40 50> !!!");
        System.out.println("Added? " + set.add(40));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Added, Cap increased <10 20 30 40 50 60> !!!");
        System.out.println("Added? " + set.add(60));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Iterable test !!!");
        for (Integer element : set) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("\n!!! Removed, <60 20 30 40 50> !!!");
        System.out.println("Removed? " + set.remove(10));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Removed, <60 20 50 40> !!!");
        System.out.println("Removed? " + set.remove(30));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! NOT removed, <60 20 50 40> !!!");
        System.out.println("Removed? " + set.remove(30));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Removed, <60 40 50> !!!");
        System.out.println("Removed? " + set.remove(20));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Removed, <60 40> !!!");
        System.out.println("Removed? " + set.remove(50));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Removed, <60> !!!");
        System.out.println("Removed? " + set.remove(40));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! Removed, <> !!!");
        System.out.println("Removed? " + set.remove(60));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());

        System.out.println("\n!!! NOT removed, <> !!!");
        System.out.println("Removed? " + set.remove(60));
        System.out.println(set);
        System.out.println("isEmpty? " + set.isEmpty());
    }
}
