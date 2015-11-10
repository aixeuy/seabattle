package ships;

import weapons.Weapon;

public class Ship {
	public String name;
	public int weight;
	public int health;
	public int resthealth;
	public int cost;
	public Weapon[] weap;
	public int numofweap;
	public String type1;
	public String type2;
	public int level;
	public int point;
	public int antisub;
	public int antifire;
	public int antiair;
	public int search;
	public int attack;
	public int speed;
	public int insspeed;
	public int position;
	public String instruction;
	public Ship target;
	public int tiredness;
	public int status;
	public int continuation;
	
	public Ship(){
		antisub=0;
		antiair=0;
		antifire=0;
		search=0;
		attack=0;	
		weap=new Weapon[4];
		numofweap=0;
		speed=0;
		insspeed=0;
		position=0;
		instruction="none";
		target=null;
		tiredness=0;
		status=1;
		continuation=100;
	}
	public Ship(String name,int weight,int health,int cost,String type1,String type2,int antisub,
			int antiair,int antifire,int search,int attack,int speed){
		this.name=name;
		this.weight=weight;
		this.health=health;
		this.resthealth=0;
		this.cost=cost;
		this.type1=type1;
		this.type2=type2;
		this.level=0;
		this.point=0;
		this.antisub=antisub;
		this.antifire=antifire;
		this.antiair=antiair;
		this.search=search;
		this.attack=attack;
		this.speed=speed;
		insspeed=speed;
		position=0;
		instruction="none";
		setspeed();
		target=null;
		tiredness=0;
		status=1;
		continuation=100;
	}
	public Ship(boolean b){
		if(b){
		position=15;
		}
		else{
		position=-15;	
		}
		this.name="NULL";
		this.weight=2;
		this.health=100;
		this.resthealth=100;
		this.cost=1;
		this.type1="NULL";
		this.type2="NULL";
		this.level=0;
		this.point=0;
		this.antisub=0;
		this.antifire=0;
		this.antiair=0;
		this.search=0;
		this.attack=0;
		this.speed=0;
		insspeed=0;
		position=0;
		instruction="none";
		target=null;
	}
	
	public void copyexceptname(Ship s){
		name=null;
		weight=s.weight;
		health=s.health;
		resthealth=s.health;
		cost=s.cost;
		weap=s.weap;
		numofweap=s.numofweap;
		type1=s.type1;
		type2=s.type2;
		level=0;
		point=0;
		antisub=0;
		antifire=0;
		antiair=0;
		search=0;
		attack=0;
		speed=s.speed;
		insspeed=speed;
		position=0;
		instruction="none";
		target=null;
	}
	public void setspeed(){
		position=4;
		/*
		if(type1.equals("submarine")){
			if(weight==2){
				speed=9;
			}
			if(weight==3){
				speed=10;
			}
			if(weight==4){
				speed=10;
			}
		}
		else{
		 if(weight==22){
		 speed=6;
		 }
		 if(weight==18){
			 speed=7;
			 }
		if(weight==15){
			 speed=9;
			 }
		if(weight==14){
			 speed=7;
			 }
		if(weight==11){
			 speed=8;
			 }
		if(weight==10){
			 speed=11;
			 }
		if(weight==13){
			 speed=10;
			 }
		if(weight==8){
			 speed=13;
			 }
		if(weight==5){
			 speed=20;
			 }
		if(weight==4){
			 speed=18;
			 }
		if(weight==3){
			 speed=17;
			 }
		}
		for(int i=0;i<level;i++){
			if(level==0){
				break;
			}
			int add=ver(speed*0.1);
			speed=speed+add;
		}
		*/
		insspeed=speed;
	}
	
