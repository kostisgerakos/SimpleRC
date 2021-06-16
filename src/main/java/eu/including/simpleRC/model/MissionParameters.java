package eu.including.simpleRC.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class MissionParameters {
	Goto gotoCommand;
	Sensor sensorActDeact;
	Task task;
	
	@Override
	public String toString() {
		return "MissionParameters [gotoCommand=" + gotoCommand + ", sensorActDeact=" + sensorActDeact + ", task=" + task
				+ "]";
	}
	
	
}
