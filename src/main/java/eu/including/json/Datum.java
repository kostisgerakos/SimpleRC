
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
    "location"
})
@Generated("jsonschema2pojo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Datum {

    @JsonProperty("location")
    public List<Location> location = null;

}
