package eu.including.simpleRC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Goto {
	Double latitude;
	Double longitude;
	Double height;
	
	@Override
	public String toString() {
		return "Goto [latitude=" + latitude + ", longitude=" + longitude + ", height=" + height + "]";
	}
	
	
}
