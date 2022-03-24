package irawan.electroshock.beritaku.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import irawan.electroshock.beritaku.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM table_news")
    fun getAllArticles(): Flow<List<Article>>
}