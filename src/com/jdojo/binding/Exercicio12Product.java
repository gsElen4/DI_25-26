package com.jdojo.binding;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Exercicio12Product {
    private String name;
    private Double price;

    private PropertyChangeSupport support;

    public Exercicio12Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.support = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double newPrice) {
        if ((this.price == null && newPrice != null) ||
            (this.price != null && !this.price.equals(newPrice))) {
            Double oldPrice = this.price;
            this.price = newPrice;
            support.firePropertyChange("price", oldPrice, newPrice);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public Double getDiscount() {
        return price * 0.10;
    }
}
