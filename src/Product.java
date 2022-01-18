public class Product {
    private String productName;
    private String productCharacteristic;
    private int productQuantity;
    private int quantityOfPurchasedProducts;
    private double productPrice;
    private int salePercent=0;


    public Product(String productName, String productCharacteristic, int productQuantity,
                   int quantityOfPurchasedProducts, double productPrice, int salePercent)
    {
        this.productName = productName;
        this.productCharacteristic = productCharacteristic;
        this.quantityOfPurchasedProducts = quantityOfPurchasedProducts;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.salePercent = salePercent;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(String productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantityOfPurchasedProducts() {
        return quantityOfPurchasedProducts;
    }

    public void setQuantityOfPurchasedProducts(int quantityOfPurchasedProducts) {
        this.quantityOfPurchasedProducts = quantityOfPurchasedProducts;
    }




    public String toString()
    {
        String str = "Name of product:" + this.productName;
        str+= "\nSpecifications: " + this.productCharacteristic;
        str+= "\nCount: " + this.quantityOfPurchasedProducts;
        str+= "\nPrice: " + this.productPrice+"\n";

        return str;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }



}
