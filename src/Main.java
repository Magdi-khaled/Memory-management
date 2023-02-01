import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static LinkedList<Partition> LLPartition(){
        LinkedList<Partition>partitions=new LinkedList<>();
        System.out.print("Enter number of PARTITION : ");
        int numPARTITION=scanner.nextInt();
        for (int i = 0; i < numPARTITION; i++) {
            Partition partition=new Partition();
            System.out.print("Enter PARTITION name : ");String namePARTITION = scanner.next();
            System.out.print("Enter PARTITION size : ");int sizePARTITION = scanner.nextInt();
            partition.setmName(namePARTITION);
            partition.setmsize(sizePARTITION);
            partitions.add(partition);
        }
        return partitions;
    }
    public static ArrayList<Process> AProcess(){
        ArrayList<Process> processes1 =new ArrayList<>();
        System.out.print("Enter number of PROCESS : ");
        int numPROCESS=scanner.nextInt();
        for (int i = 0; i < numPROCESS; i++) {
            Process process=new Process();
            System.out.print("Enter process name : ");String namePROCESS = scanner.next();
            System.out.print("Enter process size : ");int sizePROCESS = scanner.nextInt();
            process.setName(namePROCESS);
            process.setsize(sizePROCESS);
            processes1.add(process);
        }
        return processes1;
    }
    public static void main (String[]args){
        while (true){
            LinkedList<Partition> L1 = new LinkedList<>();
            ArrayList<Process>L2 = new ArrayList<>();
            L1= LLPartition();
            L2 = AProcess();
            int numPARTITION= L1.size();
            int numPROCESS=L2.size();
            System.out.println("1 - First Fit ");
            System.out.println("2 - Best Fit  ");
            System.out.println("3 - Worst Fit ");
            System.out.println("4 - Exit      ");
            System.out.println("--------------");
            System.out.print(  "Choice Method : ");int num=scanner.nextInt();
            if(num==1){

                FirstFit firstFit=new FirstFit();
                firstFit.ImpFirstFit(L1,L2,numPROCESS,numPARTITION);
            }
            else if(num==2){

                BestFit bestFit=new BestFit();
                bestFit.ImpBestFit(L1,L2,numPROCESS,numPARTITION);
            }
            else if(num==3){

                WorstFit worstFit=new WorstFit();
                worstFit.ImpWorstFit(L1,L2,numPROCESS,numPARTITION);
            }
            else if(num==4){
                break;
            }
        }
    }

}

