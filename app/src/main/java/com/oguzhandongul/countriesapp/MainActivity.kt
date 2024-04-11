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
import com.oguzhandongul.countriesapp.profile.data.model.Experience
import com.oguzhandongul.countriesapp.profile.data.model.ProfileData
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
                        ProfileScreen()

                        Button(onClick = {  }, Modifier.fillMaxWidth().padding(Dimensions.medium)) {
                            Text(text = "Go to Countries")
                        }
                    }

                }
            }

        }
    }

}
