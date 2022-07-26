// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: animalLocator.proto

package ds.animalLocator;

public final class AnimalLocatorImpl {
  private AnimalLocatorImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_Point_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_Point_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_LocationMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_LocationMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_LocationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_LocationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_LocationDatabase_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_LocationDatabase_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_EmptyMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_EmptyMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_animalLocator_HeardMemeberNMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_animalLocator_HeardMemeberNMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023animalLocator.proto\022\ranimalLocator\032\037go" +
      "ogle/protobuf/timestamp.proto\",\n\005Point\022\020" +
      "\n\010latitude\030\001 \001(\005\022\021\n\tlongitude\030\002 \001(\005\"r\n\017L" +
      "ocationMessage\022#\n\005point\030\001 \001(\0132\024.animalLo" +
      "cator.Point\022\020\n\010AnimalId\030\002 \001(\t\022(\n\004Time\030\003 " +
      "\001(\0132\032.google.protobuf.Timestamp\"_\n\020Locat" +
      "ionResponse\022\025\n\rcountRecieved\030\001 \001(\005\0224\n\014La" +
      "stRecieved\030\002 \001(\0132\036.animalLocator.Locatio" +
      "nMessage\"K\n\020LocationDatabase\0227\n\017location" +
      "Message\030\001 \003(\0132\036.animalLocator.LocationMe" +
      "ssage\"\016\n\014EmptyMessage\"3\n\024HeardMemeberNMe" +
      "ssage\022\020\n\010animalId\030\001 \001(\t\022\t\n\001N\030\002 \001(\0052\233\002\n\ra" +
      "nimalLocator\022V\n\017LocationUpdater\022\036.animal" +
      "Locator.LocationMessage\032\037.animalLocator." +
      "LocationResponse\"\000(\001\022W\n\024CurrentHeardLoca" +
      "tion\022\033.animalLocator.EmptyMessage\032\036.anim" +
      "alLocator.LocationMessage\"\0000\001\022Y\n\016LastNLo" +
      "cations\022#.animalLocator.HeardMemeberNMes" +
      "sage\032\036.animalLocator.LocationMessage\"\0000\001" +
      "B\'\n\020ds.animalLocatorB\021AnimalLocatorImplP" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_animalLocator_Point_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_animalLocator_Point_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_Point_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", });
    internal_static_animalLocator_LocationMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_animalLocator_LocationMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_LocationMessage_descriptor,
        new java.lang.String[] { "Point", "AnimalId", "Time", });
    internal_static_animalLocator_LocationResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_animalLocator_LocationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_LocationResponse_descriptor,
        new java.lang.String[] { "CountRecieved", "LastRecieved", });
    internal_static_animalLocator_LocationDatabase_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_animalLocator_LocationDatabase_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_LocationDatabase_descriptor,
        new java.lang.String[] { "LocationMessage", });
    internal_static_animalLocator_EmptyMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_animalLocator_EmptyMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_EmptyMessage_descriptor,
        new java.lang.String[] { });
    internal_static_animalLocator_HeardMemeberNMessage_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_animalLocator_HeardMemeberNMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_animalLocator_HeardMemeberNMessage_descriptor,
        new java.lang.String[] { "AnimalId", "N", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
