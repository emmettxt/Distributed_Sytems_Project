// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alerter.proto

package ds.alerter;

public interface alertDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alerter.alertDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.alerter.alertMessage alertMessage = 1;</code>
   */
  boolean hasAlertMessage();
  /**
   * <code>.alerter.alertMessage alertMessage = 1;</code>
   */
  ds.alerter.alertMessage getAlertMessage();
  /**
   * <code>.alerter.alertMessage alertMessage = 1;</code>
   */
  ds.alerter.alertMessageOrBuilder getAlertMessageOrBuilder();

  /**
   * <code>string alertId = 2;</code>
   */
  java.lang.String getAlertId();
  /**
   * <code>string alertId = 2;</code>
   */
  com.google.protobuf.ByteString
      getAlertIdBytes();
}