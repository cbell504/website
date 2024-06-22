package dev.christopherbell.blog.models.blog;

import java.util.List;

import dev.christopherbell.blog.models.global.Message;
import dev.christopherbell.blog.models.global.Response;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlogResponse extends Response {

  private Post post;
  private List<Post> posts;
  private List<String> tags;

  public BlogResponse(List<Post> posts, List<String> tags, List<Message> messages, String status) {
    super(messages, status);
    this.posts = posts;
    this.tags = tags;
  }

  public BlogResponse(Post post, List<Message> messages, String status) {
    super(messages, status);
    this.post = post;
  }
}
