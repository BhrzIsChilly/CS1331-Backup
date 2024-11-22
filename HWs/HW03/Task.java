/*
* Braiden Anderson
* 10/16/2024
* Task.java
*/
package new_devices;

public class Task {
    // Variables
    private String name;
    private int cpuCost;

    // Default values
    private static final String DEF_NAME = "GEN_TASK";
    private static final int DEF_MIN_CPU_COST = 8;

    // Constructors
    public Task() {
        this(DEF_NAME, DEF_MIN_CPU_COST);
    }

    public Task(String name, int cpuCost) {
        this.name = name;
        this.cpuCost = (cpuCost >= DEF_MIN_CPU_COST) ? cpuCost : DEF_MIN_CPU_COST;
    }

    // Concrete method

    public int getCPUCost() {
        return this.cpuCost;
    }

    // Overridden Object methods

    public String toString() {
        return String.format("%s has CPU cost of %d", this.name, this.cpuCost);
    }

    public boolean equals(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }

        Task that = (Task) other;

        return this.name == that.name && this.cpuCost == that.cpuCost;
    }
}
