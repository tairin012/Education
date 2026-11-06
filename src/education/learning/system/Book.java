
package education.learning.system;




public class Book {

    private String Name;
    private String Author;
    private String Category;
    private String Price;
    private String Quantity;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
   

    public Book(String Name, String Author, String Category, String Price, String Quantity) {
        this.Name = Name;
        this.Author = Author;
        this.Category = Category;
        this.Price = Price;
        this.Quantity = Quantity;
    }


    @Override
    public String toString() {
        return "Book{" + "Name=" + Name + ", Author=" + Author + ", Category=" + Category + ", Price=" + Price + ", Quantity=" + Quantity + '}';
    }
    
}
