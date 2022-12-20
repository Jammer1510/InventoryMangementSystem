package skeleton;

public class Inventory {
	private int id;
    private int stock;
    private int date;
    private double cost;
    private String location;
    private int orderStatus;
	
	
	//Constructor & Getters/Setters

    public Inventory(int id, int date, int stock, double cost, String location, int orderStatus) {
        this.id = id;
        this.date = date;
        this.stock = stock;
        this.cost = cost;
        this.location = location;
        this.orderStatus = orderStatus;
        
    }
// ID setter and getter

    public void setId(int id) {
       this.id = id;
    }
    
    public int getId() {
       return id;
    }
    
// Date setter/getter
    public void setDate(int date)
    {
        this.date = date;
    }
    public int checkDate()
    {
        return date;
    }
// Restock and remove stock functions
    public void addStock(int newStock, int access)
    {
        if(access == 1)
        {
             stock += newStock;
        }
        else
        {
            System.out.println("Unauthorized to add stock.");
        }
    }
    
    public void removeStock(int stockToRemove)
    {
        stock -= stockToRemove;
    }
    
    
 // Cost setter/getter   
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    public double getCost()
    {
        return cost;
    }
// Location setter/getter
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String checkStatus()
    {
        String status = "";
        if(orderStatus == 0)
        {
            status = "No order has been placed.";
        }
        else if(orderStatus == 1)
        {
            status = "Order placed on: " + date;
        }
        else if(orderStatus == 2)
        {
            status = "Order fulfilled.";
        }
        return status;
    }

	
	
	
}

