package app.carte.entity;

public  class Ingredient {
    private String name;
    private Integer amount;

    public Ingredient(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

/**
 * This function sets the name of the object to the name passed in as a parameter
 * 
 * @param name The name of the parameter.
 */
    public void setName(String name){
        this.name = name;
    }

/**
 * This function returns the name of the ingredient
 * 
 * @return The name of the ingredient.
 */
    public String getName(){
        return this.name;
    }

/**
 * This function sets the amount of the item
 * 
 * @param amount The amount of the this ingredient.
 */
    public void setAmount(Integer amount){
        this.amount = amount;
    }

/**
 * This function returns the amount of this ingredient
 * 
 * @return The amount of the item.
 */
    public Integer getAmount(){
        return this.amount;
    }
}