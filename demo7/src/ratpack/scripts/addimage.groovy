package scripts

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.MongoClient

def name = "ratpack-footer.png"
def url = "http://www.ratpack-framework.org/images/ratpack-footer.png"

MongoClient client = new MongoClient("ds037518.mongolab.com", 37518)

DB db = client.getDB("ratpack-mongodb")
db.authenticate("groovymn", "groovymn" as char[])
def coll = db.getCollection("assets")
coll.insert new BasicDBObject(name: name, data: url.toURL().bytes)
