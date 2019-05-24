package RVV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import Infrastructure.Process;
import Infrastructure.Server;

public class Main {


	//private static Scanner sc;
	private static int ProcessNumber=100;
	private static int ServerNumber=100;

	public static void main(String[] args) throws IOException {
		
		
		
		
		/********************************** Remplir les JSON ******************************************************************************/
		

		RempJson.rempJsonProc1(ProcessNumber);
		RempJson.rempJsonServ1(ServerNumber);
		
		
		
		/******************************** Remplir les Listes des processes et serveurs  *************************************************/
		
		
		List<Server> servers = new ArrayList<Server>();
		List<Process> processes = new ArrayList<Process>();
		
		initSolution.RempProc(processes,ProcessNumber);
		initSolution.RempServ(servers,ServerNumber);
		

		
		/******************************** Remplir les trois Matrices, deux matrices des couts et une matrice de la solution*************/
		

		int[][] MatCE = Cout.rempCE(servers, processes);
		int[][] MatCC = Cout.rempCC(servers, processes); 
		
		int[][] solInit = new int[ProcessNumber][ServerNumber];
    	int[][] solFin = new int[ProcessNumber][ServerNumber];
		solInit =initSolution.SolutionInit(servers, processes);
		
		Heuristic.setCCT(Cout.CoutTotal(solInit, MatCC, servers, processes));
		Heuristic.setCET(Cout.CoutTotal(solInit, MatCE, servers, processes));
		
    	
	
		
	 	
     	for(int k=0;k<processes.size();k++)
    	{	for(int j=0;j<servers.size();j++)
    		
    			System.out.print(solInit[k][j] + "   ");
				System.out.println();
				}
		
     	
     	
     	System.out.println("\n\n Le cout de communication initial est  : "+Heuristic.getCCT());
     	System.out.println(" Le cout d'éxecution initial est       : "+Heuristic.getCET()+" \n\n");
     	
     	
     	
     	

     	solFin = Heuristic.RVV_2_s(solInit, processes, servers);
    	
    	
    	for(int k=0;k<processes.size();k++)
    	{	for(int j=0;j<servers.size();j++)
    		
    			System.out.print(solFin[k][j] + "   ");
				System.out.println();
				}
    	

     	System.out.println("\n\n Le cout de communication final est  : "+Heuristic.getCCT());
     	System.out.println("Le cout d'éxecution final est       : "+Heuristic.getCET()+" \n\n");
     	
	}
	
	
	
	

	
	
	
}
