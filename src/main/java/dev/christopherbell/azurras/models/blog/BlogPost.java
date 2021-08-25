package dev.christopherbell.azurras.models.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    private String author;
    private String contentText;
    private Date creationDate;
    private String description;
    private int id;
    private String imagePath;
    private String tags;
    private String title;

    public BlogPost(String author,
                    String contentText,
                    String description,
                    String imagePath,
                    String tags,
                    String title) {
        this.author =  author;
        this.contentText = contentText;
        this.description = description;
        this.imagePath = imagePath;
        this.tags = tags;
        this.title = title;
    }
}
