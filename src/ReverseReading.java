public class ReverseReading {
    private String str;
    private MyStack<Character> stack;

    public ReverseReading(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String str is null");
        }
        this.str = str;
        stack = new MyStack<>(str.length());
        fill();
    }

    private void fill() {
        int i = 0;
        while (i < str.length()){
            stack.push(str.charAt(i));
            i++;
        }
    }
    void reverse() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

}
