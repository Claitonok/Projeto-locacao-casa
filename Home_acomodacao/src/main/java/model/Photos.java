package model;

public class Photos {
   private int id;
   private String source;
   private String description;
   private String city;
   private String price;
   private String state;
   private String rating;
   private String title;

   public Photos(int id, String source, String description, String city, String price, String state, String rating, String title) {
      this.id = id;
      this.source = source;
      this.description = description;
      this.city = city;
      this.price = price;
      this.state = state;
      this.rating = rating;
      this.title = title;
   }

   public Photos() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getPrice() {
      return this.price;
   }

   public void setPrice(String price) {
      this.price = price;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getRating() {
      return this.rating;
   }

   public void setRating(String rating) {
      this.rating = rating;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }
}
