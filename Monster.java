package rpgif;
/*
 * Character subclass
 */

public class Monster extends Character implements Movable {

	Monster(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = 10;
	}

	@Override
	public boolean move(Character target) {
		this.attack(target);
		return win_low;
	}

	public boolean attack(Character damageCha) {
		if (this.hp <= 0) {
			win_low = false;
			return win_low;

		} else {
			System.out.println(getName() + "の攻撃！！");
			damageCha.damage(this.power);
			win_low = true;
			return win_low;
		}
	}

	public void appear() {
		System.out.println(this.name + "が現れた！");
		this.introduce();
	}

	public void introduce() {
		System.out.println("「" + this.name + "だぞー」");
	}

}