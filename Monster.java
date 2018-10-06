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

public boolean attack(Character nowAttack, int which, Character damageCha, int seed) {

	if (nowAttack.hp <= 0) {
		return false;
	} else {
		
		System.out.println(nowAttack.getName() + "の攻撃！！");
		damageCha.damage(nowAttack, which, damageCha, seed);
		return true;
	}
}}