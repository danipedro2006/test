package main.advanced.lambda;

public class Sum implements Operation<Integer> {

    @Override
    public Integer operate(Integer first, Integer last) {
        return first + last;
    }
}
