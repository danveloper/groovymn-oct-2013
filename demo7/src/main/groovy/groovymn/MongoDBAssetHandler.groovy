package groovymn

import com.mongodb.BasicDBObject
import com.mongodb.DB
import ratpack.file.MimeTypes
import ratpack.handling.Context
import ratpack.handling.Handler

import javax.inject.Inject
/**
 * User: danielwoods
 * Date: 10/8/13
 */
class MongoDBAssetHandler implements Handler {

  @Inject
  DB db

  @Override
  void handle(Context context) {
    def path = context.request?.path
    def coll = db.getCollection("assets")
    def dbo = coll.find(new BasicDBObject(name: path))?.getAt(0)
    if (!dbo) {
      context.clientError 404
    } else {
      context.response.send context.get(MimeTypes).getContentType(dbo.name), (byte[])dbo.data
    }
  }
}
