package app.carte.entity;

public  class Ingredient {
    private String name;
    private Integer amount = 1;

    public Ingredient(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public Integer getAmount(){
        return this.amount;
    }
}