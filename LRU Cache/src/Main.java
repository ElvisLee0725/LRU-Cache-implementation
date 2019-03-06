
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache<Integer, String> lru = new LRUCache<Integer, String>(3);
		System.out.println(lru.getSize());
		lru.set(1, "Albert");
		lru.set(2, "Bill");
		lru.set(3, "Clay");
		lru.printAll();
		System.out.println(lru.get(2));
		lru.printAll();
		System.out.println(lru.get(4));
		System.out.println(lru.get(3));
		System.out.println(lru.getSize());
		lru.printAll();
	}
}
