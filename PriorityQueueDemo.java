import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<WorkOrder> q = new PriorityQueue<>();

		q.add(new WorkOrder(3, "Shampoo carpets"));
		q.add(new WorkOrder(1, "Fix broken sink"));
		q.add(new WorkOrder(2, "Order cleaning supplies"));

		while (!q.isEmpty()) {
			WorkOrder next = q.remove();
			System.out.println("Working on " + next);
		}
	}
}