package com.datamodels.models;

import java.util.Arrays;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag [] tags;
    private String status;

    public Pet(long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        if (!category.equals(pet.category)) return false;
        if (!name.equals(pet.name)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photoUrls, pet.photoUrls)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(tags, pet.tags)) return false;
        return status.equals(pet.status);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(photoUrls);
        result = 31 * result + Arrays.hashCode(tags);
        result = 31 * result + status.hashCode();
        return result;
    }
}
