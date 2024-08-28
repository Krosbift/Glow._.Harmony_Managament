package imc.api.routes.users.interfaces;

public interface UsersInterface {

  /**
   * Returns the user's id.
   * 
   * @return the user's id.
   */
  public Long getId();

  /**
   * Sets the user's id.
   * 
   * @param idUser the user's id.
   */
  public void setId(Long idUser);

  /**
   * Returns the user's names.
   * 
   * @return the user's names.
   */
  public String getNames();

  /**
   * Sets the user's names.
   * 
   * @param names the user's names.
   */
  public void setNames(String names);

  /**
   * Returns the user's surnames.
   * 
   * @return the user's surnames.
   */
  public String getSurnames();

  /**
   * Sets the user's surnames.
   * 
   * @param surnames the user's surnames.
   */
  public void setSurnames(String surnames);

  /**
   * Returns the user's email.
   * 
   * @return the user's email.
   */
  public String getEmail();

  /**
   * Sets the user's email.
   * 
   * @param email the user's email.
   */
  public void setEmail(String email);

  /**
   * Returns the user's password.
   * 
   * @return the user's password.
   */
  public String getPassword();

  /**
   * Sets the user's password.
   * 
   * @param password the user's password.
   */
  public void setPassword(String password);

  /**
   * Returns the user's role id.
   * 
   * @return the user's role id.
   */
  public String getIdUserRol();

  /**
   * Sets the user's role id.
   * 
   * @param idUserRol the user's role id.
   */
  public void setIdUserRol(String idUserRol);

  /**
   * Returns the user's active status.
   * 
   * @return the user's active status.
   */
  public boolean getActive();

  /**
   * Sets the user's active status.
   * 
   * @param active the user's active status.
   */
  public void setActive(boolean active);
}
