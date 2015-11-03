import java.util.HashMap;

// The Key and Value of the LRUCache can be any type, ex: <1, "Jack"> <2, "Louis"> <3, "Kevin"> etc.
// Create a Doubly Linked List for O(1) insert & remove
// We need a HashMap to record nodes in the Doubly Linked List
public class LRUCache<K, V> {
	private int size;
	private int capacity;
	private HashMap<K, Node<K, V>> map;
	private Node<K, V> head;
	private Node<K, V> tail;
	public LRUCache(int limit) {
		this.capacity = limit;
		this.map = new HashMap<K, Node<K, V>>();
	}
	static class Node<K, V> {
		K key;
		V val;
		Node<K, V> prev;
		Node<K, V> next;
		public Node(K k, V val) {
			this.key = k;
			this.val = val;
		}
	}
	public void set(K key, V value) {
		Node<K, V> node = null;
		if(map.containsKey(key)) {
			node = map.get(key);
			remove(node);
			node.val = value;
		}
		else if(size == capacity) {
			remove(tail);
			node = new Node<K, V>(key, value);
		}
		else {
			node = new Node<K, V>(key, value);
		}
		insert(node);
	}
	public V get(K key) {
		if(!map.containsKey(key)) {
			return null;
		}
		Node<K, V> node = map.get(key);
		remove(node);
		insert(node);
		return node.val;
	}
	public void remove(Node<K, V> node) {
		if(node.prev != null) {
			node.next.prev = node.prev;
		}
		if(node.next != null) {
			node.prev.next = node.next;
		}
		if(node == head) {
			head = head.next;
		}
		if(node == tail) {
			tail = tail.prev;
		}
		node.prev = null;
		node.next = null;
		map.remove(node.key);
		size--;
	}
	public void insert(Node<K, V> node) {
		// For the very first time
		if(head == null) {
			head = node;
		}
		else {
			head.prev = node;
			node.next = head;
			head = node;
		}
		map.put(node.key, node);
		size++;
	}
	public void printAll() {
		Node<K, V> cur = head;
		if(cur == null) {
			return ;
		}
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
