/*REFERENCE: https://listverse.com/2013/06/13/10-creepy-cave-dwelling-cryptids/
   			 https://io9.gizmodo.com/the-greatest-craziest-and-most-badass-monsters-in-gree-1698254404
   			 http://www.gods-and-monsters.com/list-of-mythical-creatures.html
 */
import java.util.Random;
public class Monster {
	private String name;
	private String description;
	private int health; //health that the monster has
	private int strength; //strength that the monster has (the value that will attack the player)
	private int exp; //the amount of exp that will be given to the player when monster is defeated
	private int gold; //the amount of gold that will be give to the player when monster is defeated
	private int agility;
	
	//constructor
	public Monster(String nameIn, String des, int hpIn, int strIn, int expIn, int goldIn, int agilIn) {
		name = nameIn;
		description = des;
		health = hpIn;
		strength = strIn;
		exp = expIn;
		gold = goldIn;
		agility = agilIn;
	}
	
	//set methods
	public void setName(String n) {
		this.name = n;
	}
	public void setDesc(String d) {
		this.description = d;
	}
	public void setHealth(int h) {
		this.health = h;
	}
	public void setStrength(int s) {
		this.strength = s;
	}
	public void setExp(int e) {
		this.exp = e;
	}
	public void setGold(int g) {
		this.gold = g;
	}
	public void setAgility(int i) {
		this.agility = i;
	}
	
	//get methods
	public String getName() {
		return name;
	}
	public String getDesc() {
		return description;
	}
	public int getHealth() {
		return health;
	}
	public int getStrength() {
		return strength;
	}
	public int getExp() {
		return exp;
	}
	public int getGold() {
		return gold;
	}
	public int getAgility() {
		return agility;
	}
	
	//display monster specs when loaded
	public String toString() {
		return "Monster: " + name + "\n" + "Description: " + description + "\n" + "Health: " + health + "\n" + "Strength: " + strength + "\n";
	}
	
	//display monster name
	
	//attack player
	public void attackPlayer(Character c) { //needs to check the object class name
		Random rand = new Random();
		int damage = this.strength + rand.nextInt(10);
		if (c.getHealth() > 0) { //must check the get method from character class
			c.setHealth(c.getHealth() - damage); //must check the set method from character class
		}
		else if (c.getHealth() > 0 && c.getHealth() - damage <= 0) {
			c.setHealth(0);
		}
	}
}
