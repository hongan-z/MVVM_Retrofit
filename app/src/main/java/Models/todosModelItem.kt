package Models

data class todosModelItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)