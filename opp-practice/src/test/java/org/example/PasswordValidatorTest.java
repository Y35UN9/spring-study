package org.example;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * - 비밀번호는 최소 8자 12자 이하
 * - 비밀번호가 미만 또는 초과인 경우 lllegalArgumentException 예외를 발생시킴
 * - 경계조건에 대해 테스트 코드를 작성
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 8자 이상, 12자 이하면 예외가 발생하지 않음")
    @Test
    void validatorPasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 ILLegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
