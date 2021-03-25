

public class Branch {

	private BranchEmployee [] employees = new BranchEmployee[100];

	private Furniture [] furnitures = new Furniture[100];

	private String branchName="";
	
	private int branchEmployeeNum=0;
	
	private int furnitureNum=0;
	
	/**
     * No parameters Branch Constructor adds otomatically Unnamed Branc name.
     */
	
	Branch(){
		
		setBranchName("Unnamed Branch");
		branchEmployeeNum=0;
		furnitureNum=0;
		
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
	        if( !(obj instanceof Branch) )
	            return false;
	        return branchName.equals( ((Branch)obj).getBranchName() );
	    }
	
    /**
     * sets branchsemployees to indexed employee array
     * @param employee- employee to add
     * @param index - specify which array must be added 
     */
    
	public void setBranchEmployee(BranchEmployee employee,int index) {
		this.employees[index-1] = employee;
	}

	 /**
     * gets Furnitures to indexed furniture array
     * @param index - specify which array must be added
     * @return returns Furniture object 
     */
    
	public Furniture  getFurniture(int index) {
		return furnitures[index-1];
	}
	
   /**
     * sets Furnitures to indexed furniture array
     * @param newFurniture - furniture to add
     * @param index - specify which array must be added 
     */
    

	public void setFurniture(Furniture newFurniture,int index) {
		this.furnitures[index] = newFurniture;
	}

	/**
     * gets Branchname
   	 * @return String for the branchname
     */
	
	public String getBranchName() {
		return branchName;
	}
	
	/**
     * sets Branchname
     * @param branchName- takes branchname
     */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
     * gets BranchEmployee's number
   	 * @return int - for specify employee num
     */
	
	public int getBranchEmployeeNum() {
		return branchEmployeeNum;
	}
	

	 /**
     * sets branchemployee number
     * @param branchEmployeeNum - takes branchEmployeeNum
     */
	
	public void setBranchEmployeeNum(int branchEmployeeNum) {
		this.branchEmployeeNum = branchEmployeeNum;
	}
	
	 /**
     * gets furniture number
     * @return int - furniturenum
     */
	
	
	public int getFurnitureNum() {
		return furnitureNum;
	}
	
	/**
     * sets furniture number
     * @param furnitureNum - specifies furnitures number

     */
	

    public void setFurnitureNum(int furnitureNum) {
		this.furnitureNum = furnitureNum;
	}
	
	 /**
     * gets BranchEmployee which specified by index parameter
     * @param index - type index
     * @return BranchEmployee

     */
	
    
    public BranchEmployee getBranchEmployee(int index) {
    	return employees[index-1];
    }

   

	 
}
