package dev.christopherbell.blog.services;

import dev.christopherbell.blog.models.blog.BlogResponse;
import dev.christopherbell.blog.configs.properties.BlogProperties;
import dev.christopherbell.libs.common.api.exceptions.InvalidRequestException;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Represents the service layer for handling blog related requests.
 */
@AllArgsConstructor
@Service
@Slf4j
public class BlogService {

  private final BlogProperties blogProperties;

  /**
   * Gets a blog post with the requested id.
   *
   * @param id of the requested blog post,
   * @return a BlogResponse with the requested post.
   * @throws InvalidRequestException when id is not as expected or no blog post is found.
   */
  public BlogResponse getPostById(String id) throws InvalidRequestException {
    if (Objects.isNull(id) || id.isBlank()) {
      throw new InvalidRequestException("Id can't be null or blank");
    }

    for (var post : blogProperties.getPosts()) {
      if (post.getId().equals(Integer.parseInt(id))) {
        return BlogResponse.builder()
            .posts(List.of(post))
            .build();
      }
    }

    throw new InvalidRequestException("No Post Found");
  }

  /**
   * Get all existing blog posts.
   *
   * @return a BlogResponse containing a list of all blog posts.
   */
  public BlogResponse getPosts() {
    return BlogResponse.builder()
        .posts(blogProperties.getPosts())
        .build();
  }
}
