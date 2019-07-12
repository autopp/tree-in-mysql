package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SampleTest {
    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        assertThat(1 + 1, is(2));
    }
}
