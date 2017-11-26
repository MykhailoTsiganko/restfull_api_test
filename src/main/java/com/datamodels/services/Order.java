package com.datamodels.services;

import java.time.LocalDateTime;

public class Order {
     private long id;
     private long petId;
     private long quantity;
     private LocalDateTime time;
     private String status;
     private boolean complite;

     public Order(long id, long petId, long quantity, LocalDateTime time, String status, boolean complite) {
          this.id = id;
          this.petId = petId;
          this.quantity = quantity;
          this.time = time;
          this.status = status;
          this.complite = complite;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getPetId() {
          return petId;
     }

     public void setPetId(long petId) {
          this.petId = petId;
     }

     public long getQuantity() {
          return quantity;
     }

     public void setQuantity(long quantity) {
          this.quantity = quantity;
     }

     public LocalDateTime getTime() {
          return time;
     }

     public void setTime(LocalDateTime time) {
          this.time = time;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public boolean isComplite() {
          return complite;
     }

     public void setComplite(boolean complite) {
          this.complite = complite;
     }
}
