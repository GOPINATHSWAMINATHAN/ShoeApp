package myshoes.com.myshoes.model;

/**
 * Created by gopinath on 06/02/18.
 */

public class HomeShop {

    private String imageUrl, productName, productId;
    private double productPrice;
    private int discount;

    public HomeShop(String imageUrl, String productName, String productId, double productPrice, int discount) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
