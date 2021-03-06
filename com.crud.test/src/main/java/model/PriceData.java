package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "price_data")
public class PriceData {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @JsonProperty("code")
    @Column(name="code")
    private String code;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @JsonProperty("price")
    @Column(name="price")
    private double price;

    public PriceData() {
    }

    public PriceData(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
