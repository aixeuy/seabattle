package weapons;

public class Gun extends Weapon {
	public Gun(){
	}
	public Gun(int n){
		switch(n)

		{

		case 1:settype("antiairbasic",3,2,0,0,0,0,0,3);break;
		case 2:settype("antiairimproved",4,3,0,0,0,0,0,5);break;
		case 3:settype("gunsmall",2,1,1,1,0,0,0,0);break;
		case 4:settype("gunmedium",4,2,2,3,0,0,0,1);break;
		case 5:settype("gunlarge",5,3,3,5,0,0,0,0);break;
		case 6:settype("gunsuperlarge",6,4,4,8,0,0,0,0);break;
		default:System.out.println("unable to add");break;	
		}
	}
	public void settype(String type,int cost,int weight,int attack,int range,int add,int search,
			int antisub,int antiair){
		this.amor=add;
		this.antiair=antiair;
		this.antisub=antisub;
		this.attack=attack;
		this.cost=cost;
		this.range=range;
		this.search=search;
		this.name=type;
		this.weight=weight;
		this.type="gun";
	}
}
