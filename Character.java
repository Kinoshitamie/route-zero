package rpgif;

/*
 * abstract
 */
public abstract class Character {
	protected String name;
	protected int hp;
	protected int max_hp;
	protected int power;
	protected boolean life_flg;
	protected boolean win_low;

	Character() {
		this.life_flg = true;
	}

	public abstract boolean attack(Character damageCha);

	public void damage(int power, Character damageCha) {
		damageCha.hp = damageCha.hp - power;
		System.out.println(damageCha.getName() + "は" + power + "のダメージを受けた（残りHP " + damageCha.getHp() + ")");
		if (damageCha.hp <= 0) {
			System.out.println(damageCha.name + "is down!");
			damageCha.life_flg = false;
		}
	}

	public void introduce() {
		System.out.println("I am  " + this.name);
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxHp() {
		return this.max_hp;
	}

	public String getName() {
		return this.name;
	}
}
