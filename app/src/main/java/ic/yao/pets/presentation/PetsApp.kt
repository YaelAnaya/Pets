package ic.yao.pets.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ic.yao.pets.data.Pet

@Composable
fun PetsApp(
    modifier: Modifier = Modifier,
    petList: List<Pet>,
    onPetClick: (Int) -> Unit,
    onShuffle: () -> Unit
){
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = "Pets",
                onAction = { onShuffle() }
            )
        },
    ) { innerPadding ->
        PetList(
            modifier = Modifier.padding(innerPadding),
            petList = petList,
            onPetClick = onPetClick
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetList(
    modifier: Modifier = Modifier,
    petList: List<Pet>,
    onPetClick: (Int) -> Unit,
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        items(
            items = petList,
            key = { pet -> pet.id }
        ){ pet ->
            PetItem(
                pet = pet,
                onPetClick = onPetClick
            )
        }
    }
}

@Composable
fun PetItem(
    modifier: Modifier = Modifier,
    pet: Pet,
    onPetClick: (Int) -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onPetClick(pet.id) }
            .padding(vertical = 12.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Image(
            modifier = modifier
                .size(95.dp)
                .clip(CircleShape),
            painter = painterResource(id = pet.drawableId),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Column(
            modifier= modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Age: ${pet.age}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onAction: () -> Unit = {},
    onBack: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = { Text(text = title, style = MaterialTheme.typography.headlineMedium)},
        actions = {
            IconButton(onClick = { onAction()}) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
            }
        },
        navigationIcon = {
            IconButton(onClick = { onBack()}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}