package rpgif;

public class Dancer implements Movable {

	static String name;
	static String Job_name = "Dancer";
	protected boolean win_low;
	protected int hp;
	protected int power = 2;
	protected int max_hp;
	static boolean life_flg = true;

	Dancer(String name, int hp) {
		Dancer.name = name;
		this.hp = hp;
		max_hp = hp;
		introduce();
	}

	@Override
	public boolean move(Character tagert) { // なにをかえす？？
		attack(tagert);
		return true;
	}

	public boolean attack(Character damageCha) {
		if (this.hp <= 0) {
			win_low = false;
			return win_low;
		} else {
			System.out.println(name + "はセンスで叩いた！！");
			damageCha.damage(power, damageCha);
			win_low = true;
			return win_low;
		}
	}

	public void damage(int power, Character damageCha) {
		damageCha.hp = damageCha.hp - power;
		System.out.println(damageCha.getName() + "は" + power + "のダメージを受けて少し痛かった！（残りHP " + damageCha.getHp() + ")");
		if (damageCha.hp <= 0) {
			System.out.println(damageCha.name + "is down!");
			damageCha.life_flg = false;
		}
	}

	public void introduce() {
		System.out.println("私は" + name + "！" + Dancer.Job_name + "よん!");
	}

	public int getHp() {
		return this.hp;
	}
}
