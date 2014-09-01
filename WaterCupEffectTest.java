package tryCatch;

import java.util.Scanner;

public class WaterCupEffectTest  {
	
	
	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		double kettleVolume = scanner.nextDouble();
		
		double cupVolume = scanner.nextDouble();
		
		
		CupData cupData = measureCupVolume(kettleVolume, cupVolume);
		
		
		System.out.println(cupData.fullCupCnt + " " + cupData.someCopCnt + " " + cupData.depthLevel);
	}
	
	public static CupData measureCupVolume(double kettleVolume, double cupVolume)throws Exception{
		
		CupData cupData = new CupData();
		
		
		while(true){
			
			cupData.depthLevel++;
			
			double rest = kettleVolume - cupVolume*(cupData.depthLevel);
			
			if(rest >= 0){
				
				cupData.fullCupCnt = cupData.fullCupCnt + cupData.depthLevel;
				
				kettleVolume = rest;
				
			}else{
				
				while(kettleVolume > 0){
					rest = kettleVolume - cupVolume;
					
					if(rest < 0){
						cupData.someCopCnt++;
					}else{
						cupData.fullCupCnt++;
					}
					
					kettleVolume = rest;
				}
				
			}
			
			if(kettleVolume <= 0)
				break;
			
		}
		
		return cupData;
	}
	
	
}


class CupData{
	
	int fullCupCnt;
	int someCopCnt;
	int depthLevel;
}