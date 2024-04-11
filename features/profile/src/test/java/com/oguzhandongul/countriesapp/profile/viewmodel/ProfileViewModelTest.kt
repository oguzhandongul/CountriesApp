package com.oguzhandongul.countriesapp.profile.viewmodel

import com.oguzhandongul.countriesapp.profile.data.DataProvider
import com.oguzhandongul.countriesapp.profile.domain.usecase.GetProfileDataUseCase
import com.oguzhandongul.countriesapp.profile.presentation.states.ProfileUiState
import com.oguzhandongul.countriesapp.profile.presentation.viewmodel.ProfileViewModel
import com.oguzhandongul.countriesapp.profile.usecase.GetProfileDataUseCaseTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class ProfileViewModelTest {
    @Mock
    lateinit var profileDataUseCase: GetProfileDataUseCase

    private lateinit var profileViewModel: ProfileViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        profileViewModel = ProfileViewModel(profileDataUseCase)
    }

    @Test
    fun `loading state is emitted when data is fetched`() = testScope.runBlockingTest {
        // Setup (mock data or use case behavior)

        // Execute
        profileViewModel.loadProfileData()

        // Assert
        advanceUntilIdle() // Advance time if needed
        assertEquals(profileViewModel.uiState.value, ProfileUiState.Loading)
    }

    @Test
    fun `success state is emitted with profile data`() = testScope.runBlockingTest  {
        // Setup
        val mockProfileData = DataProvider.getProfileData()
        whenever(profileDataUseCase.invoke()).thenReturn(Result.success(mockProfileData))

        // Execute
        profileViewModel.loadProfileData()

        // Assert
        advanceUntilIdle()
        assertEquals(profileViewModel.uiState.value, ProfileUiState.Success(mockProfileData))
    }

}