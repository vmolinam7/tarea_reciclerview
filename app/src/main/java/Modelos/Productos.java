package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Productos {
    private String title;
    private String description;
    private String price;
    private String stock;
    private String [] Images;
    private String website;
    private String urlavatar;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String[] getImages() {
        return Images;
    }

    public void setImages(String[] images) {
        Images = images;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }

    public Productos(JSONObject a) throws JSONException {
        title = a.getString("title").toString();
        description = a.getString("description").toString();
        price = a.getString("price").toString();
        stock= a.getString("stock").toString();
        ObtenerImages(a);
        website = a.getString("thumbnail").toString() ;
        urlavatar = a.getString("thumbnail").toString() ;
    }

    private String[] ObtenerImages(JSONObject a) throws JSONException {
        JSONArray json=a.getJSONArray("images");
        this.Images=new String[json.length()];
        for(int i=0;i<json.length();i++){
            this.Images[i]=json.get(i).toString();
        }
        return this.Images;
    }

    public static ArrayList<Productos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Productos> Productos = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            Productos.add(new Productos(datos.getJSONObject(i)));
        }
        return Productos;
    }

}
