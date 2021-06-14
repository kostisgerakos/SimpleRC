package eu.including.simpleRC.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Resource  {

	private Integer resourceId;
	private String resourceName;
	private Integer partition;
	List<MissionParameters> missionParameters;
	


}