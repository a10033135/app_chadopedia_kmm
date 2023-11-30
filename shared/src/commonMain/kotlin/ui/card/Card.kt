package ui.card


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SquareCard(title: String = "title", desc: String = "desc", hasImage: Boolean = true, imgUrl: String = "") {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            if (hasImage) {
                KamelImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    resource = asyncPainterResource(data = imgUrl),
                    contentDescription = ""
                )
            }
            val color = if (hasImage) Color.White else Color.Black
            DescCard(
                textColor = color,
                title = title,
                desc = desc
            )
        }
    }
}


@Composable
fun RectCard(
    title: String = "title",
    desc: String = "desc",
    hasImage: Boolean = true,
    imgUrl: String = "",
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        Column(
            modifier = Modifier.background(Color.Transparent)
        ) {
            if (hasImage) {
                Card(shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)) {
                    KamelImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        resource = asyncPainterResource(data = imgUrl),
                        contentDescription = ""
                    )
                }
            }
            DescCard(
                title = title,
                desc = desc,
                textColor = Color.Black
            )
        }
    }
}

@Composable
fun HorizonRectCard(
    title: String = "title",
    desc: String = "desc",
    hasImage: Boolean = true,
    imgUrl: String = "",
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier.background(Color.Transparent)
        ) {
            if (hasImage) {
                KamelImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    resource = asyncPainterResource(data = imgUrl),
                    contentDescription = ""
                )
            }

            DescCard(
                title = title,
                desc = desc,
                textColor = Color.Black
            )

        }
    }
}

@Composable
fun DescCard(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    title: String = "Title",
    desc: String = "desc",
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(20.dp, 12.dp, 20.dp, 0.dp),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = textColor
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(24.dp, 0.dp, 24.dp, 12.dp),
            text = desc,
            fontSize = 16.sp,
            color = textColor
        )
    }
}