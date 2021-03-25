

public abstract class User implements Person  {
	
	private String fullName;
	private int id;
	private String mailAdress;
	private userType _userType;
	private String password;
	
	enum userType{ADMINISTRATOR,CUSTOMER,EMPLOYEE,UNDEFINED_USER}
	
	/* two parameter constructor takes user type and full name implements person 
	 * @return String - for person's name */
	
    public User( String fullName, userType _userType ){
        this.fullName = fullName;
        this._userType = _userType;
    }
    
    /* no parameter assing Unnamed user by default
	 * @return String - for person's name */
	
    
    public User(){
        this( "Unnamed User" , userType.UNDEFINED_USER );
    }
	
    /**
     * gets user name
     * @return String - Person name
  
      
     */
	public String getFullName() {
		return fullName;
	}

	/**
     * gets user id
     * @return int - Person id
  
      
     */
	public int getId() {
		return id;
	}
	
	/**
     * gets user mail
     * @return String - Person mail
  
      
     */

	public String getMail() {
		return mailAdress;

	}

	public void setMail(String mailAdress) {
		this.mailAdress=mailAdress;

	}
	
	public void setFullName(String fullName) {
		this.fullName=fullName;
		
	}

	public void setId(int id) {
		this.id=id;
		
	}
	
	/**
     * gets user type
     * @return userType - return types
  
      
     */
	public userType getUserType() {
		return _userType;
	}

	public void setUserType(userType _userType) {
		this._userType = _userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
