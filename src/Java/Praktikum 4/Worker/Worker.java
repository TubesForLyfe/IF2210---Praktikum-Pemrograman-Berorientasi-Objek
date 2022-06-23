import java.util.List;

public class Worker {
 public static int run(List<Integer> durations, int machineCount) {
  int[] machines = new int[machineCount];
        for(int j = 0; j < machineCount; j++) {
            machines[j] = 0;
        }
        int seconds = 0;
        int i = 0;
        while(i < durations.size()) {
            for(int j=0; j<machineCount && i < durations.size(); j++) {
                if(machines[j] == 0) {
                    machines[j] = durations.get(i);
                    i++;
                }
            }
            if(i == durations.size()){
                int max = 0;
                for(int j=0; j<machineCount; j++) {
                    if(machines[j] > max) {
                        max = machines[j];
                    }
                }
                seconds += max;
            }
            else{
                int min = 1000001;
                for(int j=0; j<machineCount; j++) {
                    if(machines[j] < min && machines[j] != 0) {
                        min = machines[j];
                    }
                }
                seconds += min;
                for(int j=0; j<machineCount; j++) {
                    machines[j] -= min;
                }
            }
        }
  return seconds;
 }
}