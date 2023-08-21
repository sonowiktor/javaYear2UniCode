package lib;

public class OrderLine {
	private String id;
	private int unitPrice;
	private int quantity;
	
	public OrderLine() {
		this.id = "";
		this.unitPrice = 0;
		this.quantity = 0;
	}
	
	public OrderLine(String id) {
		this.id = id;
		this.unitPrice = 0;
		this.quantity = 0;
	}
	
	public OrderLine(String id, int unitPrice, int quantity) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getUnitPrice() {
		return unitPrice;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getCost() {
		return unitPrice * quantity;
	}
	
	public String toString() {
		return "OrderLine:[id=" + id + ", unitPrice=" + unitPrice 
				+ ", quantity=" + quantity + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		OrderLine other = (OrderLine) obj;

		return this.id.equals(other.id) && 
				this.unitPrice == other.unitPrice &&
				this.quantity == other.quantity;
	}


}
