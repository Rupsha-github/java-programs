import java.util.*;
class Data {
    String name;
    int roll;
    Data(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
    @Override
    public String toString() {
        return "{Name : '" + this.name + "' , Roll : " + this.roll + "} ";
    }
}
class JCF {
    public static void main(String args[]) {
        System.out.println("ArrayList");
        ArrayList<Integer> list = new ArrayList<>();    //can insert/delete elements from only one end
        list.add(30);
        list.add(45);
        list.add(0,15);
        list.add(60);
        list.addFirst(0);
        list.addLast(75);
        System.out.println("SIZE = " + list.size());
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.contains(45));
        System.out.println("------------------------");
        ArrayList<Data> list1 = new ArrayList<>();
        list1.add(new Data("Rupsha", 99));
        list1.add(new Data("Shilpa", 30));
        list1.add(new Data("Anonoymous", 55));
        System.out.println("SIZE = " + list1.size());
        System.out.println(list1);
        System.out.println(list1.isEmpty());
        System.out.println(list1.get(2));
        System.out.println("------------------------");
        System.out.println("Linked List");
        LinkedList<Integer> ll = new LinkedList<>();    //Operations can be performed on both ends
        ll.add(18);
        ll.addFirst(0);
        ll.add(1,6);
        ll.add(2,12);
        System.out.println(ll.size());
        System.out.println(ll);
        System.out.println(ll.get(3));
        System.out.println(ll.isEmpty());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll);
        System.out.println("------------------------");
        System.out.println("Stack");
        Stack<Integer> st = new Stack<>();   //LIFO with operations performed only on one end
        st.push(4);
        st.push(6);
        st.push(8);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println("------------------------");
        System.out.println("HashSet");
        HashSet<Integer> hs = new HashSet<>();   //stores unique elements in random order
        hs.add(1);  //O(1)
        hs.add(0);  //O(1)
        hs.add(1);  //O(1)
        hs.add(2);  //O(1)
        hs.add(-5);  //O(1)
        System.out.println(hs);
        hs.remove(0);  //O(1)
        System.out.println(hs);
        for(Integer ele : hs)   //for each loop
        System.out.println(ele);
        System.out.println("------------------------");
        System.out.println("Tree Set");
        TreeSet<Integer> ts = new TreeSet<>();   //stores unique elements in sorted order
        ts.add(1);  //O(log N)
        ts.add(0);  //O(log N)
        ts.add(1);  //O(log N)
        ts.add(2);  //O(log N)
        ts.add(-5);  //O(log N)
        ts.add(7);  //O(log N)
        ts.add(9);  //O(log N)
        ts.add(11);  //O(log N)
        System.out.println(ts);
        ts.remove(0);  //O(log N)
        System.out.println(ts);
        for(Integer ele : ts)   //for each loop
        System.out.println(ele);
        System.out.println(ts.floor(8));   //element just lesser than or equal to 8 in ts
        System.out.println(ts.ceiling(8));  //element just greater than or equal to 8 in ts
        //QUEUE
        //Insertions are done from the rear end and deletions are done from the front end
        System.out.println("------------------------");
        System.out.println("Array Deque");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(1);
        ad.offer(6);
        ad.offer(2);
        System.out.println(ad);
        System.out.println(ad.peek());  //FIFO
        System.out.println(ad.poll()); //deletion
        System.out.println(ad);
        //there are other fnx like peekFirst(), peekLast(), pollFirst(), pollLast()
        //Priority Queue
        //Internally implemented as min heap [DUPLICATES ARE ALLOWED HERE]
        //so for every peek() call, it returns the smallest element currently existing in the list
        System.out.println("------------------------");
        System.out.println("Priority Queue");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(0);
        pq.offer(5);
        pq.offer(4);
        System.out.println(pq);
        System.out.println(pq.peek()); //returns smallest element
        System.out.println(pq.poll());  //deletes smallest element
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq);
        pq.offer(1);
        pq.offer(0);
        pq.offer(5);
        pq.offer(4);
        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.poll();
        }
        //MAPS   -    DOESN'T STORE DUPLICATES  [HashMap, TreeMap]
        //HASHMAP  -  Stores key, value pairs in random order and the list will not be sorted based on keys
        System.out.println("------------------------");
        System.out.println("HashMap");
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "Raj");
        hmap.put(2, "Piyush");
        hmap.put(7, "Rajesh");
        System.out.println(hmap);
        System.out.println(hmap.size());
        System.out.println(hmap.remove(7));//returns only the value associated with the key which we wish to delete along with its value
        System.out.println(hmap);
        System.out.println(hmap.get(2)); //returns value associated with the key we passed
        System.out.println(hmap.get(4)); //if key is invalid the null is returned
        //HASHMAP  -  Stores key, value pairs in sorted order and the list will be sorted based on keys
        System.out.println("------------------------");
        System.out.println("TreeMap");
        TreeMap<Integer, String> tmap = new TreeMap<>();
        tmap.put(1, "Raj");
        tmap.put(2, "Piyush");
        tmap.put(7, "Rajesh");
        System.out.println(tmap);
        System.out.println(tmap.size());
        System.out.println(tmap.remove(7));//returns only the value associated with the key which we wish to delete along with its value
        System.out.println(tmap);
        System.out.println(tmap.get(2)); //returns value associated with the key we passed
        System.out.println(tmap.get(4)); //if key is invalid the null is returned 
        tmap.put(4, "Shreya");
        tmap.put(5, "Sanjana");
        tmap.put(6, "Rajendra");
        System.out.println(tmap.ceilingKey(3)); //returns key just >= the key passed
        System.out.println(tmap.floorKey(3)); //returns key just <= the key passed
        Set<Integer> keySet = tmap.keySet();
        System.out.println(keySet);
        //ITERATOR
        System.out.println("------------------------");
        System.out.println("Iterator");
        ArrayList<Integer> al =  new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(8);
        al.add(6);
        Iterator<Integer> it = al.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        //Collections interface popular algorithms or functions
        System.out.println("------------------------");
        Collections.sort(al);  //doesn't return anything so can't be written inside sopln
        System.out.println(al);
        System.out.println(Collections.max(al));
        System.out.println(Collections.min(al));
        Collections.reverse(al); //doesn't return anything so can't be written inside sopln
        System.out.println(al);
        int arr[] = {2, 0, 14, 52, 8};
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i] + " ");
        System.out.println("\n"+Collections.frequency(al, 5));
        System.out.println(Collections.frequency(al, 8));
        System.out.println(Collections.binarySearch(al, 2));
        //CUSTOM  COMPARATOR
        System.out.println("------------------------");
        System.out.println("Custom comparator");
        ArrayList<Integer> arl =  new ArrayList<>();
        arl.add(2);
        arl.add(1);
        arl.add(8);
        arl.add(6);
        to sort in descending order
        Collections.sort(arl, new Comparator<Integer>()  {
            @Override
            public int compare(Integer num1, Integer num2) {
                if(num1 < num2)
                return 1;
                else if(num1 > num2)
                return -1;
                else
                return 0;
            }
        });
        System.out.println(arl);
        //We may also write a LAMBDA FUNCTION for the same
        System.out.println("------------------------");
        System.out.println("Lambda function");
        Collections.sort(arl, (num1, num2) -> num2 - num1);   //to sort in ascending order write `num1 - num2`
        System.out.println(arl);        
    }
}