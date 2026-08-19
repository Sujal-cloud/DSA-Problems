class Node{
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    Node currentPage = null;
    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = newPage;
    }
    
    public String back(int steps) {
        while(steps != 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
            steps--;
        }
        return currentPage.data;
    }
    
    public String forward(int steps) {
        while(steps != 0 && currentPage.next != null) {
            currentPage = currentPage.next;
            steps--;
        }
        return currentPage.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */