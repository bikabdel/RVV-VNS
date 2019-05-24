package RVV;

import java.util.List;

import Infrastructure.*;
import Infrastructure.Process;




/****************************************************** Classe pour calculer les coût *******************************************************/




public class Cout {
	
	



	/************************************************** remplissage de la matrice des couts d'éxecution  *************************************************/
	
	public static int[][] rempCE(List<Server> servers,List<Process> processes){
		
		int[][] matCE = new int[processes.size()][servers.size()];
		
			int i=0,j=0;
				for(Process p : processes) {
					j=0;
					for(Server s : servers) {
				matCE[i][j]=(int) (p.getWorkLoad()*s.getProcessingPower());
				j++;
					}
					i++;
				}
				return matCE;
				
	}
	
	
	
	
	/**************************************************** remplissage de la matrice des couts de communication ***********************************************/
	
	
public static int[][] rempCC(List<Server> servers,List<Process> processes){
		
		int[][] matCC = new int[processes.size()][servers.size()];
		
			int i=0,j=0;
				for(Process p : processes) {
					j=0;
					for(Server s : servers) {
				matCC[i][j]=(int) (p.getCommunication()*s.getDebit());
				j++;
					}
					i++;
				}
				return matCC;
				
	}
	

/********************************** Calcul du cout total d'éxecution d'une solution *********************/
					
		public static int CoutTotal(int[][] copie,int[][] matCout,List<Server> servers,List<Process> processes) {
			int C=0;
			for(int i=0;i<processes.size();i++)
				for(int j=0;j<servers.size();j++)
					if(copie[i][j]!=0)
						C += matCout[i][j];  
			
			
			return C;
		}

		
		
		
		
	


		



}
