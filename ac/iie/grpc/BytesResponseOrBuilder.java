// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package cn.ac.iie.grpc;

public interface BytesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:BytesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */
  int getVectorBytesCount();
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */
  boolean containsVectorBytes(
      java.lang.String key);
  /**
   * Use {@link #getVectorBytesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.protobuf.ByteString>
  getVectorBytes();
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */
  java.util.Map<java.lang.String, com.google.protobuf.ByteString>
  getVectorBytesMap();
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  com.google.protobuf.ByteString getVectorBytesOrDefault(
      java.lang.String key,
      com.google.protobuf.ByteString defaultValue);
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  com.google.protobuf.ByteString getVectorBytesOrThrow(
      java.lang.String key);

  /**
   * <code>string code = 2;</code>
   */
  java.lang.String getCode();
  /**
   * <code>string code = 2;</code>
   */
  com.google.protobuf.ByteString
      getCodeBytes();
}