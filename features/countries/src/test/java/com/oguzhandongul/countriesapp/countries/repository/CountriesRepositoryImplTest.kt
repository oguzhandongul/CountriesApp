package com.oguzhandongul.countriesapp.countries.repository

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.data.remote.ApiService
import com.oguzhandongul.countriesapp.countries.data.repository.CountriesRepositoryImpl
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CountriesRepositoryImplTest {

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var resourceHelper: ResourceHelper

    private lateinit var countriesRepository: CountriesRepository

    @Before
    fun setUp() {
        countriesRepository = CountriesRepositoryImpl(apiService, resourceHelper)
    }

    @Test
    fun getCountries_success() = runBlocking {
        // Mock the behavior of resourceHelper
        doReturn(listOf("Germany", "Spain", "Italy")).whenever(resourceHelper)
            .getStringArray(R.array.countries_array)

        // Call the function under test
        val result = countriesRepository.getCountries()

        // Assert the expected outcome
        Assert.assertTrue(result.isSuccess)
        Assert.assertEquals(listOf("Germany", "Spain", "Italy"), result.getOrNull())
    }

    @Test
    fun getCountries_fail() = runBlocking {
        // Mock the behavior of resourceHelper
        doReturn(listOf("Germany", "Spain")).whenever(resourceHelper)
            .getStringArray(R.array.countries_array)

        // Call the function under test
        val result = countriesRepository.getCountries()

        // Assert the expected outcome
        Assert.assertTrue(result.isSuccess)
        Assert.assertNotEquals(listOf("Germany", "Spain", "Italy"), result.getOrNull())
    }

}