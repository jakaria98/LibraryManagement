package com.libraryManagement.LibraryManagement.Model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String ID;
    private String name;
    private String address;
    private List<Shelf> shelves;

    public Library(String ID,String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.shelves = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }

    public void removeShelf(Shelf shelf) {
        shelves.remove(shelf);
    }
}
