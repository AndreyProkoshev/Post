data class Post(
    val id: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val signerId: Int,
    val text: String,
    val markedAsAds: Int,
    val isFavorite: Boolean,
    val canPin: Boolean,
    val isPinned: Int,
    val likes: Likes = Likes(),
)
data class Likes(
    val count: Int = 12,
    val userLikes: Int = 5,
    val canLikes: Int = 6,
    val canPublisn: Int = 7,
)
object WallService {
    private var posts = emptyArray<Post>()
    private var LastId = 112364
    fun add(post: Post): Post {
        posts += post.copy(id = ++LastId)
        return posts.last()
    }

    fun update(postNew: Post): Boolean {
        for ((index, Post) in posts.withIndex()) {
            if (Post.id == postNew.id) {
                posts[index] = postNew.copy()
                return true
            }
        }
        return false
    }
    fun printPosts() {
        for (post in posts) {
            println(post)
        }
    }

    fun clear() {
        posts = emptyArray()
        LastId = 0
    }
}
fun main(){
    WallService.add(Post(0,1,1,1,1,
        "Hello",1,false,true,2,))
    WallService.add(Post(1,1,1,1,1,
        "Hello",1,false,true,2,))
    WallService.printPosts()
    println(WallService.update(Post(1,1,1,1,1,
        "Привет",1,false,true,2,)))
    WallService.printPosts()
}
