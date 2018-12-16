package rpgif;

/*
 * Character subclass
 */
public class Justice extends Character implements Movable {

	protected String job_name;
	protected int mp;

	Justice(String name, int hp, String job_name) {
		super();
		this.name = name;
		this.hp = hp;
		this.job_name = job_name;
		this.power = 15;
		this.introduce();
		this.max_hp = this.hp;
	}

	@Override
	public boolean move(Character tagert) {
		this.attack(tagert);
		return win_low;
	}

	public void introduce() {
		System.out.println("I am  " + this.name + ", and  a " + this.job_name + "！");
	}

	@Override
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

}
