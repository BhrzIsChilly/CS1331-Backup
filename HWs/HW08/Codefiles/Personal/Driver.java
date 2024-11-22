public class Driver {

    public static void main(String[] args) {
        // Node<String> fourthNode = new Node<>("4");
        // Node<String> thirdNode = new Node<>("3", fourthNode);
        // Node<String> secondNode = new Node<>("2", thirdNode);
        // Node<String> firstNode = new Node<>("1", secondNode);

        String[] stringList = {"A", "B", "C"};


        LinkedList<String> list = new LinkedList<>(stringList);

        list.toArray();

        list.add("E");
        list.add(3, "D");

        list.remove(1);
        System.out.println(list.remove() + ": HAAAAAAAAAH");

        // list.add("D");
        // list.add("D");
        // list.add("D");

        System.out.println(list.get(0) + " <First element");
        System.out.println(list.get(1) + " <Second element");
        System.out.println(list.get(2) + " <Last element");
        // System.out.println(list.get(3) + " <Out of bound element");

        System.out.println(list.contains("A") + " <First element");
        System.out.println(list.contains("B") + " <Second element");
        System.out.println(list.contains("C") + " <Last element");

        System.out.println(list.set(1, "Q"));

        System.out.println(list.get(1));

        System.out.println(list);


        // Object[] stringList2 = list.toArray();


        // LinkedListIterator<String>()

        // System.out.println(LinkedListIterator instanceof Iterator);
    }

}