package miscel;

import java.util.HashMap;

public class LRUCache {
  private int capacity;
  private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public Integer get(int key) {
    if (map.containsKey(key)) {
      increasePriority(key);
      return map.get(key).value;
    }
    return null;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      increasePriority(key);
      map.get(key).value = value;
    } else {
      Node newNode = new Node(key, value);
      if (head == null) {
        head = newNode;
        tail = head;
      } else {
        head.previous = newNode;
        newNode.next = head;
        if (head == tail) {
          tail = newNode.next;
        }
        head = newNode;
      }
      map.put(key, newNode);
    }
    if (map.size() > capacity) {
      removeExcessiveValue();
    }
  }

  private void removeExcessiveValue() {
    int keyToRemove = tail.key;
    if (tail.hasPrevious()) {
      tail = tail.previous;
      tail.next = null;
    }
    map.remove(keyToRemove);
    if (map.size() == 0) {
      head = null;
      tail = null;
    }
  }

  private void increasePriority(int key) {
    Node priorityNode = map.get(key);
    if (priorityNode != head) {
      if (priorityNode.previous != null && priorityNode.next != null) {
        priorityNode.previous.next = priorityNode.next;
        priorityNode.next.previous = priorityNode.previous;
      } else {
        tail = priorityNode.previous;
        tail.next = null;
      }
      head.previous = priorityNode;
      priorityNode.next = head;
      head = priorityNode;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("");
    if (head != null) {
      Node node = head;
      result.append(node.key + ":" + node.value + ", ");
      while (node.hasNext()) {
        node = node.next;
        result.append(node.key + ":" + node.value + ", ");
      }
    }
    return result.toString();
  }

  private class Node {
    final int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public boolean hasNext() {
      return (next != null);
    }

    public boolean hasPrevious() {
      return (previous != null);
    }
  }
}