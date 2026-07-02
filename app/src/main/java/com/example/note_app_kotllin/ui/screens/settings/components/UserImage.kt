package com.example.note_app_kotllin.ui.screens.settings.components
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.valentinilk.shimmer.shimmer
import com.example.note_app_kotllin.R

@Composable
fun UserImage(imageUrl: String) {
    var isLoading by remember { mutableStateOf(true) }

    AsyncImage(
        model = imageUrl,
        error = painterResource(R.drawable.user_error_profile),
        contentDescription = "User Image",
        modifier = Modifier

            .clip(RoundedCornerShape(8.dp))
            .then(
                if (isLoading) Modifier.shimmer()
                else Modifier
            ),
        onLoading = { isLoading = true },
        onSuccess = { isLoading = false },
        onError = { isLoading = false },
        contentScale = ContentScale.Crop
    )
}