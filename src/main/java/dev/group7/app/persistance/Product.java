package dev.group7.app.persistance;

public class Product {
    private int Pro_id;
    private String Pro_name;
    private double Unit_price;
    private int Pro_amount;
    private String Pro_status;
    private String Pro_description;
    private  String pro_pack;
    private  int Category_ID;

    public Product() {
    };

    public Product(int Pro_id, String Pro_name, double Unit_price, int Pro_amount, String Pro_status,
            String Pro_description) {
        super();
        this.Pro_id = Pro_id;
        this.Pro_name = Pro_name;
        this.Unit_price = Unit_price;
        this.Pro_amount = Pro_amount;
        this.Pro_status = Pro_status;
        this.Pro_description = Pro_description;
    };

    public void setPro_id(int Pro_id) {
        this.Pro_id = Pro_id;
    }

    public int getPro_id() {
        return Pro_id;
    }

    public void setPro_name(String Pro_name) {
        this.Pro_name = Pro_name;
    }

    public String getPro_name() {
        return Pro_name;
    }

    public void setUnitPrice(Double Unit_price) {
        this.Unit_price = Unit_price;
    }

    public Double getUnitPrice() {
        return Unit_price;
    }

    public void setAmount(int Pro_amount) {
        this.Pro_amount = Pro_amount;
    }

    public int getAmount() {
        return Pro_amount;
    }

    public void setPro_status(String Pro_status) {
        this.Pro_status = Pro_status;
    }

    public String getPro_status() {
        return Pro_status;
    }

    public void setDescription(String Pro_description) {
        this.Pro_description = Pro_description;
    }

    public String getDescription() {
        return Pro_description;
    }
    public String getpro_pack(){
        return pro_pack;
    }
    public void setpro_pack(String pro_pack){
        this.pro_pack=pro_pack;
    }

    public int getCategory_ID(){
        return Category_ID;
    }
    public void setCategory_ID(int category_ID){
        this.Category_ID=category_ID;
    }


    
}