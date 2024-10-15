package ic.yao.pets

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import ic.yao.pets.data.DataProvider
import ic.yao.pets.presentation.PetsApp
import ic.yao.pets.ui.theme.PetsTheme
import kotlin.properties.Delegates

// TODO: 1. Create the PetDetail view
class MainActivity : ComponentActivity() {
    private val petList = mutableStateOf(DataProvider.petList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsTheme {
                PetsApp(
                    petList = petList.value ,
                    onPetClick = {  },
                    onShuffle = { petList.value = petList.value.shuffled() }
                )
            }
        }
    }
}

