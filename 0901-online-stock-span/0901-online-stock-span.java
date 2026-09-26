class Pair{
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}
class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;

        while(!st.isEmpty() && st.peek().price <= price) {
            cnt += st.peek().span;
            st.pop();
        }
        st.push(new Pair(price, cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */