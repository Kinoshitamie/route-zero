package rpg3;

//super class
public abstract class Character {

	protected String name;
	protected int hp;
	protected int max_hp;
	protected int power;
	protected boolean life_flg;
	Character(){
		this.life_flg=true;
	}
	public abstract boolean attack(Character nowAttack, int which, Character damageCha, int seed);

	public void damage(Character nowAttack, int which, Character damageCha, int seed) {
		damageCha.hp = damageCha.hp - nowAttack.getPower();
		System.out.println(
				damageCha.getName() + "は" + nowAttack.getPower() + "のダメージを受けた（残りHP " + damageCha.getHp() + ")");
		if(damageCha.hp <=0) {
			System.out.println(damageCha.name+"is down!");
			life_flg=false;
			
		}

	}

	public void introduce() {
		System.out.println("I am  " + this.name );
	}

	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.max_hp;
	}
	public int getPower() {
		return this.power;
	}

	public String getName() {
		return this.name;
	}

}
