import java.sql.Date;
public class Product {
	String type,model;
	int count;
	float price;
	Date delivery_date;
	int id;
	
	public Product(int id,String type,String model,float price,int count,Date delivery_date) {
		this.type = type;
		this.model= model;
		this.price = price;
		this.count = count;
		this.delivery_date = delivery_date;
		this.id = id;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
