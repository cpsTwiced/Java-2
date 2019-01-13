import java.util.Random;
public class Character 
{
	//variables
	private String name,description;
	private int level;
	private int health,maxHealth,strength,luck,agility,exp,gold;
   //private ArrayList<Potion> inventory;
	
	public Character(String n, String d, int h, int m, int s, int l, int a, int e, int g, int lvl)
	{
		name = n;
		description = d;
		health = h;
      maxHealth = m;
		strength = s;
		luck = l;
		agility = a;
		exp = e;
		gold = g;
		level = lvl;
	}
	
	//accessors
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getHealth() {
		return health;
	}
	
   public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getLuck()
	{
		return luck;
	}
	
	public int getAgility()
	{
		return agility;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	//mutators
	public void setName(String n)
	{
		name = n;
	}
	
	public void setDescription(String d)
	{
		description = d;
	}
	
	public void setHealth(int h)
	{
		health = h;
	}
	
	public void setMaxHealth(int m)
	{
		maxHealth = m;
	}
	
   public void setStrength(int s)
	{
		strength = s;
	}
	
	public void setLuck(int l)
	{
		luck = l;
	}
	
	public void setAgility(int a)
	{
		agility = a;
	}
	
	public void setGold(int g)
	{
		gold = g;
	}
	
	public void setExp(int e)
	{
		exp = e;
	}
	
	public void setLevel(int lvl)
	{
		level = lvl;
	}
	
	//toString
	public String toString()
	{
		return "\nCharacter name: " + name + "\nDescription: " + description + "\nHealth: " + health + "/" + maxHealth + "\nStrength: " + strength + "\nLuck: " + luck + "\nAgility: " + agility + "\nGold: " + gold + "\nLevel: " + level +"\nEXP: " + exp;
	}
	
	//deals damage = to strength when attacking
	public void damage(Monster m)
	{
		Random rand = new Random();
		int damage = this.strength + rand.nextInt(10);
		if (m.getHealth() > 0) {
			m.setHealth(m.getHealth() - damage);
		}
		else if (m.getHealth() > 0 && m.getHealth() - damage <= 0) {
			m.setHealth(0);
		}
	}
	
	//adds weapon value to strength
	public void equip(Weapon w)
	{
		this.setStrength(this.getStrength()+w.getStrength());
	}
	
	//increases experience
	public void gainXP(Monster m)
	{
      System.out.print("You have gained " + m.getExp() + " exp. ");
		if (exp + m.getExp() <= 100) {
			exp = m.getExp() + exp;
		}
		else if (exp + m.getExp() > 100) {
			System.out.print("You have levelled up! Your stats increase. ");
         exp = m.getExp() + exp - 100;
			level++;
         health+=100;
         maxHealth+=100;
         strength+=15;
         luck+=10;
         agility+=5;
		}
	}
	
	//adds gold
	public void addMGold(Monster m) 
	{
		this.setGold(this.getGold() + m.getGold());
		System.out.print("You have obtained " + m.getGold() + " gold. ");
	}
}
