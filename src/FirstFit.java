import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstFit {

    FirstFit(){}
    public void ImpFirstFit(LinkedList<Partition> partitions1,ArrayList<Process> processes,int numProcess,int numPartitions) {
        Scanner scanner=new Scanner(System.in);
        int count=numPartitions;
        int occ[]=new int[numPartitions];
        int []allocation=new int[numProcess];
        for (int i = 0; i < numPartitions; i++)
            occ[i] = 0;
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < allocation.length; i++) {
            allocation[i]=-1;
        }
        for (int i = 0; i < processes.size(); i++)
        {
            for (int j = 0; j < partitions1.size(); j++)
            {
                if (partitions1.get(j).getmsize()>=processes.get(i).getsize())
                {

                    if(partitions1.get(j).gettmFlag())
                        continue;
                    allocation[i]=j;
                    partitions1.get(j).setmsize(partitions1.get(j).getmsize()-processes.get(i).getsize());
                    partitions1.get(j).setmFlag();
                    processes.get(i).setprocessNumber(i);
                    partitions1.get(j).process=processes.get(i);
                    if(partitions1.get(j).getmsize()>0){
                        Partition p=new Partition();
                        partitions1.add(j+1,p);
                        partitions1.get(j+1).setmName("Partition"+(count));
                        partitions1.get(j+1).setmsize(partitions1.get(j).getmsize());
                        count++;
                    }

                    break;
                }
            }
        }
//        System.out.println(partitions1);
        for (int i = 0; i < partitions1.size(); i++) {
            if(partitions1.get(i).gettmFlag()){
                System.out.println(partitions1.get(i).getmName()+"("+partitions1.get(i).process.getsize()+")"+"=>"+partitions1.get(i).process.getName());
            }
            else{
                System.out.println(partitions1.get(i).getmName()+"("+partitions1.get(i).getmsize()+")"+"=> External Fragment");
            }
        }
        for (int i = 0; i < numProcess; i++) {
            if(allocation[i]==-1){
                System.out.println(processes.get(i).getName()+" Can't be allocated");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Do You Want to Compact? 1.YES 2.NO");
        System.out.print("select choice : ");int choice=scanner.nextInt();
        if(choice==1){
            System.out.println("\nProcess No.\t\t\t\tProcess Size\t\t\tPartition no.\n");
            for (int i = 0; i < processes.size(); i++)//process4
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
