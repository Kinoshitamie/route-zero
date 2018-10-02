package rpg3;

public class Justice extends Character {

	protected String job_name;
	protected int mp;

	Justice(String name, int hp, String job_name) {
		super();
		this.name = name;
		this.hp = hp;
		this.job_name = job_name;
		this.power = 15;
		this.introduce(name, job_name);
	}

	Justice(String name, int hp, String job_name, int mp) {
		super();
		this.name = name;
		this.hp = hp;
		this.job_name = job_name;
		this.power = 5;
		this.mp = mp;
		this.introduce(name, job_name, mp);
	}

	public void heal(Character[] hero, int seed) {
		hero[seed].hp += this.mp;
		System.out.println(hero[2].name + "はベホマズンを唱えた！" + hero[seed].name + "は" + this.mp + "回復した");
	}

	public int getMp() {
		return this.mp;
	}

	public String getJob_name() {
		return this.job_name;
	}

}
