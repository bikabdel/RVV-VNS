package Infrastructure;

/**
 * Created by t460p on 12/01/2018.
 */
public class Server {
    private int id;
    private double processingPower;
    private double ressources;
	private double qtCommunication;
	private double debit;

    public Server( int id, double processingPower, double ressources, int Communication, int Debit) {
       this.id = id;
     this.processingPower = processingPower;
        this.ressources = ressources;
        this.qtCommunication = Communication;
        this.debit = Debit;
       
    }
    
    
   

    public double getProcessingPower() {
        return processingPower;
    }

    public void setProcessingPower(double processingPower) {
        this.processingPower = processingPower;
    }

    public double getRessources() {
        return ressources;
    }

    public void setRessources(double ressources) {
        this.ressources = ressources;
    }

    public int getId() {
        return id;
    }

	public void setId(int id) {
		this.id = id;
	}




	public double getQtCommunication() {
		return qtCommunication;
	}




	public void setQtCommunication(double qtCommunication) {
		this.qtCommunication = qtCommunication;
	}




	public double getDebit() {
		return debit;
	}




	public void setDebit(double debit) {
		this.debit = debit;
	}


}


