public class FizzBuzz {
    public String evaluate(int i) {
        if (i % 15 == 0 || (contains(i, "3") && contains(i, "5"))) {
            return "FizzBuzz";
        }

        if (i % 3 == 0 || contains(i, "3")) {
            return "Fizz";
        }

        if (i % 5 == 0 || contains(i, "5")) {
            return "Buzz";
        }

        return String.valueOf(i);
    }

    private boolean contains(int i, String number) {
        return Integer.toString(i).contains(number);
    }
}
