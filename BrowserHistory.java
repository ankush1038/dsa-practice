class BrowserHistory {

    private class Node{
        Node prev,next;
        String url;
        Node(String url){
            this.url=url;
        }
    }

    private Node currentNode;
    public BrowserHistory(String homepage) {
        currentNode =new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        currentNode.next=null;
        newNode.prev= currentNode;
        currentNode.next=newNode;
        currentNode =newNode;
    }

    public String back(int steps) {
        while(steps-- > 0 && currentNode.prev!=null){
            currentNode = currentNode.prev;
        }
        return currentNode.url;
    }

    public String forward(int steps) {
        while(steps-- > 0 && currentNode.next!=null){
            currentNode = currentNode.next;
        }
        return currentNode.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */