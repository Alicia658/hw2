package my.com.represent.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "OrderEntity")
public class OrderEntity {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "imgId")
    private int imgId;
    @Column(name = "name")
    private String name;
    @Column(name = "des")
    private String des;
    @Column(name = "price")
    private String price;
    @Column(name = "num")
    private String num;
    
    public int getImgId() {
        return imgId;
    }
    
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDes() {
        return des;
    }
    
    public void setDes(String des) {
        this.des = des;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getNum() {
        return num;
    }
    
    public void setNum(String num) {
        this.num = num;
    }
}
