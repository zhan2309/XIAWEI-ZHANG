import java.util.ArrayList;

public class Airport {
	private String name;
	private ArrayList flights;

	public Airport(String name) {
		this.name = name;
		this.flights = new ArrayList();
	}

	public String getName() {
		return name;
	}

	public boolean wasVisitedBy(Flight f) {
		return this.flights.contains(f);
	}

	public void addFlight(Flight f) {
		if (!flights.contains(f)){
			flights.add(f);
			f.addAirport(this);
		}
	}

	public boolean onSameFlight(Airport a2) {
		int i = 0;
		while (i < flights.size()){
			if(this.flights.contains(a2.flights.get(i))){
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public String toString() {
		String temp = "";
		int i = 0;
		if (flights.size() == 0){
			return name + " " + "()";
		}

		else if (flights.size() == 1){
			Flight flight = (Flight) flights.get(0);
			return name + " " + "(" + flight.getName() + ")";
		} else {
			while (i < flights.size()){
				Flight flight = (Flight) flights.get(i);
				temp += flight.getName() + ", ";
				i++;
			}
			temp = "(" + temp + ")";
			temp = name + " " + temp;
			temp = temp.substring(0, temp.length() - 3);
			return temp + ")";
		}
	}

	@Override
	public boolean equals(Object o) {
	if (o instanceof Airport){
		Airport airport = (Airport) o;

		if (!name.equals(airport.name)){
			return false;
		}
			{
			if (flights.size() != (airport.flights.size())){
				return false;
			}
				{
				int i = 0;
				while(i!=flights.size()){
					if (!flights.contains(airport.flights.get(i))){
						return false;
					}else{
						i+=1;
					}
				}
				return true;
			}

		}
	}
	return false;
	}
}
