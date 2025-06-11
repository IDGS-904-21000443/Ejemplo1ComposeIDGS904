package com.jaguirre.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import com.jaguirre.ejemplo1composeidgs904.Ejemplo1ComposeIDGS904Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // PreviewMessageCard("jose")
            Ejemplo1ComposeIDGS904Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

data class PersonajeTarjeta (val title : String, val body : String, val img : String)

var tarjetas : List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla.", "goku_normal"),
    PersonajeTarjeta("Vegeta","Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters.","vegeta_normal"),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku.", "picolo_normal"),
    PersonajeTarjeta("Bulma","Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es hija del Dr.","bulma"),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer.","freezer"),
    PersonajeTarjeta("Zarbon","Zarbon es uno de los secuaces de Freezer y un luchador poderoso.","zarbon"),
    PersonajeTarjeta("Dodoria","Dodoria es otro secuaz de Freezer conocido por su brutalidad.","dodoria"),
    PersonajeTarjeta("Ginyu","Ginyu es el líder del la élite de mercenarios de mayor prestigio del Ejército de Freeza, la cual lleva el nombre de Fuerzas Especiales Ginew en su honor.","ginyu"),
    PersonajeTarjeta("Cell","Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército.","celula"),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT.","gohan")
)

@Composable
fun Tarjeta(personajes : List<PersonajeTarjeta>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 30.dp)
    ) {
        items(personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun ImagenHeroe(imageName : String) {
    val context = LocalContext.current
    var ImageResId = remember (imageName){
        context.resources.getIdentifier(imageName.lowercase(),
            "drawable", context.packageName)
    }
    Image(
        painter = painterResource(id = ImageResId),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyPersonajes(personaje : PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        ){
            ImagenHeroe(personaje.img)
            Column {
                Personaje(
                    personaje.title,
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.typography.titleLarge
                )
                Personaje(
                    personaje.body,
                    MaterialTheme.colorScheme.onBackground,
                    MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun Personajes(personaje : PersonajeTarjeta) {
    Column {
        Personaje(personaje.title, MaterialTheme.colorScheme.primary, MaterialTheme.typography.titleLarge)
        Personaje(personaje.body, MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun Personaje(name : String, color : Color, style : TextStyle){

        Text(text = name, color = color, style = style)
}

@Composable
fun  MessageCard(name : String) {
    Text("Hola mundo " + name)
    Text("Hola mundo 2")
}

@Composable
fun  PreviewMessageCard(name : String) {
    //MessageCard("jose")
    Tarjeta(tarjetas)
}