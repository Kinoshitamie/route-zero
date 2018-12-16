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

	public void damage(int power) {
		this.hp = this.hp - power;
		System.out.println(this.getName() + "は" + power + "のダメージを受けた（残りHP " + this.getHp() + ")");
		if (this.hp <= 0) {
			System.out.println(this.name + "is down!");
			this.life_flg = false;
		}
	}

	public void introduce() {
		System.out.println("I am  " + this.name);
	}

	public int getHp() {
		return this.hp;
	}

	public int getPower() {
		return this.power;
	}

	public int getMaxHp() {
		return this.max_hp;
	}

	public String getName() {
		return this.name;
	}
}
