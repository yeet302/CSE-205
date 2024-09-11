public class WorkOrder implements Comparable<WorkOrder> {
	private int level;
	private String description;

	public WorkOrder(int l, String d) {
		level = l;
		description = d;
	}
	
	public int compareTo(WorkOrder other) {
		return level - other.level;
	}
	
	public String toString() {
		return "Task: " + description + " (" + level + ")";
	}
}