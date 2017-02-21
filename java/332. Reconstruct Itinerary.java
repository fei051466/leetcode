public class Solution {
    private Map<String, List<Integer>> ticketMap;
    List<String> path ;
    List<String> result;
    private String[][] myTickets;
    private boolean finish = false;

    class myconparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return myTickets[a][1].compareTo(myTickets[b][1]);
        }
    }

    private void dfs(String[][] tickets, String from, int pathLength, Set<Integer> usedTickets) {
        if (finish)
            return;
        if (path.size() == pathLength) {
            finish = true;
            result = new ArrayList<String>(path);
            return;
        }
        List<Integer> desTickets = ticketMap.get(from);
        if (desTickets == null)
            return;
        for (int ticketNum: desTickets) {
            if (usedTickets.contains(ticketNum))
                continue;
            usedTickets.add(ticketNum);
            path.add(tickets[ticketNum][1]);
            dfs(tickets, tickets[ticketNum][1], pathLength, usedTickets);
            usedTickets.remove(Integer.valueOf(ticketNum));
            path.remove(path.size() - 1);
        }
    }
    public List<String> findItinerary(String[][] tickets) {
        myTickets = tickets;
        ticketMap = new HashMap<String, List<Integer>>();
        path = new ArrayList<String>();
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            if (ticketMap.containsKey(from)) {
                ticketMap.get(from).add(i);
            }
            else {
                List<Integer> des = new ArrayList<Integer>();
                des.add(i);
                ticketMap.put(from, des);
            }
        }

        for (List<Integer> des: ticketMap.values()) {
            Collections.sort(des, new myconparator());
        }

        Set<Integer> usedTickets = new HashSet<Integer>();
        path.add("JFK");
        dfs(tickets, "JFK", tickets.length + 1, usedTickets);

        return result;

    }
}