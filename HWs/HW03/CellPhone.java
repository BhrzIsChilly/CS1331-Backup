/*
* Braiden Anderson
* 10/16/2024
* CellPhone.java
*/
package new_devices;

public class CellPhone extends Device {
    // Variables
    private static int tasksCompleted;

    // DEFAULT values
    private static final int DEF_TASK_LENGTH = 10;

    // Constructors
    public CellPhone(int serialNumber, int cpuCapacity) {
        this(serialNumber, cpuCapacity, DEF_TASK_LENGTH);
    }

    public CellPhone(int serialNumber, int cpuCapacity, int taskLength) {
        super(serialNumber, cpuCapacity, taskLength);
    }

    // Concrete methods
    public boolean canAddTask(Task taskObject) {
        for (int i = 0; i < tasks.length; i++) {
            if (this.tasks[i] == null && this.cpuRemaining >= taskObject.getCPUCost()) {
                return true;
            }
        }
        return false;
    }

    public boolean addTask(Task taskObject) {
        if (canAddTask(taskObject)) {
            for (int i = 0; i < tasks.length; i++) {
                if (this.tasks[i] == null)
                    this.tasks[i] = taskObject;
                    this.cpuRemaining -= taskObject.getCPUCost();
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
        
        CellPhone that = (CellPhone) other;
        
        return this.tasksCompleted == that.tasksCompleted;
    }

    public String toString() {
        return String.format("%s It has completed %d tasks.", this.toString(), this.tasksCompleted);
    }

}