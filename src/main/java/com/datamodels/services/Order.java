package com.datamodels.services;


public class Order {
     private long id;
     private long petId;
     private long quantity;
     private String shipDate;
     private String status;
     private boolean complete;

     public Order(long id, long petId, long quantity, String time, String status, boolean complite) {
          this.id = id;
          this.petId = petId;
          this.quantity = quantity;
          this.shipDate = time;
          this.status = status;
          this.complete = complite;
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

     public String getShipDate() {
          return shipDate;
     }

     public void setShipDate(String shipDate) {
          this.shipDate = shipDate;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public boolean isComplete() {
          return complete;
     }

     public void setComplete(boolean complete) {
          this.complete = complete;
     }
}
