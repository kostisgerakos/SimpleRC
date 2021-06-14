
package eu.including.json;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timestep",
    "nodes",
    "sensors",
    "tasks"
})
@Generated("jsonschema2pojo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {

    @JsonProperty("timestep")
    public double timestep;
    @JsonProperty("nodes")
    public List<Node> nodes = null;
    @JsonProperty("sensors")
    public List<Sensor> sensors = null;
    @JsonProperty("tasks")
    public List<List<Task>> tasks = null;

}
