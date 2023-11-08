package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개를 입력하셔야 합니다.");
        }
        if (hasSameNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에는 중복되지 않는 6개를 입력하셔야 합니다.");
        }
        if (!areInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    private boolean hasSameNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean areInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                return false;
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
