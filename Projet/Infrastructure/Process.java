package Infrastructure;



/**
 * Created by t460p on 12/01/2018.
 */
public class Process {
    private int id;
    private double workLoad;
    private double requiredRessources;
    private double Communication;
   

    public Process(int id, double workLoad, double requiredRessources, int Communication) {
        this.id = id;
        this.workLoad = workLoad;
        this.requiredRessources = requiredRessources;
        this.Communication = Communication;
    }

    public double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(double workLoad) {
        this.workLoad = workLoad;
    }

    public double getRequiredRessources() {
        return requiredRessources;
    }

    public void setRequiredRessources(double requiredRessources) {
        this.requiredRessources = requiredRessources;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

	public double getCommunication() {
		return Communication;
	}

	public void setCommunication(double communication) {
		Communication = communication;
	}
	
}
