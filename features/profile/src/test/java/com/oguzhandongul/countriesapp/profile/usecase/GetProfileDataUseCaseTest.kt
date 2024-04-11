package com.oguzhandongul.countriesapp.profile.usecase

import com.oguzhandongul.countriesapp.profile.data.DataProvider.getProfileData
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import com.oguzhandongul.countriesapp.profile.domain.usecase.GetProfileDataUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetProfileDataUseCaseTest {

    private val profileRepository: ProfileRepository = mock()
    private val useCase = GetProfileDataUseCase(profileRepository)

    @Test
    fun `should call repository and return profile data on success`() = runTest {
        // Setup
        val mockProfileData = getProfileData() // Sample profile data
        whenever(profileRepository.getProfileData()).thenReturn(Result.success(mockProfileData))

        // Execute
        val result = useCase()

        // Verify
        verify(profileRepository).getProfileData() // Check repository was called
        assert(result.getOrNull() == mockProfileData) // Check the returned result
    }


    @Test(expected = Exception::class) // Unit test expects an exception
    fun `should throw error when repository fails`() = runTest {
        // Setup
        whenever(profileRepository.getProfileData()).thenThrow(Exception("Repository Error"))

        // Execute
        useCase()
    }

}