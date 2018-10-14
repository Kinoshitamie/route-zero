package rpgif;

/*
 * Character subclass
 */
public class Monk extends Character implements Movable {

	static String job_name = "monk";
	protected int mp;

	Monk(String name, int hp, int mp) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = 5;
		this.mp = mp;
		this.introduce();
		this.max_hp = this.hp;
	}

	@Override
	public boolean move(Character tagert) {
		this.attack(tagert);
		return win_low;
	}

	public void introduce() {
		System.out.println("私は  " + this.name + "ていう名前で " + job_name + "をしてて, MP は " + this.mp + "だわさ");
	}

	public boolean attack(Character damageCha) {

		if (this.hp <= 0) {
			win_low = false;
			return win_low;
		} else {

			damageCha.hp += this.mp; // 回復maxHPまで
			if (damageCha.hp > damageCha.max_hp) {
				damageCha.hp = damageCha.max_hp;
				System.out.println(this.name + "はベホマズンを唱えたが何も起こらなかった！");
			} else {
				System.out.println(this.name + "はベホマズンを唱えた！" + damageCha.name + "は" + this.mp + "回復した");
			}
			win_low = true;
			return win_low;
		}
	}
}
