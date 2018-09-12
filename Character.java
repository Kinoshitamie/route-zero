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
		System.out.println("「私は" + job_name + "の" + name + "だし！」");
	}

	public void shopping(Character cha) {
		Character.money -= item_price;
		System.out.println(cha.name + "は" + item_price + "ごーるどのお買い物をした！");
	}

}
