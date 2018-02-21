package myshoes.com.myshoes.model;

import java.util.ArrayList;

/**
 * Created by gopinath on 21/02/18.
 */

public class HomeData {

    /*

    color:
"White"
description:
"long lasting best shoes"
discountPrice:
296
image
image1:
"https://firebasestorage.googleapis.com/v0/b/new..."
image2:
"https://firebasestorage.googleapis.com/v0/b/new..."
material:
"canvas"
modelName:
"Boxer-303"
mrpPrice:
499
occasion:
"Casual"
prodName:
"Oricum Boxer-303 Sneakers"
rating
sizeAvailable:
"5,6,7,8"


     */

    private String color, description, modelName,
            material, occassion, prodName, discountPrice,
            mrpPrice, sizesAvailable, rating;

    private String[] image;

    public HomeData(String color, String description, String modelName, String material, String occassion, String prodName, String discountPrice, String mrpPrice, String sizeAvailable, ArrayList<String> imageUrl) {

    }
    public HomeData(String color, String description, String modelName, String material, String occassion, String prodName, String discountPrice, String mrpPrice, String sizesAvailable, String[] images) {
        this.color = color;
        this.description = description;
        this.modelName = modelName;
        this.material = material;
        this.occassion = occassion;
        this.prodName = prodName;
        this.discountPrice = discountPrice;
        this.mrpPrice = mrpPrice;
        this.sizesAvailable = sizesAvailable;
        this.image = images;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(String mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public String getSizesAvailable() {
        return sizesAvailable;
    }

    public void setSizesAvailable(String sizesAvailable) {
        this.sizesAvailable = sizesAvailable;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }
}
