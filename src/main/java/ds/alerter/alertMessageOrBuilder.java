// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alerter.proto

package ds.alerter;

public interface alertMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alerter.alertMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.alerter.alertMessage.PriorityLevel priorityLevel = 1;</code>
   */
  int getPriorityLevelValue();
  /**
   * <code>.alerter.alertMessage.PriorityLevel priorityLevel = 1;</code>
   */
  ds.alerter.alertMessage.PriorityLevel getPriorityLevel();

  /**
   * <code>string description = 2;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 2;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();
}