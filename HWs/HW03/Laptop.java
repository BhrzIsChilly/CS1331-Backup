/*
* Braiden Anderson
* 10/16/2024
* CellPhone.java
*/
package new_devices;

public class Laptop extends Device {
    // Variable
    private boolean overclockable;
    private boolean permanentOverclocked;

    // DEFAULT Values
    private static final boolean DEF_OVERCLOCKABLE = false;

    // Constructors
    public Laptop(int serialNumber, int cpuCapacity, int taskLength) {
        this(serialNumber, cpuCapacity, taskLength, DEF_OVERCLOCKABLE);
    }

    public Laptop(int serialNumber, int cpuCapacity, int taskLength, boolean overclockable) {
        super(serialNumber, cpuCapacity, taskLength);
        this.overclockable = overclockable;
        this.permanentOverclocked = false;
    }

    // Concrete Methods
    public int bufferSlotsRequired(int cpuRemaining) {
        if (this.tasks.length <= 4) {
            return 0;
        }

        return (cpuRemaining < 128) ? 2 : 1;
    }

    public boolean canAddTask(Task taskObject) {
        int realizedCPURemaining = this.cpuRemaining;
        int tasksCurrentBufferSlots = 0;

        if (overclockable) {
            realizedCPURemaining = this.cpuRemaining + this.cpuCapacity/4;        
        }

        for (int i = 0; i < tasks.length; i++) {
            if (this.tasks[i] == null)
                tasksCurrentBufferSlots++;
        }

        if (realizedCPURemaining >= taskObject.getCPUCost() && tasksCurrentBufferSlots > bufferSlotsRequired(this.cpuRemaining)) {
            return true;
        }
        return false;
    }

    public boolean addTask(Task taskObject) {
        int taskCost = taskObject.getCPUCost();
        if (canAddTask(taskObject)) {
            for (int i = 0; i < tasks.length; i++) {
                if (this.tasks[i] == null)
                    this.tasks[i] = taskObject;
                    if (this.cpuRemaining < taskCost && this.permanentOverclocked == false) {
                        this.cpuRemaining += this.cpuCapacity/4;
                        this.permanentOverclocked = true;
                    }
                    this.cpuRemaining -= taskCost;
                    return true;
            }
        }
        return false;
    }

    // Overridden Object methods

    public boolean equals(Object other) {
        if (!this.equals(other)) {
            return false;
        }
        
        Laptop that = (Laptop) other;
        
        return this.overclockable == that.overclockable;
    }

    public String toString() {
        return String.format("%s This laptop %s have overclocking", this.toString(), (this.overclockable ? "Does" : "Does not"));
    }

}