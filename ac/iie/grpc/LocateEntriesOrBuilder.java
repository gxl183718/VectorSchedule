// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package cn.ac.iie.grpc;

public interface LocateEntriesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:LocateEntries)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  java.util.List<cn.ac.iie.grpc.LocateEntry> 
      getLocatesList();
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  cn.ac.iie.grpc.LocateEntry getLocates(int index);
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  int getLocatesCount();
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  java.util.List<? extends cn.ac.iie.grpc.LocateEntryOrBuilder> 
      getLocatesOrBuilderList();
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  cn.ac.iie.grpc.LocateEntryOrBuilder getLocatesOrBuilder(
      int index);

  /**
   * <pre>
   *0：没有特征 -1：异常 1：正常
   * </pre>
   *
   * <code>string code = 2;</code>
   */
  java.lang.String getCode();
  /**
   * <pre>
   *0：没有特征 -1：异常 1：正常
   * </pre>
   *
   * <code>string code = 2;</code>
   */
  com.google.protobuf.ByteString
      getCodeBytes();

  /**
   * <code>sint32 w = 3;</code>
   */
  int getW();

  /**
   * <code>sint32 h = 4;</code>
   */
  int getH();
}