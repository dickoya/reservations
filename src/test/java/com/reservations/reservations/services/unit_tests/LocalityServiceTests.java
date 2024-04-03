package com.reservations.reservations.services.unit_tests;

import com.reservations.reservations.exceptions.GeneralException;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.repositories.LocalityRepository;
import com.reservations.reservations.services.LocalityServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocalityServiceTests {

    @InjectMocks
    private LocalityServices localityServices;

    @Mock
    private LocalityRepository localityRepository;

    @Test
    public void testCreateLocality_whenAllInformationAreCorrect_thenALocalityIsCreatedSuccessfully() throws Exception{
        Locality locality = new Locality(1L,"BP110-Dschang", "Dschang");
        when(localityRepository.save(Mockito.any(Locality.class)))
                .thenReturn(new Locality(1L, locality.getPostalCode(), locality.getLocality()));
        when(localityRepository.existsByLocality(locality.getLocality())).thenReturn(false);
        Locality localityCreated = localityServices.save(locality);
        Assertions.assertNotNull(localityCreated);
        Assertions.assertNotNull(localityCreated.getId());
        Assertions.assertEquals(1L, localityCreated.getId());
        Assertions.assertEquals(localityCreated.getPostalCode(), localityCreated.getPostalCode());
        Assertions.assertEquals(localityCreated.getLocality(), localityCreated.getLocality());
        verify(this.localityRepository, times(1)).save(Mockito.any(Locality.class));
        verify(this.localityRepository, times(1))
                .existsByLocality(locality.getLocality());
    }

    @Test
    public void testCreateLocality_whenThereIsAnExistingLocalityWithTheSameLocality_thenThrowGeneralException()
        throws Exception{
        Locality locality = new Locality(1L,"BP110-Dschang", "Dschang");
        when(localityRepository.existsByLocality(locality.getLocality())).thenReturn(true);
        GeneralException exception = Assertions.assertThrows(GeneralException.class,
                () -> localityServices.save(locality));
        Assertions.assertEquals("Locality already exist in database", exception.getMessage());
    }

    @Test
    public void testCreateLocality_whenLocalityIsBlank_thenThrowGeneralException() throws Exception {
        Locality locality = new Locality(1L,"BP110-Dschang", "");
        GeneralException fstException = Assertions.assertThrows(GeneralException.class,
                () -> localityServices.save(locality));
        Assertions.assertEquals("Locality name is mandatory", fstException.getMessage());
        locality.setLocality(null);
        GeneralException sndException = Assertions.assertThrows(GeneralException.class,
                () -> localityServices.save(locality));
        Assertions.assertEquals("Locality name is mandatory", sndException.getMessage());
    }


    @Test
    public void testUpdateLocality_Success() throws GeneralException {

        Locality existingLocality = new Locality(1L, "BP110-Dschang", "Dschang");
        Locality updatedLocality = new Locality(1L, "BP111-Dschang", "Dschang");

        when(localityRepository.findById(existingLocality.getId())).thenReturn(Optional.of(existingLocality));
        when(localityRepository.findByLocality(updatedLocality.getLocality())).thenReturn(null);
        when(localityRepository.save(any(Locality.class))).thenReturn(updatedLocality);

        Locality result = localityServices.update(updatedLocality);

        Assertions.assertEquals(updatedLocality.getLocality(), result.getLocality());
        Assertions.assertEquals(updatedLocality.getPostalCode(), result.getPostalCode());

        verify(localityRepository, times(1)).findById(existingLocality.getId());
        verify(localityRepository, times(1)).findByLocality(updatedLocality.getLocality());
        verify(localityRepository, times(1)).save(any(Locality.class));
    }

    @Test
    public void testUpdateLocality_LocalityNotFound() {
        Locality localityToUpdate = new Locality(1L, "BP110-Dschang", "Dschang");

        when(localityRepository.findById(localityToUpdate.getId())).thenReturn(Optional.empty());

        Assertions.assertThrows(GeneralException.class, () -> localityServices.update(localityToUpdate));

        verify(localityRepository, times(1)).findById(localityToUpdate.getId());
        verify(localityRepository, never()).findByLocality(anyString());
        verify(localityRepository, never()).save(any(Locality.class));
    }

    @Test
    public void testUpdateLocality_NameConflict() {
        Locality existingLocality1 = new Locality(1L, "BP110-Dschang", "Dschang");
        Locality existingLocality2 = new Locality(2L, "BP111-Dschang", "Dschang");
        Locality localityToUpdate = new Locality(3L, "BP112-Dschang", "Dschang");

        when(localityRepository.findById(localityToUpdate.getId())).thenReturn(Optional.of(existingLocality1));
        when(localityRepository.findByLocality(localityToUpdate.getLocality())).thenReturn(existingLocality2);

        Assertions.assertThrows(GeneralException.class, () -> localityServices.update(localityToUpdate));

        verify(localityRepository, times(1)).findById(localityToUpdate.getId());
        verify(localityRepository, times(1)).findByLocality(localityToUpdate.getLocality());
        verify(localityRepository, never()).save(any(Locality.class));
    }

    @Test
    public void testGetById_whenBlogCategoryExists_thenReturnBlogCategoryDTO() throws GeneralException {
        Long localityId = 1L;
        Locality locality = new Locality(localityId, "BP110-Dschang", "Dschang");
        when(localityRepository.findById(localityId))
                .thenReturn(java.util.Optional.of(locality));

        Locality result = localityServices.findById(localityId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(localityId, result.getId());
        Assertions.assertEquals(locality.getLocality(), result.getLocality());
        Assertions.assertEquals(locality.getPostalCode(), result.getPostalCode());

        verify(localityRepository, times(1)).findById(localityId);
    }

    @Test
    public void testFindById_LocalityNotFound() {
        when(localityRepository.findById(anyLong())).thenReturn(Optional.empty());

        Locality result = localityServices.findById(999L);

        Assertions.assertNull(result);

        verify(localityRepository, times(1)).findById(999L);
    }

    @Test
    public void testFindAll() {
        List<Locality> localityList = Arrays.asList(
                new Locality(1L, "Paris", "75000"),
                new Locality(2L, "Marseille", "13000"),
                new Locality(3L, "Lyon", "69000")
        );

        when(localityRepository.findAll()).thenReturn(localityList);
        Iterable<Locality> result = localityServices.findAll();
        Assertions.assertEquals(localityList, result);
        verify(localityRepository, times(1)).findAll();
    }

    @Test
    public void testDelete_LocalityExists() throws GeneralException {
        Long existingLocalityId = 1L;
        when(localityRepository.existsById(existingLocalityId)).thenReturn(true);
        localityServices.delete(existingLocalityId);
        verify(localityRepository, times(1)).deleteById(existingLocalityId);
    }

    @Test
    public void testDelete_LocalityNotFound() {
        Long nonExistingLocalityId = 999L;
        when(localityRepository.existsById(nonExistingLocalityId)).thenReturn(false);
        Assertions.assertThrows(GeneralException.class, () -> {
            localityServices.delete(nonExistingLocalityId);
        });
    }

}
