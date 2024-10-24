/*
* Braiden Anderson
* 10/16/2024
* Device.java
*/
package new_devices;

public abstract class Device {
    // Variables
    private int serialNumber;
    protected int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    // DEFAULT values
    private static final int DEF_CPU_CAPACITY = 512;

    // Constructors
    public Device(int serialNumber, int taskLength) {
        this(serialNumber, DEF_CPU_CAPACITY, taskLength);        
    }

    public Device(int serialNumber, int cpuCapacity, int taskLength) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.cpuRemaining = cpuCapacity;
        this.tasks = new Task[taskLength];
    }

    // Abstract methods

    public abstract boolean canAddTask(Task taskObject);

    public abstract boolean addTask(Task taskObject);

    // Concrete methods

    public boolean processTask(Task taskObject) {
        if (taskObject == null) {
            return false;
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].equals(taskObject)) {
                this.cpuRemaining += taskObject.getCPUCost();
                System.out.printf("Processed: %s\n", taskObject.toString());
                tasks[i] = null;
                return true;
            }
        }

        return false;
    }

    // Overridden Object methods

    public boolean equals(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }

        Device that = (Device) other;

        return this.serialNumber == that.serialNumber && this.cpuCapacity == that.cpuCapacity && this.cpuRemaining == this.cpuRemaining;
    }

    public String toString() {
        return String.format("Device with serial number %s has %s of %s CPU remaining.", this.serialNumber, this.cpuRemaining, this.cpuCapacity);
    }
}