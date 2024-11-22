public class Driver {
    public static void main(String[] args) {

        Car[] vrooms = new Car[3];
        GarageOwner me = new GarageOwner();
        Garage myGarage = new Garage(me, vrooms);

        Car crazyCar1 = new Car();
        Car crazyCar2 = new Car(2005, "Chevrolet", "Tahoe");
        Car crazyCar3 = new Car(1995, "Chevrolet", "Truck...", "Blue", 49);

        myGarage.addCar(0, crazyCar1);
        myGarage.addCar(1, crazyCar2);
        myGarage.addCar(2, crazyCar3);
        System.out.println(me.getCarOwned());

        myGarage.sellCar(2);

        System.out.println(me.getCarOwned());

        myGarage.showCertainCars(48);

    }
}