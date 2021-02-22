package project1;

public class Patient {
    private String filepath="C:\\Users\\Akash\\Desktop\\CSV files\\Patientlist.csv";
    
    public String id;
    public String name;
    public String address;
    public String email;
    public String password;
    
    public String getpatientid(){
        return id;
    }
    public String getpatientname(){
        return name;
    }
    public String getpatientaddress(){
        return address;
    }
    public String getpatientemail(){
        return email;
    }
    public String getpatientpassword(){
        return password;
    }
        
    public Patient(String id,String name,String address,String email,String password){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
    }
    
    public String toString(){
        return "Patient Id:"+getpatientid()+"Patient Name:"+getpatientname()+
                "Patient Address:"+getpatientaddress()+"Patient Email:"+getpatientemail()+
                "Patient Password:"+getpatientpassword();
        
    }
    Patient(){
        
    }
}
