import jason.asSyntax.*;
import jason.environment.Environment;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Logger;

public class Crossroads extends Environment{
	 
	 public static final int CrossSize=12;
	
	private CrossModel model;
    private CrossView  view;
	
	public boolean l1;
	public boolean l2;
	public boolean l3;
	public boolean l4;
	
	private int pedlast;
		
	static Logger logger = Logger.getLogger(Crossroads.class.getName());
	
	
	public static final Term s1 = Literal.parseLiteral("switch1");
	public static final Term s2 = Literal.parseLiteral("switch2");
	public static final Term s3 = Literal.parseLiteral("switch3");
	public static final Term s4 = Literal.parseLiteral("switch4");
	
	public static final Term mp = Literal.parseLiteral("move(pedestrian)");
	public static final Term mc1 = Literal.parseLiteral("move(car_1)");
	public static final Term mc2 = Literal.parseLiteral("move(car_2)");
	public static final Term mc3 = Literal.parseLiteral("move(car_3)");
	
	
	@Override
    public void init(String[] args) {
		model = new CrossModel();
		view = new CrossView(model);
		model.setView(view);
		updatePercepts();
		l1=true;
		l2=false;
		l3=true;
		l4=false;
		pedlast=4;
    }
	
	
	
	@Override
    public boolean executeAction(String agName, Structure action) {
		
		logger.info(agName + " doing: " + action);
		
		
		try {
			
			if (action.equals(s1)) {
				l1= !l1;
			}else if (action.equals(s2)){
				l2= !l2;
			}else if (action.equals(s3)){
				l3= !l3;
			}else if (action.equals(s4)){
				l4= !l4;
			}else if (action.equals(mp)){
				model.movePedastrian();
			}else if (action.equals(mc1)){
				model.moveCar1();
			}else if (action.equals(mc2)){
				model.moveCar2();
			}else if (action.equals(mc3)){
				model.moveCar3();
			}
			
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		updatePercepts();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        informAgsEnvironmentChanged();
        return true;
		
	}
	
	
	void updatePercepts() {
        clearPercepts();
	}
	
	@Override
    public void stop() {
        super.stop();
    }

	


class CrossModel extends GridWorldModel {

		private CrossModel() {
			// Size of the map, num of agents to display
            super(CrossSize, CrossSize, 8);

			try {
				
				// pedastrian
                setAgPos(0, 4, 8);
				
				// car1
                setAgPos(1, 0, 6);
				//car2
				setAgPos(2, 5, 0);
				// car3
				setAgPos(3, 6,11);
				
				//lamp1
				setAgPos(4, 4,7);
				//lamp2
				setAgPos(5, 4,4);
				//lamp3
				setAgPos(6, 7,4);
				//lamp4
				setAgPos(7, 7,7);
				

            } catch (Exception e) {
                e.printStackTrace();
            }
			
		}

		void movePedastrian(){
			Location loc;
			loc	= getAgPos(0);
		
			if (loc.x==4){
				loc.x++;
				pedlast = 4;
			}else if(loc.x==5 && pedlast==4){
				loc.x++;
				pedlast = 5;
			}else if(loc.x==5 && pedlast==6){
				loc.x--;
				pedlast = 5;
			}else if (loc.x==6 && pedlast==5){
				loc.x++;
				pedlast = 6;
			}else if (loc.x==6&&pedlast==7){
				loc.x--;
				pedlast = 6;
			}else if (loc.x==7){
				loc.x--;
				pedlast = 7;
			}
			setAgPos(0, loc);
		}
		
		void moveCar1(){
			Location loc;
			loc	= getAgPos(1);
			if (loc.y==6 && loc.x>=0 && loc.x <=10&& loc.x!=4&&!getAgPos(2).equals(new Location(loc.x+1,loc.y))&&!getAgPos(3).equals(new Location(loc.x+1,loc.y))){
				loc.x++;
			}else if (loc.y==5 && loc.x>=1 && loc.x <=11&& loc.x!=7&&!getAgPos(2).equals(new Location(loc.x-1,loc.y))&&!getAgPos(3).equals(new Location(loc.x-1,loc.y))){
				loc.x--;
			}else if (loc.y==6&&loc.x==4&&l1&&!getAgPos(2).equals(new Location(loc.x+1,loc.y))&&!getAgPos(3).equals(new Location(loc.x+1,loc.y))){
				loc.x++;
			}else if(loc.y==5&&loc.x==7&&l3&&!getAgPos(2).equals(new Location(loc.x-1,loc.y))&&!getAgPos(3).equals(new Location(loc.x-1,loc.y))){
				loc.x--;
			}else if(loc.x==11&&loc.y==6&&!getAgPos(2).equals(new Location(loc.x,loc.y-1))&&!getAgPos(3).equals(new Location(loc.x,loc.y-1))){
				loc.y=5;
			}else if(loc.x==0&&loc.y==5&&!getAgPos(2).equals(new Location(loc.x,loc.y+1))&&!getAgPos(3).equals(new Location(loc.x,loc.y+1))){
				loc.y=6;
			}
			setAgPos(1, loc);
		}
		
		void moveCar2(){
			Location loc;
			loc	= getAgPos(2);
			if (loc.x==5&&loc.y>=0&&loc.y<=10&&loc.y!=4&&!getAgPos(3).equals(new Location(loc.x,loc.y+1))&&!getAgPos(1).equals(new Location(loc.x,loc.y+1))&&!getAgPos(0).equals(new Location(loc.x,loc.y+1))){
				loc.y++;
			}else if (loc.x==6&&loc.y>=1&&loc.y<=11&&loc.y!=7&&!getAgPos(3).equals(new Location(loc.x,loc.y-1))&&!getAgPos(1).equals(new Location(loc.x,loc.y-1))&&!getAgPos(0).equals(new Location(loc.x,loc.y-1))){
				loc.y--;
			}else if(loc.y==4&&loc.x==5&&l2&&!getAgPos(1).equals(new Location(loc.x,loc.y+1))&&!getAgPos(3).equals(new Location(loc.x,loc.y+1))&&!getAgPos(0).equals(new Location(loc.x,loc.y+1))){
				loc.y++;
			}else if(loc.y==7&&loc.x==6&&l4&&!getAgPos(1).equals(new Location(loc.x,loc.y-1))&&!getAgPos(3).equals(new Location(loc.x,loc.y-1))&&!getAgPos(0).equals(new Location(loc.x,loc.y-1))){
				loc.y--;
			}else if(loc.x==5&&loc.y==11&&!getAgPos(1).equals(new Location(loc.x-1,loc.y))&&!getAgPos(3).equals(new Location(loc.x+1,loc.y))){
				loc.x=6;
			}else if(loc.x==6&&loc.y==0&&!getAgPos(1).equals(new Location(loc.x+1,loc.y))&&!getAgPos(3).equals(new Location(loc.x-1,loc.y))){
				loc.x=5;
			}
			
			
			setAgPos(2, loc);
		}
		
		
		void moveCar3(){
			Location loc;
			loc	= getAgPos(3);
			
			if(loc.x==6&&loc.y>=6&&loc.y<=11&&loc.y!=7&&!getAgPos(1).equals(new Location(loc.x,loc.y-1))&&!getAgPos(0).equals(new Location(loc.x,loc.y-1))&&!getAgPos(2).equals(new Location(loc.x,loc.y-1))){
				loc.y--;
			}else  if(loc.x<=6&&loc.x>=1&&loc.y==5&&!getAgPos(1).equals(new Location(loc.x-1,loc.y))&&!getAgPos(0).equals(new Location(loc.x-1,loc.y))&&!getAgPos(2).equals(new Location(loc.x-1,loc.y))){
				loc.x--;
			}else if( loc.x>=0&&loc.x<=3&&loc.y==6&&!getAgPos(1).equals(new Location(loc.x+1,loc.y))&&!getAgPos(0).equals(new Location(loc.x+1,loc.y))&&!getAgPos(2).equals(new Location(loc.x+1,loc.y))){
				loc.x++;
			}else if(loc.x==5&&loc.y>=6&&loc.y<=10&&!getAgPos(1).equals(new Location(loc.x,loc.y+1))&&!getAgPos(0).equals(new Location(loc.x,loc.y+1))&&!getAgPos(2).equals(new Location(loc.x,loc.y+1))){
				loc.y++;
			}else if(loc.x==6&&loc.y==7&&l4&&!getAgPos(1).equals(new Location(loc.x,loc.y-1))&&!getAgPos(0).equals(new Location(loc.x,loc.y-1))&&!getAgPos(2).equals(new Location(loc.x,loc.y-1))){
				loc.y--;
			}else if(loc.x==4&&loc.y==6&&l1&&!getAgPos(1).equals(new Location(loc.x+1,loc.y))&&!getAgPos(0).equals(new Location(loc.x+1,loc.y))&&!getAgPos(2).equals(new Location(loc.x+1,loc.y))){
				loc.x++;
			}else if(loc.x==0&&loc.y==5&&!getAgPos(1).equals(new Location(loc.x,loc.y+1))&&!getAgPos(0).equals(new Location(loc.x,loc.y+1))&&!getAgPos(2).equals(new Location(loc.x,loc.y+1))){
				loc.y++;
			}else if(loc.x==5&&loc.y==11&&!getAgPos(1).equals(new Location(loc.x+1,loc.y))&&!getAgPos(0).equals(new Location(loc.x+1,loc.y))&&!getAgPos(2).equals(new Location(loc.x+1,loc.y))){
				loc.x++;
			}
			
			
			setAgPos(3, loc);
		}
}
	class CrossView extends GridWorldView {

        public CrossView(CrossModel model) {
            super(model, "Smart Cross", 600);
           setResizable(false);
            setVisible(true);
            repaint();
        }

        /** draw application objects */
        @Override
        public void draw(Graphics g, int x, int y, int object) {
            
        }

        @Override
        public void drawAgent(Graphics g, int x, int y, Color c, int id) {
			String label;
			switch(id){
				case 0: label="P";c = Color.black; break;
				case 1:label="C"; c = Color.yellow;
				break;
				case 2: label="C"; c = Color.yellow;
				break;
				case 3: label="C"; c = Color.yellow;
				break;
				case 4: label=" L";
					if (l1){
						c = Color.green;
					}else{
						c = Color.red;
					}
					break;
				case 5: label=" L";
				if (l2){
						c = Color.green;
					}else{
						c = Color.red;
					}
					break;
				case 6: label=" L";
				if (l3){
						c = Color.green;
					}else{
						c = Color.red;
					}
					break;
				case 7: label=" L";
				if (l4){
						c = Color.green;
					}else{
						c = Color.red;
					}
					break;
				default: label="X"; break;
			}
			label=label+(id);
			
			super.drawAgent(g, x, y, c, -1);
			g.setColor(Color.white);
            super.drawString(g, x, y, defaultFont, label);
            repaint();
        }

	}	
 }


