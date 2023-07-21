package com.musala.drones.models;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class BaseModel implements Serializable {

  @CreatedDate
  @Column(name = "created_date", columnDefinition = "TIMESTAMP")
  Instant createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date", columnDefinition = "TIMESTAMP")
  Instant lastModifiedDate;

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  public Instant getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
}
