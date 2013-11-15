package groovymn

import com.google.inject.AbstractModule
import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.MongoClient

/**
 * User: danielwoods
 * Date: 10/8/13
 */
class AppModule extends AbstractModule {
  @Override
  protected void configure() {

    MongoClient client = new MongoClient("ds037518.mongolab.com", 37518)

    DB db = client.getDB("ratpack-mongodb")
    db.authenticate("groovymn", "groovymn" as char[])
    def coll = db.getCollection("assets")
    coll.find(new BasicDBObject(name: "groovymn.png")).collect { it.remove() }
    coll.insert new BasicDBObject(name: "groovymn.png",
      data: "https://gs1.wac.edgecastcdn.net/8019B6/data.tumblr.com/5c52273a2522cbce3e221fca4ff667da/tumblr_mqqzukFzFx1sdqapso1_1280.png".toURL().bytes)

    bind(DB).toInstance(db)
    bind(MongoDBAssetHandler).toInstance(new MongoDBAssetHandler())

  }
}
