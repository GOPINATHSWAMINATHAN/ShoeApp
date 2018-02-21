package myshoes.com.myshoes.model;

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
            mrpPrice, sizesAvailable;

    private String[] images;

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

    public String getOccassion() {
        return occassion;
    }

    public String getProdName() {
        return prodName;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public String getMrpPrice() {
        return mrpPrice;
    }

    public String getSizesAvailable() {
        return sizesAvailable;
    }

    public String[] getImages() {
        return images;
    }

}
