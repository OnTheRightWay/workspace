package contact;

public class Main {
	static Contact [] list=new Contact[10];
	public static void main(String[] args) {
//		Contact [] list=new Contact[10];
		
		Contact c1 = new Contact("����","11111111");
		c1.setGroupName("����һ");
		c1.setSex("Ů");
		Contact c2 = new Contact("����","22222222");
		c2.setGroupName("�����");
		Contact c3 = new Contact("����","33333333");
		c3.setGroupName("����һ");
		Contact c4 = new Contact("С��","44444444");
		c4.setSex("Ů");
		Contact c5 = new Contact("����","55555555");
		c5.setGroupName("�����");
		c5.setSex("Ů");
		Contact c6 = new Contact("����","66666666");
		c6.setGroupName("����һ");
		Contact c7 = new Contact("û��","77777777");
		Contact c8 = new Contact("s��","7777777");
		Contact c9 = new Contact("d��","777777");
		Contact c10 = new Contact("f��","77777");
		Contact c11 = new Contact("g��","7777");
		
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
		
		
		showInformationByGroup("����һ");
		showInformationByPhoneNo("77777777");
		showInformationBySex("Ů");
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
			System.out.println(contact.getName()+"�Ѵ���ͨѶ¼��");
		}else if(foot>9){
			System.out.println("��ϵ���������޷��������");
		}else if(contact.getName()==null||contact.getPhoneNo()==null){
			System.out.println("���ʧ��");
		}else {
			list[foot]=contact;
			System.out.println("��ӳɹ�");
		}
	}
	
	public static void showInformationByGroup(String groupName){
		System.out.println("����"+groupName+"��");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(groupName.equals(list[i].getGroupName())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationByPhoneNo(String phoneNo){
		System.out.println("����Ϊ"+phoneNo+"���ǣ�");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(phoneNo.equals(list[i].getPhoneNo())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationBySex(String sex){
		System.out.println("�Ա�Ϊ"+sex+"��");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				if(sex.equals(list[i].getSex())){
					list[i].showInformation();
				}
			}
		}
	}
	public static void showInformationAll(){
		System.out.println("ͨѶ¼��������ϵ�ˣ�");
		for(int i=0;i<10;i++){
			if(list[i]!=null){
				list[i].showInformation();
			}
		}
	}
	
}
