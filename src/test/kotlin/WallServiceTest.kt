import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add_passed() {
        val service = WallService()
        val post1 = service.add(Post(from_id = 1, date = 1656494786, text = "Всем привет1!"))
        val post2 = service.add(Post(from_id = 1, date = 1656494787, text = "Всем привет2!"))
        val result = post2.id
        assertEquals(2, result)
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(from_id = 1, date = 1656494786, text = "Всем привет1!"))
        service.add(Post(from_id = 2, date = 1656494787, text = "Всем привет2!"))
        service.add(Post(from_id = 3, date = 1656494788, text = "Всем привет3!"))
        // создаём информацию об обновлении
        val postUpdate = Post(id=1, from_id = 1, date = 1656494786, text = "Всем привет5!")

        // выполняем целевое действие
        val result = service.update(postUpdate)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }
    @Test
    fun tryUpdateNoExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(from_id = 1, date = 1656494786, text = "Всем привет1!"))
        service.add(Post(from_id = 2, date = 1656494787, text = "Всем привет2!"))
        service.add(Post(from_id = 3, date = 1656494788, text = "Всем привет3!"))
        // создаём информацию об обновлении
        val postUpdate = Post(id=5, from_id = 1, date = 1656494786, text = "Всем привет1!")

        // выполняем целевое действие
        val result = service.update(postUpdate)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

}