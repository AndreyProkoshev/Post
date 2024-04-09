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
    private var lastId = 0
    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }
    fun update(postNew: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postNew.id) {
                posts[index] = postNew.copy()
                return true
            }
        }
        return false
    }
    fun clear() {
        posts = emptyArray()
        lastId = 0
    }
    fun printPosts() {
        for (post in posts) {
            println(post)
        }
    }
}
fun main(){
    WallService.add(Post(1,1,1,1,1,
        "Hello",1,false,true,2,))
    WallService.add(Post(2,1,1,1,1,
        "Hi",1,false,true,2,))
    WallService.printPosts()
    WallService.update(Post(52,1,1,1,1,
        "Привет",1,false,true,2,))
    WallService.update(Post(2,1,1,1,1,
        "До встречи",1,false,true,2,))
    WallService.printPosts()
}
