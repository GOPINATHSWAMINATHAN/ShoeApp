package myshoes.com.myshoes.model;

import java.util.ArrayList;

/**
 * Created by gopinath on 06/02/18.
 */

public class CategoryProducts {

    private String color;
    private String description;
    private String modelName;
    private String material;
    private String occasion;
    private String prodName;
    private int discountPrice;
    private int mrpPrice;
    private String sizesAvailable;
    private int rating;
    private String thumbnail;
    private ArrayList<String> images;

    public CategoryProducts(String color, String description, String modelName, String material, String occassion, String prodName, int discountPrice, int mrpPrice, String sizesAvailable, String thumbnail, ArrayList<String> images) {
        this.color = color;
        this.description = description;
        this.modelName = modelName;
        this.material = material;
        this.occasion = occassion;
        this.prodName = prodName;
        this.discountPrice = discountPrice;
        this.mrpPrice = mrpPrice;
        this.sizesAvailable = sizesAvailable;
        this.rating = rating;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getModelName() {
        return modelName;
    }

    public String getMaterial() {
        return material;
    }

    public String getOccasion() {
        return occasion;
    }

    public String getProdName() {
        return prodName;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getMrpPrice() {
        return mrpPrice;
    }

    public String getSizesAvailable() {
        return sizesAvailable;
    }

    public int getRating() {
        return rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public ArrayList<String> getImages() {
        return images;
    }
}
