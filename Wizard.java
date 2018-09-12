package MakingRPG;

//Character subclass
public class Wizard extends Character {

	private int mp;
	private int power;
	
	Wizard(String name, int hp, int mp, String job_name) {
		this.hp = hp;
		this.mp = 80;
		this.power=30;
		this.name = name;
		this.item_price = 30;
		introduce(this.name, job_name);

	}
	public void magic(Monster mon) {
		System.out.println(this.name + "はベキラゴンをとなえた!");
		
		System.out.println(mon.name + "は" + this.power + "のダメージ！");
	}

}
