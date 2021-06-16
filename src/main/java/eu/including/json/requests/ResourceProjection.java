package eu.including.json.requests;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resourceId", "resourceName", "resourceDescription", "resourceLocation", "resourceStatus",
		"healthStatus", "resourceType", "transferable", "partition", "testbedId", "preferedSrid", "mobile",
		"testbedAreaId" })
@Generated("jsonschema2pojo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResourceProjection {

	@JsonProperty("resourceId")
	public Integer resourceId;
	@JsonProperty("resourceName")
	public String resourceName;
	@JsonProperty("resourceDescription")
	public String resourceDescription;
	@JsonProperty("resourceLocation")
	public String resourceLocation;
	@JsonProperty("resourceStatus")
	public String resourceStatus;
	@JsonProperty("healthStatus")
	public String healthStatus;
	@JsonProperty("resourceType")
	public String resourceType;
	@JsonProperty("transferable")
	public Boolean transferable;
	@JsonProperty("partition")
	public Integer partition;
	@JsonProperty("testbedId")
	public Integer testbedId;
	@JsonProperty("preferedSrid")
	public Integer preferedSrid;
	@JsonProperty("mobile")
	public Boolean mobile;
	@JsonProperty("testbedAreaId")
	public Integer testbedAreaId;

}