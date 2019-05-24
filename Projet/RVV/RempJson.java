package RVV;

import static Infrastructure.Methodes.randomWithRange;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import com.google.gson.Gson;

import Infrastructure.Process;
import Infrastructure.Server;

public class RempJson {

	/************************** pour changer les paramètres de la liste des process **********************/
	private static final int ValMin_WorkLoad = 100;
	private static final int ValMax_WorkLoad = 500;
	private static final int ValMin_requiredRessources = 1;
	private static final int ValMax_requiredRessources = 50;
	
	/************************** pour changer les paramètres de la liste des serveurs ************************/
	private static final int ValMin_ProcessingPower = 1800;
	private static final int ValMax_ProcessingPower = 3500;
	private static final int ValMin_ressources = 10;
	private static final int ValMax_ressources = 50;
	
	 static Gson gson = new Gson();
	
	int n=100, m=500;
	 /** Server **/
	int maxProcessingPower = 2,minProcessingPower=10; //server Processing Power range!
	int minRessources = 1000, maxRessources = 100000; //server ressources range!
	static int minqtcommunication = 1;
	static int maxqtcommunication = 10000;
	static int mindebit = 40;
	static int maxdebit = 70;
		  /** proces **/
	int minWorkload =50, maxWorkload = 100;
	int minRequiredRessources = 1, maxRequiredRessources = 500;
	static int minRequiredcommunication = 1;
	static int maxRequiredcommunication = 100;

	/*********************** remplir le JSON process ********************************/
	
