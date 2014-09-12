/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.fun.playinfo.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefinitionVO implements org.apache.thrift.TBase<DefinitionVO, DefinitionVO._Fields>, java.io.Serializable, Cloneable, Comparable<DefinitionVO> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DefinitionVO");

  private static final org.apache.thrift.protocol.TField DEFINITION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("definitionID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DEF_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("defCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DEF_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("defName", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DefinitionVOStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DefinitionVOTupleSchemeFactory());
  }

  public int definitionID; // required
  public String defCode; // required
  public String defName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEFINITION_ID((short)1, "definitionID"),
    DEF_CODE((short)2, "defCode"),
    DEF_NAME((short)3, "defName");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEFINITION_ID
          return DEFINITION_ID;
        case 2: // DEF_CODE
          return DEF_CODE;
        case 3: // DEF_NAME
          return DEF_NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __DEFINITIONID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEFINITION_ID, new org.apache.thrift.meta_data.FieldMetaData("definitionID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEF_CODE, new org.apache.thrift.meta_data.FieldMetaData("defCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEF_NAME, new org.apache.thrift.meta_data.FieldMetaData("defName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DefinitionVO.class, metaDataMap);
  }

  public DefinitionVO() {
  }

  public DefinitionVO(
    int definitionID,
    String defCode,
    String defName)
  {
    this();
    this.definitionID = definitionID;
    setDefinitionIDIsSet(true);
    this.defCode = defCode;
    this.defName = defName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DefinitionVO(DefinitionVO other) {
    __isset_bitfield = other.__isset_bitfield;
    this.definitionID = other.definitionID;
    if (other.isSetDefCode()) {
      this.defCode = other.defCode;
    }
    if (other.isSetDefName()) {
      this.defName = other.defName;
    }
  }

  public DefinitionVO deepCopy() {
    return new DefinitionVO(this);
  }

  @Override
  public void clear() {
    setDefinitionIDIsSet(false);
    this.definitionID = 0;
    this.defCode = null;
    this.defName = null;
  }

  public int getDefinitionID() {
    return this.definitionID;
  }

  public DefinitionVO setDefinitionID(int definitionID) {
    this.definitionID = definitionID;
    setDefinitionIDIsSet(true);
    return this;
  }

  public void unsetDefinitionID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DEFINITIONID_ISSET_ID);
  }

  /** Returns true if field definitionID is set (has been assigned a value) and false otherwise */
  public boolean isSetDefinitionID() {
    return EncodingUtils.testBit(__isset_bitfield, __DEFINITIONID_ISSET_ID);
  }

  public void setDefinitionIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DEFINITIONID_ISSET_ID, value);
  }

  public String getDefCode() {
    return this.defCode;
  }

  public DefinitionVO setDefCode(String defCode) {
    this.defCode = defCode;
    return this;
  }

  public void unsetDefCode() {
    this.defCode = null;
  }

  /** Returns true if field defCode is set (has been assigned a value) and false otherwise */
  public boolean isSetDefCode() {
    return this.defCode != null;
  }

  public void setDefCodeIsSet(boolean value) {
    if (!value) {
      this.defCode = null;
    }
  }

  public String getDefName() {
    return this.defName;
  }

  public DefinitionVO setDefName(String defName) {
    this.defName = defName;
    return this;
  }

  public void unsetDefName() {
    this.defName = null;
  }

  /** Returns true if field defName is set (has been assigned a value) and false otherwise */
  public boolean isSetDefName() {
    return this.defName != null;
  }

  public void setDefNameIsSet(boolean value) {
    if (!value) {
      this.defName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DEFINITION_ID:
      if (value == null) {
        unsetDefinitionID();
      } else {
        setDefinitionID((Integer)value);
      }
      break;

    case DEF_CODE:
      if (value == null) {
        unsetDefCode();
      } else {
        setDefCode((String)value);
      }
      break;

    case DEF_NAME:
      if (value == null) {
        unsetDefName();
      } else {
        setDefName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DEFINITION_ID:
      return Integer.valueOf(getDefinitionID());

    case DEF_CODE:
      return getDefCode();

    case DEF_NAME:
      return getDefName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DEFINITION_ID:
      return isSetDefinitionID();
    case DEF_CODE:
      return isSetDefCode();
    case DEF_NAME:
      return isSetDefName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DefinitionVO)
      return this.equals((DefinitionVO)that);
    return false;
  }

  public boolean equals(DefinitionVO that) {
    if (that == null)
      return false;

    boolean this_present_definitionID = true;
    boolean that_present_definitionID = true;
    if (this_present_definitionID || that_present_definitionID) {
      if (!(this_present_definitionID && that_present_definitionID))
        return false;
      if (this.definitionID != that.definitionID)
        return false;
    }

    boolean this_present_defCode = true && this.isSetDefCode();
    boolean that_present_defCode = true && that.isSetDefCode();
    if (this_present_defCode || that_present_defCode) {
      if (!(this_present_defCode && that_present_defCode))
        return false;
      if (!this.defCode.equals(that.defCode))
        return false;
    }

    boolean this_present_defName = true && this.isSetDefName();
    boolean that_present_defName = true && that.isSetDefName();
    if (this_present_defName || that_present_defName) {
      if (!(this_present_defName && that_present_defName))
        return false;
      if (!this.defName.equals(that.defName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(DefinitionVO other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDefinitionID()).compareTo(other.isSetDefinitionID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefinitionID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.definitionID, other.definitionID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDefCode()).compareTo(other.isSetDefCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defCode, other.defCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDefName()).compareTo(other.isSetDefName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defName, other.defName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DefinitionVO(");
    boolean first = true;

    sb.append("definitionID:");
    sb.append(this.definitionID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("defCode:");
    if (this.defCode == null) {
      sb.append("null");
    } else {
      sb.append(this.defCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("defName:");
    if (this.defName == null) {
      sb.append("null");
    } else {
      sb.append(this.defName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DefinitionVOStandardSchemeFactory implements SchemeFactory {
    public DefinitionVOStandardScheme getScheme() {
      return new DefinitionVOStandardScheme();
    }
  }

  private static class DefinitionVOStandardScheme extends StandardScheme<DefinitionVO> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DefinitionVO struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEFINITION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.definitionID = iprot.readI32();
              struct.setDefinitionIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DEF_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.defCode = iprot.readString();
              struct.setDefCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEF_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.defName = iprot.readString();
              struct.setDefNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DefinitionVO struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(DEFINITION_ID_FIELD_DESC);
      oprot.writeI32(struct.definitionID);
      oprot.writeFieldEnd();
      if (struct.defCode != null) {
        oprot.writeFieldBegin(DEF_CODE_FIELD_DESC);
        oprot.writeString(struct.defCode);
        oprot.writeFieldEnd();
      }
      if (struct.defName != null) {
        oprot.writeFieldBegin(DEF_NAME_FIELD_DESC);
        oprot.writeString(struct.defName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DefinitionVOTupleSchemeFactory implements SchemeFactory {
    public DefinitionVOTupleScheme getScheme() {
      return new DefinitionVOTupleScheme();
    }
  }

  private static class DefinitionVOTupleScheme extends TupleScheme<DefinitionVO> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DefinitionVO struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDefinitionID()) {
        optionals.set(0);
      }
      if (struct.isSetDefCode()) {
        optionals.set(1);
      }
      if (struct.isSetDefName()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDefinitionID()) {
        oprot.writeI32(struct.definitionID);
      }
      if (struct.isSetDefCode()) {
        oprot.writeString(struct.defCode);
      }
      if (struct.isSetDefName()) {
        oprot.writeString(struct.defName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DefinitionVO struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.definitionID = iprot.readI32();
        struct.setDefinitionIDIsSet(true);
      }
      if (incoming.get(1)) {
        struct.defCode = iprot.readString();
        struct.setDefCodeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.defName = iprot.readString();
        struct.setDefNameIsSet(true);
      }
    }
  }

}

