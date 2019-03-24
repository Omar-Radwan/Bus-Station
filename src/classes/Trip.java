package classes;

public class Trip {

	String source;
	String destination;
	Double distance;
	String type;
	int numberOfStops;
	
	//---------------------------------------------------------------------------
	
	public Trip(String source, String destination, Double distance, String type, int numberOfStops) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.type = type;
		this.numberOfStops = numberOfStops;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	
	//---------------------------------------------------------------------------

}
