package contact;

public class Main {
	static Contact [] list=new Contact[10];
	public static void main(String[] args) {
//		Contact [] list=new Contact[10];
		
		Contact c1 = new Contact("张三","11111111");
		c1.setGroupName("分组一");
		c1.setSex("女");
		Contact c2 = new Contact("李四","22222222");
		c2.setGroupName("分组二");
		Contact c3 = new Contact("王五","33333333");
		c3.setGroupName("分组一");
		Contact c4 = new Contact("小米","44444444");
		c4.setSex("女");
		Contact c5 = new Contact("二米","55555555");
		c5.setGroupName("分组二");
		c5.setSex("女");
		Contact c6 = new Contact("三米","66666666");
		c6.setGroupName("分组一");
		Contact c7 = new Contact("没米","77777777");
		Contact c8 = new Contact("s米","7777777");
		Contact c9 = new Contact("d米","777777");
		Contact c10 = new Contact("f米","77777");
		Contact c11 = new Contact("g米","7777");
		
		addContact(c1);
		addContact(c2);
		addContact(c3);
		addContact(c4);
		addContact(c5);
		addContact(c6);
		addContact(c7);
		addContact(c8);
		addContact(c9);
		addContact(c10);
		addContact(c11);
		
		
		showInformationByGroup("分组一");
		showInformationByPhoneNo("77777777");
		showInformationBySex("女");
		showInformationAll();
		
		
		
	}
	public static void addContact(Contact contact){
		int foot=0;
		boolean temp=false; 
		for(;foot<10&&list[foot]!=null;foot++){
			if(list[foot].getName().equals(contact.getName())){
				
				temp=true;
			}
		}
		if(temp){
			System.out.println(contact.getName()+"已存在通讯录中");
		}else if(foot>9){
			System.out.println("联系人已满，无法继续添加");
		}else if(contact.getName()==null||contact.getPhoneNo()==null){
			System.out.println("添加失败");
		}else {
			list[foot]=contact;
			System.out.println("添加成功");
		}
	}
	
	public static void showInformationByGroup(String groupName){
		System.out.println("属于"+groupName+"：");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(groupName.equals(list[i].getGroupName())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationByPhoneNo(String phoneNo){
		System.out.println("号码为"+phoneNo+"的是：");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(phoneNo.equals(list[i].getPhoneNo())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationBySex(String sex){
		System.out.println("性别为"+sex+"：");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(sex.equals(list[i].getSex())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationAll(){
		System.out.println("通讯录中所有联系人：");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				list[i].showInformation();
			}
		}
	}
	
}
