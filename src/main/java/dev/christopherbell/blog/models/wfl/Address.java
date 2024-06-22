package dev.christopherbell.blog.models.wfl;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {

  private String city;
  private String state;
  private String streetName;
  private String postalCode;
}
