package de.itemis.maven.aether;

import com.google.common.base.Objects;

public class ArtifactCoordinates {
  private String groupId;
  private String artifactId;
  private String version;
  private String type;
  private String classifier;

  public ArtifactCoordinates(String groupId, String artifactId, String version, String type) {
    this(groupId, artifactId, version, type, null);
  }

  public ArtifactCoordinates(String groupId, String artifactId, String version, String type, String classifier) {
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
    this.type = type;
    this.classifier = classifier;
  }

  public String getGroupId() {
    return this.groupId;
  }

  public String getArtifactId() {
    return this.artifactId;
  }

  public String getVersion() {
    return this.version;
  }

  public String getType() {
    return this.type;
  }

  public String getClassifier() {
    return this.classifier;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.groupId).append(':');
    sb.append(this.artifactId).append(':');
    sb.append(this.type).append(':');
    if (this.classifier != null) {
      sb.append(this.classifier).append(':');
    }
    sb.append(this.version);
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (!(other instanceof ArtifactCoordinates)) {
      return false;
    }
    return Objects.equal(toString(), other.toString());
  }

  @Override
  public int hashCode() {
    if (this.classifier != null) {
      return Objects.hashCode(this.groupId, this.artifactId, this.type, this.classifier, this.version);
    }
    return Objects.hashCode(this.groupId, this.artifactId, this.type, this.version);
  }
}