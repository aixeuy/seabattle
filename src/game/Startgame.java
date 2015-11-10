package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import ships.Ship;
import weapons.Weapon;

import fleets.Aicountry;
import fleets.Country;

public class Startgame {
	public static Ship Null=new Ship();
	public static int year=0;
	public static Country player=new Country();
	public static Country ai=new Aicountry();
	public static String[] place={"拉普拉塔河口","日德兰","夏威夷","中途岛","瓜达尔卡纳尔岛"
		,"圣克鲁斯","吉尔伯托","铁底湾","关岛","阿留申群岛","所罗门群岛","马绍尔群岛","马里亚纳"
		,"莱特湾","硫磺岛","冲绳","奄美"};
	public static Position[] p=new Position[31];
	public static double time;
public static void main(String[] args) throws IOException{
	read();
	start();	
}
/////////////////////////process file/////////////////////////////////////////////
public static void read() throws IOException{
	//try{
        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String s;  
        s = br.readLine();
        player.num=toint(s);
        s = br.readLine();
        player.cash=toint(s);
        s = br.readLine();
        player.industry=toint(s);
        s = br.readLine();
        player.fleet.numofship=0;
        int pfs=toint(s);
        s = br.readLine();
        player.repair.numofship=0;
        int prs=toint(s);
        for(int i=0;i<pfs;i++){
            Ship sh=new Ship();
        	s = br.readLine();
        	sh.numofweap=0;
        	int nw=toint(s);
        	s = br.readLine();
        	sh.name=s;
        	s = br.readLine();
        	sh.weight=toint(s);
        	s = br.readLine();
        	sh.speed=toint(s);
        	s = br.readLine();
        	sh.continuation=toint(s);
        	s = br.readLine();
        	sh.health=toint(s);
        	s = br.readLine();
        	sh.resthealth=toint(s);
        	s = br.readLine();
        	sh.cost=toint(s);
        	s = br.readLine();
        	sh.type1=s;
        	s = br.readLine();
        	sh.type2=s;
        	s = br.readLine();
        	sh.level=toint(s);
        	s = br.readLine();
        	sh.point=toint(s);
        	player.fleet.add(sh);
        	//System.out.println(player.fleet.ships[0].numofweap);
        	 for(int j=0;j<nw;j++){
             	Weapon wp=new Weapon();
        		s = br.readLine();
        		wp.amor=toint(s);
        		s = br.readLine();
        		wp.antiair=toint(s);
        		s = br.readLine();
        		wp.antisub=toint(s);
        		s = br.readLine();
        		wp.attack=toint(s);
        		s = br.readLine();
        		wp.cost=toint(s);
        		s = br.readLine();
        		wp.name=s;
        		s = br.readLine();
        		wp.range=toint(s);
        		s = br.readLine();
        		wp.search=toint(s);
        		s = br.readLine();
        		wp.type=s;
        		s = br.readLine();
        		wp.weight=toint(s);
        		player.fleet.ships[i].addweapon(wp);
        		player.fleet.ships[i].health-=wp.amor;
        	 }
        }
        
        
        
        
        for(int i=0;i<prs;i++){
            Ship sh=new Ship();
        	s = br.readLine();
        	sh.numofweap=0;
        	int nw=toint(s);
        	s = br.readLine();
        	sh.name=s;
        	s = br.readLine();
        	sh.weight=toint(s);
        	s = br.readLine();
        	sh.speed=toint(s);
        	s = br.readLine();
        	sh.continuation=toint(s);
        	s = br.readLine();
        	sh.health=toint(s);
        	s = br.readLine();
        	sh.resthealth=toint(s);
        	s = br.readLine();
        	sh.cost=toint(s);
        	s = br.readLine();
        	sh.type1=s;
        	s = br.readLine();
        	sh.type2=s;
        	s = br.readLine();
        	sh.level=toint(s);
        	s = br.readLine();
        	sh.point=toint(s);
        	player.repair.add(sh);
        	 for(int j=0;j<nw;j++){
             	Weapon wp=new Weapon();
        		s = br.readLine();
        		wp.amor=toint(s);
        		s = br.readLine();
        		wp.antiair=toint(s);
        		s = br.readLine();
        		wp.antisub=toint(s);
        		s = br.readLine();
        		wp.attack=toint(s);
        		s = br.readLine();
        		wp.cost=toint(s);
        		s = br.readLine();
        		wp.name=s;
        		s = br.readLine();
        		wp.range=toint(s);
        		s = br.readLine();
        		wp.search=toint(s);
        		s = br.readLine();
        		wp.type=s;
        		s = br.readLine();
        		wp.weight=toint(s);
        		player.repair.ships[i].addweapon(wp);
        		player.repair.ships[i].health-=wp.amor;
        	 }
        }///////////////////////////special
        s = br.readLine();///////#####################################
		player.special.numofss=0;
		int noss=toint(s);
		for(int i=0;i<noss;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
        	sh.speed=toint(s);
			s = br.readLine();
			sh.continuation=toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
        	  sh.health-=wp.amor;
            }
			player.special.add(sh);
		}
		s = br.readLine();///////#####################################
		player.special.numofdd=0;
		int nodd=toint(s);
		for(int i=0;i<nodd;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
        	sh.speed=toint(s);
			s = br.readLine();
			sh.continuation=toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
        	  sh.health-=wp.amor;
            }
			player.special.add(sh);
		}
		s = br.readLine();///////#####################################
		player.special.numofc=0;
		int noc=toint(s);
		for(int i=0;i<noc;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.continuation=toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
        	  sh.health-=wp.amor;
            }
			player.special.add(sh);
		}
		s = br.readLine();///////#####################################
		player.special.numofbb=0;
		int nobb=toint(s);
		for(int i=0;i<nobb;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.continuation=toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
        	  sh.health-=wp.amor;
            }
			player.special.add(sh);
		}
		s = br.readLine();///////#####################################
		player.special.numofcv=0;
		int nocv=toint(s);
		for(int i=0;i<nocv;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.continuation=toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
        	  sh.health-=wp.amor;
            }
			player.special.add(sh);
		}
        
        br.close(); 

    //}
    //catch(Exception e){
        //System.out.println(e);
    //}
	
	///////////////////////////////read ai/////////////

