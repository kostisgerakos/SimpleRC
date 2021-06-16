package eu.including.simpleRC.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class TaskItems {
	String taskMessage;
	Integer duration;
	
	
	@Override
	public String toString() {
		return "TaskItems [taskMessage=" + taskMessage + ", duration=" + duration + "]";
	}
	
	
}
