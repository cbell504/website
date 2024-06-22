package dev.christopherbell.blog.models.wfl;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Restaurant {

  private Address address;
  private Integer id;
  private String name;
  private String phoneNumber;
}