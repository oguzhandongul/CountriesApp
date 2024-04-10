package com.oguzhandongul.countriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTheme
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.profile.data.Experience
import com.oguzhandongul.countriesapp.profile.data.ProfileData
import com.oguzhandongul.countriesapp.profile.presentation.ui.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TODO add AppNavigation()
            CountriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        ProfileScreen(profileData = getProfileData())

                        Button(onClick = {  }, Modifier.fillMaxWidth().padding(Dimensions.medium)) {
                            Text(text = "Go to Countries")
                        }
                    }

                }
            }

        }
    }

    fun getProfileData(): ProfileData {
        return ProfileData(
            name = "Oguzhan Dongul",
            profileImage = "",
            summary = "Senior Mobile Engineer with a decade of expertise in Native Android development, specializing in Java and Kotlin, as well as proficiency in iOS development, UI&UX design and Automation projects. Recognized as a top 5% contributor on StackOverflow.com with an impressive reputation score of 8,000.\n" +
                    "Notable achievements include earning the \"Top Developer\" badge and having a project featured in \"The Best Applications of 2015\" on Google Play. Earned a BS degree from Bilkent University in 2014, securing two prestigious accolades: the Best Senior Project Award and the Best Intern Award. Senior project focused on developing an advanced mobile and web-based communication and management system for hotels and their customers.\n" +
                    "In addition to professional experience, I actively develop and contribute to open-source Android libraries, fostering innovation and collaboration within the developer community.",
            education = listOf(
                Experience(
                    title = "Edu 1",
                    organization = "Org 1",
                    duration = "5 years"
                )
            ),
            experience = listOf(
                Experience(
                    title = "Exp 1",
                    organization = "Exp 2",
                    duration = "3 years"
                )
            )
        )
    }

}
