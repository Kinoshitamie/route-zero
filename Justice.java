package rpg3;

public class Justice extends Character {

	protected String job_name;		
	 
	Justice(String name,int hp,String job_name){
		super();
		this.name = name;
		this.hp = hp;
		this.job_name=job_name;
		this.power = 15;
		this.introduce(name, job_name);
	}
	
	
	public void introduce(String name, String job_name) {
		System.out.println("I am  " + name + ", and  a " + job_name + "！");
	}
	public void attack(Monster mon) {
		mon.damage(this.power);
	}	
	

}