//try{
        BufferedReader br2 = new BufferedReader(new FileReader("ai.txt"));
        String s1;  
        s1 = br2.readLine();
        ai.num=toint(s1);
        s1 = br2.readLine();
        ai.cash=toint(s1);
        s1 = br2.readLine();
        ai.industry=toint(s1);
        s1 = br2.readLine();
        ai.fleet.numofship=0;
        int afn=toint(s1);
        s1 = br2.readLine();
        ai.repair.numofship=0;
        int arn=toint(s1);
        for(int i=0;i<afn;i++){
        	Ship sh=new Ship();
        	s1 = br2.readLine();
        	sh.antiair=toint(s1);
        	s1 = br2.readLine();
        	sh.antifire=toint(s1);
        	s1 = br2.readLine();
        	sh.antisub=toint(s1);
        	s1 = br2.readLine();
        	sh.attack=toint(s1);
        	s1 = br2.readLine();
        	sh.cost=toint(s1);
        	s1 = br2.readLine();
        	sh.health=toint(s1);
        	s1 = br2.readLine();
        	sh.level=toint(s1);
        	s1 = br2.readLine();
        	sh.name=s1;
        	s1 = br2.readLine();
        	sh.weight=toint(s1);
        	s1 = br2.readLine();
        	sh.speed=toint(s1);
        	s1 = br2.readLine();
        	sh.continuation=toint(s1);
        	s1 = br2.readLine();
        	sh.point=toint(s1);
        	s1 = br2.readLine();
        	sh.resthealth=toint(s1);
        	s1 = br2.readLine();
        	sh.search=toint(s1);
        	s1 = br2.readLine();
        	sh.type1=s1;
        	s1 = br2.readLine();
        	sh.type2=s1;
        	ai.fleet.add(sh);
        }
        for(int i=0;i<arn;i++){
        	Ship sh=new Ship();
        	s1 = br2.readLine();
        	sh.antiair=toint(s1);
        	s1 = br2.readLine();
        	sh.antifire=toint(s1);
        	s1 = br2.readLine();
        	sh.antisub=toint(s1);
        	s1 = br2.readLine();
        	sh.attack=toint(s1);
        	s1 = br2.readLine();
        	sh.cost=toint(s1);
        	s1 = br2.readLine();
        	sh.health=toint(s1);
        	s1 = br2.readLine();
        	sh.level=toint(s1);
        	s1 = br2.readLine();
        	sh.name=s1;
        	s1 = br2.readLine();
        	sh.weight=toint(s1);
        	s1 = br2.readLine();
        	sh.speed=toint(s1);
        	s1 = br2.readLine();
        	sh.continuation=toint(s1);
        	s1 = br2.readLine();
        	sh.point=toint(s1);
        	s1 = br2.readLine();
        	sh.resthealth=toint(s1);
        	s1 = br2.readLine();
        	sh.search=toint(s1);
        	s1 = br2.readLine();
        	sh.type1=s1;
        	s1 = br2.readLine();
        	sh.type2=s1;
        	ai.repair.add(sh);
        }
        
        
        br2.close(); 
    //}
    //catch(Exception e){
        //System.out.println(e);
    //}
	player.setspeed();
	ai.setspeed();
}
public static void write(){
	     try
	        {
	          BufferedWriter bw = new BufferedWriter(new FileWriter("player.txt"));
	          	  bw.write(tostring(player.num));
	          	  bw.newLine();    
	          	  bw.write(tostring(player.cash));
	              bw.newLine();
	              bw.write(tostring(player.industry));
	              bw.newLine();
	              bw.write(tostring(player.fleet.numofship));
	              bw.newLine();
	              bw.write(tostring(player.repair.numofship));
	              bw.newLine();
	              for(int i=0;i<player.fleet.numofship;i++){
	            	  bw.write(tostring(player.fleet.ships[i].numofweap));
		              bw.newLine();
	            	  bw.write(player.fleet.ships[i].name);
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].continuation));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].health));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].resthealth));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].cost));
		              bw.newLine();
		              bw.write(player.fleet.ships[i].type1);
		              bw.newLine();
		              bw.write(player.fleet.ships[i].type2);
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].level));
		              bw.newLine();
		              bw.write(tostring(player.fleet.ships[i].point));
		              bw.newLine();
		              for(int j=0;j<player.fleet.ships[i].numofweap;j++){
		            	  bw.write(tostring(player.fleet.ships[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.fleet.ships[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.fleet.ships[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.fleet.ships[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              
	              
	              for(int i=0;i<player.repair.numofship;i++){
	            	  bw.write(tostring(player.repair.ships[i].numofweap));
		              bw.newLine();
	            	  bw.write(player.repair.ships[i].name);
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].continuation));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].health));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].resthealth));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].cost));
		              bw.newLine();
		              bw.write(player.repair.ships[i].type1);
		              bw.newLine();
		              bw.write(player.repair.ships[i].type2);
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].level));
		              bw.newLine();
		              bw.write(tostring(player.repair.ships[i].point));
		              bw.newLine();
		              for(int j=0;j<player.repair.ships[i].numofweap;j++){
		            	  bw.write(tostring(player.repair.ships[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.repair.ships[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.repair.ships[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.repair.ships[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              ///////////////////special//////###################
	              bw.write(tostring(player.special.numofss));
	              bw.newLine();
	              for(int i=0;i<player.special.numofss;i++){
	            	  if(player.special.numofss==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(player.special.ss[i].cost));
		              bw.newLine();
		              bw.write(tostring(player.special.ss[i].health));
		              bw.newLine();
		              bw.write(tostring(player.special.ss[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(player.special.ss[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.special.ss[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.special.ss[i].continuation));
		              bw.newLine();
		              bw.write(player.special.ss[i].type1);
		              bw.newLine();
		              bw.write(player.special.ss[i].type2);
		              bw.newLine();
		              for(int j=0;j<player.special.ss[i].numofweap;j++){
		            	  if(player.special.ss[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(player.special.ss[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.special.ss[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.special.ss[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.special.ss[i].weap[j].weight));
			              bw.newLine();
		              }
	              }/////////////////////
	              bw.write(tostring(player.special.numofdd));
	              bw.newLine();
	              for(int i=0;i<player.special.numofdd;i++){
	            	  if(player.special.numofdd==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(player.special.dd[i].cost));
		              bw.newLine();
		              bw.write(tostring(player.special.dd[i].health));
		              bw.newLine();
		              bw.write(tostring(player.special.dd[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(player.special.dd[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.special.dd[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.special.dd[i].continuation));
		              bw.newLine();
		              bw.write(player.special.dd[i].type1);
		              bw.newLine();
		              bw.write(player.special.dd[i].type2);
		              bw.newLine();
		              for(int j=0;j<player.special.dd[i].numofweap;j++){
		            	  if(player.special.dd[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(player.special.dd[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.special.dd[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.special.dd[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.special.dd[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(player.special.numofc));
	              bw.newLine();
	              for(int i=0;i<player.special.numofc;i++){
	            	  if(player.special.numofc==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(player.special.c[i].cost));
		              bw.newLine();
		              bw.write(tostring(player.special.c[i].health));
		              bw.newLine();
		              bw.write(tostring(player.special.c[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(player.special.c[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.special.c[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.special.c[i].continuation));
		              bw.newLine();
		              bw.write(player.special.c[i].type1);
		              bw.newLine();
		              bw.write(player.special.c[i].type2);
		              bw.newLine();
		              for(int j=0;j<player.special.c[i].numofweap;j++){
		            	  if(player.special.c[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(player.special.c[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.special.c[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.special.c[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.special.c[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(player.special.numofbb));
	              bw.newLine();
	              for(int i=0;i<player.special.numofbb;i++){
	            	  if(player.special.numofbb==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(player.special.bb[i].cost));
		              bw.newLine();
		              bw.write(tostring(player.special.bb[i].health));
		              bw.newLine();
		              bw.write(tostring(player.special.bb[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(player.special.bb[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.special.bb[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.special.bb[i].continuation));
		              bw.newLine();
		              bw.write(player.special.bb[i].type1);
		              bw.newLine();
		              bw.write(player.special.bb[i].type2);
		              bw.newLine();
		              for(int j=0;j<player.special.bb[i].numofweap;j++){
		            	  if(player.special.bb[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(player.special.bb[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.special.bb[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.special.bb[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.special.bb[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(player.special.numofcv));
	              bw.newLine();
	              for(int i=0;i<player.special.numofcv;i++){
	            	  if(player.special.numofcv==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(player.special.cv[i].cost));
		              bw.newLine();
		              bw.write(tostring(player.special.cv[i].health));
		              bw.newLine();
		              bw.write(tostring(player.special.cv[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(player.special.cv[i].weight));
		              bw.newLine();
		              bw.write(tostring(player.special.cv[i].speed));
		              bw.newLine();
		              bw.write(tostring(player.special.cv[i].continuation));
		              bw.newLine();
		              bw.write(player.special.cv[i].type1);
		              bw.newLine();
		              bw.write(player.special.cv[i].type2);
		              bw.newLine();
		              for(int j=0;j<player.special.cv[i].numofweap;j++){
		            	  if(player.special.cv[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(player.special.cv[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].cost));
			              bw.newLine();
			              bw.write(player.special.cv[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].search));
			              bw.newLine();
			              bw.write(player.special.cv[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(player.special.cv[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              
	          bw.close();
	        }
	        
	        catch(Exception ee){
	            System.out.println(ee);
	        }
	     
	     
	     
	     ////////////////write ai////////////
	     try
	        {
	          BufferedWriter bw = new BufferedWriter(new FileWriter("ai.txt"));
	          bw.write(tostring(ai.num));
              bw.newLine();
	          bw.write(tostring(ai.cash));
              bw.newLine();
              bw.write(tostring(ai.industry));
              bw.newLine();
              bw.write(tostring(ai.fleet.numofship));
              bw.newLine();
              bw.write(tostring(ai.repair.numofship));
              bw.newLine();
              for(int i=0;i<ai.fleet.numofship;i++){
            	  bw.write(tostring(ai.fleet.ships[i].antiair));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].antifire));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].antisub));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].attack));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].cost));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].health));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].level));
                  bw.newLine();
                  bw.write(ai.fleet.ships[i].name);
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].weight));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].speed));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].continuation));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].point));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].resthealth));
                  bw.newLine();
                  bw.write(tostring(ai.fleet.ships[i].search));
                  bw.newLine();
                  bw.write(ai.fleet.ships[i].type1);
                  bw.newLine();
                  bw.write(ai.fleet.ships[i].type2);
                  bw.newLine();
              }
              for(int i=0;i<ai.repair.numofship;i++){
            	  bw.write(tostring(ai.repair.ships[i].antiair));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].antifire));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].antisub));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].attack));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].cost));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].health));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].level));
                  bw.newLine();
                  bw.write(ai.repair.ships[i].name);
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].weight));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].speed));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].continuation));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].point));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].resthealth));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].search));
                  bw.newLine();
                  bw.write(ai.repair.ships[i].type1);
                  bw.newLine();
                  bw.write(ai.repair.ships[i].type2);
                  bw.newLine();
              }
              
              
	              bw.close();
	        }
	        
	        catch(Exception ee){
	            System.out.println(ee);
	        }
	
}
public static int toint(String s)
{
  if(s.length()==1)
  {
    return s.charAt(0)-48;
  }
  else
  {
    return (s.charAt(s.length()-1)-48)+10*toint(s.substring(0,s.length()-1));
  }
}
public static String tostring(int i)
{
  return ""+i;
} 
/////////////////////////////cover page////////////////////////////////////////
public static void start(){
	System.out.println("1.tutourial");
	System.out.println("2.loadgame");
	System.out.println("3.newgame");
	System.out.println("4.exit");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 1:tutour();break;
	case 2:play();break;
	case 3:newgame();break;
	case 4:break;
	default:break;
	}
}
////////////////////////////////core///////////////////////////////////////////
public static void play(){
	//try{
	prepare();
	int industry=(int)(10*random(0.5));
	String location=place[(int)(100*random(0.0))%place.length];
	System.out.println("place "+place+" value"+industry);
	ai.newbattle();player.newbattle();
	ai.arrangebattle();
	System.out.println("their fleet number"+ai.battle.numofship);
	player.arrangebattle();
	ai.battle.printlist(false);
	battle(industry,location);
	passyear();
	write();
	check();
	//}
	//catch(Exception e){
		//System.out.println("you fool!");
	//}
}
public static void tutour(){
	System.out.println("defeat the other side by building ships and arranging" +
			" battles,losing a battle will cause the decrease of gdp,your country " +
			"will break down if your debt is larger than 100,the interest is 20%." +
			"the defence value of the fleet will be printed at the beginning of each" +
			" battle,a higher search value will earn you a larger chance of attacking");
	System.out.println("有关海战：背景二战时期，没有核动力和导弹");
	System.out.println("  船只：船只分为航母，战列舰（包括袖珍，超重），巡洋舰（轻巡，重巡，战巡），驱逐舰，潜艇");
	System.out.println("建造船只时要考虑吨位，吨位决定抗揍能力和武器数量");
	System.out.println("然后可以给船只装配武器，根据不同舰种可以装配舰炮，防空炮，鱼雷，装甲，雷达，声呐，舰载机");
	System.out.println("为了方便，可以发明装配好武器的舰型（xx级），也可以将其删除");
	System.out.println("  舰队：不同舰种相互配合才能提高舰队的生存率和攻击力");
	System.out.println("主力舰（航母，战列舰）是主要攻击力量，辅助舰（轻巡，驱逐）为舰队提供保护");
	System.out.println("潜艇有特殊的攻击方式，如果舰队缺乏反潜能力会遭受惨重损失，驱逐舰是潜艇的克星");
	System.out.println("  攻击：舰队的搜索能力决定能否优先攻击");
	System.out.println("距离决定攻击舰使用的武器，炮在攻击范围内才能发挥作用，不同炮的攻击范围不同，近距离的鱼雷射击" +
			"是致命的，舰载机不受距离限制");
	System.out.println("被进攻舰会拉开距离，而进攻方企图接近对方，此时较高的航速可以使船只处于有利位置");
	System.out.println("吨位低的船只（如驱逐舰）有更高的航速，遭受攻击的船的航速会降低，甚至会瘫痪");
	System.out.println("  防守：潜艇和舰载机的攻击力最强大，舰队必须有反潜和防空能力");
	System.out.println("舰队的反潜和防空能力取决于各舰的反潜防空能力和水上舰队的数量");
	System.out.println("紧凑的阵型能提高舰队的防御力，如果阵型被打乱要及时调整");
	System.out.println("打不过的话可以撤退");
	start();
}
public static void newgame(){
	if(!(player.cash<-100||ai.cash<-100)){
		System.out.println("as a country leader,you cannot surrender unless your " +
				"parliamenthas approved,this happens only when they have run out of " +
				"money.");
		start();
	}
	else{
	player=new Country();
	ai=new Aicountry();//System.out.println("start"+ai.cash);/////////////
	prepare();ai.repair.printlist(false);///////////////////////
	passyear();
	prepare();ai.repair.printlist(false);///////////////////////
	passyear();
	prepare();ai.repair.printlist(false);///////////////////////
	passyear();
	write();
	play();
	}
}
///////////////////////////////helper for play///////////////////////////////////
public static void passyear(){
	year++;
	player.passyear(true);System.out.println("before"+ai.cash);//////
	ai.passyear(false);System.out.println("after"+ai.cash);/////////
}
public static void prepare(){
	ai.buildship();
	System.out.println("cash"+player.cash+" industry"+player.industry);
	System.out.println("0:done");
	System.out.println("1:check fleet");
	System.out.println("2:build ship");
	System.out.println("3:renew weapon");
	System.out.println("4:weed invention");
	System.out.println("5:update invention");
	//System.out.println("4:exit");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 0:break;
	case 1:checkfleet();prepare();break;
	case 2:player.buildship();prepare();break;
	case 3:player.addeq();prepare();break;
	case 4:player.special.weed();prepare();break;
	case 5:player.special.update();prepare();break;
	default:break;
	}		
	
}
/////////////////////////for battle/////////



