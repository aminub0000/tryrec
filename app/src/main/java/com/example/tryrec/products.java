package com.example.tryrec;

public class products {
    String img;
    String nom;
    String categorie;
    String datep;
    String datef;

    public String getDatep() {
        return datep;
    }

    public void setDatep(String datep) {
        this.datep = datep;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    String prix;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    int quantité_product;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getQuantité_product() {
        return quantité_product;
    }

    public void setQuantité_product(int quantité_product) {
        this.quantité_product = quantité_product;
    }
    public products() {
    }

    public products(String nom, String categorie, String datep, String datef, String prix, int quantité_product,String img) {
        this.nom = nom;
        this.categorie = categorie;
        this.datep = datep;
        this.datef = datef;
        this.prix = prix;
        this.quantité_product = quantité_product;
        this.img = img;
    }
    public products(String nom, String categorie, String datep, String datef, String prix,String img) {
        this.nom = nom;
        this.categorie = categorie;
        this.datep = datep;
        this.datef = datef;
        this.prix = prix;
        this.quantité_product = quantité_product;
        this.img = img;
    }

    public products(String img,String nom, String categorie, String prix, int quantité_product) {
        this.img = img;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantité_product = quantité_product;
    }
    public products(String nom, String categorie, String prix, int quantité_product) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantité_product = quantité_product;
    }
}
