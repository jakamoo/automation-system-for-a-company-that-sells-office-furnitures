

import java.util.Scanner;

/**
 * Administrator is a class the extends the user class
 * Administrator is a class implements the Menu
 * and is used to manipulate the system
 * by adding branches, branch employees
 */

public class  Administrator extends User  implements Menu {
	
	
	private CompanyAutomation system;
	
	/**
     * One Parameter constructor takes CompanyAutomation reference and using it.
     * CompanyAutomation a class which is including branches and customers datas.
     * name as Unnamed Admin
     * @param system refers to CompanyAutomation for reach the datas.
     */

    public Administrator(CompanyAutomation system ){
        this( "Unnamed Admin", system );
     
    }
    
    /**
     * Two parameter constructor that takes CompanyAutomation reference and using it.
     * @param fullName - fullName
     * @param system - CompanyAutomation's reference 
     */
    
    public Administrator( String fullName, CompanyAutomation system ){
        super( fullName, userType.ADMINISTRATOR );
        this.system = system;
        
    }

    /**
     * Administrators are able to add branches to the system
     * @param newBranch , newBranch is a branch object 
     */
    
    public void addBranch(Branch newBranch){
    		
    		
    		system.setBranch(newBranch, system.getBranchSize());
    		
    		System.out.println(newBranch.getBranchName()+" is Succesfully added");
    		
    		system.setBranchSize(system.getBranchSize()+1);
	
		
	}
    
    
    
    public void addBranchEmployee(BranchEmployee newBranchEmployee, int index){
    	
	if(system.getBranchSize()<index) {
		System.out.println("There is no Branch ");
		return;
	}	
	newBranchEmployee.saveToBranch(system.getBranch(index));
    	system.getBranch(index).setBranchEmployee(newBranchEmployee, system.getBranch(index).getBranchEmployeeNum()+1);
		System.out.println(newBranchEmployee.getFullName()+" is Succesfully added");
		system.getBranch(index).setBranchEmployeeNum(system.getBranch(index).getBranchEmployeeNum()+1);

	
}
    
    /**
     * Remove a branch from the system
     * @param theBranch , theBranch is an branch object which is ready to remove 
     */
    
    public void removeBranch(Branch theBranch) {
    	
    	
    	boolean drop=false;
    	
    	for(int i=1;i<=system.getBranchSize();i++)
    		
    		if(theBranch.equals(system.getBranch(i))) {
    	
    	    	for(int j=i;j<system.getBranchSize();j++) {
    	    		
    	    		system.setBranch(system.getBranch(j+1), j-1);
    	    	}
    	    	drop=true;
    			System.out.println(theBranch.getBranchName()+" Succesfully removed");
    			system.setBranchSize(system.getBranchSize()-1);
    		}
    	
    	if(!drop)
    	System.out.println("Branch Has not found");
    	
    		
    }
    
    /**
     * showBranches shows which branchs are included 
     
     */
    
    
    public void showBranches() {
    		
    	if(system.getBranchSize()<=0)
    			System.out.println("There is no Branch yet !");
    	else	
    		for(int i=1;i<=system.getBranchSize();i++)
    				System.out.println(system.getBranch(i).getBranchName());
    }
    
    /**
     * showBranchEmployees shows which branchEmployees are included 
     
     */
    
    public void showBranchEmployees() {
		
    boolean drop=false;
    
		for(int i=1;i<=system.getBranchSize();i++)
			for(int j=1;j<=system.getBranch(i).getBranchEmployeeNum();j++) {
				System.out.println(system.getBranch(i).getBranchEmployee(j).getFullName());
				drop=true;
				
			}
		if(!drop)
			System.out.println("There is no BranchEmployee");
		
    	}
    
    
    /**
     * Remove a branchEmployee from the system
     * @param theBranchEmployee , theBranchEmployee is an branchemployee object which is ready to remove 
      
     */
    
