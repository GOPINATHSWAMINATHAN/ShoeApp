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

    private ArrayList<String> color;
    private ArrayList<String> description;
    private ArrayList<String> modelName;
    private ArrayList<String> material;
    private ArrayList<String> occassion;
    private ArrayList<String> prodName;
    private ArrayList<String> discountPrice;
    private ArrayList<String> mrpPrice;
    private ArrayList<String> sizesAvailable;
    private ArrayList<String> rating;
    private ArrayList<String> thumbnail;

    private ArrayList<String> image;

    public HomeData(String color, String description, String modelName, String material, String occassion, String prodName, String discountPrice, String mrpPrice, String sizeAvailable, ArrayList<String> imageUrl) {

    }


    public HomeData(ArrayList<String> color, ArrayList<String> description, ArrayList<String> modelName, ArrayList<String> material, ArrayList<String> occassion, ArrayList<String> prodName, ArrayList<String> discountPrice, ArrayList<String> mrpPrice, ArrayList<String> sizesAvailable, ArrayList<String> images, ArrayList<String> thumbnail) {
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

    public ArrayList<String> getColor() {
        return color;
    }

    public void setColor(ArrayList<String> color) {
        this.color = color;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public ArrayList<String> getModelName() {
        return modelName;
    }

    public void setModelName(ArrayList<String> modelName) {
        this.modelName = modelName;
    }

    public ArrayList<String> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<String> material) {
        this.material = material;
    }

    public ArrayList<String> getOccassion() {
        return occassion;
    }

    public void setOccassion(ArrayList<String> occassion) {
        this.occassion = occassion;
    }

    public ArrayList<String> getProdName() {
        return prodName;
    }

    public void setProdName(ArrayList<String> prodName) {
        this.prodName = prodName;
    }

    public ArrayList<String> getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(ArrayList<String> discountPrice) {
        this.discountPrice = discountPrice;
    }

    public ArrayList<String> getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(ArrayList<String> mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public ArrayList<String> getSizesAvailable() {
        return sizesAvailable;
    }

    public void setSizesAvailable(ArrayList<String> sizesAvailable) {
        this.sizesAvailable = sizesAvailable;
    }

    public ArrayList<String> getRating() {
        return rating;
    }

    public void setRating(ArrayList<String> rating) {
        this.rating = rating;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public ArrayList<String> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ArrayList<String> thumbnail) {
        this.thumbnail = thumbnail;
    }
}
