package imc.api.routes.example.interfaces;

public interface ExampleInterface {

  /**
   * Returns the example's id.
   * 
   * @return the example's id.
   */
  public Long getId();

  /**
   * Sets the example's id.
   * 
   * @param idExample the example's id.
   */
  public void setId(Long idExample);

  /**
   * Returns the example's name.
   * 
   * @return the example's name.
   */
  public String getName();

  /**
   * Sets the example's name.
   * 
   * @param name the example's name.
   */
  public void setName(String name);

  /**
   * Returns the example's description.
   * 
   * @return the example's description.
   */
  public String getDescription();

  /**
   * Sets the example's description.
   * 
   * @param description the example's description.
   */
  public void setDescription(String description);

  /**
   * Returns the example's active status.
   * 
   * @return the example's active status.
   */
  public boolean getActive();

  /**
   * Sets the example's active status.
   * 
   * @param active the example's active status.
   */
  public void setActive(boolean active);
}
