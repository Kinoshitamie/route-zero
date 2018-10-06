package rpg3;

public class Monk extends Character {

	protected String job_name;
	protected int mp;

	Monk(String name, int hp, String job_name, int mp) {

		super();
		this.name = name;
		this.hp = hp;
		this.job_name = job_name;
		this.power = 5;
		this.mp = mp;
		this.introduce();
		this.max_hp = this.hp;
	}

	public void introduce() {
		System.out.println("私は  " + this.name + "ていう名前で " + this.job_name + "をしてて, MP は " + this.mp + "だわさ");
	}

	public boolean attack(Character nowAttack, int which, Character damageCha, int seed) {

		if (nowAttack.hp <= 0) {
			return false;
		} else {

			damageCha.hp += this.mp;	//回復maxHPまで
			if (damageCha.hp > damageCha.max_hp) {
				damageCha.hp = damageCha.max_hp;
				System.out.println(nowAttack.name + "はベホマズンを唱えたが何も起こらなかった！");
			}else {		
				System.out.println(nowAttack.name + "はベホマズンを唱えた！" + damageCha.name + "は" + this.mp + "回復した");
			}
			return true;
		}
		
	}

}
