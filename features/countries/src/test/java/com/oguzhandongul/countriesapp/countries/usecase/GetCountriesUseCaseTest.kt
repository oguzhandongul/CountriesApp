package com.oguzhandongul.countriesapp.countries.usecase

import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import com.oguzhandongul.countriesapp.countries.domain.usecase.GetCountriesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class GetCountriesUseCaseTest {

    @Mock
    private lateinit var countriesRepository: CountriesRepository

    private lateinit var getCountriesUseCase: GetCountriesUseCase

    @Before
    fun setUp() {
        getCountriesUseCase = GetCountriesUseCase(countriesRepository)
    }

    @Test
    fun `invoke success`() = runBlocking {
        // Mock the repository behavior
        val mockCountries = listOf("Germany", "UK", "France")
        doReturn(Result.success(mockCountries)).whenever(countriesRepository).getCountries()

        // Invoke the use case
        val result = getCountriesUseCase()

        // Assert the result
        Assert.assertTrue(result.isSuccess)
        Assert.assertEquals(mockCountries, result.getOrNull())
    }

    @Test
    fun `invoke failure`() = runBlocking {
        // Mock repository failure
        val exception = Exception("Repository Error")
        doReturn(Result.failure<List<String>>(exception)).whenever(countriesRepository)
            .getCountries()

        // Invoke the use case
        val result = getCountriesUseCase()

        // Assert the result
        Assert.assertTrue(result.isFailure)
        // You could optionally assert the specific exception
    }
}