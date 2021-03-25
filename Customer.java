
import java.util.Scanner;

public class Customer extends User implements Menu{

	private CompanyAutomation system;
	private String adress="";
	private String phoneNum="";
	
	private int purchaseHistoryNum=0;
	
	private Furniture[] purchaseHistory = new Furniture [100];
	
	/**
     * gets Purchased Furnitures arrays
     * @return Furniture[]  - furnitures array
     */
	
	public Furniture[] getPurchaseHistory() {
		return purchaseHistory;
	}
	
	/**
     * sets Purchased Furnitures arrays
     * @param purchaseHistory  - specifies which purchaseHistory will be add
     */
	public void setPurchaseHistory(Furniture[] purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}

	/**
     * when customer buy a furniture then adds purchase history
     * @param furnitureName  - specifies which furnitureName will be add
     */
	public void addPurchaseHistory(Furniture furnitureName) {
		purchaseHistory[purchaseHistoryNum]=furnitureName;
		purchaseHistoryNum++;
	}
	
	/**
     * Customers subscribe 
     */
	
	public void subscribe() {
	
		
		System.out.println("Please Enter Full Name");

		Scanner input= new Scanner(System.in);
		this.setFullName(input.nextLine());
		
		System.out.println("Please define a password");
		this.setPassword(input.nextLine());

		system.getCustomers()[system.getCustomerNum()]=this;
		system.setCustomerNum(system.getCustomerNum()+1);
	
		
	}
	
	/**
     * Shows Customers 
     */
	
	
	public void showcustomers() {
		for (int i=0;i<system.getCustomerNum();i++)
			System.out.println(system.getCustomers()[i].getFullName());

		
	}
	
	
	/**
     * Customer Constructor refers to Companyautomation for search every furnitures
     */
	
	public Customer(CompanyAutomation system) {
		this.system=system;
		this.setId(this.hashCode());
	}
	
	/**
     * ordering metod
     * @param furniture - specifies ordering furniture
     * @return boolean - if orders sucessfull or not then true or false
     */
	
	
	public boolean order(Furniture furniture) {
		Scanner input= new Scanner(System.in);
		System.out.println("Please Enter Phone Number ");
		phoneNum= input.next();
		System.out.println("Please Enter Adress");
		adress= input.next();
		
		for(int i=1;i<=system.getBranchSize();i++) {
			
			for(int j=1;j<=system.getBranch(i).getFurnitureNum();j++) {
				
				if(furniture.getFurnitureName().equals(system.getBranch(i).getFurniture(j).getFurnitureName())) {
					addPurchaseHistory(system.getBranch(i).getFurniture(j));
					system.getBranch(i).getBranchEmployee(j).removeProduct(furniture);
					return true;
				}
			}
		
	}
		return false;
	}
	
	/**
     * shows products
     */
	
	public void showProducts() {
	
		if(purchaseHistoryNum<=0)
			System.out.println("There is no Product !");
		
		else
			
			for(int i=0;i<purchaseHistoryNum;i++) {
				System.out.println((i+1)+"-)"+getPurchaseHistory()[i].getFurnitureName());
			}
	}
	
	/**
     * when customer subscribe then get into
     * @param theCustomer - specifies customer
     */
	
	public void registeredCustomer(Customer theCustomer) {
		
		Scanner input= new Scanner(System.in);
		int choice;
		boolean exit=false;
		
		while(!exit) {	
			
		System.out.println("Welcome Mr/Mrs \n"+theCustomer.getFullName());
		System.out.println("1-) Give an Order ");
		System.out.println("2-) Show Order History");
		System.out.println("0-) Back");
		
		choice=input.nextInt();
		input.nextLine();
		
		switch(choice) {
			
		case 1:
				Furniture temp=system.selectProduct();
				if(!order(temp))
					System.out.println("There is no this Furniture");
				else
					System.out.println("You successfully ordered!");
				break;
			
		case 2:
			showProducts();
			break;
			
		case 0:
			exit=true;
			break;
			
			default:System.out.println("Invalid Choice !");
		
		}
		
		
		}
		
	}
	
	/**
     * login metod
     * @return boolean - if loging successfull or not then true or false
     */
	
	public boolean login() {

		System.out.println("Please Enter Full Name");

		Scanner input= new Scanner(System.in);
		this.setFullName(input.nextLine());
		
		System.out.println("Please enter password");
		this.setPassword(input.nextLine());

		for(int i=0;i<system.getCustomerNum();i++)
			if(this.equals(system.getCustomers()[i])) {
				registeredCustomer(system.getCustomers()[i]);
				return true;
			}
					
		
		return false;
	}
	
	/**
     * menu implements Menu interface
     * menu Polymorphism shows for Customer Menu  
      
     */
	
	
	
	@Override
	public void menu() {

	
	

		Scanner input= new Scanner(System.in);
		boolean exit = false;
		int choice;
		
			
		while(!exit) {	
			
			System.out.println("1-) Login");
			System.out.println("2-) Subscribe");
			System.out.println("3-) List Products");
			System.out.println("4-) Search Furniture");	
			System.out.println("0-) Exit");
	
		
			
			choice=input.nextInt();
			input.nextLine();
			
			
			switch(choice) {
			
			case 1:
				if(!login())
					System.out.println("There is no Such Customer ! ");
				break;
				
			case 2:
				subscribe() ;
				break;
				
			case 3:
				listProducts();
						
				break;
			case 4: 
				searchProduct();
				break;
				
			case 0:
				exit=true;
				break;
				
			case 9:
				showcustomers();
		
			}
		}
		
	}
	
	/**
     * Searching product
  
      
     */
	
	
	public void searchProduct() {
		System.out.println("Please Select What do you want ");
		Furniture temp=system.selectProduct();
		
		for(int i=1;i<=system.getBranchSize();i++) {
			
			for(int j=0;j<system.getBranch(i).getFurnitureNum();j++) {
				
					if(temp.equals(system.getBranch(i).getFurniture(j))) {
						 
						System.out.println("Your product at "+system.getBranch(i).getBranchName()+ " Branch");
					return;
					}
			}
		}
		System.out.println("There is no this product");
	}

	/**
     * Listing  products
  
      
     */
	

	public void listProducts() {

	if(system.getBranchSize()<=0)
		System.out.println("There is no Product ");
	
	else
		for(int i=1;i<=system.getBranchSize();i++) {
			
			for(int j=0;j<system.getBranch(i).getFurnitureNum();j++) {
	
				System.out.println((i+1)+"-)"+system.getBranch(i).getFurniture(j).getFurnitureName()+" "+
						system.getBranch(i).getFurniture(j).getModel()+" "+system.getBranch(i).getFurniture(j).getModel());
			
			}
	
		}
	
	 }
	}
