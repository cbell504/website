package dev.christopherbell.photo;

import dev.christopherbell.libs.common.api.models.Response;
import dev.christopherbell.photo.model.PhotoGalleryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller that handles all photo gallery related requests.
 */
@AllArgsConstructor
@RestController
public class PhotoGalleryController {

  private final PhotoGalleryService photoGalleryService;

  /**
   * Returns all existing images for the photo gallery.
   *
   * @return a PhotoGalleryResponse containing all existing images.
   */
  @GetMapping(value = "/api/photos", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<PhotoGalleryResponse>> getImages() {
    return new ResponseEntity<>(
        Response.<PhotoGalleryResponse>builder()
            .payload(photoGalleryService.getAllImages())
            .success(true)
            .build(), HttpStatus.OK);
  }
}