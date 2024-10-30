package com.desktop.core.navigation.models;

public class ViewsModel {
  private Integer viewId;
  private String viewName;
  private String description;

  public Integer getViewId() {
    return viewId;
  }

  public ViewsModel setViewId(Integer viewId) {
    this.viewId = viewId;
    return this;
  }

  public String getViewName() {
    return viewName;
  }

  public ViewsModel setViewName(String viewName) {
    this.viewName = viewName;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ViewsModel setDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * Builds and returns the current instance of ViewsModel.
   *
   * @return the current instance of ViewsModel
   */
  public ViewsModel build() {
    return this;
  }
}
