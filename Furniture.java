

public class Furniture {
	
	private String furnitureColor="";
	private String Model="";
	private String furnitureName="";
	
	/**
     * gets Furniture Color
     * @return String - Furniture color
  
      
     */
	
	
	public String getFurnitureColor() {
		return furnitureColor;
	}
	
	/**
     * sets Furniture Color
     * @param String - furnitureColor
  
      
     */
	
	public void setFurnitureColor(String furnitureColor) {
		this.furnitureColor = furnitureColor;
	}
	
	
	
	/**
     * sets Furniture Model
     * @param String - Furniture Model
  
      
     */
	
	
	public String getModel() {
		return Model;
	}
	
	/**
     * sets Furniture model
     * @param String - furniture model
  
      
     */
	
	public void setModel(String model) {
		Model = model;
	}
	
	/**
     * gets Furniture name
     * @return String - Furniture name
  
      
     */
	public String getFurnitureName() {
		return furnitureName;
	}
	
	/**
     * sets Furniture name
     * @param String - furniture name
  
      
     */
	
	public void setFurnitureName(String type) {
		this.furnitureName = type;
	}
	
	
	  /**
     * Takes an object for compare between objects
     * @param obj - taking object
     * @return boolean 
     */
	
	   @Override
	    public boolean equals(Object obj) {
		        if( this == obj )
		            return true;
		        if( !(obj instanceof Furniture) )
		            return false;
		        return furnitureName.equals( ((Furniture)obj).getFurnitureName() ) &&
		        		furnitureColor.equals( ((Furniture)obj).getFurnitureColor()) && 
		        		Model.equals( ((Furniture)obj).getModel()) ;
		    }
	

}
