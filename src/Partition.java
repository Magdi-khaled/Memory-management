public class Partition {
    Process process=new Process();
    String Name;
    int size;
    boolean flag=false;
    public Partition(){}
    public String getmName() {return Name;}
    public void setmName(String mName) {this.Name = mName;}
    public void setmFlag() {this.flag = true;}
    public Boolean gettmFlag() {return flag;}

    public int  getmsize() {return size;}
    public void setmsize(int size) {this.size = size;}



    @Override
    public String toString() {
        return "["+"Partition Name = "+this.getmName()+"\t"+"Partition Size = "+this.getmsize()+"] \n";
    }
}
