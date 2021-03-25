

import java.util.Scanner;

public class BranchEmployee extends User implements Menu {
	
	private Branch branch;
	
	 /**
     * One parameter Constructor Takes branch reference for datas
     * sets Unnamed Person name by default
     * @param branch - branch reference for branchemployees tasks.
     */
	
	BranchEmployee(Branch branch){
		super.setFullName("Unnamed Person");
		this.branch=branch;
	}
	
	 /**
     * No parameter Constructor sets Unnamed Person name by default
     */
	
	BranchEmployee(){
		super.setFullName("Unnamed Person");
	}
	
	 /**
     * Register BranchEmployee to branch 
     * @param branch - branch reference for branchemployees tasks.
     */
	
	
    public void saveToBranch(Branch branch) {
			this.branch=branch;
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
	        if( !(obj instanceof BranchEmployee) )
	            return false;
	        return getFullName().equals( ((BranchEmployee)obj).getFullName() );
	        		
	    }
 
    /**
     * AddProducts to whole product's  
     * @param newFurniture - ready to adding Furniture object
     */
	
	public void addProduct(Furniture newFurniture) {
		
		branch.setFurniture(newFurniture, branch.getFurnitureNum());
		branch.setFurnitureNum(branch.getFurnitureNum()+1);
		System.out.println(newFurniture.getFurnitureName()+" "+newFurniture.getModel()  +" "+newFurniture.getFurnitureColor()+ " Successfully added ");
	
	}
	
	  /**
     * Selecting Products catalog for add , search or remove
     * @return Furniture - returns an furniture object
     */
	
	public Furniture selectProduct() {
		Scanner scan = new Scanner(System.in);
		int i,choice;
		String Model="";
		String Color="";
		String Type="";
		String types[]= new String [] { "chair","desk","meetingtable","bookcases","officecabinets"  };
		String colors [][]= new String [][] {{"red","yellow","blue","brown","orange","green","black"},{"red","yellow","blue","brown"},{"red","yellow","blue","brown"}};
		String models [][]= new String [][] {{"model1","model2","model3","model3","model4","model5","model6","model7"},{"model1","model2","model3","model3","model4","model5"}
											,{"model1","model2","model3","model3","model4","model5","model6","model7","model8","model9","model10"},
											{"model1","model2","model3","model3","model4","model5","model6","model7","model8","model9","model10","model11","model12"},
											{"model1","model2","model3","model3","model4","model5","model6","model7","model8","model9","model10","model11","model12"}};
		for(i=0;i<types.length;i++) {
			
			System.out.println(i+"->"+types[i]);
			
		}
		
		System.out.println("Choice Type:");
		choice = scan.nextInt();
	
		switch(choice) {
		
		case 0: Type= types[0];
				break;
				
		case 1: Type= types[1];
		break;
		case 2: Type= types[2];
		break;
		case 3: Type= types[3];
		break;
		case 4: Type= types[4];
		break;
		default : System.out.println("Type is not faund");
				break;
		}
		int Type_index=choice;
	
	
		if(Type_index==0||Type_index==1||Type_index==2) {
			
			
			for(i=0;i<colors[Type_index].length;i++) {
				
				System.out.println(i+"->"+colors[Type_index][i]);
				
			}
			
			System.out.println("Color Type:");
			
			choice = scan.nextInt();
			
			
			switch(choice) {
			
			case 0: Color= colors[Type_index][choice];
					break;
					
			case 1: Color= colors[Type_index][choice];
			break;
			case 2: Color= colors[Type_index][choice];
			break;
			case 3: Color= colors[Type_index][choice];
			break;
			case 4: Color= colors[Type_index][choice];
			break;
			default : System.out.println("Color is not faund");
						break;
			}
			
			
			
		}
		
		for(i=0;i<models[Type_index].length;i++) {
			
			System.out.println(i+"->"+models[Type_index][i]);
			
		}
		
		
		System.out.println("Model Type:");
		
		choice = scan.nextInt();
	
		
		switch(choice) {
		
		case 0: Model= models[Type_index][choice];
				break;
				
		case 1: Model= models[Type_index][choice];
				break;
		case 2: Model= models[Type_index][choice];
				break;
		case 3: Model= models[Type_index][choice];
				break;
		case 4: Model= models[Type_index][choice];
				break;
		default : System.out.println("Color is not faund");
				break;
		}
		
		
		Furniture temp= new Furniture();
			temp.setFurnitureColor(Color);
			temp.setFurnitureName(Type);
			temp.setModel(Model);
			
			return temp;
		 }
		 
		 
	  /**
     * Remove Products from  whole product's  
	 * @param theFurniture - ready to remove product 
     */
	
	public void removeProduct(Furniture theFurniture) {
	
	boolean flag=false;
    	for(int i=1;i<=branch.getFurnitureNum();i++) {
    		if(theFurniture.equals(branch.getFurniture(i))) {
    			branch.setFurniture(new Furniture() , i);
    			System.out.println(theFurniture.getModel()+" Succesfully removed");
    		flag=true;
    		}
    		
    	}
    	
    	if(flag)
    	branch.setFurnitureNum(branch.getFurnitureNum()-1);
    	else
    		System.out.println("This Product Could not found");
    		
	}
	
	  /**
     * Shows stocks in data array 
 
     */

	public void showstock(){
		
		if(branch.getFurnitureNum()<=0)
			System.out.println("There is no product in Stock ");
		else
			for(int i=0;i<branch.getFurnitureNum();i++)
				System.out.println(branch.getFurniture(i).getFurnitureName()+" "+ branch.getFurniture(i).getModel()+" "+branch.getFurniture(i).getFurnitureColor());
	}
	
	 
   /**
   * sells Products from  whole product's  
	 * @param theFurniture - ready to selling product 
   */
	
	public void sellProduct(Furniture thefurniture){
	

    	
    	for(int i=1;i<=branch.getFurnitureNum();i++)
    		
    		if(thefurniture.equals(branch.getFurniture(i))) {
    			
    			for(int j=i;j<branch.getFurnitureNum();j++) {
    				branch.setFurniture(branch.getFurniture(i+1), i);
    				System.out.println("The Furniture Succesfully sold");
    				return;
    			}
    		}
    		
    		
    	
    	branch.setFurnitureNum(branch.getFurnitureNum()-1);

	}
	
	 /**
     * menu implements Menu interface
     * menu Polymorphism shows for BranchEmployee Menu  
      
     */
	
	@Override
	public void menu() {
	
	boolean exit=false;	
	
	while(!exit) {	
		Scanner input=new Scanner(System.in);
		System.out.println("1-)Show Stocks");
		System.out.println("2-)Sell Furniture");
		System.out.println("3-)Furniture Add");
		System.out.println("4-)Furniture Remove");
		System.out.println("5-)Show Selling History");
		System.out.println("0-)Exit");
		
		 
		int choice =input.nextInt();
		 input.nextLine();
		
		 switch(choice) {
		 
		 case 1:
			 showstock();
			 break;
		
		 case 2:
			 break;
		 
		 case 3:
			
			 addProduct(selectProduct());
			 break;
		 case 4:
			 removeProduct(selectProduct());
			 break;
			 	
		 case 5:
			 break;
			 
		 case 0:
			 exit=true;
			 break;	 
		 }
		 
	}
		
	}
	
	
}
