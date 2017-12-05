package contact;

public class Contact {
	private String name;
	private String sex;
	private String phoneNo;
	private String address;
	private String groupName;
	
	public Contact(String name,String phoneNo){
		this.name=name;
		this.phoneNo=phoneNo;
	}
	public void showInformation(){
		System.out.println("姓名："+name
				+" 性别："+sex
				+" 电话号码："+phoneNo
				+" 住址："+address
				+" 分组名称："+groupName);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
