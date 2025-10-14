package com.jdojo.binding;

public class Person {
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[]args) {
    	Person p = new Person();
    	p.setName("Jonh Jacobs");
    	String name = p.getName();
    	
    }
}
