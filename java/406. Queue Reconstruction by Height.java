class People {
    int h;
    int k;
    
    public People(int h, int k){
        this.h = h;
        this.k = k;
    }
}

class PeopleComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return a[0] == b[0]? a[1] - b[1]: b[0] - a[0];
    }
}

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        List<People> peopleList = new ArrayList<People>();
        Arrays.sort(people, new PeopleComparator());
        for (int i = 0; i < people.length; i++) {
            peopleList.add(people[i][1], new People(people[i][0], people[i][1]));
        }
        int i = 0;
        for (People person: peopleList) {
            result[i][0] = person.h;
            result[i][1] = person.k;
            i++;
        }

        return result;
    }
}