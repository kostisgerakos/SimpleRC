/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv.commands;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Location extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1817136729773834724L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"eu.rawfie.uxv.commands\",\"fields\":[{\"name\":\"latitude\",\"type\":\"double\",\"doc\":\"Latitude in the WGS 84 reference coordinate system\",\"unit\":\"rad\",\"min\":-1.570796326794897,\"max\":1.570796326794897},{\"name\":\"longitude\",\"type\":\"double\",\"doc\":\"Longitude in the WGS 84 reference coordinate system\",\"unit\":\"rad\",\"min\":-3.141592653589793,\"max\":3.141592653589793},{\"name\":\"height\",\"type\":\"float\",\"doc\":\"Height above the WGS 84 ellipsoid\",\"unit\":\"m\"},{\"name\":\"n\",\"type\":\"double\",\"doc\":\"The North offset of the North/East/Down field with respect to Latitude/Longitude/Height\",\"unit\":\"m\"},{\"name\":\"e\",\"type\":\"double\",\"doc\":\"The East offset of the North/East/Down field with respect to Latitude/Longitude/Height\",\"unit\":\"m\"},{\"name\":\"d\",\"type\":\"double\",\"doc\":\"The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height\",\"unit\":\"m\"},{\"name\":\"depth\",\"type\":[\"float\",\"null\"],\"doc\":\"Depth\",\"unit\":\"m\"},{\"name\":\"altitude\",\"type\":[\"float\",\"null\"],\"doc\":\"Altitude\",\"unit\":\"m\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Latitude in the WGS 84 reference coordinate system */
   public double latitude;
  /** Longitude in the WGS 84 reference coordinate system */
   public double longitude;
  /** Height above the WGS 84 ellipsoid */
   public float height;
  /** The North offset of the North/East/Down field with respect to Latitude/Longitude/Height */
   public double n;
  /** The East offset of the North/East/Down field with respect to Latitude/Longitude/Height */
   public double e;
  /** The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height */
   public double d;
  /** Depth */
   public java.lang.Float depth;
  /** Altitude */
   public java.lang.Float altitude;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Location() {}

  /**
   * All-args constructor.
   * @param latitude Latitude in the WGS 84 reference coordinate system
   * @param longitude Longitude in the WGS 84 reference coordinate system
   * @param height Height above the WGS 84 ellipsoid
   * @param n The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param e The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param d The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param depth Depth
   * @param altitude Altitude
   */
  public Location(java.lang.Double latitude, java.lang.Double longitude, java.lang.Float height, java.lang.Double n, java.lang.Double e, java.lang.Double d, java.lang.Float depth, java.lang.Float altitude) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.height = height;
    this.n = n;
    this.e = e;
    this.d = d;
    this.depth = depth;
    this.altitude = altitude;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return latitude;
    case 1: return longitude;
    case 2: return height;
    case 3: return n;
    case 4: return e;
    case 5: return d;
    case 6: return depth;
    case 7: return altitude;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: latitude = (java.lang.Double)value$; break;
    case 1: longitude = (java.lang.Double)value$; break;
    case 2: height = (java.lang.Float)value$; break;
    case 3: n = (java.lang.Double)value$; break;
    case 4: e = (java.lang.Double)value$; break;
    case 5: d = (java.lang.Double)value$; break;
    case 6: depth = (java.lang.Float)value$; break;
    case 7: altitude = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'latitude' field.
   * @return Latitude in the WGS 84 reference coordinate system
   */
  public java.lang.Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the 'latitude' field.
   * Latitude in the WGS 84 reference coordinate system
   * @param value the value to set.
   */
  public void setLatitude(java.lang.Double value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the 'longitude' field.
   * @return Longitude in the WGS 84 reference coordinate system
   */
  public java.lang.Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the 'longitude' field.
   * Longitude in the WGS 84 reference coordinate system
   * @param value the value to set.
   */
  public void setLongitude(java.lang.Double value) {
    this.longitude = value;
  }

  /**
   * Gets the value of the 'height' field.
   * @return Height above the WGS 84 ellipsoid
   */
  public java.lang.Float getHeight() {
    return height;
  }

  /**
   * Sets the value of the 'height' field.
   * Height above the WGS 84 ellipsoid
   * @param value the value to set.
   */
  public void setHeight(java.lang.Float value) {
    this.height = value;
  }

  /**
   * Gets the value of the 'n' field.
   * @return The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
   */
  public java.lang.Double getN() {
    return n;
  }

  /**
   * Sets the value of the 'n' field.
   * The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param value the value to set.
   */
  public void setN(java.lang.Double value) {
    this.n = value;
  }

  /**
   * Gets the value of the 'e' field.
   * @return The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
   */
  public java.lang.Double getE() {
    return e;
  }

  /**
   * Sets the value of the 'e' field.
   * The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param value the value to set.
   */
  public void setE(java.lang.Double value) {
    this.e = value;
  }

  /**
   * Gets the value of the 'd' field.
   * @return The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
   */
  public java.lang.Double getD() {
    return d;
  }

  /**
   * Sets the value of the 'd' field.
   * The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
   * @param value the value to set.
   */
  public void setD(java.lang.Double value) {
    this.d = value;
  }

  /**
   * Gets the value of the 'depth' field.
   * @return Depth
   */
  public java.lang.Float getDepth() {
    return depth;
  }

  /**
   * Sets the value of the 'depth' field.
   * Depth
   * @param value the value to set.
   */
  public void setDepth(java.lang.Float value) {
    this.depth = value;
  }

  /**
   * Gets the value of the 'altitude' field.
   * @return Altitude
   */
  public java.lang.Float getAltitude() {
    return altitude;
  }

  /**
   * Sets the value of the 'altitude' field.
   * Altitude
   * @param value the value to set.
   */
  public void setAltitude(java.lang.Float value) {
    this.altitude = value;
  }

  /**
   * Creates a new Location RecordBuilder.
   * @return A new Location RecordBuilder
   */
  public static eu.rawfie.uxv.commands.Location.Builder newBuilder() {
    return new eu.rawfie.uxv.commands.Location.Builder();
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Location RecordBuilder
   */
  public static eu.rawfie.uxv.commands.Location.Builder newBuilder(eu.rawfie.uxv.commands.Location.Builder other) {
    return new eu.rawfie.uxv.commands.Location.Builder(other);
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Location instance.
   * @param other The existing instance to copy.
   * @return A new Location RecordBuilder
   */
  public static eu.rawfie.uxv.commands.Location.Builder newBuilder(eu.rawfie.uxv.commands.Location other) {
    return new eu.rawfie.uxv.commands.Location.Builder(other);
  }

  /**
   * RecordBuilder for Location instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Location>
    implements org.apache.avro.data.RecordBuilder<Location> {

    /** Latitude in the WGS 84 reference coordinate system */
    private double latitude;
    /** Longitude in the WGS 84 reference coordinate system */
    private double longitude;
    /** Height above the WGS 84 ellipsoid */
    private float height;
    /** The North offset of the North/East/Down field with respect to Latitude/Longitude/Height */
    private double n;
    /** The East offset of the North/East/Down field with respect to Latitude/Longitude/Height */
    private double e;
    /** The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height */
    private double d;
    /** Depth */
    private java.lang.Float depth;
    /** Altitude */
    private java.lang.Float altitude;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.uxv.commands.Location.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.latitude)) {
        this.latitude = data().deepCopy(fields()[0].schema(), other.latitude);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.longitude)) {
        this.longitude = data().deepCopy(fields()[1].schema(), other.longitude);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.height)) {
        this.height = data().deepCopy(fields()[2].schema(), other.height);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.n)) {
        this.n = data().deepCopy(fields()[3].schema(), other.n);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.e)) {
        this.e = data().deepCopy(fields()[4].schema(), other.e);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.d)) {
        this.d = data().deepCopy(fields()[5].schema(), other.d);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.depth)) {
        this.depth = data().deepCopy(fields()[6].schema(), other.depth);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.altitude)) {
        this.altitude = data().deepCopy(fields()[7].schema(), other.altitude);
        fieldSetFlags()[7] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Location instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.uxv.commands.Location other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.latitude)) {
        this.latitude = data().deepCopy(fields()[0].schema(), other.latitude);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.longitude)) {
        this.longitude = data().deepCopy(fields()[1].schema(), other.longitude);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.height)) {
        this.height = data().deepCopy(fields()[2].schema(), other.height);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.n)) {
        this.n = data().deepCopy(fields()[3].schema(), other.n);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.e)) {
        this.e = data().deepCopy(fields()[4].schema(), other.e);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.d)) {
        this.d = data().deepCopy(fields()[5].schema(), other.d);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.depth)) {
        this.depth = data().deepCopy(fields()[6].schema(), other.depth);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.altitude)) {
        this.altitude = data().deepCopy(fields()[7].schema(), other.altitude);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'latitude' field.
      * Latitude in the WGS 84 reference coordinate system
      * @return The value.
      */
    public java.lang.Double getLatitude() {
      return latitude;
    }

    /**
      * Sets the value of the 'latitude' field.
      * Latitude in the WGS 84 reference coordinate system
      * @param value The value of 'latitude'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setLatitude(double value) {
      validate(fields()[0], value);
      this.latitude = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * Latitude in the WGS 84 reference coordinate system
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'latitude' field.
      * Latitude in the WGS 84 reference coordinate system
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearLatitude() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'longitude' field.
      * Longitude in the WGS 84 reference coordinate system
      * @return The value.
      */
    public java.lang.Double getLongitude() {
      return longitude;
    }

    /**
      * Sets the value of the 'longitude' field.
      * Longitude in the WGS 84 reference coordinate system
      * @param value The value of 'longitude'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setLongitude(double value) {
      validate(fields()[1], value);
      this.longitude = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * Longitude in the WGS 84 reference coordinate system
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'longitude' field.
      * Longitude in the WGS 84 reference coordinate system
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearLongitude() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'height' field.
      * Height above the WGS 84 ellipsoid
      * @return The value.
      */
    public java.lang.Float getHeight() {
      return height;
    }

    /**
      * Sets the value of the 'height' field.
      * Height above the WGS 84 ellipsoid
      * @param value The value of 'height'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setHeight(float value) {
      validate(fields()[2], value);
      this.height = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'height' field has been set.
      * Height above the WGS 84 ellipsoid
      * @return True if the 'height' field has been set, false otherwise.
      */
    public boolean hasHeight() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'height' field.
      * Height above the WGS 84 ellipsoid
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearHeight() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'n' field.
      * The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return The value.
      */
    public java.lang.Double getN() {
      return n;
    }

    /**
      * Sets the value of the 'n' field.
      * The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @param value The value of 'n'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setN(double value) {
      validate(fields()[3], value);
      this.n = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'n' field has been set.
      * The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return True if the 'n' field has been set, false otherwise.
      */
    public boolean hasN() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'n' field.
      * The North offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearN() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'e' field.
      * The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return The value.
      */
    public java.lang.Double getE() {
      return e;
    }

    /**
      * Sets the value of the 'e' field.
      * The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @param value The value of 'e'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setE(double value) {
      validate(fields()[4], value);
      this.e = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'e' field has been set.
      * The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return True if the 'e' field has been set, false otherwise.
      */
    public boolean hasE() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'e' field.
      * The East offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearE() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'd' field.
      * The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return The value.
      */
    public java.lang.Double getD() {
      return d;
    }

    /**
      * Sets the value of the 'd' field.
      * The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @param value The value of 'd'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setD(double value) {
      validate(fields()[5], value);
      this.d = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'd' field has been set.
      * The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return True if the 'd' field has been set, false otherwise.
      */
    public boolean hasD() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'd' field.
      * The Down offset of the North/East/Down field with respect to Latitude/Longitude/Height
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearD() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'depth' field.
      * Depth
      * @return The value.
      */
    public java.lang.Float getDepth() {
      return depth;
    }

    /**
      * Sets the value of the 'depth' field.
      * Depth
      * @param value The value of 'depth'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setDepth(java.lang.Float value) {
      validate(fields()[6], value);
      this.depth = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'depth' field has been set.
      * Depth
      * @return True if the 'depth' field has been set, false otherwise.
      */
    public boolean hasDepth() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'depth' field.
      * Depth
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearDepth() {
      depth = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'altitude' field.
      * Altitude
      * @return The value.
      */
    public java.lang.Float getAltitude() {
      return altitude;
    }

    /**
      * Sets the value of the 'altitude' field.
      * Altitude
      * @param value The value of 'altitude'.
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder setAltitude(java.lang.Float value) {
      validate(fields()[7], value);
      this.altitude = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'altitude' field has been set.
      * Altitude
      * @return True if the 'altitude' field has been set, false otherwise.
      */
    public boolean hasAltitude() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'altitude' field.
      * Altitude
      * @return This builder.
      */
    public eu.rawfie.uxv.commands.Location.Builder clearAltitude() {
      altitude = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public Location build() {
      try {
        Location record = new Location();
        record.latitude = fieldSetFlags()[0] ? this.latitude : (java.lang.Double) defaultValue(fields()[0]);
        record.longitude = fieldSetFlags()[1] ? this.longitude : (java.lang.Double) defaultValue(fields()[1]);
        record.height = fieldSetFlags()[2] ? this.height : (java.lang.Float) defaultValue(fields()[2]);
        record.n = fieldSetFlags()[3] ? this.n : (java.lang.Double) defaultValue(fields()[3]);
        record.e = fieldSetFlags()[4] ? this.e : (java.lang.Double) defaultValue(fields()[4]);
        record.d = fieldSetFlags()[5] ? this.d : (java.lang.Double) defaultValue(fields()[5]);
        record.depth = fieldSetFlags()[6] ? this.depth : (java.lang.Float) defaultValue(fields()[6]);
        record.altitude = fieldSetFlags()[7] ? this.altitude : (java.lang.Float) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
