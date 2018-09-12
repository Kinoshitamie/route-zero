package MakingRPG;

//Character subclass
public class Hero extends Character {

	Hero(String name, int hp, String job_name) {
		this.name = name;
		this.hp = hp;
		this.power = 10;
		this.item_price = 20;
		introduce(this.name, job_name);
	}

	public void attack(Monster mon) {
		System.out.println(this.name + "の攻撃!");
		
	//	System.out.println(mon.name + "��" + this.power + "�̃_���[�W�I");

	}

}
