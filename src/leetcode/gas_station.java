package leetcode;

public class gas_station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = -1;
        int i = 0;
        int j = i + 1;
        int n = gas.length;
        int index = -1;
        boolean isCircle = false;
        while(i < n) {
            if(i == index && isCircle && tank != -1) return index;
            if(tank >= cost[i]) {
                if(i == n - 1) {
                    tank = tank - cost[i] + gas[0];
                    i = 0;
                    j = 1;
                    isCircle = true;
                } else {
                    tank = tank - cost[i] + gas[j];
                    i++;
                    j = i + 1;
                }
            }
            else if(gas[i] >= cost[i] && tank == -1) {
                tank = gas[i];
                index = i;
                j = i + 1;
            } else {
                tank = -1;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new gas_station().canCompleteCircuit(
                new int[]{2, 3, 4},
                new int[]{3, 4, 3}
        );
    }
}
