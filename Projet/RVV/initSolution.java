package RVV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import Infrastructure.Host;
import Infrastructure.Process;
import Infrastructure.Server;

public class initSolution {

	
	/***************************************************** la solution Initiale ****************************************/
	
	
	
	public static int[][] SolutionInit(List<Server> servers, List<Process> processes){
	int[][] solution = new int[processes.size()][servers.size()];
	Host[]  hosts = new Host[servers.size()];
	int i=0;
	for(Server s : servers){
		hosts[i] = new Host(s);
		++i;
	}
	
	for(Process p : processes){
	
		for(int j=0;j<hosts.length; j++){
			if(hosts[j].getQtRessource() >= p.getRequiredRessources()){ 
				hosts[j].getProcesses().add(p);
				double c = hosts[j].getQtRessource();
				hosts[j].setQtRessource(c-p.getRequiredRessources());

				solution[processes.indexOf(p)][j] = p.getId();
				break;
			}
		}
	
		
	}
	
	return solution;
}
	
	/*************************** remplissage de la liste des process depuis le fichier json ****************************************/ 
	
	public static void RempProc(List<Process> processes,int NumberProcess) {
	  String line = "";
  String filePath = "Infrastructure/p.json";
  
  try {
      FileReader fr = new FileReader(filePath);
     
	@SuppressWarnings("resource")
	BufferedReader reader2 = new BufferedReader(fr);
      Gson gson = new Gson();
//	while((line = reader2.readLine())!= null)
      for(int i = 0; i<NumberProcess; i++) {
          line = reader2.readLine();
          processes.add(gson.fromJson(line,Process.class));
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
  
	}

	/*************************** remplissage de la liste des serveur depuis le fichier json ****************************************/ 
	
    
	public static void RempServ(List<Server> servers,int NumberServer) {
	
		 String line = "";
    String filePath = "Infrastructure/s.json";
    try {
          FileReader fr = new FileReader(filePath);
          
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(fr);
          Gson gson = new Gson();
		//	while((line = reader.readLine())!= null)
          for(int i = 0; i<NumberServer ; i++) {
              line = reader.readLine();
              servers.add(gson.fromJson(line,Server.class));
          }
      } catch (IOException e) {
      	
          e.printStackTrace();
      }
    
  
	}
	
	

	
	
	
	
	
	
	
}
