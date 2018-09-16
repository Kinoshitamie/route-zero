package rpg3;

//super class
public class Character {

	protected String name;
	protected int hp;
	protected int power;

	public int getHp() {
		return this.hp;
	}

	public int getPower() {
		return this.power;
	}

	public String getName() {
		return this.name;
	}

	public void damage(int power) {
		this.hp -= power;
	}
}
