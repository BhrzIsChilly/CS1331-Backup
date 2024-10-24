public class Driver {

    public static void main(String[] args) {
        //Animal a = new Animal("generic animal"); // Can we do this?
        

        // System.out.println("\n\n~~~~~~~~~~ CAT STUFF ~~~~~~~~~~\n");
        // Cat c = new Cat();
        // c.scratch(5);
        // c.makeNoise();
        // System.out.println("Cat toString(): " + c.toString());

        
        // System.out.println("\n\n~~~~~~~~~~ DOG STUFF ~~~~~~~~~~\n");
        // Dog d = new Dog();
        // d.scratch(5);
        // d.makeNoise();
        // d.bark();
        // System.out.println("Dog toString(): " + d.toString());

        

        // System.out.println("\n\n~~~~~~~~~~ BIRD STUFF ~~~~~~~~~~\n");
        // Bird b = new BigBird();
        // b.scratch(5);
        // b.makeNoise();
        // System.out.println("Bird toString(): " + b.toString());
        

        // System.out.println("\n\n~~~~~~~~~~ FISH STUFF ~~~~~~~~~~\n");
        // Fish f = new Fish();
        // f.scratch(5); // Remember, Fish does not have a scratch method defined!
        // f.makeNoise();
        // System.out.println("Fish toString(): " + f.toString());



        Object o = new Dog(); // This object has the capacity to be everything up and into the Dog class, which means it can act like an Object, an Animal, and/or a Dog.
        Animal a = new Dog(); // but as these Static types are being loaded with the dynamic Dog class, the methods that are in the static classes that are overridden
        Dog d = new Dog();    // by the dynamic type's methods are overridden when a method from the static type with that particular dynamic type is called. Also, only
                              // the methods that are present in the static type are allowed to be called upon. I would understand that the data from the dynamic type is
                              // loaded into the memory address when the dynamic type is called in place of the appropriate static type, so when the static type is casted
                              // down, the memory that was once allocated is now in use again.

        /*****************/
        System.out.println(o.toString());
        System.out.println(a.toString());

        // o.move(); // compiles? runs?
        // a.move(); // compiles? runs?
        // a.bark(); // compiles? runs?
        System.out.println(d.toString());
        d.scratch();
        ((Animal) o).bark(); // similar to Animal temp = (Animal) o; temp.bark();

        // /*****************/
        // a = new Animal();

        // ((Dog) a).bark();
        // ((Dog) a).move();

        // /*****************/
        // // Assume Fish extends Animal and doesn't have any new methods
        // Object o2 = new Fish();
        // ((Dog) o2).bark();
    }
}
