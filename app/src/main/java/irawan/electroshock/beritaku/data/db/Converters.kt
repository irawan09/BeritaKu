package irawan.electroshock.beritaku.data.db

import androidx.room.TypeConverter
import irawan.electroshock.beritaku.data.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source):String?{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name, name)
    }
}