public static void battle(int industry,String location){
	System.out.println("your fleet");
	player.battle.printlist(true);
	System.out.println("their fleet");
	ai.battle.printlist(false);
	player.battle.setvalue(true,ai.battle.position);
	ai.battle.setvalue(false,player.battle.position);
	time=ver(random(0.0)*24);
	int psupply=ver(random(0.5)*20);
	int asupply=ver(random(0.5)*20);
	p=new Position[31];
	for(int i=0;i<31;i++){
		p[i]=new Position();
	}
	System.out.println("place"+location+" value"+industry+" condition"+" you"+psupply+"ai"+asupply);
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.ships[i]==null){
			break;
		}
		player.battle.ships[i].tiredness=0;
		player.battle.ships[i].status=1;
		if(!player.battle.ships[i].type1.equals("submarine")){
			p[2+15].add();///////////////////////////////////////////////position
		}
		player.battle.ships[i].position=2;
		if(player.battle.ships[i].type1.equals("submarine")){
			player.battle.ships[i].instruction="forward";
		}
		else{
		player.battle.ships[i].instruction="none";
		}
		player.battle.ships[i].insspeed=player.battle.ships[i].speed;
		choosetarget(player.battle.ships[i],ai.battle.ships,ai.battle.numofship);
	}
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.ships[i]==null){
			break;
		}
		ai.battle.ships[i].tiredness=0;
		ai.battle.ships[i].status=1;
		if(!ai.battle.ships[i].type1.equals("submarine")){
			p[-2+15].add();///////////////////////////////////////////////position
		}
		ai.battle.ships[i].position=-2;
		if(ai.battle.ships[i].type1.equals("submarine")){
			ai.battle.ships[i].instruction="forward";
		}
		else{
		ai.battle.ships[i].instruction="none";
		}
		ai.battle.ships[i].insspeed=ai.battle.ships[i].speed;
		choosetarget(ai.battle.ships[i],player.battle.ships,player.battle.numofship);
	}
	round(industry,psupply,asupply);
	player.addtofleet();
	player.addtorepair();
	ai.addtofleet();
	ai.addtorepair();
}





