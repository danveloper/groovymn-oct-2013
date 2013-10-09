import groovymn.AppModule
import groovymn.MongoDBAssetHandler

import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
  modules {
    register new AppModule()
  }
  handlers { MongoDBAssetHandler mongoAssetHandler ->
    get("event/:name?") {
      def name = pathTokens.name ?: "GroovyMN"
      response.send "Hello, $name!"
    }

    handler mongoAssetHandler
  }

}




