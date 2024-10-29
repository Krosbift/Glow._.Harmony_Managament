package com.desktop.views.login.components.loginForm;

import java.util.Map;
import java.util.HashMap;
import com.desktop.views.login.LoginPanelController;
import com.desktop.views.login.components.loginForm.components.SubFormPanelComponent;
import com.desktop.views.login.components.loginForm.components.FormLogoLabelComponent;
import com.desktop.views.login.components.loginForm.components.FormEmailFieldComponent;
import com.desktop.views.login.components.loginForm.components.FormInputButtonComponent;
import com.desktop.views.login.components.loginForm.components.FormPasswordFieldComponent;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class LoginFormPanelController implements ControllerInterface {
  public LoginPanelController parentController;
  public LoginFormPanelComponent loginFormPanelComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public LoginFormPanelController(LoginPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildComponents();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    loginFormPanelComponent = new LoginFormPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {

  }

  public void _initChildComponents() {
    childComponents = new HashMap<>();
    childComponents.put("SubFormPanelComponent", new SubFormPanelComponent(this));
    childComponents.put("FormLogoLabelComponent", new FormLogoLabelComponent(this));
    childComponents.put("FormEmailFieldComponent", new FormEmailFieldComponent(this));
    childComponents.put("FormPasswordFieldComponent", new FormPasswordFieldComponent(this));
    childComponents.put("FormInputButtonComponent", new FormInputButtonComponent(this));
  }
}
