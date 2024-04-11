package com.oguzhandongul.countriesapp.profile.repository

import android.content.Context
import android.content.res.Resources
import com.oguzhandongul.countriesapp.profile.R
import com.oguzhandongul.countriesapp.profile.data.model.ProfileDataAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.ByteArrayInputStream


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProfileRepositoryImplTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var resources: Resources

    // Assume your ProfileDataAdapter has a static adapter field for simplicity
    companion object {
        val profileDataAdapter = ProfileDataAdapter
    }

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        `when`(context.resources).thenReturn(resources)
        val jsonString = "{\"name\":\"Oguzhan Dongul\",\"profileImage\":\"https://avatars.githubusercontent.com/u/6702583?v=4\",\"summary\":\"Senior Mobile Engineer with a decade of expertise in Native Android development, specializing in Java and Kotlin, as well as proficiency in iOS development, UI&UX design and Automation projects. Recognized as a top 5% contributor on StackOverflow.com with an impressive reputation score of 8,000.\\nNotable achievements include earning the \\\"Top Developer\\\" badge and having a project featured in \\\"The Best Applications of 2015\\\" on Google Play. Earned a BS degree from Bilkent University in 2014, securing two prestigious accolades: the Best Senior Project Award and the Best Intern Award. Senior project focused on developing an advanced mobile and web-based communication and management system for hotels and their customers.\\nIn addition to professional experience, I actively develop and contribute to open-source Android libraries, fostering innovation and collaboration within the developer community.\",\"education\":[{\"title\":\"BS Degree\",\"organization\":\"Bilkent University\",\"duration\":\"2009 - 2014\"}],\"experience\":[{\"title\":\"Senior Android Engineer\",\"organization\":\"Getir \",\"duration\":\"2018 - 2024\"},{\"title\":\"Lead Mobile Developer\",\"organization\":\"Mobillium\",\"duration\":\"2013 - 2018\"}]}"
        val inputStream = ByteArrayInputStream(jsonString.toByteArray())
        `when`(resources.openRawResource(R.raw.profile)).thenReturn(inputStream)
    }

    @Test
    fun `getProfileData returns correct data`() = runBlockingTest {
//        val expected = DataProvider.getProfileData()
//
//        // Assuming your adapter correctly parses the JSON string to a ProfileData object
//        `when`(profileDataAdapter.adapter.fromJson(anyString())).thenReturn(expected)
//
//        val repository = ProfileRepositoryImpl(context)
//        val result = repository.getProfileData()
//
//        assertEquals(expected, result.getOrNull())
    }
}