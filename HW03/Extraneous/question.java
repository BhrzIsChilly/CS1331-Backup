// Doesn't super() take the data type of the super class? how can a child class send in a data type that isn't the data type given?
// is the child class also considered the super class?
//ANS: Polymorphism -- the child class is also a super class. The super class can take many forms.
// The child class can do things a super class can do

/*
When we have .equals() from our parent class or the Object class, and we make
an overridden .equals() method, why are we allowed to use .equals() inside the
overridden .equals() method? At what point do the overridden methods take effect?
Outside of the overridden

The equals method uses the class's method's equal function that it is run on.
It is not functional, it is a class method, so it is relative to the class
that it is used with.

How does the equals method inherit over a chain of inherited classes?
does it copy the method...
no. It just knows that it's not overridden, and uses the equals method from the object class,
or the class that last overrode it.