package Infrastructure;

import java.util.List;

public class Methodes {
    public static String generateId(int a, int b){
        String tmp = ""+a;
        int zeros = 4-tmp.length();
        for (int i = 0 ; i<zeros ; i++){
            tmp = "0"+tmp;
        }
        tmp = b+tmp;
        zeros = 8-tmp.length();
        for (int i = 0 ; i<zeros ; i++){
            tmp = "0"+tmp;
        }
         return tmp;
    }

    public static int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min);
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }
    
	
	public static int[][] permuter(int[][] solution,int p, int i,int j) {
	
		int[][] newVoisin= solution;
		int permute;
		permute = newVoisin[p][i];
		newVoisin[p][i]= newVoisin[p][j];
		newVoisin[p][j]=permute;
		
		
		
		return newVoisin;
	}
	
	
	public static boolean VerifContr(List<Process> processes, List<Server> servers,int[][] copie, int i) {
	
		int  QtRessources=0,ressources=0;
		for(int k=0;k<processes.size();k++) {
			int Id=0;
			if(copie[k][i]!=0) {
				Id=copie[k][i];
				for(Process p : processes)
					if(Id==p.getId())
						QtRessources+=p.getRequiredRessources();
			}}
			for(Server s : servers)
				if(i==s.getId())
					ressources=(int) s.getRessources();
			if(ressources>=QtRessources)
				return true;
			else
				return false;
			
						
					
		
				
				
		}
			
		
	
}
