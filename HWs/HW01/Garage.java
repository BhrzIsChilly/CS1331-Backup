/*
 * Braiden Anderson - HW 01
 * Garage.java to house all
 * the Cars I've collected.
*/
public class Garage {

    private GarageOwner theOwner;
    private Car[] carCatalogue; // null for empty parking spots.



    ////// METHODS //////

    public Car addCar(int parkingLotIndex, Car vehicle) {
        Car previousCar = this.carCatalogue[parkingLotIndex];

        if (vehicle == null || (0 >= parkingLotIndex && parkingLotIndex >= carCatalogue.length)) {
            System.out.println("Cannot add a car to this spot.");
            return null;
        }

        if (previousCar != null) {
            String[] carDetails = previousCar.getColorMakeModel();
            System.out.printf("There was a %s %s %s here before.\n", carDetails[0], previousCar.getYear(), carDetails[1], carDetails[2]);
            carCatalogue[parkingLotIndex] = vehicle;
            this.theOwner.addCarCount(1);

            return previousCar;
        } else {
            String[] currentCarDetails = vehicle.getColorMakeModel();
            System.out.printf("A %s %d %s %s was just parked here.\n", currentCarDetails[0], vehicle.getYear(), currentCarDetails[1], currentCarDetails[2]);
            this.carCatalogue[parkingLotIndex] = vehicle;
            this.theOwner.addCarCount(1);

            return null;
        }
    }

    public Car sellCar(int parkingLotIndex) {
        if ((0 >= parkingLotIndex && parkingLotIndex >= carCatalogue.length) || carCatalogue[parkingLotIndex] == null) {
            System.out.println("There was no car to sell!");
            return null;
        } else {
            Car vehicle = this.carCatalogue[parkingLotIndex];
            String[] vehicleDetails = vehicle.getColorMakeModel();
            System.out.printf("%s just sold a %s %d %s %s.\n", theOwner.getName(), vehicleDetails[0], vehicle.getYear(), vehicleDetails[1], vehicleDetails[2]);

            this.carCatalogue[parkingLotIndex] = null;
            this.theOwner.addCarCount(-1);

            return vehicle;
        }
    }

    public void showCertainCars(int conditionCategory) {
        int baselineCondition = conditionCategory;

        for (int i = 0; i < this.carCatalogue.length; i++) {
            if (this.carCatalogue[i] != null) {
                Car vehicle = this.carCatalogue[i];
                if (vehicle.getConditionCategory() > baselineCondition) {
                    String[] carDetails = vehicle.getColorMakeModel();

                    System.out.printf("A %s %d %s %s with a condition category of %d.\n", carDetails[0], vehicle.getYear(), carDetails[1], carDetails[2], vehicle.getConditionCategory());
                }
            }
        }
    }




    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4]; // initializes the parking lots to empty with null
    }

    public Garage(GarageOwner owner, Car[] catalogue) {
        this.theOwner = owner;
        this.carCatalogue = catalogue;

        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null) {
                this.theOwner.addCarCount(1);
            }
        }
    }
}