// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alerter.proto

package ds.alerter;

public interface AlertDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alerter.AlertDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.alerter.AlertMessage alertMessage = 1;</code>
   */
  boolean hasAlertMessage();
  /**
   * <code>.alerter.AlertMessage alertMessage = 1;</code>
   */
  ds.alerter.AlertMessage getAlertMessage();
  /**
   * <code>.alerter.AlertMessage alertMessage = 1;</code>
   */
  ds.alerter.AlertMessageOrBuilder getAlertMessageOrBuilder();

  /**
   * <code>int32 alertId = 2;</code>
   */
  int getAlertId();
}
