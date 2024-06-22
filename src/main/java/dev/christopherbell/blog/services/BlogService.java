package dev.christopherbell.blog.services;

import dev.christopherbell.blog.models.blog.BlogResponse;
import dev.christopherbell.blog.models.blog.Post;
import dev.christopherbell.blog.models.global.Message;
import dev.christopherbell.blog.configs.Constants;
import dev.christopherbell.blog.configs.properties.BlogProperties;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogService {

  private final BlogProperties blogProperties;

  @Autowired
  public BlogService(BlogProperties blogProperties) {
    this.blogProperties = blogProperties;
  }

  public BlogResponse getPostById(String id) {
    if (Objects.isNull(id) || id.isBlank()) {
      final var message = new Message("BlogService.getPostById.InvalidId", "Given id is blank, empty or null");
      log.error(message.getDescription());
      final var messages = List.of(message);
      return new BlogResponse(null, messages, Constants.STATUS_FAILURE);
    }
    final var posts = this.blogProperties.getPosts();
    if (Objects.isNull(posts)) {
      final var message = new Message("BlogService.getPosts.NoResults", "No posts found in the config file.");
      log.error(message.getDescription());
      final var messages = List.of(message);
      return new BlogResponse(null, messages, Constants.STATUS_FAILURE);
    }
    Post post = null;
    for (Post blogPost : posts) {
      if (blogPost.getId().equals(Integer.parseInt(id))) {
        post = blogPost;
      }
    }
    return new BlogResponse(post, null, null);
  }

  public BlogResponse getPosts() {
    final var posts = this.blogProperties.getPosts();
    if (Objects.isNull(posts)) {
      final var message = new Message("BlogService.getPosts.NoResults", "No posts found in the config file.");
      log.error(message.getDescription());
      final var messages = List.of(message);
      return new BlogResponse(null, null, messages, Constants.STATUS_FAILURE);
    }
    return new BlogResponse(posts, null, null, null);
  }

  public BlogResponse getTagById(String id) {
    return new BlogResponse(null, null, null, null);
  }

  public BlogResponse getTags() {
    return new BlogResponse(null, null, null, null);
  }
}
