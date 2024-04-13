package com.oguzhandongul.countriesapp.countries.viewmodel

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.countries.domain.usecase.GetCountriesUseCase
import com.oguzhandongul.countriesapp.countries.presentation.viewmodel.CountriesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CountriesViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)
    private lateinit var viewModel: CountriesViewModel
    private val resourceHelper: ResourceHelper = mock()
    private val getCountriesUseCase: GetCountriesUseCase = mock()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = CountriesViewModel(resourceHelper, getCountriesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }


//    @Test
//    fun `loadCountriesData emits Success state when data is successfully loaded`() = runTest {
//        // Arrange
//        val countriesList = listOf("USA", "Canada", "UK")
//        whenever(getCountriesUseCase()).thenReturn(Result.success(countriesList))
//
//        // Act
//        viewModel.loadCountriesData()
//        val state = viewModel.uiState.value
//
//        // Assert
//        assertTrue(state is CountriesUiState.Success)
//        assertEquals(countriesList, (state as CountriesUiState.Success).countryList)
//    }

}