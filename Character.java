package MakingRPG;

//super class
public class Character {
	protected int hp;
	protected int power;
	protected String name;
	protected String job_name;
	static int money=200;
	protected int item_price = 0;

	public void introduce(String name, String job_name) {
		System.out.println("私は" + job_name + "の" + name + "なのだ！");
	}

	/*public void shopping(Character cha) {
		Character.money -= item_price;
		System.out.println(cha.name + "��" + item_price + "���[��ǂ̂��������������I");
	}
*/
}
