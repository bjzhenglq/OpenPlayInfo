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

public class DefinitionOPResult implements org.apache.thrift.TBase<DefinitionOPResult, DefinitionOPResult._Fields>, java.io.Serializable, Cloneable, Comparable<DefinitionOPResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DefinitionOPResult");

  private static final org.apache.thrift.protocol.TField RET_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("retCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField RET_MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("retMsg", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DefinitionOPResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DefinitionOPResultTupleSchemeFactory());
  }

  public int retCode; // required
  public String retMsg; // required
  public List<Definition> result; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RET_CODE((short)1, "retCode"),
    RET_MSG((short)2, "retMsg"),
    RESULT((short)3, "result");

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
        case 1: // RET_CODE
          return RET_CODE;
        case 2: // RET_MSG
          return RET_MSG;
        case 3: // RESULT
          return RESULT;
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
  private static final int __RETCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RET_CODE, new org.apache.thrift.meta_data.FieldMetaData("retCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.RET_MSG, new org.apache.thrift.meta_data.FieldMetaData("retMsg", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Definition.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DefinitionOPResult.class, metaDataMap);
  }

  public DefinitionOPResult() {
  }

  public DefinitionOPResult(
    int retCode,
    String retMsg,
    List<Definition> result)
  {
    this();
    this.retCode = retCode;
    setRetCodeIsSet(true);
    this.retMsg = retMsg;
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DefinitionOPResult(DefinitionOPResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.retCode = other.retCode;
    if (other.isSetRetMsg()) {
      this.retMsg = other.retMsg;
    }
    if (other.isSetResult()) {
      List<Definition> __this__result = new ArrayList<Definition>(other.result.size());
      for (Definition other_element : other.result) {
        __this__result.add(new Definition(other_element));
      }
      this.result = __this__result;
    }
  }

  public DefinitionOPResult deepCopy() {
    return new DefinitionOPResult(this);
  }

  @Override
  public void clear() {
    setRetCodeIsSet(false);
    this.retCode = 0;
    this.retMsg = null;
    this.result = null;
  }

  public int getRetCode() {
    return this.retCode;
  }

  public DefinitionOPResult setRetCode(int retCode) {
    this.retCode = retCode;
    setRetCodeIsSet(true);
    return this;
  }

  public void unsetRetCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RETCODE_ISSET_ID);
  }

  /** Returns true if field retCode is set (has been assigned a value) and false otherwise */
  public boolean isSetRetCode() {
    return EncodingUtils.testBit(__isset_bitfield, __RETCODE_ISSET_ID);
  }

  public void setRetCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RETCODE_ISSET_ID, value);
  }

  public String getRetMsg() {
    return this.retMsg;
  }

  public DefinitionOPResult setRetMsg(String retMsg) {
    this.retMsg = retMsg;
    return this;
  }

  public void unsetRetMsg() {
    this.retMsg = null;
  }

  /** Returns true if field retMsg is set (has been assigned a value) and false otherwise */
  public boolean isSetRetMsg() {
    return this.retMsg != null;
  }

  public void setRetMsgIsSet(boolean value) {
    if (!value) {
      this.retMsg = null;
    }
  }

  public int getResultSize() {
    return (this.result == null) ? 0 : this.result.size();
  }

  public java.util.Iterator<Definition> getResultIterator() {
    return (this.result == null) ? null : this.result.iterator();
  }

  public void addToResult(Definition elem) {
    if (this.result == null) {
      this.result = new ArrayList<Definition>();
    }
    this.result.add(elem);
  }

  public List<Definition> getResult() {
    return this.result;
  }

  public DefinitionOPResult setResult(List<Definition> result) {
    this.result = result;
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RET_CODE:
      if (value == null) {
        unsetRetCode();
      } else {
        setRetCode((Integer)value);
      }
      break;

    case RET_MSG:
      if (value == null) {
        unsetRetMsg();
      } else {
        setRetMsg((String)value);
      }
      break;

    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        setResult((List<Definition>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RET_CODE:
      return Integer.valueOf(getRetCode());

    case RET_MSG:
      return getRetMsg();

    case RESULT:
      return getResult();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RET_CODE:
      return isSetRetCode();
    case RET_MSG:
      return isSetRetMsg();
    case RESULT:
      return isSetResult();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DefinitionOPResult)
      return this.equals((DefinitionOPResult)that);
    return false;
  }

  public boolean equals(DefinitionOPResult that) {
    if (that == null)
      return false;

    boolean this_present_retCode = true;
    boolean that_present_retCode = true;
    if (this_present_retCode || that_present_retCode) {
      if (!(this_present_retCode && that_present_retCode))
        return false;
      if (this.retCode != that.retCode)
        return false;
    }

    boolean this_present_retMsg = true && this.isSetRetMsg();
    boolean that_present_retMsg = true && that.isSetRetMsg();
    if (this_present_retMsg || that_present_retMsg) {
      if (!(this_present_retMsg && that_present_retMsg))
        return false;
      if (!this.retMsg.equals(that.retMsg))
        return false;
    }

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!this.result.equals(that.result))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(DefinitionOPResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRetCode()).compareTo(other.isSetRetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retCode, other.retCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRetMsg()).compareTo(other.isSetRetMsg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRetMsg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retMsg, other.retMsg);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
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
    StringBuilder sb = new StringBuilder("DefinitionOPResult(");
    boolean first = true;

    sb.append("retCode:");
    sb.append(this.retCode);
    first = false;
    if (!first) sb.append(", ");
    sb.append("retMsg:");
    if (this.retMsg == null) {
      sb.append("null");
    } else {
      sb.append(this.retMsg);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
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

  private static class DefinitionOPResultStandardSchemeFactory implements SchemeFactory {
    public DefinitionOPResultStandardScheme getScheme() {
      return new DefinitionOPResultStandardScheme();
    }
  }

  private static class DefinitionOPResultStandardScheme extends StandardScheme<DefinitionOPResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DefinitionOPResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RET_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.retCode = iprot.readI32();
              struct.setRetCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RET_MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.retMsg = iprot.readString();
              struct.setRetMsgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.result = new ArrayList<Definition>(_list16.size);
                for (int _i17 = 0; _i17 < _list16.size; ++_i17)
                {
                  Definition _elem18;
                  _elem18 = new Definition();
                  _elem18.read(iprot);
                  struct.result.add(_elem18);
                }
                iprot.readListEnd();
              }
              struct.setResultIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DefinitionOPResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(RET_CODE_FIELD_DESC);
      oprot.writeI32(struct.retCode);
      oprot.writeFieldEnd();
      if (struct.retMsg != null) {
        oprot.writeFieldBegin(RET_MSG_FIELD_DESC);
        oprot.writeString(struct.retMsg);
        oprot.writeFieldEnd();
      }
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.result.size()));
          for (Definition _iter19 : struct.result)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DefinitionOPResultTupleSchemeFactory implements SchemeFactory {
    public DefinitionOPResultTupleScheme getScheme() {
      return new DefinitionOPResultTupleScheme();
    }
  }

  private static class DefinitionOPResultTupleScheme extends TupleScheme<DefinitionOPResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DefinitionOPResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRetCode()) {
        optionals.set(0);
      }
      if (struct.isSetRetMsg()) {
        optionals.set(1);
      }
      if (struct.isSetResult()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetRetCode()) {
        oprot.writeI32(struct.retCode);
      }
      if (struct.isSetRetMsg()) {
        oprot.writeString(struct.retMsg);
      }
      if (struct.isSetResult()) {
        {
          oprot.writeI32(struct.result.size());
          for (Definition _iter20 : struct.result)
          {
            _iter20.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DefinitionOPResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.retCode = iprot.readI32();
        struct.setRetCodeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.retMsg = iprot.readString();
        struct.setRetMsgIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.result = new ArrayList<Definition>(_list21.size);
          for (int _i22 = 0; _i22 < _list21.size; ++_i22)
          {
            Definition _elem23;
            _elem23 = new Definition();
            _elem23.read(iprot);
            struct.result.add(_elem23);
          }
        }
        struct.setResultIsSet(true);
      }
    }
  }

}
