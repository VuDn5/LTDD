package com.example.hw08.Data;

public class ItemChannel {
    private String Name;
    private String Key;
    private String Link;
    private String Description;

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public ItemChannel() {
    }

    public ItemChannel(String name, String key, String link) {
        Name = name;
        Key = key;
        Link = link;
    }

    public ItemChannel(String name, String key) {
        Name = name;
        Key = key;
        Link = "";
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