public static void round(int industry,int psupply,int asupply){
	player.battle.setposition();
	ai.battle.setposition();
	
	Ship[] retreat=new Ship[10];
	int index=0;
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.numofship==0){
			break;
		}
	if(player.battle.ships[i].position>=10){
		System.out.println("\n"+player.battle.ships[i].name+" out of battle"+"\n");
		retreat[index]=player.battle.ships[i];
		index++;
	}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		player.repair.add(retreat[i]);
		player.battle.delete(retreat[i]);
		for(int j=0;j<ai.battle.numofship;j++){
			if(ai.battle.ships[j].target.equals(retreat[i])){
				choosetarget(ai.battle.ships[j],player.battle.ships,player.battle.numofship);
			}
		}
	}
	retreat=new Ship[10];
	index=0;
	
	
	for(int i=0;i<player.battle.numofship;i++){////////////////////////instruction
		if(player.battle.numofship==0){
			break;
		}
		int speedmod=1;
		player.battle.ships[i].tiredness-=psupply;
		if(player.battle.ships[i].tiredness<0){
			player.battle.ships[i].tiredness=0;
		}
		if(player.battle.ships[i].type1.equals("submarine")){
			if(player.battle.ships[i].tiredness>=player.battle.ships[i].continuation){
				player.battle.ships[i].status=1;
			}
			else{
				if(player.battle.ships[i].tiredness<=50){
				if(player.battle.ships[i].status!=-2){
					player.battle.ships[i].status=-1;
				}
				}
			}
			if(player.battle.ships[i].status<0){
			player.battle.ships[i].tiredness+=30;
			}
		}
		else{
		player.battle.ships[i].status=1;
		}
		if(player.battle.ships[i].instruction.equals("forward")){
			if(player.battle.ships[i].position>ai.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
			//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
			}
			else if(player.battle.ships[i].position<ai.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
				//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
			}
		}
		else if(player.battle.ships[i].instruction.equals("backward")){
			move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
			//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
		}
		else if(player.battle.ships[i].instruction.equals("retreat")){
			move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/5),true);////////////////move
			//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed*2))/10;	
			if(player.battle.ships[i].position-1>ai.battle.lastposition(false)){
				System.out.println("\n"+player.battle.ships[i].name+" out of battle"+"\n");
				retreat[index]=player.battle.ships[i];
				index++;
			}
		}
		else if(player.battle.ships[i].instruction.equals("hunt")){
			if(player.battle.ships[i].position>player.battle.ships[i].target.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
				//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
				}
				else if(player.battle.ships[i].position<player.battle.ships[i].target.position){
					move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
					//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
				}
		}
		else if(player.battle.ships[i].instruction.equals("defence")){
			if(player.battle.ships[i].position>player.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
				//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
				}
				else if(player.battle.ships[i].position<player.battle.position){
					move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
					//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
				}
		}	
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		player.repair.add(retreat[i]);
		player.battle.delete(retreat[i]);
		for(int j=0;j<ai.battle.numofship;j++){
			if(ai.battle.ships[j].target.equals(retreat[i])){
				choosetarget(ai.battle.ships[j],player.battle.ships,player.battle.numofship);
			}
		}
	}
	retreat=new Ship[5];
	index=0;
	
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.numofship==0){
			break;
		}
	if(ai.battle.ships[i].position<=-10){
		System.out.println("\n"+ai.battle.ships[i].name+" out of battle"+"\n");
		retreat[index]=ai.battle.ships[i];
		index++;
	}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		ai.repair.add(retreat[i]);
		ai.battle.delete(retreat[i]);
		for(int j=0;j<player.battle.numofship;j++){
			if(player.battle.ships[j].target.equals(retreat[i])){
				choosetarget(player.battle.ships[j],ai.battle.ships,ai.battle.numofship);
			}
		}
	}
	retreat=new Ship[5];
	index=0;
	
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.numofship==0){
			break;
		}
		int speedmod=1;
		ai.battle.ships[i].tiredness-=asupply;
		if(ai.battle.ships[i].tiredness<0){
			ai.battle.ships[i].tiredness=0;
		}
		if(ai.battle.ships[i].type1.equals("submarine")){
			if(ai.battle.ships[i].tiredness>=ai.battle.ships[i].continuation){
				ai.battle.ships[i].status=1;
			}
			else{
				if(ai.battle.ships[i].tiredness<=50){
				if(ai.battle.ships[i].status!=-2){
					ai.battle.ships[i].status=-1;
				}
				}
			}
			if(ai.battle.ships[i].status<0){
			ai.battle.ships[i].tiredness+=30;
			}
		}
		else{
		ai.battle.ships[i].status=1;
		}
		if(ai.battle.ships[i].instruction.equals("forward")){
			if(ai.battle.ships[i].position>player.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
			}
			else if(ai.battle.ships[i].position<player.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
				//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
			}
		}
		if(ai.battle.ships[i].instruction.equals("backward")){
			move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
			//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
		}
		else if(ai.battle.ships[i].instruction.equals("retreat")){
			move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/5),false);////////////////move
			//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed*2))/10;	
			if(ai.battle.ships[i].position+1<player.battle.lastposition(true)){
				System.out.println("\n"+ai.battle.ships[i].name+" out of battle"+"\n");
				retreat[index]=ai.battle.ships[i];
				index++;
			}
		}
		else if(ai.battle.ships[i].instruction.equals("hunt")){
			if(ai.battle.ships[i].position>ai.battle.ships[i].target.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
				}
				else if(ai.battle.ships[i].position<ai.battle.ships[i].target.position){
					move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
					//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
				}
		}
		else if(ai.battle.ships[i].instruction.equals("defence")){
			if(ai.battle.ships[i].position>ai.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
				}
				else if(ai.battle.ships[i].position<ai.battle.position){
					move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
					//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
				}
		}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=-15;
		ai.repair.add(retreat[i]);
		ai.battle.delete(retreat[i]);
		for(int j=0;j<player.battle.numofship;j++){
			if(player.battle.ships[j].target.equals(retreat[i])){
				choosetarget(player.battle.ships[j],ai.battle.ships,ai.battle.numofship);
			}
		}
	}
	
	
	
	player.battle.setvalue(true,ai.battle.position);
	ai.battle.setvalue(false,player.battle.position);
	if(time-(int)time!=0){
		System.out.print("time "+(int)time+".30   ");
	}
	else{
	System.out.print("time "+(int)time+".00   ");
	}
	if(time<=18&&time>=4){
	System.out.println("day");
	}
	else{
	System.out.println("night");
	if(player.battle.numofship!=0)
	{
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.ships[i].type1.equals("carrier")){
			player.battle.ships[i].status=0;	
		}
	}
	}
	
	if(ai.battle.numofship!=0)
	{
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.ships[i].type1.equals("carrier")){
			ai.battle.ships[i].status=0;	
		}
	}
	}
	
	}
	System.out.println("condition"+" you"+psupply+" ai"+asupply);
	System.out.println("antiair"+player.battle.antiair+" "+ai.battle.antiair
			+"antisub"+player.battle.antisub+" "+ai.battle.antisub
			+"antifire"+player.battle.antifire+" "+ai.battle.antifire
			+"search"+player.battle.search+" "+ai.battle.search+
			" position"+player.battle.position+" "+ai.battle.position);//////to be deleted
	
	//System.out.println("position0"+" "+p[0+15].numofshipaw);//////////////////////////////////////////
	//player.battle.printlist(true);///////////////////////////////////////////////
	/////////////////////////////////////////to delete///////////////
	
	for(int i=0;i<5;i++){
		if(player.battle.numofship==0){
			break;
		}
		if(ai.battle.numofship==0){
			break;
		}
		
		
	Ship a=new Ship();
	Ship b=new Ship();
	a=player.battle.chooseship();
	b=ai.battle.chooseship();
	if(chooseattack()){
		if(a.instruction.equals("retreat")){
			System.out.println("retreating"+0);
			System.out.println(a.name+a.position+"retreats");
			move(a,ver(random(0.5)*(a.insspeed)/10),true);////////////////move
		}
		else if(a.tiredness>=a.continuation||a.instruction.equals("rest")){
			System.out.println("resting"+0);
			System.out.println(a.name+a.position+"rests"+a.tiredness);
		}
		else{
			if(a.type1.equals("cruiser")){
				if((a.target.position-a.position)*(a.target.position-a.position)>(a.position
						-b.position)*(a.position-b.position)){
					if(!((b.type1.equals("submarine"))&&a.getantisub(true)==0)){
					a.target=b;
					}
				}
			}
			if(!((a.target.position-a.position)*(a.target.position-a.position)>(a.position
					-b.position)*(a.position-b.position))){
				b=a.target;
			}
			if(a.type1.equals("carrier")){
				if((a.position-b.position)*(a.position-b.position)>=4){
					b=a.target;
				}
			}
		attack(a,b,true,ai.battle.position);
		if(b.resthealth<=0){
			System.out.println(a.name+" "+a.type1+a.position+" sinks "+b.name+" "+b.type1+b.position);
			a.point=a.point+b.cost;
			a.levelup();	
			ai.battle.delete(b);
			ai.battle.setvalue(false,player.battle.position);
			for(int j=0;j<player.battle.numofship;j++){
				if(player.battle.ships[j].target.equals(b)){			
					choosetarget(player.battle.ships[j],ai.battle.ships,ai.battle.numofship);
				}
			}
			if(a.instruction.equals("hunt")){
				if(a.type1.equals("submarine")){
					a.instruction="forward";
				}
				else{
					a.instruction="none";
				}
			}
		}
		else{
			System.out.println(a.name+" "+a.type1+a.position+" demages "+b.name+" "+b.type1+b.position);
		    if(b.resthealth<=b.health/10){
		    	b.instruction="retreat";
		    }
		}
		}
	}
	else{
		if(b.instruction.equals("retreat")){
			System.out.println("retreating"+0);
			System.out.println("they are retreating"+b.name+b.position);
			move(b,ver(random(0.5)*(b.insspeed)/10),false);////////////////move
		}
		else if(b.tiredness>=b.continuation||b.instruction.equals("rest")){
			System.out.println("resting"+0);
			System.out.println("they are resting"+b.name+b.position);
		}
		else{
			if(b.type1.equals("cruiser")){
				if((b.target.position-b.position)*(b.target.position-b.position)>(b.position
						-a.position)*(b.position-a.position)){
					if(!((a.type1.equals("submarine"))&&b.getantisub(false)==0)){
					b.target=a;
					}
				}
			}
			if(!((b.target.position-b.position)*(b.target.position-b.position)>(b.position
					-a.position)*(b.position-a.position))){
				a=b.target;
			}
		attack(b,a,false,player.battle.position);
		if(a.resthealth<=0){
			System.out.println(a.name+" "+a.type1+a.position+" sunk by "+b.name+" "+b.type1+b.position);
			b.point+=a.cost;
			b.levelup();
			player.battle.delete(a);
			player.battle.setvalue(true,ai.battle.position);
			for(int j=0;j<ai.battle.numofship;j++){
				if(ai.battle.ships[j].target.equals(a)){
					choosetarget(ai.battle.ships[j],player.battle.ships,player.battle.numofship);
				}
			}
			if(b.instruction.equals("hunt")){
				if(b.type1.equals("submarine")){
					b.instruction="forward";
				}
				else{
					b.instruction="none";
				}
			}
		}
		else{
			System.out.println(a.name+" "+a.type1+a.position+" demaged by "+b.name+" "+b.type1+b.position);
			if(a.resthealth<=a.health/10){
		    	a.instruction="retreat";
		    }
		}
	}
	}
	}
	
	
	
	if(player.battle.numofship==0){
		System.out.println("you lose,your fleet has been destroyed");
		ai.industry=80;//+=(int)(industry*0.8);
		player.industry=80;//-=industry;
	}
	else if(ai.battle.numofship==0){
		System.out.println("you win,you have destroyed their fleet");
		player.industry=80;//+=(int)(industry*0.8);
		ai.industry=80;//-=industry;
		if(player.battle.numofship!=0){
		for(int i=0;i<player.battle.numofship;i++){
            if(player.battle.ships[i].type1.equals("cruiser")||player.battle.ships[i].type1.equals("destroyer")){
            	player.battle.ships[i].point+=(player.battle.ships[i].getantiair(true)
            			+player.battle.ships[i].getantisub(true)+
            			player.battle.ships[i].getsearch(true))/3;
			/*if(player.battle.ships[i].getattack(true)!=0){
			player.battle.ships[i].point+=
					ver(player.battle.ships[i].cost/player.battle.ships[i].getattack(true));
			}
			else{
				player.battle.ships[i].point+=
						ver(player.battle.ships[i].cost/1);
			}*/
            }
            if(player.battle.numofship<=2){
            	player.battle.ships[i].point+=player.battle.ships[i].cost;
            }
            player.battle.ships[i].levelup();
		}
		}
	}
	/*else if(aigiveup()){
		System.out.println("you win,they have retreated");
		player.industry=80;//+=(int)(industry*0.8);
		ai.industry=80;//-=industry;
	}*/
	else{
		if(aigiveup()){
			System.out.println("ai begins to retreat");
			for(int i=0;i<ai.battle.numofship;i++){
				if(ai.battle.numofship==0){
					break;
				}
				ai.battle.ships[i].instruction="retreat";
			}
		}
		System.out.println("your fleet");
		player.battle.printlist(true);
		System.out.println("their fleet");
		ai.battle.printlist(false);
		
		
		time+=0.5;
		if(time>=24){
			time=0;
		}
		
		
	System.out.println("1:continue");
	System.out.println("2:cheat to retreat");
	System.out.println("3:retreat");
	System.out.println("4:set strategy");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 1:round(industry,psupply,asupply);break;
	case 2:
		ai.industry=80;//+=(int)(industry*0.8);
		player.industry=80;//-=industry;
		break;
	case 3:
		for(int j=0;j<player.battle.numofship;j++){
			if(player.battle.numofship==0){
				break;
			}
			player.battle.ships[j].instruction="retreat";
		}
		round(industry,psupply,asupply);break;
	case 4:
		arrangeposition();
		round(industry,psupply,asupply);
		break;
		//break;
		default:break;
	}
	}
}