	public static void rempJsonProc1(int ProcessNumber) throws IOException {
		FileWriter fichier = new FileWriter("Infrastructure/p.json");
        for (int i=1; i<=ProcessNumber; i++) {
            Gson gson = new Gson();
            Process rand = new Process(i, randomWithRange(ValMin_WorkLoad, ValMax_WorkLoad), randomWithRange(ValMin_requiredRessources,ValMax_requiredRessources),randomWithRange(minRequiredcommunication, maxRequiredcommunication));
            try {
				
				fichier.write(gson.toJson(rand));
				fichier.write("\n");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
            
        }
        fichier.close();
    }
	
	
	
	/*********************** remplir le JSON serveur ********************************/
            
       

	public static void rempJsonServ1(int ServerNumber) throws IOException {
	FileWriter fichier = new FileWriter("Infrastructure/s.json");
    for (int i=0; i<ServerNumber ; i++) {
        Gson gson = new Gson();
        Server rand = new Server(i, randomWithRange(ValMin_ProcessingPower,ValMax_ProcessingPower), randomWithRange(ValMin_ressources,ValMax_ressources), randomWithRange( minqtcommunication, maxqtcommunication), randomWithRange(mindebit,maxdebit));
        try {
			
			fichier.write(gson.toJson(rand));
			fichier.write("\n");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
    }
    fichier.close();
    
    
	}
	
	
	
	
	
	
	
	/**************************************** générateur ********************************/
	
	
	
	public static  void generateur2(int serveur,int process){
		
		 /** Server **/
		int maxProcessingPower = 2,minProcessingPower=10; //server Processing Power range!
		int minRessources = 1000, maxRessources = 100000; //server ressources range!
		int minqtcommunication = 1, maxqtcommunication = 10000;
		int mindebit = 40, maxdebit = 70;
			  /** proces **/
		int minWorkload =50, maxWorkload = 100;
		int minRequiredRessources = 1, maxRequiredRessources = 500;
		int minRequiredcommunication = 1, maxRequiredcommunication = 100;
		
		/*** 						**	generation des servers 	**							***/		
		try {
			PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/s.json"));
		for (int i=0; i<serveur ; i++) {
	            Server rand = new Server(i, randomWithRange(minProcessingPower, maxProcessingPower), randomWithRange(minRessources, maxRessources), randomWithRange(minqtcommunication, maxqtcommunication),randomWithRange(mindebit,maxdebit));
	            sortie.println(gson.toJson(rand));				
			}
			sortie.close();
		} catch (IOException e) {
				e.printStackTrace();
			}
            
	/***						**	generation des Processes 	**									 ***/
	 	try {
	 		PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/p.json"));
	 		for (int i=0; i<process ; i++) {
		 		Gson gson = new Gson();
		 		Process rand = new Process(i, randomWithRange(minWorkload, maxWorkload), randomWithRange(minRequiredRessources, maxRequiredRessources),randomWithRange(minRequiredcommunication, maxRequiredcommunication));				
				sortie.println(gson.toJson(rand));				
			}
		 	sortie.close();
	 		}
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void generateur3(int server,int process){
		
		 /** Server **/
		int maxProcessingPower = 2,minProcessingPower=10; //server Processing Power range!
		int minRessources = 99998, maxRessources = 100000; //server ressources range!
		int minqtcommunication = 1, maxqtcommunication = 10000;
		int mindebit = 40, maxdebit = 70;
			  /** proces **/
		int minWorkload =50, maxWorkload = 100;
		int minRequiredRessources = 49996, maxRequiredRessources = 49998;
		int minRequiredcommunication = 1, maxRequiredcommunication = 100;
		
		/*** 						**	generation des servers 	**							***/		
		try {
			PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/s.json"));
		for (int i=0; i<server ; i++) {
	            Server rand = new Server(i, randomWithRange(minProcessingPower, maxProcessingPower), randomWithRange(minRessources, maxRessources), randomWithRange(minqtcommunication, maxqtcommunication),randomWithRange(mindebit,maxdebit));
	            sortie.println(gson.toJson(rand));				
			}
			sortie.close();
		} catch (IOException e) {
				e.printStackTrace();
			}
            
	/***						**	generation des Processes 	**									 ***/
	 	try {
	 		PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/p.json"));
	 		for (int i=0; i<process ; i++) {
		 		Gson gson = new Gson();
		 		if(i>250){
		 			minRequiredRessources = 100000;
		 			maxRequiredRessources = 100003;
		 			
		 		}
		 		Process rand = new Process(i, randomWithRange(minWorkload, maxWorkload), randomWithRange(minRequiredRessources, maxRequiredRessources),randomWithRange(minRequiredcommunication, maxRequiredcommunication));				
				sortie.println(gson.toJson(rand));				
			}
		 	sortie.close();
	 		}
			catch (IOException e) {
				e.printStackTrace();
			}
            
		
		
	}
	
	
	
		
	
	
	public static void generateur4(int server,int process){
		
		 /** Server **/
		int maxProcessingPower = 2,minProcessingPower=10; //server Processing Power range!
		int minRessources = 99998, maxRessources = 100000; //server ressources range!
		int minqtcommunication = 100, maxqtcommunication = 10000;
		int mindebit = 40, maxdebit = 70;
			  /** proces **/
		int minWorkload =50, maxWorkload = 100;
		int minRequiredRessources =19997 , maxRequiredRessources = 19999;
		int minRequiredcommunication = 1, maxRequiredcommunication = 100;
		
		/*** 						**	generation des servers 	**							***/		
		try {
			PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/s.json"));
		for (int i=0; i<server ; i++) {
	            Server rand = new Server(i, randomWithRange(minProcessingPower, maxProcessingPower), randomWithRange(minRessources, maxRessources), randomWithRange(minqtcommunication, maxqtcommunication),randomWithRange(mindebit,maxdebit));
	            sortie.println(gson.toJson(rand));				
			}
			sortie.close();
		} catch (IOException e) {
				e.printStackTrace();
			}
            
	/***						**	generation des Processes 	**									 ***/
	 	try {
	 		PrintWriter sortie = new PrintWriter(new FileWriter("Infrastructure/p.json"));
	 		for (int i=0; i<process ; i++) {
		 		Gson gson = new Gson();
		 		Process rand = new Process(i, randomWithRange(minWorkload, maxWorkload), randomWithRange(minRequiredRessources, maxRequiredRessources),randomWithRange(minRequiredcommunication, maxRequiredcommunication));				
				sortie.println(gson.toJson(rand));				
			}
		 	sortie.close();
	 		}
			catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
	
	
	
	
	
	
	
	/************************* couts *****************************************/
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	