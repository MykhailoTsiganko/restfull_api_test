package com.datamodels.models;


public class Order {
     private long id;
     private long petId;
     private long quantity;
     private String shipDate;
     private String status;
     private boolean complete;

     public Order(){}

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Order order = (Order) o;

          if (getId() != order.getId()) return false;
          if (getPetId() != order.getPetId()) return false;
          if (getQuantity() != order.getQuantity()) return false;
          if (isComplete() != order.isComplete()) return false;
          if (!getShipDate().equals(order.getShipDate())) return false;
          return getStatus().equals(order.getStatus());
     }

     @Override
     public int hashCode() {
          int result = (int) (getId() ^ (getId() >>> 32));
          result = 31 * result + (int) (getPetId() ^ (getPetId() >>> 32));
          result = 31 * result + (int) (getQuantity() ^ (getQuantity() >>> 32));
          result = 31 * result + getShipDate().hashCode();
          result = 31 * result + getStatus().hashCode();
          result = 31 * result + (isComplete() ? 1 : 0);
          return result;
     }

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
