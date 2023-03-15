import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week9.Main;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class AnnotationTest {

    @Test
    @DisplayName("Проверка минимального значения 1")
    public void checkOne() {
        int result = Main.countedNumber(1);
        assertThat(Main.countedNumber(1))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка значения 10")
    public void checkTen() {
        int result = Main.countedNumber(10);
        assertThat(Main.countedNumber(10))
                .isEqualTo(55);
    }

    @Test
    @DisplayName("Проверка максимального(очень большого) значения 9999")
    public void checkMany() {
        int result = Main.countedNumber(9999);
        assertThat(Main.countedNumber(9999))
                .isEqualTo(49995000);
    }

    @Test
    @DisplayName("Проверка  значения 0")
    public void checkZero() {
           assertThatThrownBy(() -> {
               Main.verificatedNumber("0");
           })
                .isInstanceOf(RuntimeException.class)
                   .hasMessage(Main.errorMessage);
    }

    @Test
    @DisplayName("Проверка  значения -1")
    public void checkMinus() {
        assertThatThrownBy(() -> {
            Main.verificatedNumber("-1");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Main.errorMessage);
    }
    @Test
    @DisplayName("Проверка дробного числа")
    public void checkFloat() {
        assertThatThrownBy(() -> {
            Main.verificatedNumber("5.5");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Main.errorMessage);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    public void checkNull() {
        assertThatThrownBy(() -> {
            Main.verificatedNumber("");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Main.errorMessage);
    }

    @Test
    @DisplayName("Проверка ввода текста")
    public void checkString() {
        assertThatThrownBy(() -> {
            Main.verificatedNumber("Шесть");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Main.errorMessage);
    }

    @Test
    @DisplayName("Проверка символа")
    public void checkSymbol() {
        assertThatThrownBy(() -> {
            Main.verificatedNumber("$");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Main.errorMessage);
    }
}
