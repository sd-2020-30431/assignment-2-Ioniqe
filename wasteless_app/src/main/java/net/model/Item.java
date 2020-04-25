package net.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    private Lists list;

    private String name;
    private int quantity;
    private int calories;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consumptionDate;

    public Item() {
    }

    public Item(String name, int quantity, int calories, Date purchaseDate, Date expirationDate, Date consumptionDate) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lists getList() {
        return list;
    }

    public void setList(Lists list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }



    //-----------for OBSERVER----------------

    public int notifyItem(){
        Date today = Calendar.getInstance().getTime();

        long daysBetween = Duration.between(today.toInstant(), expirationDate.toInstant()).toDays();

//        if(daysBetween <= 3){
//            System.out.println(daysBetween + " days remaining for " + name);
//        }

        return (int) daysBetween;
//        if(today.compareTo(expirationDate) == 0){
//            System.out.println("THEY ARE THE SAME DATE");
//        }
    }
}
