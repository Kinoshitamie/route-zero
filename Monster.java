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
	}

}