public static boolean chooseattack(){
	double a=player.battle.search;double b=ai.battle.search;
	if (!(time<=18&&time>=4)){
		a=5;b=5;
	}
	if((a+5)*random(0.0)>=(b+5)*random(0.0)){
		return true;
	}
	return false;
}
public static void attack(Ship a, Ship b,boolean bo,int bfposition){
	int demage=0;
	double antiair;
	double antifire;
	double antisub;
	double positionmod;
	double aspeedmod;
	double bspeedmod;
	int distance2=bfposition-b.position;
	if(distance2<0){
		distance2=0-distance2;
	}
	positionmod=1-distance2*0.2;
	if(positionmod<0){
		positionmod=0;
	}
	int distance3=bfposition-a.position;
	if(distance3<0){
		distance3=0-distance3;
	}
	double atpositionmod=1-distance3*0.2;
	if(atpositionmod<0){
		atpositionmod=0;
	}
	if(bo){
		antiair=ai.battle.getrantiair(!bo,b.position);
		antifire=ai.battle.antifire;
		antisub=ai.battle.getrantisub(!bo,b.position);
	}
	else{
		antiair=player.battle.getrantiair(!bo,b.position);
		antifire=player.battle.antifire;
		antisub=player.battle.getrantisub(!bo,b.position);
	}
	int distance=a.position-b.position;
	aspeedmod=1-(atpositionmod)*antifire*3;
	if(distance<0){
		distance=0-distance;
	}
	bspeedmod=1.6-distance3*0.2;
	if(bspeedmod<0){
		bspeedmod=0;
	}
	if(bspeedmod>1){
		bspeedmod=1;
	}
	if(a.type1.equals("submarine")){
		if(a.status==-2){
			aspeedmod=0;
			bspeedmod=0;
		}
		else{
		aspeedmod=1;
		if(!b.type1.equals("submarine")&&b.antisub==0){
			bspeedmod=0;
		}
		}
	}
	if(b.type1.equals("submarine")){
		if(a.antisub==0){
		bspeedmod=0;
		}
		if(b.status==-2){
			bspeedmod=0;
		}
	}
	if(a.type1.equals("carrier")){
		aspeedmod=0;
		bspeedmod=0;
	}
	if(a.position>=b.position){
		move(b,ver(random(0.5)*(b.insspeed)*bspeedmod/10),false);///////////////move
	//b.position-=ver(random(0.5)*(b.insspeed)*bspeedmod/10);
	}
	else{
		move(b,ver(random(0.5)*(b.insspeed)*bspeedmod/10),true);////////////////move
		//b.position+=ver(random(0.5)*(b.insspeed)*bspeedmod/10);
	}
	if(a.position>b.position){
		move(a,ver(random(0.5)*(a.insspeed)*aspeedmod/10),false);////////////////move
		if(a.position<b.position){
			p[a.position+15].remove();
			a.position=b.position;
			p[a.position+15].add();
		}
		//a.position-=ver(random(0.5)*(a.insspeed)*aspeedmod/10);
		}
		else{
			move(a,ver(random(0.5)*(a.insspeed)*aspeedmod/10),true);////////////////move
			if(a.position>b.position){
				p[a.position+15].remove();
				a.position=b.position;
				p[a.position+15].add();
			}
			//a.position+=ver(random(0.5)*(a.insspeed)*aspeedmod/10);
		}
	
	
	if(b.type1.equals("submarine")){
		if(distance<=1){
			if(a.type1.equals("destroyer")){
				if(b.status==-2){
					demage=0;
				}
				else{
				demage=ver(10*random(0.5));
				}
			}
			else if(a.type1.equals("submarine")){
				demage=ver(3*random(0.5));
			}
			else if(a.antisub>0){
			demage=ver(3*random(0.5));
			if(b.status<=-1){
				demage=0;
			}
		}
		else{
			demage=ver(1*random(0.5));
			if(b.status<=-1){
				demage=0;
			}
		}
		}
		else{
			demage=0;
		}
			if(demage==0){
				System.out.print("searching                     status"+b.status);
			}
	}
	else{
	if(a.type1.equals("carrier")){
	boolean canattack=false;
	if(time<=18&&time>=4){
		canattack=true;
	}
	if(a.getattack(bo)>=28){
		canattack=true;
	}
	double nightmod=1;
	if(canattack){
		a.status=0;
	nightmod=1;
	if(!(time<=18&&time>=4)){
		nightmod=0.5;
	}
	demage=ver(a.getrealattack(bo,distance,(1.0-antiair)*nightmod)*random(0.5));
	System.out.println(                                   "antiair"+antiair);//////////////////////////////////////delete
	a.tiredness+=(a.attack-demage);
	}
	else{
		nightmod=0;
		System.out.println("                 cannot attack at night");
		demage=ver(a.getrealattack(bo,distance,0)*random(0.5));a.tiredness-=30;b.tiredness-=10;
	}
	
	
	
	}
	else if(a.type1.equals("battleship")||a.type1.equals("cruiser")
			||a.type1.equals("destroyer")){
	demage=ver(a.getrealattack(bo,distance,(1.0-antiair))*random(0.5));	
	}
	else{
		double d;
	double an=(antisub);
	System.out.println("                               antisub"+antisub);/////////////////////////////////delete
			double ra=random(0.5);
			d=an*ra;
		if(d>0.5){
			demage=0;
		}
		else{
	demage=ver(a.getrealattack(bo,distance,0)*random(0.5));//*(1.0-ai.battle.antisub));
			}
		if(a.status==-2){
			demage=0;
			//a.tiredness-=30;b.tiredness-=10;
		}
	}
	if(a.getrealattack(bo,distance,(1.0-antiair))==0){
		System.out.print("approching");
		if(!a.type1.equals("submarine")){
		a.tiredness-=30;b.tiredness-=10;
		}
	}
	else if(demage==0){
		System.out.print("fail");
	}
	}
	
	if(!a.type1.equals("submarine")){
	a.tiredness+=30;
	}
	if(!b.type1.equals("submarine")){
	b.tiredness+=10;
	}
	b.resthealth-=demage;
	b.insspeed-=(demage*b.speed/b.health);
	System.out.println(demage+"                           " +
			"                                "+aspeedmod+" "+bspeedmod);/////////////////////////
	if(b.type1.equals("battleship")){
		if(demage>5){
			if((a.position-b.position)*(a.position-b.position)<16){
			b.target=a;
			}
		}
	}
}
public static double random(double d){
	Random r = new Random();
    double rv = d+1.0 * r.nextDouble();
    return rv;
}
public static boolean aigiveup(){
	if((ai.battle.numofship<ai.fleet.numofship/2)&&
			(ai.battle.numofship<player.battle.numofship)){
		if(ai.battle.getcost()<player.battle.getcost()){
		return true;
		}
	}
	return false;
}
public static void arrangeposition(){
	System.out.println("choose ship");
	player.battle.printinstructionlist(true);
	System.out.println(player.battle.numofship+"attack");
	System.out.println(player.battle.numofship+1+"defence");
	System.out.println(player.battle.numofship+2+"normal");
	System.out.println(player.battle.numofship+3+"set commen target");
	System.out.println(player.battle.numofship+4+"cancel");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
    if((i<player.battle.numofship)&&(i>=0)){
    	System.out.println("-1:rest");
    	System.out.println("0:hunt");
    	System.out.println("1：forward");
    	System.out.println("2：defence");
    	System.out.println("3：backward");
    	System.out.println("4：retreat");
    	System.out.println("5:none");
    	System.out.println("6:set target");
    	System.out.println("7:set status");
    	System.out.println("8:check weapons");
    	System.out.println("9:cancel");
        int j = sc.nextInt();
        if(j==-1){
        	player.battle.ships[i].instruction="rest";
        }
        if(j==0){
        	player.battle.ships[i].instruction="hunt";
        }
        if(j==1){
        	player.battle.ships[i].instruction="forward";
        }
        if(j==2){
        	player.battle.ships[i].instruction="defence";
        }
        if(j==3){
        	player.battle.ships[i].instruction="backward";
        }
        if(j==4){
        	player.battle.ships[i].instruction="retreat";
        }
        if(j==5){
        	player.battle.ships[i].instruction="none";
        }
        if(j==6){
        	System.out.println("choose target");
        	ai.battle.printlist(false);
        	int k = sc.nextInt();
        	player.battle.ships[i].target=ai.battle.ships[k];
        }
        if(j==7){
        	System.out.println("1:1"+"-1:-1"+"-2:-2");
        	int k = sc.nextInt();
        	player.battle.ships[i].status=k;
        }
        if(j==8){
        	player.battle.ships[i].printweap();
        }
        arrangeposition();
    }
    else if(i==player.battle.numofship){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="forward";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+1){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="defence";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+2){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="normal";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+3){
    	System.out.println("choose target");
    	ai.battle.printlist(false);
    	int k = sc.nextInt();
    	for(int w=0;w<player.battle.numofship;w++){
    		player.battle.ships[w].target=ai.battle.ships[k];
    	}
    	arrangeposition();
    }
}
public static void choosetarget(Ship s,Ship[] sh,int n){
	if(s.type1.equals("destroyer")){
		if(n<=1){
			if(n==0){
			s.target=Null;
			}
			else{
				s.target=sh[0];
			}
		}
		else{
		s.target=sh[n-1-(int)(100*random(0.0))%(n/2)];
		}
	}
	else if(s.type1.equals("cruiser")){
		if(n<=1){
			if(n==0){
				s.target=Null;
				}
				else{
					s.target=sh[0];
				};
		}
		else{
		s.target=sh[(int)(100*random(0.0))%n];
		}
	}
	else{
		if(n<=1){
			if(n==0){
				s.target=Null;
				}
				else{
					s.target=sh[0];
				}
		}
		else{
		s.target=sh[(int)(100*random(0.0))%(n/2)];
		if(s.target.type1.equals("submarine")){
			s.target=sh[(int)(100*random(0.0))%(n/2)];
		}
		if(s.target.type1.equals("submarine")){
			s.target=sh[(int)(100*random(0.0))%(n/2)];
		}
		}
	}
}
///////////////////////battle end///////////
public static void check(){
	//if(player.cash>=-100&&ai.cash>=-100){
		//play();
	//}
	if(player.cash<-100){
		System.out.println("you lose");
		start();
	}
	else if(ai.cash<-100){
		System.out.println("you win");
		start();
	}
	System.out.println("next year?");
	System.out.println("1:yes");
	System.out.println("2:no");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 1:play();break;
	case 2:start();break;
	}
}
public static void move(Ship sh,int rspeed,boolean direction){
	try{
	p[sh.position+15].remove();
	if(!direction){
		rspeed=ver(rspeed*(1-0.2*p[sh.position+15-1].numofshipaw)/0.8);
		if(rspeed<0){
			rspeed=0;
		}
		rspeed=0-rspeed;
	}
	else{
		rspeed=ver(rspeed*(1-0.2*p[sh.position+15+1].numofshipaw)/0.8);
		if(rspeed<0){
			rspeed=0;
		}
	}
	sh.position+=rspeed;
	p[sh.position+15].add();
	}
	catch(Exception e){
		System.out.println("indexoutofbound index"+sh.position+"+15");
	}
	
}
////////////////////////////////further helper////////////////////////////////
public static void checkfleet(){
	System.out.println("1:available");
	System.out.println("2:under repair");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
    int j;
	switch(i)
	{
	case 1:
	if(player.fleet.numofship==0){System.out.println("no ship");
	break;}
	player.fleet.printlist(true);
	System.out.println("choose ship");
	j = sc.nextInt();
	player.fleet.printweap(j);
	break;
	case 2:
		if(player.repair.numofship==0){System.out.println("no ship");
		break;}
		player.repair.printlist(true);
		System.out.println("choose ship");
		j = sc.nextInt();
		player.repair.printweap(j);	
	break;
	default:break;
	}
}
public static int ver(double d){
	int i=(int)d;
	d=d-i;
	if(d>0.5){
		return(i+1);
	}
	return i;
}
}
