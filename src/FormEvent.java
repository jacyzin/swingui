import java.util.EventObject;

public class FormEvent extends EventObject {

	private static final long serialVersionUID = 7972092453094688007L;
	private String name;
	private String occupation;
	private int ageCat;
	private String empCat;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int ageCat, String empCat) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCat = ageCat;
		this.empCat = empCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAgeCat() {
		return ageCat;
	}

	public String getEmpCategory() {
		return empCat;
	}
}
