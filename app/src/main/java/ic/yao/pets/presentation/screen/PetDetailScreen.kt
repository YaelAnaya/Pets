package ic.yao.pets.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ic.yao.pets.data.DataProvider
import ic.yao.pets.data.Pet
import ic.yao.pets.presentation.TopAppBar
import ic.yao.pets.ui.theme.PetsTheme

@Composable
fun PetDetailScreen(
    modifier: Modifier = Modifier,
    pet: Pet
) {
    PetDetailContent(pet = pet)
}

@Composable
fun PetDetailContent(
    modifier: Modifier = Modifier,
    pet: Pet
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = modifier
                .size(130.dp)
                .clip(shape = CircleShape),
            painter = painterResource(id = pet.drawableId),
            contentDescription = "Pet cover image",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = pet.name,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Age: ${pet.age}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = modifier.padding(15.dp),
            text = pet.description,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
fun PetDetailPreview() {
    val pet = DataProvider.petList.random()
    PetsTheme {
        PetDetailScreen(pet = pet)
    }
}