    public void removeBranchEmployee(BranchEmployee theBranchEmployee ) {
	
    	int index;
    	boolean adding = false;
    	
      for(index=1;index<=system.getBranchSize();index++)
    		
    	for(int i=1;i<=system.getBranch(index).getBranchEmployeeNum();i++)
    		if(theBranchEmployee.equals(system.getBranch(i).getBranchEmployee(i))) {
    			system.getBranch(i).setBranchEmployee(new BranchEmployee(), i);
    			System.out.println(theBranchEmployee.getFullName()+" Succesfully removed");
    			adding = true;
    	    	system.getBranch(index).setBranchEmployeeNum(system.getBranch(index).getBranchEmployeeNum()-1);
    		}
    if(!adding) {
    	System.out.println("There is no Such Branch Employee");
    	return;
    }	

    	
    		
    }

    /**
     * Shows avaible for selling Furnitures in stock
      
     */

	public void showFurnitures() {
		int bkcase=0;
		int mttablee=0;
		int officecabnet=0;
		int officeChair=0;
		int officeDesk=0;
		
		for(int i=0;i<system.getBranchSize();i++) {
			
			for(int j=0;j<system.getBranch(i).getFurnitureNum();j++) {
			
		
			if(system.getBranch(i).getFurniture(j).getFurnitureName().equals("BookCases")) {
			
				bkcase++;
				
			}
			
		         
			if(system.getBranch(i).getFurniture(j).getFurnitureName().equals("MeetingTable")) {
		
				mttablee++;
			}
			
			if(system.getBranch(i).getFurniture(j).getFurnitureName().equals("OfficeCabinet")) {
			
				officecabnet++;
			}
			
			if(system.getBranch(i).getFurniture(j).getFurnitureName().equals("OfficeChair")) {
	
				officeChair++;
			}
			
			if(system.getBranch(i).getFurniture(j).getFurnitureName().equals("OfficeDesk")) {
				officeDesk++;
			}
			
			
			
			System.out.println("Office Desk: "+officeDesk);
			System.out.println("Office Chair: "+officeChair);
			System.out.println("Office Cabinets: "+officeDesk);
			System.out.println("Office MeetingTable: "+mttablee);
			System.out.println("Office BookCase: "+bkcase);
			
		}
		}
	
	}
	
	 /**
     * menu implements Menu interface
     * menu Polymorphism shows for Administrator Menu  
      
     */
	
	@Override
	public void menu() {
	
	boolean exit=false;	
	
	while(!exit) {	
		System.out.println("1-) Branch add ");
		System.out.println("2-) Branch remove ");
		System.out.println("3-) BranchEmployee add ");
		System.out.println("4-) BranchEmployee remove ");
		System.out.println("5-) ShowBranches ");
		System.out.println("6-) ShowBranchEmployees ");
		System.out.println("0-) Exit ");
		
		Scanner input = new Scanner(System.in);
			int selection=input.nextInt();
			input.nextLine();
			
			switch (selection) {
				
			case 1:
				Branch branch= new Branch();
				System.out.println("Please Enter Branch Name");
				String name= input.next();
				branch.setBranchName(name);
			    addBranch(branch);
					break;
					
			case 2:
				Branch thebranch= new Branch();
				System.out.println("Please Enter Branch Name");
				thebranch.setBranchName(input.next());
			    removeBranch(thebranch);
			    break;
				
			case 3:
				BranchEmployee branchEmployee = new BranchEmployee();
				System.out.println("Please Enter BranchEmployee Name ");
				branchEmployee.setFullName(input.next());
				addBranchEmployee(branchEmployee,1);
					break;
			case 4:
				BranchEmployee thebranchEmployee = new BranchEmployee();
				System.out.println("Please Enter BranchEmployee Name");
				thebranchEmployee.setFullName(input.next());
				removeBranchEmployee(thebranchEmployee);
					break;
			case 5:
				showBranches();
				break;
			case 6:
				showBranchEmployees();	
				break;
			case 0:
				exit=true;
				break;
			default :
					System.out.println("Invalid Choice Try Again !");
			}
		}
	}
}






