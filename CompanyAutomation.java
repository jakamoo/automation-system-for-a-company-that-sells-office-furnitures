
import java.util.Scanner;

public class CompanyAutomation implements Menu {
	
	private int branchSize=0;
	
	private String companyName="";
	
	
	private Branch [] branches = new Branch[10];

	
	private Administrator admin = new Administrator("Sinan SARI", this);
	

	
	private int customerNum=0;
	
	private Customer [] customers=new Customer[100];
	
	  
    /**
     * gets Customer Number 
     * @return int Customer Number in branch
     */
	
	public int getCustomerNum() {
		return customerNum;
	}
	
	
	/**
     * sets Customer Number 
     */
	
	public void setCustomerNum(int customerNum) {
		this.customerNum=customerNum;
	}
	
	  
    /**
     * no Parameter constructor sets  Unnamed Company Name
     
     */
	
	
	CompanyAutomation() {

		
		setBranchSize(0);
		companyName=("Unnamed Company Name");
		
	}
	
	/**
     * one Parameter constructor sets  coName to companyAutomation
     
     */
	CompanyAutomation(String coName) {
				
		setBranchSize(0);
		companyName=coName;
		
	}
	
	 /**
     * ListBranches  
     */
	
	
	public void listBranches() {
		for(int i=0;i<branchSize;i++)
			System.out.println(branches[i].getBranchName());
	}
	
	/**
     * gets branches specified index
     * @return Branch if is there branch
     */
	
	
	public Branch getBranch(int index) {
		if(index<=0) {
			System.out.println("There is no branch yet ! ");
			return null;
		}
			
		return branches[index-1];
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
     * Sets branch
     * @param obj -  object to add
     * @param index - specifies which index must be add
     */
	
	
	public void setBranch(Branch obj, int index) {
            branches[index]=obj;
	}
	
	 /**
     * gets branchSize
     * @return int - branchsize
     */
	

	public int getBranchSize() {
		return branchSize;
	}

	 /**
     * sets branchSize
     * @param branchSize - branchsize
     */
	public void setBranchSize(int branchSize) {
		this.branchSize = branchSize;
	}

	 /**
     * gets Customer
     * @return Customer [] - customers array
     */
	public Customer [] getCustomers() {
		return customers;
	}
	
	/**
     * sets Customer
     *@param Customers [] - customer's array
     */
	
	public void setCustomers(Customer [] customers) {
		this.customers = customers;
	}

	
	
	/**
     * finds BranchEmployees
     * @return Customer [] - customers array
     */
	
	public BranchEmployee findBranchEmployee(BranchEmployee theBranchEmployee) {
		
		for(int i=1;i<=branchSize;i++) {
			
			for(int j=1;j<=getBranch(i).getBranchEmployeeNum();j++) {
				
				if(theBranchEmployee.equals(getBranch(i).getBranchEmployee(j))) {
					return getBranch(i).getBranchEmployee(j);
				}
					
			}
			
		
		}
		
		
		return null;
			
		
	}
	
	/**
     * finds Customer
     * @return Customer 
     * @param theCustomer - which will be add
     */
	
	public Customer findCustomer(Customer theCustomer) {
	
		for(int i=0;i<customerNum;i++) {
			
			if(customers[i].equals(theCustomer)) {
				return customers[i];
			}
		
		}
		
		
		return null;
			
		
	}
  
	/**
     * menu implements Menu interface
     * menu Polymorphism shows for CompanyAutomation Menu  
      
     */
	

	@Override
	public void menu() {
	
	boolean exit = false;
	int choice;

	Scanner input= new Scanner(System.in);
		
	while(!exit) {	
		
		System.out.println("Welcome");
		System.out.println("1-) Administrator " );
		System.out.println("2-) BranchEmployee" );
		System.out.println("3-) Customer " );
		System.out.println("0-) Exit " );
		
		choice=input.nextInt();
		input.nextLine();
		
			 
			
			 switch(choice) {
				
			 case 1:
				 admin.menu();
				 break;
			
			 case 2:
			 
			 System.out.println("Please enter BranchEmployee Name");
			 BranchEmployee temp=new BranchEmployee(); 	
			 Scanner sc = new Scanner(System.in);
			 String name=sc.next();
			 sc.nextLine();
			 temp.setFullName(name); 
			
			 BranchEmployee Employee=findBranchEmployee(temp);
				
				 if(Employee==null) {
					 System.out.println("Wrong BranchEmployee Name !");
					 break;
				 }
				 
				else
					 
				 Employee.menu();
				 break;
				
			 
			 case 3:						 
				Customer newCustomer=new Customer(this);
				newCustomer.menu();
					 break;
			
			 case 0:
				 	exit=true;
				 	break;
			
				 
			default: System.out.println("Invalid Entry Please Try Again ! ");
			 }
			
	}
	}

	
	
	
}
