import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class WorstFit {
    WorstFit(){}
    public void ImpWorstFit(LinkedList<Partition> partitions1,ArrayList<Process> processes,int numProcess,int numPartitions) {
        Scanner scanner=new Scanner(System.in);
        int allocate[] = new int[numProcess];
        for (int i = 0; i < allocate.length; i++)
            allocate[i] = -1;
        int count=numPartitions;
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < processes.size(); i++)
        {
            int WorstID = -1;
            for (int j = 0; j < partitions1.size(); j++)
            {
                if (partitions1.get(j).getmsize()>=processes.get(i).getsize())
                {
                    if (WorstID == -1 || partitions1.get(WorstID).getmsize()<partitions1.get(j).getmsize()){
                        WorstID = j;
                    }
                }
            }
            if(WorstID!=-1){
                allocate[i]=WorstID;
                if(partitions1.get(WorstID).gettmFlag())
                    continue;
                partitions1.get(WorstID).setmsize(partitions1.get(WorstID).getmsize()-processes.get(i).getsize());
                partitions1.get(WorstID).setmFlag();
                processes.get(i).setprocessNumber(i);
                partitions1.get(WorstID).process=processes.get(i);
                if(partitions1.get(WorstID).getmsize()>0){
                    Partition p=new Partition();
                    partitions1.add(WorstID+1,p);
                    partitions1.get(WorstID+1).setmName("Partition"+(count));
                    partitions1.get(WorstID+1).setmsize(partitions1.get(WorstID).getmsize());
                    count++;
                }
                partitions1.get(WorstID).setmsize(partitions1.get(WorstID).getmsize()-processes.get(i).getsize());
            }
        }
        for (int i = 0; i < partitions1.size(); i++) {
            if(partitions1.get(i).gettmFlag()){
                System.out.println(partitions1.get(i).getmName()+"("+partitions1.get(i).process.getsize()+")"+"=>"+partitions1.get(i).process.getName());
            }
            else{
                System.out.println(partitions1.get(i).getmName()+"("+partitions1.get(i).getmsize()+")"+"=> External Fragment");
            }
        }
        for (int i = 0; i < numProcess; i++) {
            if(allocate[i]==-1){
                System.out.println(processes.get(i).getName()+" Can't be allocated");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Do You Want to Compact? 1.YES 2.NO");
        System.out.print("select choice : ");int choice=scanner.nextInt();
        if(choice==1){
            System.out.println("\nProcess No.\t\t\t\tProcess Size\t\t\tPartition no.\n");
            for (int i = 0; i < processes.size(); i++)
            {
                int c=0;
                for (int j = 0; j < partitions1.size(); j++) {
                    if (partitions1.get(j).process.getProcessNumber()==i) {
                        System.out.print( processes.get(i).getName()+ "\t\t\t\t\t" + processes.get(i).getsize() + "\t\t\t\t\t");
                        System.out.println(partitions1.get(j).getmName());
                        break;
                    }
                    c++;
                }
                if(c==partitions1.size()){
                    System.out.print( processes.get(i).getName()+ "\t\t\t\t\t" + processes.get(i).getsize() + "\t\t\t\t\t");
                    Partition p=new Partition();
                    partitions1.add(count,p);
                    partitions1.get(count).setmName("Partition"+(count));
                    partitions1.get(count).setmsize(processes.get(i).getsize());
                    partitions1.get(count).process=processes.get(i);
                    System.out.println(partitions1.get(count).getmName());
                    count++;
                    break;
                }
            }
            System.out.println("-------------------------------------------------------");
        }
        else{
            System.out.println("-------------------------------------------------------");
        }

    }
}
