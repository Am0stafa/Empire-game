package units;

//Cavalry c = new Cavalry();

//army.setUnits(c);

import exceptions.MaxCapacityException;

public class Scout extends Unit{

	public Scout(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
		
	}
	public void Hire(Army army) throws MaxCapacityException{
		if(!(army.getCurrentStatus().equals(Status.MARCHING)) || (army.getCurrentStatus().equals(Status.BESIEGING))) {
			
			if(army.getUnits().size()==army.getMaxToHold()) {
				throw new MaxCapacityException("max");			
			}
			 if(army.getUnits().size()<=army.getMaxToHold()) {
				if(getLevel()==1) {
					Cavalry c = new Cavalry(1,50,0.5,0.6,0.7);
					army.getUnits().add(c);
				}
				if(getLevel()==2) {
					Cavalry cc = new Cavalry(2,50,0.5,0.6,0.7);
					army.getUnits().add(cc);
				}
				if(getLevel()==3) {
					Cavalry ccc = new Cavalry(3,60,0.6,0.7,0.8);
					army.getUnits().add(ccc);
				}
				
			}
			 else if(army.getUnits().size()>=army.getMaxToHold()/2){
				if(getLevel()==1) {
					Archer a = new Archer(1,60,0.4,0.5,0.6); 
					army.getUnits().add(a);
					
				}
				else if(getLevel()==2) {
					Archer aa = new Archer(2,60,0.4,0.5,0.6);
					army.getUnits().add(aa);
					
				}
				else if(getLevel()==3) {
					Archer aaa = new Archer(3,70,0.5,0.6,0.7);
					army.getUnits().add(aaa);
				}
				

			}
			 
			
			
			
			
			
		}
		
	}
	
	
	
	
	
	

}
