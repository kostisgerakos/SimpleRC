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
	private String resourceType;
	List<MissionParameters> missionParameters;
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", partition=" + partition
				+ ", resourceType=" + resourceType + ", missionParameters=" + missionParameters + "]";
	}

	


}