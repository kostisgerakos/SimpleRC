package eu.including.simpleRC.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Task {
	List<TaskItems> taskItems;

	@Override
	public String toString() {
		return "Task [taskItems=" + taskItems + "]";
	}
	
	
}
