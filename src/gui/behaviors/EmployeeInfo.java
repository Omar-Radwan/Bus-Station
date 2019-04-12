package gui.behaviors;

import actors.classes.Employee;
import actors.classes.User;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EmployeeInfo implements DrawableInformation {
	Employee employee;

	public EmployeeInfo(User user) {
		super();
		this.employee = (Employee)user;
	}


	@Override
	public void drawExtraInfo(GridPane gridpane) {
		Label salaryLabel = new Label ("Salary:");
		Label salaryValueLabel = new Label (Double.toString(employee.getSalary())+" ");
		Label egpLabel = new Label ("Egp");
		
		gridpane.add(salaryLabel, 0, 3);
		gridpane.add(salaryValueLabel,1, 3);
		gridpane.add(egpLabel,2,3);
	}
	
	
}
