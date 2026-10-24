class Solution {
    static int getDay(String date, int[] months) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;

        for(int i=0; i<month-1; i++) {
            total += months[i];
        }
        return total;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArrive = getDay(arriveAlice, months);
        int aliceLeave = getDay(leaveAlice, months);
        int bobArrive = getDay(arriveBob, months);
        int bobLeave = getDay(leaveBob, months);

        int start = Math.max(aliceArrive, bobArrive);
        int end = Math.min(aliceLeave, bobLeave);

        return Math.max(0, end - start + 1);
    }   
}