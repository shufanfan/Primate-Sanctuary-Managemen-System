package sanctuary.model;


/**
 * this class represents an individual monkey,
 * including its name, species, sex, size, weight, age, and favorite food
 */


public class Monkey {
    private String name;
    private Species species;
    private Sex sex;

    private String size;
    private double weight;
    private int age;
    private Food favoriteFood;

    public Monkey(String name, Species species, Sex sex, String size, double weight, int age, Food favoriteFood) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    /**
     * Gets the monkey's name.
     * @return The name of the monkey.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the monkey's species.
     * @return The species of the monkey.
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Gets the monkey's sex.
     * @return The sex of the monkey.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Gets the monkey's size.
     * @return The size of the monkey.
     */
    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Sex: " + sex + ", Favorite Food: " + favoriteFood;
    }

}
