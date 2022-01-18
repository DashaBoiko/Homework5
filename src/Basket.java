import java.util.Date;

public class Basket {

    private Product[] arrayOfProducts;

    private User buyingUser;

    private int productCountForOneClient = 0;


    Date dayOfPurchase;


    double purchasePrice = 0;


    public Basket()
    {
        int count = 100;
        arrayOfProducts = new Product[count];
    }


    public Basket(Product[] arrayOfProducts, User buyingUser)
    {
        this.arrayOfProducts = arrayOfProducts;
        this.buyingUser = buyingUser;
        productCountForOneClient = this.arrayOfProducts.length;
        costCalculation();
    }



    public void addProduct(Product product)
    {
        arrayOfProducts[productCountForOneClient] = product;
        productCountForOneClient++;
    }


    public Product[] getArrayOfProducts() {
        return arrayOfProducts;
    }
    public void setArrayOfProducts(Product[] arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    public int getProductCountForOneClient() {
        return productCountForOneClient;
    }

    public void setProductCountForOneClient(int productCountForOneClient) {
        this.productCountForOneClient = productCountForOneClient;
    }


    public User getBuyingUser() {
        return buyingUser;
    }
    public void setBuyingUser(User buyingUser) {
        this.buyingUser = buyingUser;
    }


    public Date getDayOfPurchase() {
        return dayOfPurchase;
    }
    public void setDayOfPurchase(Date dayOfPurchase) {
        this.dayOfPurchase = dayOfPurchase;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }



    public double costCalculation()
    {
        double sumCost = 0;

        for(int i=0;i<productCountForOneClient;i++)
        {
            sumCost+=arrayOfProducts[i].getQuantityOfPurchasedProducts()*
                    arrayOfProducts[i].getProductPrice()*
                    (1-arrayOfProducts[i].getSalePercent()/100.0);
        }

        purchasePrice = sumCost;
        return sumCost;
    }

}
