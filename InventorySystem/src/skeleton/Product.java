package skeleton;

public class Product {
	  //Declaring Variables
    private int productId;
    private String name;
    private String description;
    private String category;
    private double price;
    private int stock;
    private int min;
    private int max;
    private int supplierID;
    private static int numProduct;
    
    
    //Constructor & Getters/Setters

    public Product(int id, String name, String description, String category, double price, int stock, int min, int max, int supplierID) {
        this.productId = ++numProduct;
        this.name = name;
        this.description = description;
        this.category = category;
        this.setprice(price);
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.supplierID = supplierID;
        
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    
    public String getCategory()
    {
        return category;
    }
    
}

