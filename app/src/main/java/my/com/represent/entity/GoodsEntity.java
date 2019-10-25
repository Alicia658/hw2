package my.com.represent.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "GoodsEntity")
public class GoodsEntity {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "imgId")
    private int imgId;
    @Column(name = "name")
    private String name;
    @Column(name = "des")
    private String fooddes;
    @Column(name = "price")
    private String price;
    
    public int getImgId() {
        return imgId;
    }
    
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDes() {
        return fooddes;
    }
    
    public void setDes(String des) {
        this.fooddes = des;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
}
