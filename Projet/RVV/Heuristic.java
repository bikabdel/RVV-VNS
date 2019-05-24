package RVV;

import java.util.ArrayList;
import java.util.List;

import Infrastructure.Methodes;
import Infrastructure.Process;
import Infrastructure.Server;

public class Heuristic {
	
	
   	List<Server> servers = new ArrayList<Server>();
	List<Process> processes = new ArrayList<Process>();
	
	private static int CCT;
	private static int CET;
	private static int z;
		
	
	public static int getCCT() {
		return CCT;
	}
	public static void setCCT(int cCT) {
		CCT = cCT;
	}
	public static int getCET() {
		return CET;
	}
	public static void setCET(int cET) {
		CET = cET;
	}



/************************************************* RVV algorithme  ***********************************************/

	
	
	
	/************ RVV 2 serveur ***********/
	
	public static int[][] RVV_2_s(int[][] solution,List<Process> processes,List<Server> servers) {

		
		int[][] copie= new int[processes.size()][servers.size()];
		int[][] MatCE = Cout.rempCE(servers, processes);
		int[][] MatCC = Cout.rempCC(servers, processes); 
		
		int param = 1000,CEA=0,CCA=0,NewCC=0,NewCE=0;
		
		boolean a=false,b=false,bool1=false,bool2=false;
		
		


		CCT = Cout.CoutTotal(solution, MatCC, servers, processes);
		CET = Cout.CoutTotal(solution, MatCE, servers, processes);
		CEA=CET;CCA=CCT;
		
		copie=solution;
		
		
		for(int k=0;k<param;k++) {
			
			System.out.println("rvv2    "+z);
			
			int i=Methodes.randomWithRange(1,servers.size());
			int j=Methodes.randomWithRange(1, servers.size());
			
			if(i==j)
				continue;
			else {
				
			for(int p=0;p<processes.size();p++) {
				
				
				
				if(copie[p][i]!=0) {
					copie=Methodes.permuter(copie,p,i,j);
					a=Methodes.VerifContr(processes,servers,copie,i);
					b=Methodes.VerifContr(processes,servers,copie,j);
					}
				
					if(a || b) {
						
						NewCC = CCA-MatCC[p][j]+MatCC[p][i];
						NewCE = CEA-MatCE[p][j]+MatCE[p][i];	
						
						
						if(NewCC<CCA)
							{
							CCT=NewCC;
							bool1=true;
							}
						if(NewCE<CEA)
							{
							CET=NewCE;
							bool2=true;
							}
					
						if(bool1 && bool2)
							{
							solution=copie;
							
							}
					
						
					}			
			}

			
			}
			if(NewCC==CCT && NewCE==CET)
				z++;
			if(z==5) {
				Heuristic.RVV_3_s(copie, processes, servers);
				z=0;
				}
		}
		
		return solution;
		
	}



	
	
	
	
	
	
	/************* RVV 3 serveur *************/

		
		
 		public static void RVV_3_s(int[][] solution,List<Process> processes,List<Server> servers) {

 			
 			int[][] copie= new int[processes.size()][servers.size()];
 			copie=solution;
 			int param = 40,CEA=0,CCA=0,NewCC=0,NewCE=0;
 			boolean a=false,b=false,bool1=false,bool2=false,flag=false;
 			
 			
 			int[][] MatCE = Cout.rempCE(servers, processes);
 			int[][] MatCC = Cout.rempCC(servers, processes); 
 			

 			CCT = Cout.CoutTotal(solution, MatCC, servers, processes);
 			CET = Cout.CoutTotal(solution, MatCE, servers, processes);
 			
 			
 			
 			for(int k=0;k<param;k++) {
 				System.out.println("rvv3  ");
 				int i=Methodes.randomWithRange(1,servers.size());
 				int j=Methodes.randomWithRange(1, servers.size());
 				int h=Methodes.randomWithRange(1,servers.size());
 				if(i==j || j==h || h==i)
 					continue;
 				else {
 				for(int p=0;p<processes.size();p++) {
 					if(copie[p][i]!=0) {
 						copie=Methodes.permuter(copie,p,i,j);
 						a=Methodes.VerifContr(processes,servers,copie,i);
 						b=Methodes.VerifContr(processes,servers,copie,j);
 						}
 					
 						if(a || b) {
 							NewCC = CCA-MatCC[p][j]+MatCC[p][i];
 							NewCE = CEA-MatCE[p][j]+MatCE[p][i];	
 							
 							
 							if(NewCC<CCA)
 								{
 								CCT=NewCC;
 								bool1=true;
 								}
 							if(NewCE<CEA)
 								{
 								CET=NewCE;
 								bool2=true;
 								}
 						
 							if(bool1 || bool2)
 								{
 								solution=copie;
 								
 								}
 							
 							}
 						else 
 							continue;
 										
 				}
 				for(int p=0;p<processes.size();p++) {
 					if(copie[p][j]!=0) {
 						copie=Methodes.permuter(copie,p,j,h);
 						a=Methodes.VerifContr(processes,servers,copie,j);
 						b=Methodes.VerifContr(processes,servers,copie,h);
 						}
 					
 						if(a || b) {
 							NewCC = CCA-MatCC[p][h]+MatCC[p][j];
 							NewCE = CEA-MatCE[p][h]+MatCE[p][j];	
 							
 							
 							if(NewCC<CCA)
 								{
 								CCT=NewCC;
 								bool1=true;
 								}
 							if(NewCE<CEA)
 								{
 								CET=NewCE;
 								bool2=true;
 								}
 						
 							if(bool1 && bool2)
 								{
 								solution=copie;
 								
 								}
 						
 							}
 						else 
 							continue;
 										
 				}
 				for(int p=0;p<processes.size();p++) {
 					if(copie[p][h]!=0) {
 						copie=Methodes.permuter(copie,p,h,i);
 						a=Methodes.VerifContr(processes,servers,copie,h);
 						b=Methodes.VerifContr(processes,servers,copie,i);
 						}
 					
 						if(a || b) {
 							NewCC = CCA-MatCC[p][h]+MatCC[p][i];
 							NewCE = CEA-MatCE[p][h]+MatCE[p][i];	
 							
 							
 							if(NewCC<CCA)
 								{
 								CCT=NewCC;
 								bool1=true;
 								}
 							if(NewCE<CEA)
 								{
 								CET=NewCE;
 								bool2=true;
 								}
 						
 							if(bool1 && bool2)
 								{
 								solution=copie;
 								
 								}
 						
 						
 							}
 						else 
 							continue;
 										
 								
 				
 				
 				}
 				
 				
 				}
 				
 				if(NewCC!=CCT || NewCE!=CET)
	 				{
 					flag=true;
 						break;
 						
	 				}
	 					
	 					
	 					
 				if(flag==true)
 				
 					Heuristic.RVV_2_s(copie, processes, servers);
					
 			}
 			
 		
 		
 		}
 		
 		
}
 				
 				
 			
		
		
		
		
		
 			
	

