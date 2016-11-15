package HihoCoder;

public class DesertTraveling {
	public static int isCanFinish(int[] energy, int[] cost) {
        if(energy == null || energy.length == 0) {
            return 1;
        }
        
        int len = energy.length;
        
        int begin = 0;
        int end = 0;
        
        int energyLeft = 0;
        
        int index = 0;
        for(int i = 1; i < len; i++) {
        	energyLeft += energy[index] - cost[index];
        	
        	if(energyLeft < 0) {
        		begin = begin == 0 ? len - 1 : begin - 1;
        		index = begin;
        	} else {
        		end ++;
        		index = end;
        	}
        }
        
        return energyLeft + (energy[index] - cost[index]) >= 0 ? begin : -1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = new int[]{2,5,6,7,5};
		int[] cost = new int[]{3,4,4,4,4};
		System.out.println(isCanFinish(gas, cost));
	}

}
