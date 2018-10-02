package rpg3;

//super class
public class Character {

	protected String name;
	protected int hp;
	protected int power;

	public boolean attack(Character[] nowAttack, int which, Character[] damageCha, int seed) {
		String mark;
		if (nowAttack[which].hp <= 0) {
			return false;
		} else {
			if (nowAttack instanceof Justice[]) {
				mark = "☆";
			} else {
				mark = "★";
			}
			System.out.println(mark + nowAttack[which].getName() + "の攻撃！！");
			damageCha[seed].damage(nowAttack, which, damageCha, seed);
			return true;
		}
	}

	public void damage(Character[] nowAttack, int which, Character[] damageCha, int seed) {
		damageCha[seed].hp = damageCha[seed].hp - nowAttack[which].getPower();
		System.out.println("　　" + damageCha[seed].getName() + "は" + nowAttack[which].getPower() + "のダメージを受けた（残りHP "
				+ damageCha[seed].getHp() + ")");

	}

	public void introduce(String name, String job_name) {
		System.out.println("I am  " + name + ", and  a " + job_name + "！");
	}

	public void introduce(String name, String job_name, int mp) {
		System.out.println("I am  " + name + ", and " + job_name + ", my MP is " + mp + "!");
	}

	public int getHp() {
		return this.hp;
	}

	public int getPower() {
		return this.power;
	}

	public String getName() {
		return this.name;
	}

}
