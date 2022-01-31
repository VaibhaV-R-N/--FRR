public class Food {
String Name;
String[] Ingredient;
String ingre;
Float quan;
Float[] Quantity;

public Food(String name, String ingre, Float quan) {
    Name = name;
    this.ingre = ingre;
    this.quan = quan;
}
public Food(String Name,String[] Ingredient,Float[] Quantity ){
    this.Name = Name;
    this.Ingredient = Ingredient;
    this.Quantity = Quantity;

}
public Food(String ingredient,Float quantity){
    this.ingre= ingredient;
    this.quan= quantity;
}

public Food(){

}

public void setIngredient(String ingredient) {
    this.ingre = ingredient;
}
public void setQuantity(Float quantity) {
    this.quan = quantity;
}
public String getName() {
    return Name;
}

public void setName(String name) {
    Name = name;
}

public String[] getIngredient() {
    return Ingredient;
}

public void setIngredient(String[] ingredient) {
    Ingredient = ingredient;
}

public Float[] getQuantity() {
    return Quantity;
}

public void setQuantity(Float[] quantity) {
    Quantity = quantity;
}

public String getIngre(){
    return ingre;

}
public Float  getQuan(){
    return quan;
    
}



    
}