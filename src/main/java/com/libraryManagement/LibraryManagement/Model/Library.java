package com.libraryManagement.LibraryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "libraries")
public class Library {
    @Id
    @NotEmpty(message = "Library ID is required")
    private String ID;
    @NotEmpty(message = "Library Name is required")
    private String name;
    @NotEmpty(message = "Library Address is required")
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
