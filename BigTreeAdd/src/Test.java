public class Test {
    private int j = 0;
    private StringBuilder sb = new StringBuilder();
    private String s = "";
    public String bigTreeAdd(String a,String b){
        if(!isFormat(a)||!isFormat(b)){
            return "格式不对";
        }
        String s1 = toFormat(a);
        String s2 = toFormat(b);

        String result = "0";
        if (s1.charAt(0)=='-'&&s2.charAt(0)!='-'){
            result = sub(s2,s1.substring(1)).toString();
        }else if (s2.charAt(0)=='-'&&s1.charAt(0)!='-'){
            result = sub(s1,s2.substring(1)).toString();
        }else if (s2.charAt(0)=='-'&&s1.charAt(0)=='-'){
            s="-";
            result = add(s1.substring(1),s2.substring(1)).toString();
        }else {
            result = add(s1,s2).toString();
        }

        return s+result;
    }

    public StringBuilder sub(String s1,String s2){
        if (s1.length()==0){
            if (s2.length()!=0||j!=0){
                s="-";
            }
            if (j==0){
                return sb.append(s2);
            }else {
                return sub(s2,"0");
            }
        }
        if (s2.length()==0){
            if (j==0){
                return sb.append(s1);
            }else {
                return sub(s1,"0");
            }
        }
       int i = Integer.parseInt(s1.substring(s1.length() - 1)) -
                Integer.parseInt(s2.substring(s2.length() - 1)) - j;
       if (i<0){
           i=10-i;
           j=1;
       }else {
           j=0;
       }
        sb=sub(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
        return sb.append(i);
    }

    public StringBuilder add(String s1,String s2){
        int i = 0;
        if (s1.length()==0){
            if (j==0){
                return sb.append(s2);
            }else {
                return add(s2,"0");
            }
        }
        if (s2.length()==0){
            if (j==0){
                return sb.append(s1);
            }else {
                return add(s1,"0");
            }
        }
        i = Integer.parseInt(s1.substring(s1.length() - 1)) +
                Integer.parseInt(s2.substring(s2.length() - 1))+j;
        if (i>9){
            i=i-10;
            j=1;
        }else {
            j=0;
        }
        sb=add(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
        return sb.append(i);
    }


    public boolean isFormat(String s){
        if (!s.matches("[-]{0,1}[0-9]+")){
            return false;
        }
        return true;
    }

    public String toFormat(String s){
        if (s.length()==0){
            return "";
        }
        if (s.substring(0,1).equals("0")){
            return toFormat(s.substring(1));
        }
        return s;
    }

}
