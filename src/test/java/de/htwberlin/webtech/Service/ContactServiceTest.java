package de.htwberlin.webtech.Service;

import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.service.ContactService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)

class ContactServiceTest implements WithAssertions {

    @Mock
    private ContactRepository repository;

    @InjectMocks
    private ContactService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        int givenId = 111;
        doReturn(true).when(repository).existsById(givenId);
        // when
        boolean result = underTest.deleteById(givenId);
        // then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if contact does not exist")
    void should_return_true_if_contact_does_not_exist() {
        // given
        int givenId = 111;
        doReturn(false).when(repository).existsById(givenId);
        // when
        boolean result = underTest.deleteById(givenId);
        // then
        verify(repository).deleteById(givenId);
        assertThat(result).isFalse();

    }
}
