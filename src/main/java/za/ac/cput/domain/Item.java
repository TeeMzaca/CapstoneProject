package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

    //Class Attributes
    @Id
    @Column (name = "item_id")
    private String id;
    private String name;
    private String author;
    private String genre;
    private String status;

    //Private constructor
    protected Item() {}

    private Item(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.author = builder.author;
        this.genre = builder.genre;
        this.status = builder.status;
    }

    //Builder Class
    public class Builder {

        //Builder Attributes
        private String id;
        private String name;
        private String author;
        private String genre;
        private String status;

        //Builder constructor
        private Builder () {}

        //Builder returns
        public Builder theirID (String id) {
            this.id = id;
            return this;
        }

        public Builder theirName (String name) {
            this.name = name;
            return this;
        }

        public Builder theirAuthor (String author) {
            this.author = author;
            return this;
        }

        public Builder theirGenre (String genre) {
            this.genre = genre;
            return this;
        }

        //Builder method
        public Item build() {
            Item item = new Item();
            item.id = this.id;
            item.name = this.name;
            item.author = this.author;
            item.genre = this.genre;
            item.status = this.status;
            return item;
        }
    }

    //Getters
    public String getItem_Id() {
        return id;
    }

    public String getItem_Name() {
        return name;
    }

    public String getItem_Author() {
        return author;
    }

    public String getItem_Genre() {
        return genre;
    }

    public String getItem_Status() {
        return status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}