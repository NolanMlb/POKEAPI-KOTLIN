import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nextu.pokedex.R
import com.nextu.pokedex.model.pokemon.PokemonSummary
import com.nextu.pokedex.ui.theme.NextU_android_advancedTheme
import com.nextu.pokedex.ui.theme.Typography

@Composable
fun PokemonCard(pokemon: PokemonSummary, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column {
            var id = extractIdFromUrl(pokemon.url)
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
                contentDescription = "Image of the product ${pokemon.name}",
                placeholder = painterResource(id = R.drawable.ic_coffee),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(pokemon.name, style = Typography.labelSmall.copy(fontSize = 20.sp), fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun extractIdFromUrl(url: String): Int? {
    val pattern = """.*/(\d+)/$""".toRegex()
    val matchResult = pattern.find(url)
    return matchResult?.groupValues?.get(1)?.toInt()
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    NextU_android_advancedTheme {
        PokemonCard(
            PokemonSummary(
                name="Pikachu",
                url= "https"
            )
        )
    }
}
