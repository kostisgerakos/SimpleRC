/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package eu.including.uxv.commands;  
@SuppressWarnings("all")
/** Status of the task */
@org.apache.avro.specific.AvroGenerated
public class TaskResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1760925957402392078L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskResult\",\"namespace\":\"eu.including.uxv.commands\",\"doc\":\"Status of the task\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"namespace\":\"eu.including.uxv\",\"fields\":[{\"name\":\"sourceSystem\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the originating system\"},{\"name\":\"sourceModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the module within a given system that originated the message\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"Time elapsed since the Unix epoch\",\"unit\":\"ms\"}]}},{\"name\":\"step\",\"type\":\"int\"},{\"name\":\"result\",\"type\":{\"type\":\"enum\",\"name\":\"TaskResultType\",\"symbols\":[\"COMPLETED\",\"ONGOING\",\"BLOCKED\",\"FAILED\"]}},{\"name\":\"latitude\",\"type\":\"double\",\"doc\":\"Latitude in the WGS 84 reference coordinate system\",\"unit\":\"rad\",\"min\":-1.570796326794897,\"max\":1.570796326794897},{\"name\":\"longitude\",\"type\":\"double\",\"doc\":\"Longitude in the WGS 84 reference coordinate system\",\"unit\":\"rad\",\"min\":-3.141592653589793,\"max\":3.141592653589793}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public eu.including.uxv.Header header;
   public int step;
   public eu.including.uxv.commands.TaskResultType result;
  /** Latitude in the WGS 84 reference coordinate system */
   public double latitude;
  /** Longitude in the WGS 84 reference coordinate system */
   public double longitude;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public TaskResult() {}

  /**
   * All-args constructor.
   * @param latitude Latitude in the WGS 84 reference coordinate system
   * @param longitude Longitude in the WGS 84 reference coordinate system
   */
  public TaskResult(eu.including.uxv.Header header, java.lang.Integer step, eu.including.uxv.commands.TaskResultType result, java.lang.Double latitude, java.lang.Double longitude) {
    this.header = header;
    this.step = step;
    this.result = result;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return step;
    case 2: return result;
    case 3: return latitude;
    case 4: return longitude;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (eu.including.uxv.Header)value$; break;
    case 1: step = (java.lang.Integer)value$; break;
    case 2: result = (eu.including.uxv.commands.TaskResultType)value$; break;
    case 3: latitude = (java.lang.Double)value$; break;
    case 4: longitude = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'header' field.
   */
  public eu.including.uxv.Header getHeader() {
    return header;
  }

  /**
   * Sets the value of the 'header' field.
   * @param value the value to set.
   */
  public void setHeader(eu.including.uxv.Header value) {
    this.header = value;
  }

  /**
   * Gets the value of the 'step' field.
   */
  public java.lang.Integer getStep() {
    return step;
  }

  /**
   * Sets the value of the 'step' field.
   * @param value the value to set.
   */
  public void setStep(java.lang.Integer value) {
    this.step = value;
  }

  /**
   * Gets the value of the 'result' field.
   */
  public eu.including.uxv.commands.TaskResultType getResult() {
    return result;
  }

  /**
   * Sets the value of the 'result' field.
   * @param value the value to set.
   */
  public void setResult(eu.including.uxv.commands.TaskResultType value) {
    this.result = value;
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
   * Creates a new TaskResult RecordBuilder.
   * @return A new TaskResult RecordBuilder
   */
  public static eu.including.uxv.commands.TaskResult.Builder newBuilder() {
    return new eu.including.uxv.commands.TaskResult.Builder();
  }
  
  /**
   * Creates a new TaskResult RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskResult RecordBuilder
   */
  public static eu.including.uxv.commands.TaskResult.Builder newBuilder(eu.including.uxv.commands.TaskResult.Builder other) {
    return new eu.including.uxv.commands.TaskResult.Builder(other);
  }
  
  /**
   * Creates a new TaskResult RecordBuilder by copying an existing TaskResult instance.
   * @param other The existing instance to copy.
   * @return A new TaskResult RecordBuilder
   */
  public static eu.including.uxv.commands.TaskResult.Builder newBuilder(eu.including.uxv.commands.TaskResult other) {
    return new eu.including.uxv.commands.TaskResult.Builder(other);
  }
  
  /**
   * RecordBuilder for TaskResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskResult>
    implements org.apache.avro.data.RecordBuilder<TaskResult> {

    private eu.including.uxv.Header header;
    private eu.including.uxv.Header.Builder headerBuilder;
    private int step;
    private eu.including.uxv.commands.TaskResultType result;
    /** Latitude in the WGS 84 reference coordinate system */
    private double latitude;
    /** Longitude in the WGS 84 reference coordinate system */
    private double longitude;

    /** Creates a new Builder */
    private Builder() {
      super(eu.including.uxv.commands.TaskResult.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.including.uxv.commands.TaskResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = eu.including.uxv.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.step)) {
        this.step = data().deepCopy(fields()[1].schema(), other.step);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.result)) {
        this.result = data().deepCopy(fields()[2].schema(), other.result);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.latitude)) {
        this.latitude = data().deepCopy(fields()[3].schema(), other.latitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.longitude)) {
        this.longitude = data().deepCopy(fields()[4].schema(), other.longitude);
        fieldSetFlags()[4] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing TaskResult instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.including.uxv.commands.TaskResult other) {
            super(eu.including.uxv.commands.TaskResult.SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.step)) {
        this.step = data().deepCopy(fields()[1].schema(), other.step);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.result)) {
        this.result = data().deepCopy(fields()[2].schema(), other.result);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.latitude)) {
        this.latitude = data().deepCopy(fields()[3].schema(), other.latitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.longitude)) {
        this.longitude = data().deepCopy(fields()[4].schema(), other.longitude);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'header' field.
      * @return The value.
      */
    public eu.including.uxv.Header getHeader() {
      return header;
    }

    /**
      * Sets the value of the 'header' field.
      * @param value The value of 'header'.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder setHeader(eu.including.uxv.Header value) {
      validate(fields()[0], value);
      this.headerBuilder = null;
      this.header = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'header' field has been set.
      * @return True if the 'header' field has been set, false otherwise.
      */
    public boolean hasHeader() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'header' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public eu.including.uxv.Header.Builder getHeaderBuilder() {
      if (headerBuilder == null) {
        if (hasHeader()) {
          setHeaderBuilder(eu.including.uxv.Header.newBuilder(header));
        } else {
          setHeaderBuilder(eu.including.uxv.Header.newBuilder());
        }
      }
      return headerBuilder;
    }

    /**
     * Sets the Builder instance for the 'header' field
     * @return This builder.
     */
    public eu.including.uxv.commands.TaskResult.Builder setHeaderBuilder(eu.including.uxv.Header.Builder value) {
      clearHeader();
      headerBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'header' field has an active Builder instance
     * @return True if the 'header' field has an active Builder instance
     */
    public boolean hasHeaderBuilder() {
      return headerBuilder != null;
    }

    /**
      * Clears the value of the 'header' field.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'step' field.
      * @return The value.
      */
    public java.lang.Integer getStep() {
      return step;
    }

    /**
      * Sets the value of the 'step' field.
      * @param value The value of 'step'.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder setStep(int value) {
      validate(fields()[1], value);
      this.step = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'step' field has been set.
      * @return True if the 'step' field has been set, false otherwise.
      */
    public boolean hasStep() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'step' field.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder clearStep() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'result' field.
      * @return The value.
      */
    public eu.including.uxv.commands.TaskResultType getResult() {
      return result;
    }

    /**
      * Sets the value of the 'result' field.
      * @param value The value of 'result'.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder setResult(eu.including.uxv.commands.TaskResultType value) {
      validate(fields()[2], value);
      this.result = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'result' field has been set.
      * @return True if the 'result' field has been set, false otherwise.
      */
    public boolean hasResult() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'result' field.
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder clearResult() {
      result = null;
      fieldSetFlags()[2] = false;
      return this;
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
    public eu.including.uxv.commands.TaskResult.Builder setLatitude(double value) {
      validate(fields()[3], value);
      this.latitude = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * Latitude in the WGS 84 reference coordinate system
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'latitude' field.
      * Latitude in the WGS 84 reference coordinate system
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder clearLatitude() {
      fieldSetFlags()[3] = false;
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
    public eu.including.uxv.commands.TaskResult.Builder setLongitude(double value) {
      validate(fields()[4], value);
      this.longitude = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * Longitude in the WGS 84 reference coordinate system
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'longitude' field.
      * Longitude in the WGS 84 reference coordinate system
      * @return This builder.
      */
    public eu.including.uxv.commands.TaskResult.Builder clearLongitude() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public TaskResult build() {
      try {
        TaskResult record = new TaskResult();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (eu.including.uxv.Header) defaultValue(fields()[0]);
        }
        record.step = fieldSetFlags()[1] ? this.step : (java.lang.Integer) defaultValue(fields()[1]);
        record.result = fieldSetFlags()[2] ? this.result : (eu.including.uxv.commands.TaskResultType) defaultValue(fields()[2]);
        record.latitude = fieldSetFlags()[3] ? this.latitude : (java.lang.Double) defaultValue(fields()[3]);
        record.longitude = fieldSetFlags()[4] ? this.longitude : (java.lang.Double) defaultValue(fields()[4]);
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
    WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);  

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in));
  }

}