	public int getweapcost(){
		int i=0;
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
				i=i+weap[j].cost;
		}
		return i;
	}
	//get defence value
	public int getanifire(boolean b){
		if(b){
		int i=0;
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
				i=i+weap[j].range;
		}
		return ver(i*(1+(level+0.0)/10));
		}
		else{
			return antifire;
		}
	}
	public int getantiair(boolean b){
		if(b){
		int i=0;
		
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
			if(weap[j].attack>=15){
				i=i+weap[j].antiair*status;
			}
			else{
				i=i+weap[j].antiair;
			}
		}
		return ver(i*(1+(level+0.0)/10));
		}
		else{
			return antiair;
		}
	}
	public int getantisub(boolean b){
		if(b){
		int i=0;
		for(int j=0;j<numofweap;j++){
			if(weap[j]!=null){
				i=i+weap[j].antisub;
			}
			else{
			break;
			}
		}
		return ver(i*(1+(level+0.0)/10));
		}
		else{
			return antisub;
		}
	}
	public int getsearch(boolean b){
		if (b){
		int i=0;
		for(int j=0;j<numofweap;j++){
			if(weap[j]!=null){
				i=i+weap[j].search;
			}
			else{
			break;
			}
		}
		return ver(i*(1+(level+0.0)/10));//ver(i*(1+(level+0.0)/10));
		}
		else{
			return search;
		}
	}
	
	//get attack value
	public double getaiattack(int distance,double antiairmod){
		double attack=0;
		if(type1.equals("submarine")){
			if(weight==2){
				if(distance<=1){
					attack+=12;
				}
			}
			else if(weight==3){
				if(distance<=1){
					attack+=12;
				}
			}
			else{
				if(distance<=2){
					attack+=18;
				}
			}
		}
		else if(type1.equals("destroyer")){
			if(weight==3){
				if(distance<=1){
					attack+=2;
				}
			}
			else if(weight==4){
				if(distance<=1){
					attack+=3;
				}
			}
			else{
				if(distance<=1){
					attack+=2;
				}
				if(distance<=3){
					attack+=2;
				}
			}
		}
		else if(type1.equals("cruiser")){
			if(weight==8){
				if(distance<=3){
					attack+=2;
				}
				if(distance<=1){
					attack+=1;
				}
			}
			else if(weight==10){
				if(distance<=3){
					attack+=2;
				}
				if(distance<=1){
					attack+=1;
				}
			}
			else{
				if(distance<=1){
					attack+=1;
				}
				if(distance<=3){
					attack+=4;
				}
			}
		}
		else if(type1.equals("battleship")){
			if(weight==15){
				if(distance<=3){
					attack+=6;
				}
				if(distance<=5){
					attack+=3;
				}
			}
			else if(weight==18){
				if(distance<=1){
					attack+=12;
				}
				if(distance<=3){
					attack+=4;
				}
				if(distance<=5){
					attack+=6;
				}
			}
			else{
				if(distance<=2){
					attack+=18;
				}
				if(distance<=3){
					attack+=2;
				}
				if(distance<=5){
					attack+=3;
				}
				if(distance<=8){
					attack+=4;
				}
			}
		}
		else if(type1.equals("carrier")){
			if(weight==11){
				attack+=1*antiairmod;
			}
			else if(weight==14){
				attack+=20*antiairmod;
			}
			else{
				attack+=26*antiairmod;
			}
		}
		return attack;
	}
	public double getrealattack(boolean b,int distance,double antiairmod){
		if(!b){
			return (getaiattack(distance,antiairmod)*(1+(level+0.0)/10));
		}
		double i=0;
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
			if(weap[j].type.equals("launcher")){
				i=i+weap[j].attack*antiairmod;
			}
			if(weap[j].type.equals("subtorpedo")&&weap[j].range>=distance){
				i=i+weap[j].attack;
			}
			if((weap[j].type.equals("torpedo")||weap[j].type.equals("gun"))&&weap[j].range>=distance){
				i=i+weap[j].attack;
			}
		}
	return (i*(1+(level+0.0)/10));
	}
	
	public int getattack(boolean b){
		if(!b){
			return attack;
		}
		int i=0;
	if (type1.equals("carrier")){
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
			if(weap[j].type.equals("launcher")){
				i=i+weap[j].attack;
			}
		}
	}
	else if(type1.equals("submarine")){
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
			if(weap[j].type.equals("subtorpedo")){
				i=i+weap[j].attack;
			}
		}
	}
	else{
		for(int j=0;j<numofweap;j++){
			if(weap[j]==null){
				break;
			}
			if(weap[j].type.equals("gun")){
				i=i+weap[j].attack;
			}
			else if(weap[j].type.equals("torpedo")){
				i=i+weap[j].attack*weap[j].range/3;
			}
		}
	}
	return ver(i*(1+(level+0.0)/10));
	}
	
	//add or replace weapon
	public int getweight(){
		int i=0;
		for(int j=0;j<numofweap;j++){
				i=i+weap[j].weight;
		}
		return i;
	}
	public void addweapon(Weapon w){
		if(weight>=getweight()+w.weight){
		if(weap.length==numofweap){
		doublesize();
		}
		weap[numofweap]=w;
		numofweap++;
		if(w.type.equals("hull")){
			health+=w.amor;
		}
		}
		else{
		System.out.println("unable to add");
		}
	}
	public void doublesize(){
		Weapon[] weap2=new Weapon[weap.length*2];
		for(int i=0;i<weap.length;i++){
		weap2[i]=weap[i];
		}
		weap=weap2;
	}
	public void unload(int i){
		weap[i]=weap[numofweap-1];
		weap[numofweap-1]=null;
		numofweap--;
	}
	/*public void replaceweapon(Weapon w){
		if(weight>=getweight()+w.weight-weap[findtype(w)].weight){
		weap[findtype(w)]=w;
		if(w.type.equals("hull")){
			health+=w.amor;
		}
		}
		else{
			System.out.println("unable to replace");
			}
	}*/
	public int findweap(String name){
		if(numofweap==0){
			return-1;
		}
		for(int j=0;j<numofweap;j++){
			if(weap[j].name.equals(name)){
			return j;
			}
		}
	 return -1;
	}
	public int findweaptype(String name){
		if(numofweap==0){
			return-1;
		}
		for(int j=0;j<numofweap;j++){
			if(weap[j].type.equals(name)){
			return j;
			}
		}
	 return -1;
	}
	public void printweap(){
		if(numofweap==0){
		System.out.println("no weapon");
		}
		else{
		for(int i=0;i<numofweap;i++){
			weap[i].print();
		}
		}
	}
	public void levelup(){
		if(point>=(cost*(level+1))&&level<5){
	int add=ver(health*0.1);
	level++;
	health=health+add;
	add=ver(speed*0.1);
	speed=speed+add;
	point=point-cost;
	levelup();
		}
	}
	public int ver(double d){
		int i=(int)d;
		d=d-i;
		if(d>0.5){
			return(i+1);
		}
		return i;
	}
	public int addweapspecial(){
		return 0;
	}
}
