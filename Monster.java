package rpg3;

//Character subclass
public class Monster extends Character {

	Monster(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = 10;
	}

	public void appear() {
		System.out.println(this.name + "が現れた！");
		this.introduce();
	}

	public void introduce() {
		System.out.println(this.name + "だぞー");
	}

	public boolean attack(Character damageCha) {
		if (this.hp <= 0) {
			return false;
		} else {
			System.out.println(getName() + "の攻撃！！");
			damageCha.damage(this.power, damageCha);
			return true;
		}
	}
}