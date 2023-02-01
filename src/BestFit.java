import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BestFit {
    BestFit(){}
    public void ImpBestFit(LinkedList<Partition> partitions1,ArrayList<Process> processes,int numProcess,int numPartitions) {
        Scanner scanner=new Scanner(System.in);
        int allocate[] = new int[numProcess];
        int count=numPartitions;
        for (int i = 0; i < allocate.length; i++)
            allocate[i] = -1;

        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < numProcess; i++)
        {
            int bestIdx = -1;

            for (int j = 0; j < numPartitions; j++)
            {
                if (partitions1.get(j).getmsize()>=processes.get(i).getsize())
                {
                    if (bestIdx == -1 || partitions1.get(bestIdx).getmsize()>partitions1.get(j).getmsize()){
                        bestIdx = j;
                    }
                }
            }
            if(bestIdx!=-1){
                allocate[i]=bestIdx;
                if(partitions1.get(bestIdx).gettmFlag())
                    continue;
                partitions1.get(bestIdx).setmsize(partitions1.get(bestIdx).getmsize()-processes.get(i).getsize());
                partitions1.get(bestIdx).setmFlag();
                processes.get(i).setprocessNumber(i);
                partitions1.get(bestIdx).process=processes.get(i);
                if(partitions1.get(bestIdx).getmsize()>0){
                    Partition p=new Partition();
                    partitions1.add(bestIdx+1,p);
                    partitions1.get(bestIdx+1).setmName("Partition"+(count));
                    partitions1.get(bestIdx+1).setmsize(partitions1.get(bestIdx).getmsize());
                    count++;
                }
                partitions1.get(bestIdx).setmsize(partitions1.get(bestIdx).getmsize()-processes.get(i).getsize());
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
