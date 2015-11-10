package fleets;

import java.util.Random;
import ships.Ship;

public class Aicountry extends Country {
	public String[] names={"基辅","瓦良格","库兹涅佐夫","施佩尔海军上将","无畏","基洛夫","德意志"
			,"俾斯麦","勇气","皇家方舟","皇家橡树","厌战","决心","胡德","决心","复仇","黎塞留"
			,"赤城","加贺","苍龙","飞龙","飞鹰","隼鹰","翔鹤","瑞鹤","大凤","长门","日向","出云"
			,"金刚","武藏","大和","扶桑","沙恩霍斯特","维内托","青花鱼","企业","黄蜂","萨拉托加"
			,"约克城","列克星敦","北卡罗来纳","史密斯","衣阿华","密苏里","怀俄明","尼米兹","福煦"
			,"欧根亲王"};
	public Aicountry(){
		industry=50;
		cash=100;
		fleet=new Available();
		repair=new Underrepair();
		battle=new Battle();
		num=0;
		}	
	public void buildship(){
		int i=random();
		do{
			if(cash<0){
				break;
			}
			Ship s=new Ship();
			
			int n=i%4;
			
			if (n==0){
			int m=random()%6+1;	
			switch(m)
			{    //name,health,cost,type1,type2,antisub,antiair,antifire,search,attack
			case 1:
			s=new Ship(rdname(),11,22,30,"carrier","light",0,3,0,8,1,8);
			break;
			case 2:
			s=new Ship(rdname(),14,28,48,"carrier","normal",0,3,5,5,20,7);
			break;
			case 3:
			s=new Ship(rdname(),18,36,65,"carrier","heavy",0,9,6,5,26,7);	
			break;
			case 4:
			s=new Ship(rdname(),15,30,41,"battleship","mini",0,9,14,0,9,9);	
			break;
			case 5:
			s=new Ship(rdname(),18,36,46,"battleship","normal",0,10,17,0,22,8);
			break;
			case 6:
			s=new Ship(rdname(),22,48,56,"battleship","superheavy",0,16,17,0,27,7);
			break;
			default:break;
			}
			}
			else{
				int m=random()%9+1;	
				switch(m)
				{    //name,health,cost,type1,type2,antisub,antiair,antifire,search,attack
				case 1:
				s=new Ship(rdname(),8,16,23,"cruiser","light",4,6,4,0,3,13);
				break;
				case 2:
				s=new Ship(rdname(),10,20,28,"cruiser","heavy",4,10,4,0,3,11);
				break;
				case 3:
				s=new Ship(rdname(),13,26,39,"cruiser","battle",5,10,7,4,5,10);	
				break;
				case 4:
				s=new Ship(rdname("DD"),3,6,11,"destroyer","early",4,0,2,0,2,17);	
				break;
				case 5:
				s=new Ship(rdname("DD"),4,8,15,"destroyer","basic",5,0,3,0,3,18);
				break;
				case 6:
				s=new Ship(rdname("DD"),5,10,18,"destroyer","morden",5,0,5,0,4,20);
				break;
				case 7:
				s=new Ship(rdname("SS"),2,4,5,"submarine","early",0,0,0,1,12,9);	
				break;
				case 8:
				s=new Ship(rdname("SS"),3,6,6,"submarine","basic",0,0,0,1,12,10);
				break;
				case 9:
				s=new Ship(rdname("SS"),4,8,8,"submarine","morden",0,0,0,1,18,11);
				break;
				default:break;
				}
			}
			repair.add(s);
			cash=cash-s.cost;
			i++;
		}while(cash>28);
	}
	public void arrangebattle(){
		for(int i=0;i<fleet.numofship;i++){
			if(i>=fleet.numofship){
				break;
			}
		addtobattle(fleet.ships[i]);
    	fleet.delete(fleet.ships[i]);
		}
	}
	public int random(){
		Random r = new Random();
	    int rv =(int)(100 * r.nextDouble());
	    return rv;
	}
	public String rdname(){
		String name=names[random()%names.length];
		for(int i=0;i<fleet.numofship;i++)
		{
		if(fleet.ships[i].name.equals(name)){
			name=rdname();
		}
		}
		for(int i=0;i<repair.numofship;i++)
		{
		if(repair.ships[i].name.equals(name)){
			name=rdname();
			break;
		}
		}
		return name;
	}
	public String rdname(String s){
		num++;
		if(num>=100){
		num=0;	
		}
		return s+"-"+num;
	}
}