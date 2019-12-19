package trackingService;

public class HistoryItem {

	private int id;
	private int amount;
	private String operation;
	private int total;

	public HistoryItem(int id, int amount, String operation, int total) {

		this.id = id;
		this.amount = amount;
		this.operation = operation;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public int getAmount() {
		return amount;
	}
	public String getOperation() {
		return operation;
	}
	public int getTotal() {
		return total;
	}
	@Override
	public String toString() {
		return "HistoryItem [id=" + id + ", amount=" + amount + ", operation=" + operation + ", total=" + total + "]";
	}
	
	
	
	

}
