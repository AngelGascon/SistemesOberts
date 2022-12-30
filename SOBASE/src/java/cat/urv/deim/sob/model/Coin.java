/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.model;

import java.util.Date;

/**
 *
 * @author angel
 */
public class Coin {
    
    private Integer id;
    private String name;
    private String description;
    private Float lastQuotation;
    private Date currentDate;

    public Coin() {
    }

    public Coin(Integer id, String name, String description, Float lastQuotation, Date currentDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lastQuotation = lastQuotation;
        this.currentDate = currentDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getLastQuotation() {
        return lastQuotation;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastQuotation(Float lastQuotation) {
        this.lastQuotation = lastQuotation;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
