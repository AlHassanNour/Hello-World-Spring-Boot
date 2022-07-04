package de.htwberlin.webtech.Service;
import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.Gender;
import de.htwberlin.webtech.service.ContactTransformer;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;
public class ContactTransformTest implements WithAssertions {
    private final ContactTransformer underTest = new ContactTransformer();

    @Test
    @DisplayName("should transform ContactEntity to Contact")
    void should_transform_contact_entity_to_contact() {
        // given

        var contactEntity = Mockito.mock(ContactEntity.class);
        doReturn(112).when(contactEntity).getId();
        doReturn("Nour").when(contactEntity).getFirstName();
        doReturn("Al Hassan").when(contactEntity).getSecondName();
        doReturn("Student").when(contactEntity).getWork();
        doReturn("018739394").when(contactEntity).getPhone();
        doReturn("nour@gmail.com").when(contactEntity).getEmail();
        doReturn(Gender.FEMALE).when(contactEntity).getGender();

        // when
        var result = underTest.transformEntity(contactEntity);

        // then

        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFirstName()).isEqualTo("Nour");
        assertThat(result.getSecondName()).isEqualTo("Al Hassan");
        assertThat(result.getWork()).isEqualTo("Student");
        assertThat(result.getPhone()).isEqualTo("018739394");
        assertThat(result.getEmail()).isEqualTo("nour@gmail.com");
        assertThat(result.getGender()).isEqualTo("FEMALE");
    }
}
