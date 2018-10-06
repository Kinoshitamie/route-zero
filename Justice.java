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
		this.introduce();
		this.max_hp=this.hp;
	}

	
	public void introduce() {
		System.out.println("I am  " + this.name + ", and  a " + this.job_name + "！");
	}
	@Override	
	public boolean attack(Character nowAttack, int which, Character damageCha, int seed) {
		
		if (nowAttack.hp <= 0) {
			return false;
		} else {			
			System.out.println(nowAttack.getName() + "の攻撃！！");
			damageCha.damage(nowAttack, which, damageCha, seed);
			return true;
		}
	}
	
	public String getJob_name() {
		return this.job_name;
	}

}
