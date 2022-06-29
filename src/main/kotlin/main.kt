fun mian(){

}

data class Post(
    val id: Int = 0, //идентификатор поста
    val from_id: Int, //идентификтор автора записи
    val date: Int, //дата поста
    val text: String, //содержание поста
    val copyright: String = "", //источник материала
    val can_pin: Boolean = true,
    val can_delete: Boolean = true,
    val can_edit: Boolean = true,
    val is_pinned: Boolean = true,
    val likes: Likes = Likes()
)

class Likes (
    val count: Int = 0,
    val user_likes: Boolean = true,
    val can_like: Boolean = true,
    val can_publish: Boolean = true
    )

class WallService{
    private var posts = emptyArray<Post>()
    private var last_id: Int = 0

    fun add(post: Post): Post {
        last_id += 1
        posts += post.copy(id = last_id)
        return posts.last()
    }
    fun update(post: Post): Boolean {
        val search_id = post.id
        var find = false
        for ((index,curr_post) in posts.withIndex()) {
            if (curr_post.id==search_id) {
                posts[index] = post.copy(text = post.text,)
                find = true
            }
        }
        return find
    }
}