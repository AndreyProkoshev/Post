import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val post = Post(
            1, 1, 1, 1, 1,
            "Hello", 1, false, true, 2,
        )
        val addPost = WallService.add(post)
        assertNotEquals(1, addPost.id)
    }

    @Test
    fun updatePostTrue() {
        val post = Post(1,1,1,1,1,
            "Hello",1,false,true,2,)
        WallService.add(post)
        val updatePost = Post(2,1,1,1,1,
            "Привет",1,false,true,2,)
        val result = WallService.update(updatePost)
        assertEquals(result, true)
    }

    @Test
    fun updatePostFalse() {
        val post = Post(
            1, 1, 1, 1, 1,
            "Hello", 1, false, true, 2,)
        WallService.add(post)
        val updatePost = Post(
            10, 1, 1, 1, 1,
            "Привет", 1, false, true, 2,)
        val result = WallService.update(updatePost)
        assertEquals(result, false)
    }
}
