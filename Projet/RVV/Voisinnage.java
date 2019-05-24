package RVV;



public class Voisinnage {
	

	
	
	/*********************************************** Calcul de cout minimal ************************************
	
	public static boolean minCout(int nouvCout,int ancCout) {
		boolean b=false;
		if(nouvCout<ancCout)
		b=true;
		
		return b;
		
	}

	
	/***************************** Fonction RVV 1-Opt ***************
	
	public static int[][] RVVmini(int[][] solution,int[][] copie,List<Process> processes,List<Server> servers,int i,int j,int p,int k){
		
		
		int CoutComm=Cout.CCT(solution, processes, servers);
		int CoutExec=Cout.CCT(solution, processes, servers);
		int NCoutC,NCoutE;
		boolean a=false,b=false;
		
		copie=Voisinnage.voisinnage(solution,i,j,p,k);
		NCoutC=Cout.CCT(copie, processes, servers);
		NCoutE=Cout.CET(copie, processes, servers);
		a=Voisinnage.minCout(NCoutC, CoutComm);
		b=Voisinnage.minCout(NCoutE, CoutExec);
		if(a || b) {
			solution=copie;
			System.out.println("le cout de éxecution est          :"+NCoutE);
			System.out.println("le cout de Communication est      :"+NCoutC+"\n");
			
		}
		return solution;		
		
	}

*/




}
