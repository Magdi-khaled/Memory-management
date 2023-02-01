public class Process {
    String Name;
    int size;
    int processNumber;
    public Process(){}
    public String getName() {return Name;}
    public void setName(String mName) {this.Name = mName;}

    public int  getsize() {return size;}
    public void setsize(int size) {this.size = size;}

    public int  getProcessNumber() {return processNumber;}
    public void setprocessNumber(int processNumber) {this.processNumber = processNumber;}

    @Override
    public String toString() {
        return "["+"Process Name = "+this.getName()+"\t\t\t"+"Process Size = "+this.getsize()+"]";
    }
}
